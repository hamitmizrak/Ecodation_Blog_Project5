package com.hamitmizrak;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;


//auditor: sisteme kim ne zaman veri ekledi veya güncelledi
//audit: çalışması için enable yapmalıyız
@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")

//Spring security Exclude
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
}
)
//@SpringBootApplication
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
