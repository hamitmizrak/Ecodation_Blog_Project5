package com.hamitmizrak.controller.api;

import com.hamitmizrak.business.dto.RegisterDto;
import java.util.List;
import java.util.Map;

public interface IRegisterApi {
    
    // CREATE
    public RegisterDto createRegister(RegisterDto registerDto);

    // LIST
    public List<RegisterDto> getAllRegister();

    // FIND
    public RegisterDto getRegisterById(Long id);

    // UPDATE
    public RegisterDto updateRegister(Long id,RegisterDto registerDto);

    // DELETE
    public Map<String,Boolean> deleteRegister(Long id);
}
