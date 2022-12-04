package com.hamitmizrak.business.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

//Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
//@SneakyThrows
public class RegisterDto {
    private Long id;
    private String username;
    private String email;
    private String passwd;
    private Date createdDate;
}
