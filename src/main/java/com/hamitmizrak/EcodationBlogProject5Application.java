package com.hamitmizrak;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.TimeZone;


@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
}
)
//@SpringBootApplication
public class EcodationBlogProject5Application {

    //Spring Constructor
    @PostConstruct
    public void init(){
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
