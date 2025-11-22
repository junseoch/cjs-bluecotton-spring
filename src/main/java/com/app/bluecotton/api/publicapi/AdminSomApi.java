package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.dto.AdminSomCheckDetailDTO;
import com.app.bluecotton.domain.dto.AdminSomCheckResponseDTO;
import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.service.AdminSomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin/som/*")
public class AdminSomApi {

    private final AdminSomService adminSomService;


    @GetMapping("confirm")
    public ResponseEntity<ApiResponseDTO<List<AdminSomCheckResponseDTO>>> selectConfirmByMember() {
        List<AdminSomCheckResponseDTO> list = adminSomService.selectConfirmByMember();
        ApiResponseDTO<List<AdminSomCheckResponseDTO>> apiResponseDTO = new ApiResponseDTO<>("솜 인증 조회 성공", list);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    @GetMapping("checks/{id}")
    public ResponseEntity<ApiResponseDTO<AdminSomCheckDetailDTO>> getSomCheckDetail(@PathVariable Long id) {

        Optional<AdminSomCheckDetailDTO> check = adminSomService.selectDetailSom(id);

        return check
                .map(dto -> ResponseEntity.ok(
                        ApiResponseDTO.of("솜 상세 조회 성공", dto)
                ))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponseDTO.of("인증 정보를 찾을 수 없습니다.", null)));
    }


    @PutMapping("complete")
    public ResponseEntity<ApiResponseDTO<Long>> updateSomCheckIsChecked(@RequestParam Long id) {
        log.info("단일 인증 처리 요청 id={}", id);
        adminSomService.updateSomCheckIsChecked(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("단일 인증 처리 완료", null));
    }

    @PutMapping("completes")
    public ResponseEntity<ApiResponseDTO<List<Long>>> bulkUpdateSomCheckIsChecked(@RequestParam  List<Long> somCheckIds) {
        adminSomService.bulkUpdateSomCheckIsChecked(somCheckIds);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("다건 인증 처리 완료"));
    }

}
