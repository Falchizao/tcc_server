package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.enums.Role;
import lombok.*;

import javax.validation.constraints.Pattern;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Setter
    @Getter
    Role role;

    @Getter
    @Setter
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    String password;

}
