package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.util.Date;

//Lombok
@Getter
@Setter

//super class
@MappedSuperclass
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
    private Date createdDate;
}
