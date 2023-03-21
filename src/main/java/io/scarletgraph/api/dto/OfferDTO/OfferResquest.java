package io.scarletgraph.api.dto.OfferDTO;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class OfferResquest {

    @NotNull(message = "Salary must not be null!")
    private BigDecimal salary;

    @NotNull(message = "Content must not be null!")
    private String content;

    @NotNull(message = "Title must not be null!")
    private String title;

    @NotNull(message = "Hours must not be null!")
    private Double hours;
}

