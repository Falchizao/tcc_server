package io.scarletgraph.api.domain;

import io.scarletgraph.api.generic.IModel;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

@Entity
@Table(name = "tb_authority")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class Authority extends IModel implements GrantedAuthority {

    @Column(length = 50, nullable = false)
    private String authority;
}