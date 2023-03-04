package io.scarletgraph.api.utils;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import io.scarletgraph.api.enums.Role;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Utils {

    public User syncUpdateUser(User user, UserDTO dto) {
        if (dto.getPassword() != null){
            user.setPassword(dto.getPassword());
        }

        if (dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }

        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        if(dto.getFirstName() != null) {
            user.setFirstName(dto.getFirstName());
        }

        if(dto.getLastName() != null) {
            user.setLastName(dto.getLastName());
        }

        return user;
    }

    public Date getDate(){
        return new Date();
    }
}
