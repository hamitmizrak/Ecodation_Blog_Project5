package com.hamitmizrak;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;


//auditor: sisteme kim ne zaman veri ekledi veya güncelledi
@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")

//Spring security Exclude
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

//@EnableJpaRepositories
//Jpa Repository okumadığı  durumda @EnableJpaRepositories vermemiz gerekecek
//D:\spring\EcodationBlogProject5\src\main\java\  com\hamitmizrak\data\repository
@EnableJpaRepositories(basePackages = "com.hamitmizrak.data.repository")

public class EcodationBlogProject5Application {

    //Spring Constructor
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    }

    public static void main(String[] args) {
        //devtools active isActive
        //System.setProperty("spring.devtools.restart.enabled","true");

        //Disables headless
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(EcodationBlogProject5Application.class, args);
    }
}
