package com.hamitmizrak.bean;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.data.repository.IRegisterRepository;
import lombok.RequiredArgsConstructor;
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

    @Bean
    // Ne zaman uygulamayaı ayağa kaldırırsam otomatik olarak 5 tane veri database eklenecek
    CommandLineRunner createRegister(IRegisterService iRegisterService){
        return (args)->{
            for (int i = 1; i <5 ; i++) {
                RegisterDto registerDto= RegisterDto.builder()
                        .email(UUID.randomUUID().toString().concat("@gmail.com"))
                        .passwd(passwordEncoderBean.passwordEncoderMethod().encode("root"))
                        .username("Hamit "+i)
                        .build();
                iRegisterService.createRegister(registerDto);
            }
        };
    }
}
