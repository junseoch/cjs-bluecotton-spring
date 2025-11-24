package com.app.bluecotton.api.publicapi;


import com.app.bluecotton.domain.dto.AdminDashboardOverviewDTO;
import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.service.AdmindashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dashboard/*")
@RequiredArgsConstructor
@Slf4j
public class AdminDashboardApi {

    private final AdmindashboardService admindashboardService;

    @GetMapping("/overview")
    public ResponseEntity<ApiResponseDTO<AdminDashboardOverviewDTO>> getOverview() {
        AdminDashboardOverviewDTO dto = admindashboardService.getOverview();
        return ResponseEntity.ok(
                ApiResponseDTO.of("대시보드 조회 성공", dto)
        );
    }
}
