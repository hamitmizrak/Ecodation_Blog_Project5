package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//401: Yetkisiz Giriş
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ResourceAuthorizedException extends RuntimeException{

    //parametreli constructor
    public ResourceAuthorizedException(String message) {
        super(message);
    }
}
