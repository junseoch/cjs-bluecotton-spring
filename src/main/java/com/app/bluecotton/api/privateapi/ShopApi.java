package com.app.bluecotton.api.privateapi;

import com.app.bluecotton.domain.dto.*;
import com.app.bluecotton.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop/*")
@RequiredArgsConstructor
@Slf4j
public class ShopApi {

    private final ShopService shopService;

    // 상품 조건 조회
    @PostMapping("")
    public ResponseEntity<ApiResponseDTO> getProductsByFilter(@RequestBody Map<String, Object> filterParams) {
        log.info("상품 조건 조회 요청 들어옴: {}", filterParams);
        List<ProductListResponseDTO> products = shopService.getProductByFilter(filterParams);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("상품 조건 조회 성공", products));
    }

    // 상세 페이지 상단 조회
    @GetMapping("read/{id}")
    public ResponseEntity<ApiResponseDTO> getProductDetail(@PathVariable Long id) {
        log.info("상세 페이지 상단 조회 요청 들어옴:{}",id);
        ProductDetailResponseDTO productDetailResponseDTO = shopService.getProductDetailHeader(id);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("상세 페이지 상단 조회 성공", productDetailResponseDTO));
    }

    // 상세 페이지 상품 정보 조회
    @GetMapping("read/{id}/info")
    public ResponseEntity<ApiResponseDTO> getProductInfo(@PathVariable Long id) {
        log.info("상세 페이지 상품 정보 조회 요청 들어옴: {}",id);
        ProductInfoDetailResponseDTO productInfoDetailResponseDTO = shopService.getProductDetailInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("상품 정보 조회 성공", productInfoDetailResponseDTO));
    }

    // --- 리뷰 ---
    // 상세 페이지 상품 리뷰 조회
    @GetMapping("read/{id}/review")
    public ResponseEntity<ApiResponseDTO> getProductReview(
            @PathVariable Long id,
            @RequestParam Map<String, Object> reviewParams
    ) {
        // id도 넘겨야 함
        reviewParams.put("id", id);
        log.info("상세 페이지 리뷰 조회 요청 들어옴: {}", reviewParams);
        List<ProductReviewDetailResponseDTO> reviewProducts = shopService.getProductReviewDetail(reviewParams);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("상품 리뷰 조회 성공",  reviewProducts));
    }

    //  상세 페이지 "리뷰 평점"  조회
    @GetMapping("read/{id}/review/status")
    public ResponseEntity<ApiResponseDTO> getProductReviewStats(@PathVariable Long id) {

        log.info("상세 페이지 '리뷰 평점' 조회 요청: {}",id);
        ProductReviewStatsResponseDTO productReviewStats = shopService.getProductReviewStats(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("상품 리뷰 평점 조회 성공", productReviewStats));
    }




}
