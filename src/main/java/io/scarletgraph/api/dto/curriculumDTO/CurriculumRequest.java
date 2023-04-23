package io.scarletgraph.api.dto.curriculumDTO;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class CurriculumRequest {
    @NotBlank(message = "The Curriculum owner name must not be null")
    @Getter
    public String username;
}