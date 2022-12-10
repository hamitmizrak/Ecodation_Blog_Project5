package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

//Lombok

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data
@Getter
@Setter
@EqualsAndHashCode(of="id")


//Entity
@Entity
@Table(name="register")
public class RegisterEntity extends BaseEntity implements Serializable {

    private String username;
    //@Column(unique = true) ancak bunun yerine biz zaten kendi annotation'umuzu yazacağız.
    private String email;
    private String passwd;
}
