package io.scarletgraph.api.dto.OfferDTO;

import lombok.Getter;
import javax.validation.constraints.NotNull;

public class OfferFilterRequest {

    @Getter
    @NotNull(message = "Label must not be null!")
    String label;

    @Getter
    @NotNull(message = "Type must not be null!")
    Boolean type;

    @Getter
    @NotNull(message = "Remote must not be null!")
    Boolean remote;
}
