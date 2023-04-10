package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.enums.Role;
import lombok.Getter;

import javax.persistence.Enumerated;


public class UserRequest {

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String username;

    @Getter
    private String email;

    @Getter
    private String password;

    @Enumerated
    @Getter
    private Role role;

    @Getter
    private String description;

    @Getter
    private String location;
}
