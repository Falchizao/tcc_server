package io.scarletgraph.api.domain;

import io.scarletgraph.api.enums.Role;
import io.scarletgraph.api.generic.IModel;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity(name = "tb_user")
@Table(uniqueConstraints = {
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
    @Email(message = "Invalid email format, please verify!", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    String email;

    @Column(name = "cellphone", length = 20)
    @Size(max = 20, message = "Invalid cellphone number, please verify!")
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
    @Getter
    @Column(name = "type")
    private Role role;

    @Setter
    @Getter
    private Boolean isfollowing;


    @Getter
    @Setter
    @NotNull(message = "The password must not be null!")
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.addAll(this.authorities);
        return list;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Getter
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(
                    name = "tb_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
