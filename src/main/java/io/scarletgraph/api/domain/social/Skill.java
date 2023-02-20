package io.scarletgraph.api.domain.social;

import io.scarletgraph.api.enums.Level;
import io.scarletgraph.api.generic.IModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Enumerated;

public class Skill extends IModel {

    @Getter
    @Setter
    private String content;

    @Enumerated
    @Getter
    @Setter
    private Level level;
}
