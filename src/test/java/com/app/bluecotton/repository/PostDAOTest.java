package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.post.PostMainDTO;
import com.app.bluecotton.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class PostDAOTest {
    @Autowired
    private PostDAO postDAO;

    @Test
    void findPosts() {
        String somCategory = null; // 전체 조회
        String orderType = null;   // 최신순

        // when
        List<PostMainDTO> posts = postDAO.findPosts(somCategory, orderType, 1L);

        // then
        System.out.println("조회된 개수 = " + posts.size());
        posts.forEach(post -> log.info("✅ 게시글: {}", post));
    }

}