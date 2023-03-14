package io.scarletgraph.api.utils;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.dto.userDTO.UserDTO;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

@Component
public class Utils {

    public Collection<InternetAddress> getEmailToSend(final String email) throws AddressException {
        Collection<InternetAddress> addresses = new Collection<InternetAddress>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<InternetAddress> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(InternetAddress internetAddress) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends InternetAddress> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
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
        sb.append("We are happy that you could find a new job with us!\n");
        sb.append("With love, scarlet_graph...\n");

        return sb.toString();
    }
}
