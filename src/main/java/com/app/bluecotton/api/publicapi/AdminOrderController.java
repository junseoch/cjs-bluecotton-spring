package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.dto.AdminOrderDTO;
import com.app.bluecotton.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/admin")
public class AdminOrderController {
    private final AdminService adminService;

    // ✅ 주문 상세 조회 API
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<AdminOrderDTO> getAdminOrderById(@PathVariable Long orderId) {
        log.info("[AdminOrderController] getAdminOrderById orderId={}", orderId);

        AdminOrderDTO dto = adminService.selectAdminOrderById(orderId);

        if (dto == null) {
            return ResponseEntity.notFound().build();  // 404
        }

        return ResponseEntity.ok(dto);  // 200 + JSON
    }
}
