package io.scarletgraph.api.domain;

import io.scarletgraph.api.enums.Role;
import io.scarletgraph.api.generic.IModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@jakarta.persistence.Entity(name = "tb_user")
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "setuniquename", columnNames = "username"),
        @UniqueConstraint(name = "setuniqueemail", columnNames = "email")
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends IModel  {

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @Column(name = "email")
    @NotNull
    @Getter
    @Setter
    String email;

    @Column(name = "username")
    @NotNull
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

    @Getter
    @Setter
    @NotNull
    @Size(min = 8, max = 100)
    String password;
}
