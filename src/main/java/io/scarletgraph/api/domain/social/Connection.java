package io.scarletgraph.api.domain.social;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.generic.IModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "connection")
public class Connection extends IModel {

    @Column(name = "connection_date")
    @Getter
    @Setter
    @NotNull
    private Date connection_date;

    @OneToOne
    @JoinColumn(name = "first_user_id", referencedColumnName = "id")
    @Getter
    @Setter
    User firstUser;

    @OneToOne
    @JoinColumn(name= "second_user_id", referencedColumnName = "id")
    @Getter
    @Setter
    User secondUser;

}
