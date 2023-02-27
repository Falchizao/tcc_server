package io.scarletgraph.api.domain;

import io.scarletgraph.api.enums.Role;
import io.scarletgraph.api.generic.IModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@jakarta.persistence.Entity
@Table(name = "tb_user")
public class User extends IModel  {

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @Column(name = "email")
    @Getter
    @Setter
    String email;

    @Column(name = "username")
    @Getter
    @Setter
    @Size(min = 6, max = 20)
    String username;

    @Column(name = "first_name")
    @Getter
    @Setter
    String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    String lastName;

    @Enumerated
    @Setter
    @Column(name = "type")
    private Role role;

    @Getter
    @Setter
    @Size(min = 8, max = 100)
    String password;
}
