package io.scarletgraph.api.generator;

import com.github.javafaker.Faker;
import io.scarletgraph.api.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class UserGenerator {

    @Autowired
    private final Faker faker;

    public User normalUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .password(faker.internet().password())
                .email(faker.internet().emailAddress())
                .build();
    }

    public User userInvalid() {
        return User.builder()
                .username(null)
                .firstName(null)
                .password(null)
                .email(null)
                .role(null)
                .build();
    }
}