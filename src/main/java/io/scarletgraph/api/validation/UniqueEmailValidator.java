package io.scarletgraph.api.validation;

import io.scarletgraph.api.ContextProvider;
import io.scarletgraph.api.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private UserRepository userRepository;


    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext constraintValidatorContext) {
        try{
            if (userRepository.findByEmail(email) == null) {
                return true;
            }
        }catch (Exception e){
            String a = e.getMessage();
        }

        return false;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        this.userRepository = (UserRepository) ContextProvider.getBean(UserRepository.class);

    }
}