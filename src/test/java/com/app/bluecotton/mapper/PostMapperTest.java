package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.post.PostMainDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class PostMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    void selectTest() {
        List<PostMainDTO> posts = postMapper.select(null, null, 1L);
        System.out.println("조회된 개수 = " + posts.size());
        posts.forEach(System.out::println);
    }
}