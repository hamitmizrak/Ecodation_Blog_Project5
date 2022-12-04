package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.data.entity.RegisterEntity;

import java.util.List;
import java.util.Map;

public interface IRegisterService {

    //model mapper
    public RegisterDto EntityToDto(RegisterEntity registerEntity);
    public RegisterEntity DtoToEntity(RegisterDto registerDto);

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
