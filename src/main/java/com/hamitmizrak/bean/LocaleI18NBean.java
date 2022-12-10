package com.hamitmizrak.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class LocaleI18NBean {

    // Default Accept-Language: tr YAPTIM
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptorBean(){
        LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
        interceptor.setParamName("tr");
        return  interceptor;
    }
}
