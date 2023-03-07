package io.scarletgraph.api.dto.OfferDTO;

import io.scarletgraph.api.domain.User;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class OfferResponse {

    @Getter
    @Setter
    private BigDecimal salary;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private User employer;
}
