package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSomCheckApproveRequestDTO {
    private Long id;
    private boolean somCheckIsChecked;
}
