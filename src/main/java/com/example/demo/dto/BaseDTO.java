package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO<T> {
    private Long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
