package com.hamitmizrak.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

//Lombok
@Getter
@Setter

//super class
@MappedSuperclass

//auditing
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"created_date,update_date"},allowGetters = true)
abstract  public class BaseEntity implements Serializable {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,updatable = false)
    private Long id;

    //system current time
    @Column(name="created_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;

    //auditing field
    //KİM , NE ZAMAN EKLEDİ
    @CreatedBy
    @Column(name="created_by")
    private String createdBy;

    @Column(name="created_date")
    @CreatedDate
    private Date createdDate;

    //KİM , NE ZAMAN GÜNCELLEDİ
    @LastModifiedBy
    @Column(name="updated_by")
    private String updateBy;

    @Column(name="update_date")
    @LastModifiedDate
    private Date updateDate;
}
