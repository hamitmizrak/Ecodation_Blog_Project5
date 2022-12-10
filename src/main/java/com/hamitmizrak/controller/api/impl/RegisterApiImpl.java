package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.controller.api.IRegisterApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Lombok
@RequiredArgsConstructor
@Log4j2

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
    public ResponseEntity<RegisterDto> createRegister(@Valid @RequestBody RegisterDto registerDto) {
        iRegisterService.createRegister(registerDto);
        return ResponseEntity.ok(registerDto);
    }

    // LIST
    // http://localhost:5555/register/list
    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<RegisterDto>> getAllRegister() {
        return ResponseEntity.ok(iRegisterService.getAllRegister());
    }

    // FIND
    // http://localhost:5555/register
    // http://localhost:5555/register/0
    // http://localhost:5555/register/1
    @Override
    @GetMapping({"","/{id}"})
    public ResponseEntity<?> getRegisterById(@PathVariable(name = "id",required = false) Long id) {
        if (id == null) {
            log.error("404 Not Found --> Bulunmadı");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request--> Kötü istek");
            return ResponseEntity.badRequest().build();
        }
        log.info("Veri bulundu");
        return ResponseEntity.ok(iRegisterService.getRegisterById(id));
    }

    // UPDATE
    // http://localhost:5555/register/1
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegister(@PathVariable(name = "id",required = false) Long id, @Valid @RequestBody RegisterDto registerDto) {
        if (id == null) {
            log.error("404 Not Found --> Bulunmadı");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request--> Kötü istek");
            return ResponseEntity.badRequest().build();
        }
        log.info("Veri bulundu");
        return ResponseEntity.ok(iRegisterService.updateRegister(id, registerDto));
    }

    // DELETE
    // http://localhost:5555/register/1
    // Delete için sadece id yeterli objeyi çağırmadım boş yerine serveri yormak istemedim.
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRegister(@@PathVariable(name = "id",required = false) Long id) {
        if (id == null) {
            log.error("404 Not Found --> Bulunmadı");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request--> Kötü istek");
            return ResponseEntity.badRequest().build();
        }
        log.info("Veri bulundu");
        return ResponseEntity.ok(iRegisterService.deleteRegister(id));
    }
}
