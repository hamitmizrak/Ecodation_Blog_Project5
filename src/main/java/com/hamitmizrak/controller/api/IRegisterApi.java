package com.hamitmizrak.controller.api;
import com.hamitmizrak.business.dto.RegisterDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;
public interface IRegisterApi {

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
