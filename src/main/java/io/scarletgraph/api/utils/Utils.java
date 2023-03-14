package io.scarletgraph.api.utils;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Component
public class Utils {

    public Collection<InternetAddress> getEmailToSend(final String email) throws AddressException {
        Collection<InternetAddress> addresses = new ArrayList<>();
        InternetAddress emailAddress = new InternetAddress(email);
        addresses.add(emailAddress);
        return addresses;
    }

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
        sb.append("\nWe are happy that you could find a new job with us!\n");
        sb.append("\nWith love, scarlet_graph...\n");

        return sb.toString();
    }
}
