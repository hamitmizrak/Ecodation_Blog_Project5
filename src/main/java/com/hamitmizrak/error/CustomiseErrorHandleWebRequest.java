package com.hamitmizrak.error;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//Lombok
@RequiredArgsConstructor

//Spring boot defaultta gelen hataları kendimize göre revize yaptıl
@RestController
@CrossOrigin //CORS
public class CustomiseErrorHandleWebRequest implements ErrorController {

    //constructor Injection
    private final ErrorAttributes errorAttributes;

    //Spring hataları benim yazdığım handling(yakalamak)
    @RequestMapping("/error")
    ApiResult handleError(WebRequest webRequest){
        //Spring +2.3>
        Map<String, Object> attributes=this.errorAttributes
                .getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.BINDING_ERRORS));
        int status= (Integer) attributes.get("status");
        String message=(String)attributes.get("message");
        String path=(String)attributes.get("path");
        ApiResult apiResult=new ApiResult(status,message,path);

        if(attributes.containsKey("errors")){
            List<FieldError> listFieldErrors= (List<FieldError>) attributes.get("errors");
            Map<String,String>validationMistake=new HashMap<>();
            for(FieldError temp:listFieldErrors){
                validationMistake.put(temp.getField(),temp.getDefaultMessage());
            }
            apiResult.setValidationErrors(validationMistake);
        }
        return apiResult;
    }

}
