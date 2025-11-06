package com.app.bluecotton.api.privateapi;


import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.domain.dto.post.PostMainDTO;
import com.app.bluecotton.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/main/post")
public class PostApi {

    private final PostService postService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDTO<List<PostMainDTO>>> getAllPosts(
            @RequestParam(required = false) String somCategory,
            @RequestParam(required = false) String orderType
    ) {
        Long memberId = 1L; // 로그인 가정

//        Map<String, String> categoryMap = Map.of(
//                "전체", null,
//                "학습", "STUDY",
//                "건강", "HEALTH",
//                "소셜", "SOCIAL",
//                "취미", "HOBBIES",
//                "생활", "LIFE",
//                "루키", "ROOKIE"
//        );

//        String mappedCategory = categoryMap.getOrDefault(somCategory, somCategory);

        List<PostMainDTO> posts = postService.getPosts(somCategory, orderType, memberId);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 목록 조회 완료", posts));
    }
}
