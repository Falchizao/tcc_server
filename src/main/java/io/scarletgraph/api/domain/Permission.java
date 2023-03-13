package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "permission")
public class Permission extends IModel implements Serializable, GrantedAuthority {

    @Column(name = "description", length = 20, nullable = false)
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }
}