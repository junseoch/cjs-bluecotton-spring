package com.app.bluecotton.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRecentActivityDTO {
    private Long id;
    private String type;
    private String action;
    private String user;
    private String time;
    private String status;
}
