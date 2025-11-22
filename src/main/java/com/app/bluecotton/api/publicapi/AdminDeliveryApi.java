package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.dto.AdminDeliveryDetailDTO;
import com.app.bluecotton.domain.dto.AdminDeliveryListDTO;
import com.app.bluecotton.domain.dto.AdminOrderItemDTO;
import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.service.AdminDeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/deliveries/*")
public class AdminDeliveryApi {

    private final AdminDeliveryService adminDeliveryService;

    @GetMapping("lists")
    public ResponseEntity<ApiResponseDTO<List<AdminDeliveryListDTO>>> getDeliveryList() {
        List<AdminDeliveryListDTO> list = adminDeliveryService.getDeliveryList();
        return ResponseEntity.ok(
                ApiResponseDTO.of("배송 목록 조회 성공", list)
        );
    }

    @GetMapping("option/{id}")
    public ResponseEntity<ApiResponseDTO<AdminDeliveryDetailDTO>> getDeliveryDetail(@PathVariable Long id) {
        return adminDeliveryService.getDeliveryDetail(id)
                .map(dto -> ResponseEntity.ok(
                        ApiResponseDTO.of("배송 상세 조회 성공", dto)
                ))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponseDTO.of("해당 배송 정보를 찾을 수 없습니다.", null))
                );
    }


    @GetMapping("items/{orderId}")
    public ResponseEntity<ApiResponseDTO<List<AdminOrderItemDTO>>> getOrderItems(@PathVariable Long orderId) {
        List<AdminOrderItemDTO> items = adminDeliveryService.selectOrderItemsByOrderId(orderId);
        return ResponseEntity.ok(
                ApiResponseDTO.of("주문 상품 목록 조회 성공", items)
        );
    }

    @PutMapping("status/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> changeDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
        adminDeliveryService.changeDeliveryStatus(id, status);
        return ResponseEntity.ok(
                ApiResponseDTO.of("배송 상태 변경 성공", null)
        );
    }
}
