package io.scarletgraph.api.dto.postDTO;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Builder
public class PostResponse {

    private String username;
    private String content;
    private Date createdDate;
}






