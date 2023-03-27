package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

@Entity
@Table(name = "tb_authority")
public class Authority extends IModel implements GrantedAuthority {

    @Column(length = 50, nullable = false)
    private String authority;

    @Override
    public String getAuthority() {
        return null;
    }
}