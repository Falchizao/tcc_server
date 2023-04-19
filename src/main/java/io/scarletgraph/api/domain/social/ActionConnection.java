package io.scarletgraph.api.domain.social;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class ActionConnection {
    @Getter
    @NotNull(message = "action must not be null")
    Boolean follow;
}
