package io.scarletgraph.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class Picture {

    @Lob
    @Getter
    @Setter
    @NotNull
    private byte[] data;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Long size;
}
