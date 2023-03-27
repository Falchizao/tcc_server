package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.enums.Role;
import lombok.Builder;
import lombok.Setter;

import java.io.Serializable;

@Builder
public class UserResponse implements Serializable {

    @Setter
    private String username;

    @Setter
    private Role role;
}
