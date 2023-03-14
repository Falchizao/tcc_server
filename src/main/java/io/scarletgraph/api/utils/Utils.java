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
    public String generateEmailMessage(String content) {
        return """
                <h1>You have been selected for the offer: %s
                        <br>We are happy that you could find a new job with us!</h1>
                        <h2><br>With love, </h2> <h1 style="font-size:30px; color:#FF0000; font-weight:bold; font-style:italic;">scarlet_graph...</p> </h1>
                        <br><img src="https://cdn.pixabay.com/photo/2016/03/31/19/25/cartoon-1294994_960_720.png" alt="Image!" height="200px" width="200px" />
                """.formatted(content);
    }
}
