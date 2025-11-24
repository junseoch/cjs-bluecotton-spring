package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.dto.AdminReportedPostDTO;
import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.domain.dto.post.AdminPostDetailDTO;
import com.app.bluecotton.domain.dto.post.AdminPostListDTO;
import com.app.bluecotton.service.AdminPostReportService;
import com.app.bluecotton.service.AdminPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/posts/*")
public class AdminPostApi {

    private final AdminPostService adminPostService;

    private final AdminPostReportService adminPostReportService;

    @GetMapping("list")
    public ResponseEntity<ApiResponseDTO<List<AdminPostListDTO>>> selectAdminPostList() {
        List<AdminPostListDTO> list = adminPostService.selectAdminPostList();
        ApiResponseDTO<List<AdminPostListDTO>> body =
                new ApiResponseDTO<>("전체 게시글 조회 성공", list);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @GetMapping("select/{id}")
    public ResponseEntity<ApiResponseDTO<AdminPostDetailDTO>> selectPostDetail(@PathVariable Long id) {
        AdminPostDetailDTO detail = adminPostService.selectPostDetail(id);
        ApiResponseDTO<AdminPostDetailDTO> body =
                new ApiResponseDTO<>("게시글 상세 조회 성공", detail);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> delete(@PathVariable Long id) {
        adminPostService.delete(id);
        ApiResponseDTO<Void> body =
                new ApiResponseDTO<>("게시글 삭제 성공", null);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @GetMapping("reported")
    public ResponseEntity<ApiResponseDTO<List<AdminReportedPostDTO>>> getReportedPosts() {
        List<AdminReportedPostDTO> list = adminPostReportService.getReportedPosts();
        return ResponseEntity.ok(ApiResponseDTO.of("신고된 게시글 목록 조회 성공", list));
    }
}
