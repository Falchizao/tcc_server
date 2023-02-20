package io.scarletgraph.api.domain;

import io.scarletgraph.api.domain.social.Picture;
import io.scarletgraph.api.domain.social.Skill;
import io.scarletgraph.api.generic.IModel;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Profile extends IModel {

    @Getter
    @Setter
    private Picture picture;

    @Getter
    @Setter
    @OneToMany
    private List<Skill> skills;

    @Getter
    @Setter
    private String description;
}
