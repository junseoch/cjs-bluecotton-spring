package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.dto.AdminProductCreateRequest;
import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.domain.vo.shop.ProductImageVO;
import com.app.bluecotton.domain.vo.shop.ProductVO;
import com.app.bluecotton.service.AdminProductService;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/products/*")
public class AdminProductApi {

    private final AdminProductService adminProductService;

    @Value("${file.upload-dir}")
    private String uploadDirRoot;

    @Getter
    @Builder
    public static class ProductImageUploadResponse {
        private String productImagePath;
        private String productImageName;
    }

    @PostMapping(
            value = "/upload-image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ApiResponseDTO<ProductImageUploadResponse>> uploadImage(
            @RequestPart("file") MultipartFile file,
            @RequestParam(name = "type", defaultValue = "MAIN") String type
    ) {
        try {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("빈 파일입니다.");
            }

            String subDir = "MAIN";
            if ("SUB".equalsIgnoreCase(type)) {
                subDir = "SUB";
            }

            Path uploadDir = Paths.get(uploadDirRoot, subDir);
            Files.createDirectories(uploadDir);

            String originalName = file.getOriginalFilename();
            String ext = "";
            if (originalName != null && originalName.contains(".")) {
                ext = originalName.substring(originalName.lastIndexOf("."));
            }

            String savedName = UUID.randomUUID() + ext;
            Path target = uploadDir.resolve(savedName);

            file.transferTo(target.toFile());

            String webDir = "/file/" + subDir + "/";

            ProductImageUploadResponse data = ProductImageUploadResponse.builder()
                    .productImagePath(webDir)
                    .productImageName(savedName)
                    .build();

            return ResponseEntity.ok(ApiResponseDTO.of("이미지 업로드 성공", data));
        } catch (Exception e) {
            log.error("이미지 업로드 실패", e);
            return ResponseEntity.internalServerError()
                    .body(ApiResponseDTO.of("이미지 업로드 실패: " + e.getMessage(), null));
        }
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponseDTO<Long>> create(
            @RequestBody AdminProductCreateRequest request
    ) {
        ProductVO productVO = request.getProduct();
        List<ProductImageVO> images = request.getImages();

        Long id = adminProductService.createProduct(productVO, images);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseDTO.of("상품 등록 성공", id));
    }

    @GetMapping("list")
    public ResponseEntity<ApiResponseDTO<List<ProductVO>>> list() {
        List<ProductVO> products = adminProductService.getProducts();
        return ResponseEntity.ok(ApiResponseDTO.of("상품 조회 성공", products));
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<ApiResponseDTO<ProductVO>> detail(@PathVariable Long id) {
        return adminProductService.getProduct(id)
                .map(p -> ResponseEntity.ok(ApiResponseDTO.of("상품 상세 조회 성공", p)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponseDTO.of("상품을 찾을 수 없습니다.", null)));
    }

    @GetMapping("{id}/images")
    public ResponseEntity<ApiResponseDTO<List<ProductImageVO>>> images(@PathVariable Long id) {
        List<ProductImageVO> images = adminProductService.getProductImages(id);
        return ResponseEntity.ok(ApiResponseDTO.of("상품 이미지 조회 성공", images));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> update(
            @PathVariable Long id,
            @RequestBody ProductVO productVO
    ) {
        productVO.setId(id);
        adminProductService.updateProduct(productVO, Collections.emptyList());
        return ResponseEntity.ok(ApiResponseDTO.of("상품 수정 성공", null));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> delete(@PathVariable Long id) {
        adminProductService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponseDTO.of("상품 삭제 성공", null));
    }
}
