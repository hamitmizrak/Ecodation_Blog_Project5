package com.hamitmizrak.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Component ==> Spring nesnesi olamaıs için
@Component
@Profile("frontend")
public class FrontEndProfile implements IChooiseProfile{
    
    @Override
    public String message(String name) {
        return "NAME: "+name;
    }
}
