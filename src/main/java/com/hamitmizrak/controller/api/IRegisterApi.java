package com.hamitmizrak.controller.api;
import com.hamitmizrak.business.dto.RegisterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
public interface IRegisterApi {

    //PROFILE
    String getProfile(@PathVariable(name = "data") String name);

    // Header INFORMATION
    void getAllHeaderData(@RequestHeader Map<String, String> headers);

    //APP INFORMATION
    ResponseEntity<?> getAppInformation(HttpServletRequest request, HttpServletResponse response);

    // CREATE
    ResponseEntity<RegisterDto> createRegister(RegisterDto registerDto);

    // LIST
    ResponseEntity<List<RegisterDto>>  getAllRegister();

    // FIND
    ResponseEntity<?>  getRegisterById(Long id);

    // UPDATE
    ResponseEntity<?>  updateRegister( Long id,RegisterDto registerDto);

    // DELETE
    ResponseEntity< Map<String, Boolean>> deleteRegister( Long id);
}
