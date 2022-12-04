package com.hamitmizrak.business.dto;

import com.hamitmizrak.annotation.RegisterUniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "{register.username.validation.constraints.NotNull.message}")
    private String username;

    @NotNull(message = "{register.email.validation.constraints.NotNull.message}")
    @Email
    @Size(max = 200)
    //my special annotation will created
    @RegisterUniqueEmail
    private String email;

    @NotNull(message = "{register.password.validation.constraints.NotNull.message}")
    @Size(min = 7,max = 20)
    // Hm123456@
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$",message = "{register.password.validation.constraints.pattern.regex.message}")
    private String passwd;

    private Date createdDate;
}
