package io.scarletgraph.api.domain.social;

import io.scarletgraph.api.domain.User;
import io.scarletgraph.api.generic.IModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_connection")
public class Connection extends IModel {

    @Column(name = "connection_date")
    @Getter
    @Setter
    private Date connection_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "first_user_id", referencedColumnName = "id")
    @Getter
    @Setter
    User firstUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "second_user_id", referencedColumnName = "id")
    @Getter
    @Setter
    User secondUser;

}
