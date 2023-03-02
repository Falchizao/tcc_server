package io.scarletgraph.api.validation;

import io.scarletgraph.api.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

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