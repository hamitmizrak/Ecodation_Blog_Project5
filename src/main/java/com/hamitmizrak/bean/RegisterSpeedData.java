package com.hamitmizrak.bean;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.data.repository.IRegisterRepository;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

//lombok
@RequiredArgsConstructor

@Configuration
public class RegisterSpeedData {

    private final PasswordEncoderBean passwordEncoderBean;
    private final IRegisterRepository iRegisterRepository;

    //application properties datadan value almak
    private final ServletContext servletContext;

    @Value("${hello.my.technology.name}")
    private String myValueApplicationProperties;

    @Bean
    // Ne zaman uygulamayaı ayağa kaldırırsam otomatik olarak 5 tane veri database eklenecek
    CommandLineRunner createRegister(IRegisterService iRegisterService){
        String applicationProperties=servletContext.getInitParameter("my_username");
        return (args)->{
            for (int i = 1; i <5 ; i++) {
                RegisterDto registerDto= RegisterDto.builder()
                        .email(UUID.randomUUID().toString().concat("@gmail.com"))
                        .passwd(passwordEncoderBean.passwordEncoderMethod().encode("root"))
                        .username(applicationProperties+" "+ myValueApplicationProperties+" "+i)
                        .build();
                iRegisterService.createRegister(registerDto);
            }
        };
    }
}
