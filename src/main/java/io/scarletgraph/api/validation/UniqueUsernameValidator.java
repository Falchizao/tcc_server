package io.scarletgraph.api.validation;

import io.scarletgraph.api.repository.UserRepository;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class
UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(userRepository.findUserByUsername(value) == null){
            return true;
        }
        return false;
    }

}