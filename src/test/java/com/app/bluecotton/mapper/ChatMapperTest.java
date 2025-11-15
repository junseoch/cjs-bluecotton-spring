package com.app.bluecotton.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ChatMapperTest {

    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private ChatMemberMapper chatMemberMapper;

    @Test
    public void insert() {
        log.info("실행 {}",chatMemberMapper.selectMemberListByChatId(22L));

    }
}
