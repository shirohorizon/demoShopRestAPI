package com.example.demo.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreatedBy
    @Column(name = "createdby", updatable = false)
    private String createdBy;
    @CreatedDate
    @Column(name = "createddate", updatable = false)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "modifiedby")
    private String modifiedBy;
    @LastModifiedDate
    @Column(name = "modifieddate")
    private String modifiedDate;

}
