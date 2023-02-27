package io.scarletgraph.api.domain;

import io.scarletgraph.api.domain.social.Skill;
import io.scarletgraph.api.generic.IModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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

    @Setter
    @OneToOne(mappedBy = "profile")
    private User user;

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
}
