package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.bean.PasswordEncoderBean;
import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import com.hamitmizrak.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

//Lombok
@RequiredArgsConstructor
@Log4j2
//@SneakyThrows

//Service: Asıl iş yükünü yapan yer
@Service
public class RegisterServiceImpl implements IRegisterService {

    //injection Constructor
    private final IRegisterRepository iRegisterRepository;
    private final ModelMapperBean modelMapperBean;
    private final PasswordEncoderBean passwordEncoderBean;

    //MODEL MAPPER
    @Override
    public RegisterDto EntityToDto(RegisterEntity registerEntity) {
        return modelMapperBean.modelMapperMethod().map(registerEntity,RegisterDto.class);
    }

    @Override
    public RegisterEntity DtoToEntity(RegisterDto registerDto) {
        return modelMapperBean.modelMapperMethod().map(registerDto,RegisterEntity.class);
    }

    //CREATE
    @Transactional //create,update,delete (Manipulation)
    @Override
    public RegisterDto createRegister(RegisterDto registerDto) {
        if(registerDto!=null){
            //Spring security masking
            registerDto.setPasswd(passwordEncoderBean.passwordEncoderMethod().encode(registerDto.getPasswd()));
            RegisterEntity registerEntity=DtoToEntity(registerDto);
            RegisterEntity registerEntityId=  iRegisterRepository.save(registerEntity);
            //ID dönder
            registerDto.setId(registerEntityId.getId());
        }
        return registerDto;
    }

    //LIST
    @Override
    public List<RegisterDto> getAllRegister() {
      Iterable<RegisterEntity> registerEntityList=  iRegisterRepository.findAll();
        List<RegisterDto> registerDtoList=new ArrayList<>();
        for (RegisterEntity registerEntity: registerEntityList) {
            RegisterDto registerDto=EntityToDto(registerEntity);
            registerDtoList.add(registerDto);
        }
        return registerDtoList;
    }

    //FIND
    @Override
    public RegisterDto getRegisterById(Long id) {
        //1.YOL
        /*Optional<RegisterEntity> registerEntityFind=iRegisterRepository.findById(id);
        RegisterDto registerDto=EntityToDto(registerEntityFind.get());

        //registerEntityFind.isPresent()
        //registerDto!=null
        if(registerEntityFind.isPresent()){
            return registerDto;
        }*/

        //2.YOL
        RegisterEntity registerEntityFind=   iRegisterRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id+" nolu id bulunamadı"));
        RegisterDto registerDto=EntityToDto(registerEntityFind);
        return registerDto;
    }

    //UPDATE
    @Transactional //create,update,delete  (Manipulation)
    @Override
    public RegisterDto updateRegister(Long id, RegisterDto registerDto) {
        RegisterEntity registerEntityFind=   iRegisterRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id+" nolu id bulunamadı"));
        if(registerEntityFind!=null){
            registerEntityFind.setUsername(registerDto.getUsername());
            registerEntityFind.setPasswd( passwordEncoderBean.passwordEncoderMethod().encode(registerEntityFind.getPasswd()));
            registerEntityFind.setEmail(registerDto.getEmail());
            iRegisterRepository.save(registerEntityFind);
        }
        return registerDto;
    }

    //DELETE
    @Transactional //create,update,delete  (Manipulation)
    @Override
    public Map<String, Boolean> deleteRegister(Long id) {
        RegisterEntity registerEntityFind=   iRegisterRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id+" nolu id bulunamadı"));
        Map<String,Boolean> response=new LinkedHashMap<>();
        if(registerEntityFind!=null){
            //delete()   : Object'e göre silme
            //deleteById : id Göre silme
            iRegisterRepository.delete(registerEntityFind);
            response.put("Silindi",Boolean.TRUE);
        }
        return response;
    }
}
