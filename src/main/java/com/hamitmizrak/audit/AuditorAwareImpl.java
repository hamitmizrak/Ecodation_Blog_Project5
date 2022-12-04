package com.hamitmizrak.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    //sisteme girmiş login kişisi
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("HamitMızrak");
    }
}
