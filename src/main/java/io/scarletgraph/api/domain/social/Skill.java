package io.scarletgraph.api.domain.social;

import io.scarletgraph.api.domain.Profile;
import io.scarletgraph.api.enums.Level;
import io.scarletgraph.api.generic.IModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "skill")
@Entity
public class Skill extends IModel {

    @Getter
    @Setter
    @NotNull
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Enumerated
    @Getter
    @Setter
    private Level level;
}
