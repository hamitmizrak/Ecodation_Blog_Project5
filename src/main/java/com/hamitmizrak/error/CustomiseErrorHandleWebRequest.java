package com.hamitmizrak.error;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Lombok
@RequiredArgsConstructor

//Spring boot defaultta gelen hataları kendimize göre revize yaptıl
@RestController
@CrossOrigin //CORS
//Spring boot Error and Exception Handling
public class CustomiseErrorHandleWebRequest implements ErrorController {

    //1.YOL
    //exception handling :400
    //eğer input verilerimizde validation işlemi devereye girdiğinde bu metot çalışacak
  /*
  @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult handleValidationErrorException1(MethodArgumentNotValidException exception){
        ApiResult error=new ApiResult(400,"Validation Error","/error");
        Map<String,String> validationErrors=new HashMap<>();
        for( FieldError fieldError :exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        } //end for
        error.setValidationErrors(validationErrors);
        return error;
    }
    */

    //2.YOL
    //constructor Injection
    private final ErrorAttributes errorAttributes;

    //Spring hataları benim yazdığım handling(yakalamak)
    @RequestMapping("/error")
    ApiResult handleValidationErrorException2(WebRequest webRequest) {
        //Spring +2.3>
        Map<String, Object> attributes = this.errorAttributes.getErrorAttributes
                (
                        webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS)
                );
        int status = (Integer) attributes.get("status");
        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");
        ApiResult apiResult = new ApiResult(status, message, path);

        if (attributes.containsKey("errors")) {
            List<FieldError> listFieldErrors = (List<FieldError>) attributes.get("errors");
            Map<String, String> validationMistake = new HashMap<>();
            for (FieldError temp : listFieldErrors) {
                validationMistake.put(temp.getField(), temp.getDefaultMessage());
            }
            apiResult.setValidationErrors(validationMistake);
        }
        return apiResult;
    } // 2.yol

} //end class
