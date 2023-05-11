package io.scarletgraph.api.dto.emailDTO;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class EmailSenderRequest {

    @Getter
    @NotNull(message = "Username must not be null!")
    private String username;

    @Getter
    @NotNull(message = "OfferID must not be null!")
    private Long offer_id;
}
