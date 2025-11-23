package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private Long memberId;
    private String memberName;
    private String memberAddress;
    private String memberPhone;
    private boolean isDefault;
}
