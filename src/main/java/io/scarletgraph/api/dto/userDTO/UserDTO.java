package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.enums.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class UserDTO {

    @Getter
    @Setter
    private Long id;

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
