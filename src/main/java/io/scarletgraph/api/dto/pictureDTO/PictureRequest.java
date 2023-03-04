package io.scarletgraph.api.dto.pictureDTO;

import lombok.Getter;
import lombok.Setter;

public class PictureRequest {

    @Getter
    private byte[] data;

    @Getter
    private String name;

    @Setter
    private Long size;
}
