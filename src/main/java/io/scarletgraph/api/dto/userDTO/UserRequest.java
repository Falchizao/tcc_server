package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.enums.Role;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import javax.persistence.Enumerated;

public class UserRequest {

    private String firstName;
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
}
