package io.scarletgraph.api.dto.userDTO;

import io.scarletgraph.api.domain.Authority;
import lombok.Builder;
import lombok.Setter;
import java.util.Set;

@Builder
public class UserResponse {

    @Setter
    private String username;

    @Setter
    private Set<Authority> authorities;
}
