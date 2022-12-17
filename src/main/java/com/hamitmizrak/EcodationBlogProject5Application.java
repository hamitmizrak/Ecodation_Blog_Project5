package com.hamitmizrak;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

// Mongo aktif etmek icin
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// Spring Boot Cache mekanizmasını aktif ediyorum
// @EnableCaching

//auditor: sisteme kim ne zaman veri ekledi veya güncelledi
//@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")

//Spring security Exclude
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

//@EnableJpaRepositories: Repository bulamdığı durumlarda
//Jpa Repository okumadığı  durumda @EnableJpaRepositories vermemiz gerekecek
//D:\spring\EcodationBlogProject5\src\main\java\  com\hamitmizrak\data\repository
@EnableJpaRepositories(basePackages = "com.hamitmizrak")

//@EntityScan: Entity bulamadığı durumlarda
//Entity Classlarını bulamadığı durumlarda
//D:\spring\EcodationBlogProject5\src\main\java\  com\hamitmizrak\data\entity
@EntityScan(basePackages = "com.hamitmizrak")

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
