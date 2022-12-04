package com.hamitmizrak.annotation;


import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

//lombok
@RequiredArgsConstructor
public class RegisterUniqueEmailValidation implements ConstraintValidator<RegisterUniqueEmail,String> {

    //injection constructor
    private final IRegisterRepository iRegisterRepository;
    
    // is Valid
    @Override
    public boolean isValid(String emailAddress, ConstraintValidatorContext constraintValidatorContext) {
        RegisterEntity registerEntity=iRegisterRepository.findByEmail(emailAddress);
        //eğer bu email address sistemde varsa return false döndür
        if(registerEntity!=null)
            return false;
        return true;
    }
}
