package io.scarletgraph.api.utils;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static String parseDateToString(LocalDate dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt.format(formatter);
    }
    public String generateEmailMessage (String content) {
        StringBuilder sb = new StringBuilder();

        sb.append("You have been selected for the offer " + content + "\n");
        sb.append("We are happy that you could find a new job with us!\n");
        sb.append("With love, scarlet_graph...\n");

        return sb.toString();
    }
}
