package io.scarletgraph.api.domain;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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
