package com.app.bluecotton.domain.vo.member;

import lombok.Data;

@Data
public class MemberProfileVO {

    // ⭐ 정적(static) 기본 프로필 이미지 경로
    public static final String DEFAULT_PROFILE_PATH =
            "https://image-server.ideaflow.co.kr/uploads/default/%EC%9A%94%EC%A6%88_737a9f16-0733-4d3d-aa6e-2f4cbdf60536.png";
    private Long id;
    private String memberProfilePath = DEFAULT_PROFILE_PATH;    // ⭐ 기본값 설정 (생성 시 자동 적용)
    private String memberProfileName;
    private Long memberId;
}