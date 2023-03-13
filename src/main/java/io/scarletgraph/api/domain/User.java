package io.scarletgraph.api.domain;

import io.scarletgraph.api.enums.Role;
import io.scarletgraph.api.generic.IModel;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity(name = "tb_user")
@javax.persistence.Table(uniqueConstraints = {
        @UniqueConstraint(name = "setuniquename", columnNames = "username"),
        @UniqueConstraint(name = "setuniqueemail", columnNames = "email")
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends IModel implements UserDetails   {

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @Column(name = "email", length = 50)
    @NotNull(message = "The email must not be null!")
    @Getter
    @Setter
    String email;

    @Column(name = "cellphone", length = 15)
    private String cellphone;

    @Column(name = "username")
    @NotNull(message = "The Username must not be null!")
    @Getter
    @Setter
    @Size(min = 6, max = 20)
    String username;

    @Column(name = "first_name")
    @Getter
    @Size(min = 4, max = 20)
    @Setter
    String firstName;

    @Column(name = "last_name")
    @Size(min = 4, max = 20)
    @Getter
    @Setter
    String lastName;

    @Enumerated
    @Setter
    @Column(name = "type")
    private Role role;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    private Set<Permission> permission;

    @Getter
    @Setter
    @NotNull(message = "The password must not be null!")
    @Size(min = 8, max = 100)
    String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.addAll(this.permission);
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
