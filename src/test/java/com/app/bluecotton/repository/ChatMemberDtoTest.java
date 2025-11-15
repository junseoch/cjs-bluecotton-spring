package com.app.bluecotton.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ChatMemberDtoTest {
    @Autowired
    private ChatMemberDAO chatMemberDAO;

    @Test
    public void test(){
        log.info("test: {}", chatMemberDAO.selectIdByMemberListChatId(22L));
    }

}
