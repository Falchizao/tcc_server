package io.scarletgraph.api.dto.postDTO;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class PostRequest {

    @Getter
    @NotNull(message = "Content must not be null!")
    private String content;
}
