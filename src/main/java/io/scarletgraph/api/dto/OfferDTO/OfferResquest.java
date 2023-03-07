package io.scarletgraph.api.dto.OfferDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OfferResquest {

    @NotNull(message = "Salary must not be null!")
    private BigDecimal salary;

    @NotNull(message = "Content must not be null!")
    private String content;
}

