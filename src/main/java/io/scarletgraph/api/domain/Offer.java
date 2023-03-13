package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @NotNull
    @Setter
    @Getter
    private String content;

    @OneToOne
    @JoinColumn(name="tb_user")
    @Setter
    @Getter
    private User employer;

    @ManyToMany
    @Getter
    @JoinColumn(name="tb_user")
    private List<User> candidates;
}
