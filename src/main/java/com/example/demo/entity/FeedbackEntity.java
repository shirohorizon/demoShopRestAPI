package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "feedback")
public class FeedbackEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "fullname", nullable = false, length = 200)
    private String fullName;
    @Column(name = "mobile", nullable = false, length = 15)
    private String mobile;
    @Column(name = "email", nullable = false, length = 200)
    private String email;
    @Column(name = "content", columnDefinition = "TEXT NULL")
    private String content;
}
