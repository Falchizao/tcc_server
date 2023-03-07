package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
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