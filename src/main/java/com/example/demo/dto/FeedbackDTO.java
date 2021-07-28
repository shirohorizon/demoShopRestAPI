package com.example.demo.dto;

import lombok.Data;


@Data
public class FeedbackDTO extends BaseDTO<FeedbackDTO> {
    private String fullName;
    private String mobile;
    private String email;
    private String content;
}
