package io.scarletgraph.api.dto.userDTO;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class PictureDTO {

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
