package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Offer extends IModel {

    @NotNull
    @Setter
    @Getter
    private BigDecimal salary;

    @Column(name = "createdDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Getter
    @Setter
    @NotNull
    private Date createdDate;

    @Getter
    @Setter
    @NotNull
    private Double hours;

    @NotNull
    @Setter
    @Getter
    private String content;

    @NotBlank
    @Setter
    @Getter
    private String title;

    @NotBlank
    @Setter
    @Getter
    private String location;

    @NotBlank
    @Setter
    @Getter
    private String requirements;

    @NotNull
    @Setter
    @Getter
    private Boolean remote;

    @OneToOne
    @JoinColumn(name="tb_user")
    @Setter
    @Getter
    private User employer;

    @ManyToMany
    @Getter
    @Setter
    @JoinColumn(name="tb_user")
    private List<User> candidates;
}
