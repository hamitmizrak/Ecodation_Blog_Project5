package com.hamitmizrak.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.Date;
import java.util.Map;

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

//Backentten Frontende bilgi göndermek istersek
//Eğer Null giderse frontentte gösterme
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    //field
    private Date date = new Date(System.currentTimeMillis());
    private int status;
    private String error;
    private String message;
    private String path;

    //validationError
    private Map<String, String> validationErrors;

    //parametreli constructors
    public ApiResult(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public ApiResult(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
