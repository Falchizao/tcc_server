package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

import java.math.BigDecimal;
import java.util.List;

public class Offer extends IModel {

    private BigDecimal salary;

    private String content;

    private User employer;

    @ManyToMany
    @JoinColumn(name="tb_user")
    private List<User> candidates;


}
