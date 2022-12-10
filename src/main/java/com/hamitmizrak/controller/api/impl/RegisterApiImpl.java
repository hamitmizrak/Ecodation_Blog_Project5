package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.controller.api.IRegisterApi;
import com.hamitmizrak.error.ApiResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

//Lombok
@RequiredArgsConstructor
@Log4j2

//Dış dünyaya açılan kapı
@RestController
@RequestMapping("register")
public class RegisterApiImpl  implements IRegisterApi {

    //Constructor injection
    private final IRegisterService iRegisterService;

    //Accept-Language:tr


    // Header INFORMATION
    // http://localhost:5555/register/headers
    @GetMapping("/headers")
    public void getAllHeaderData(@RequestHeader Map<String,String> headers){
        headers.forEach((key,value)->{
            System.out.println("HeaderName: "+key+" HeaderValue: "+value);
        });
    }

    //APP INFORMATION
    // http://localhost:5555/register/app/information
    @GetMapping("/app/information")
    public ResponseEntity<?> getAppInformation(HttpServletRequest request, HttpServletResponse response) {
        String URI = request.getRequestURI();
        String LOCALHOST = request.getLocalAddr();
        String SESSION = request.getSession().toString();

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("uri: "+URI).append("<br/>localhost: "+LOCALHOST).append("<br/>session: "+SESSION);
        String informationToString=stringBuilder.toString();
        return ResponseEntity.ok(informationToString);
    }


    // CREATE
    // http://localhost:5555/register
    @Override
    @PostMapping//headers = "Register-version-1"
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
    @GetMapping({"", "/{id}"})
    public ResponseEntity<?> getRegisterById(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("404 Not Found --> Bulunmadı");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request--> Kötü istek");
            return ResponseEntity.badRequest().body("Kötü istek ");
        } else if (id == -1) {
            log.error("400 Bad Request--> Kötü istek");
            //String error, String message, String path
            ApiResult apiResult= ApiResult.builder()
                    .error("401")
                    .message("unAuthorized")
                    .path("localhost:5555/register")
                    .build();
            return ResponseEntity.status(401).body(apiResult);
        }
        log.info("Veri bulundu");
        return ResponseEntity.ok(iRegisterService.getRegisterById(id));
    }

    // UPDATE
    // http://localhost:5555/register/1
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegister(@PathVariable(name = "id", required = false) Long id, @Valid @RequestBody RegisterDto registerDto) {
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
    public ResponseEntity<Map<String, Boolean>> deleteRegister(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("404 Not Found --> Bulunmadı");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request--> Kötü istek");
            return ResponseEntity.badRequest().build();
        }
        log.info("Veri bulundu");

        //return ResponseEntity.status(HttpStatus.OK).body(iRegisterService.deleteRegister(id));
        //return ResponseEntity.status(200).body(iRegisterService.deleteRegister(id));
        return ResponseEntity.ok(iRegisterService.deleteRegister(id));
    }
}
