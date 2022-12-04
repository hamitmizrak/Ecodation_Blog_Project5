package com.hamitmizrak.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component: işaretlediği nesneyi Spring'in bir nesnesi olmasını sağlıyor
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    //sisteme girmiş login kişisi
    @Override
    public Optional<String> getCurrentAuditor() {
        //org.springframework.security.core.Authentication;
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        //Eğer sistemde birisi varsa o kişinin ismini eklesin yoksa null döndürsün
        return Optional.ofNullable(authentication!=null?authentication.getName():null);
        //return Optional.of("HamitMızrak");
    }
}
