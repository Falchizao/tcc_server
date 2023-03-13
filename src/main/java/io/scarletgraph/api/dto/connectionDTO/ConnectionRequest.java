package io.scarletgraph.api.dto.connectionDTO;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class ConnectionRequest {
    @NotBlank
    @Getter
    public String connection_name;
}
