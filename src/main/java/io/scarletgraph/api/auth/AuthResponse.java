package io.scarletgraph.api.auth;

import io.scarletgraph.api.enums.Role;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthResponse implements Serializable {

    private String token;
    private Role user_role;

}