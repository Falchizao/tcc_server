package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Builder
@Getter
@Setter
public class UserResponse implements Serializable {

    private String firstName;
    private String lastName;
    private String username;
    private Role role;
    private String description;
    private String location;
    private String email;
}
