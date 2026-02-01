package com.ex.hospitalManagement.dto;

import lombok.Data;

@Data
public class onBoardDoctorRequestDto {
    private Long userId;
    private String specialization;
    private String name;
}
