package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

//Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Entity
@Entity
@Table(name="register")
public class RegisterEntity extends BaseEntity implements Serializable {
    private String username;
    private String email;
    private String passwd;
}
