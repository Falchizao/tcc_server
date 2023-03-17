package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public class Authority extends IModel implements GrantedAuthority {

    @Column(length = 10, nullable = false)
    private String authority;
}