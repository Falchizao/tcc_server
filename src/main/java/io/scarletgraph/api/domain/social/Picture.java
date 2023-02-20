package io.scarletgraph.api.domain.social;

import io.scarletgraph.api.generic.IModel;
import lombok.Getter;
import lombok.Setter;
import java.sql.Blob;

public class Picture extends IModel {

    @Getter
    @Setter
    private Blob image;

    @Setter
    private String name;

    @Setter
    private Long size;

}
