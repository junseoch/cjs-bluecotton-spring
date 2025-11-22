package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAllMemberDTO {
    private Long id;
    private String memberEmail;
    private String memberSocialProvider;
    private String memberName;
    private String memberNickname;
    private String memberAddress;
    private String memberCandy;
    private String memberRank;
    private String memberSocialProviderId;
    private Date memberBirth;
    private String memberPhone;
}
