package io.scarletgraph.api.dto.connectionDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class ConnectionRequest {
    @NotBlank
    @Getter
    public String connection_name;
}
