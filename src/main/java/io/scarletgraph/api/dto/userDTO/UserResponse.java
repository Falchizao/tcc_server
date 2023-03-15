package io.scarletgraph.api.dto.userDTO;

import lombok.Builder;
import lombok.Setter;

@Builder
public class UserResponse {

    @Setter
    private String username;
}
