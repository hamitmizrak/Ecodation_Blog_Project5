package com.hamitmizrak.controller.api.impl;
import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.controller.api.IRegisterApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

//Lombok
@RequiredArgsConstructor

//Dış dünyaya açılan kapı
@RestController
@RequestMapping("register")
public class RegisterApiImpl implements IRegisterApi {

    //Constructor injection
    private final IRegisterService iRegisterService;

    // CREATE
    // http://localhost:5555/register
    @Override
    @PostMapping
    public RegisterDto createRegister( @RequestBody RegisterDto registerDto) {
        iRegisterService.createRegister(registerDto);
        return registerDto;
    }

    // LIST
    // http://localhost:5555/register
    @Override
    @GetMapping
    public List<RegisterDto> getAllRegister() {
        return iRegisterService.getAllRegister();
    }

    // FIND
    // http://localhost:5555/register/1
    @Override
    @GetMapping("/{id}")
    public RegisterDto getRegisterById(@PathVariable(name = "id")  Long id) {
        return iRegisterService.getRegisterById(id);
    }

    // UPDATE
    // http://localhost:5555/register/1
    @Override
    @PutMapping("/{id}")
    public RegisterDto updateRegister(@PathVariable("id")  Long id, @RequestBody RegisterDto registerDto) {
        return iRegisterService.updateRegister(id,registerDto);
    }

    // DELETE
    // http://localhost:5555/register/1
    // Delete için sadece id yeterli objeyi çağırmadım boş yerine serveri yormak istemedim.
    @Override
    @DeleteMapping("")
    public Map<String, Boolean> deleteRegister(@PathVariable(name = "id")  Long id) {
        return iRegisterService.deleteRegister(id);
    }
}
