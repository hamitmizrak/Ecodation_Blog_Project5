package com.hamitmizrak.data.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data
@Getter
@Setter
//@EqualsAndHashCode(of="id")

//Entity
@Entity
@Table(name="register")
public class RegisterEntity{
    //serileştirme
    public static final long serialVersionUID = 1L;

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    //@Column(unique = true) ancak bunun yerine biz zaten kendi annotation'umuzu yazacağız.
    private String email;
    private String passwd;

    //system current time
    @Column(name="system_created_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;
}
