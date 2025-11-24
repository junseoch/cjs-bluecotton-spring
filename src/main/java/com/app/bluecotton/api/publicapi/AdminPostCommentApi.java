package com.app.bluecotton.api.publicapi;


import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.domain.dto.ReportedCommentDTO;
import com.app.bluecotton.service.AdminPostCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/post/comments/*")
@RequiredArgsConstructor
@Slf4j
public class AdminPostCommentApi {

    private final AdminPostCommentService adminPostCommentService;

    @GetMapping("reported")
    public ResponseEntity<ApiResponseDTO> getReportedComments() {
        List<ReportedCommentDTO> list = adminPostCommentService.getReportedComments();
        return ResponseEntity.ok(ApiResponseDTO.of("신고 댓글 조회 완료", list));
    }

    @DeleteMapping("reported/{commentId}")
    public ResponseEntity<ApiResponseDTO> deleteReportedComment(@PathVariable Long commentId) {
        adminPostCommentService.deleteCommentAsAdmin(commentId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.of("댓글 삭제 완료"));
    }

    @DeleteMapping("replies/{replyId}")
    public ResponseEntity<ApiResponseDTO> deleteReplies(@PathVariable Long replyId) {
        adminPostCommentService.deleteReplyAsAdmin(replyId);
        return ResponseEntity.ok(ApiResponseDTO.of("대댓글 삭제 완료"));
    }
}
