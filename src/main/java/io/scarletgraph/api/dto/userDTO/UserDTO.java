package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.enums.Role;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;

public class UserDTO {

    @Getter
    @Setter
    private String uid;

    @Getter
    @Setter
    private String picture;

    @Getter
    @Setter
    String email;

    @Getter
    @Setter
    String username;

    @Getter
    @Setter
    String firstName;

    @Getter
    @Setter
    String lastName;

    @Enumerated
    private Role role;

    @Getter
    @Setter
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    String password;

}
