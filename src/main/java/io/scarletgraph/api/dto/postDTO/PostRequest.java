package io.scarletgraph.api.dto.postDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class PostRequest {

    @Getter
    @NotNull(message = "Content must not be null!")
    private String content;
}
