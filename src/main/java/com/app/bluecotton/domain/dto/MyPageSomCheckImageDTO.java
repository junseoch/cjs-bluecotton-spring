    package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.som.SomCheckImageVO;
import com.app.bluecotton.domain.vo.som.SomCheckVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class MyPageSomCheckImageDTO {
        private Long id;                 // SOM_CHECK_IMAGE PK
        private String somCheckImagePath;
        private String somCheckImageName;
        private Long somCheckId;         // FK (부모)
    }
