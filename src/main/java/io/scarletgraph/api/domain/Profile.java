package io.scarletgraph.api.domain;

import io.scarletgraph.api.domain.social.Skill;
import io.scarletgraph.api.generic.IModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile extends IModel {

    @Getter
    @Setter
    @Lob
    @Column(name="profile_banner")
    private byte[] profile_banner;

    @Getter
    @Setter
    @Lob
    @Column(name="profile_picture")
    private byte[] profile_picture;


    @Getter
    @Setter
    @OneToMany(mappedBy = "profile",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Skill> skills;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String location;
}
