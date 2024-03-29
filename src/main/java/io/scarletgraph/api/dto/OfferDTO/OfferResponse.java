package io.scarletgraph.api.dto.OfferDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class OfferResponse {
    private Long id;
    private BigDecimal salary;
    private String content;
    private String employer;
    private Double hours;
    private Date createdDate;
    private String title;
    private String location;
    private String requirements;
    private Boolean remote;
}
