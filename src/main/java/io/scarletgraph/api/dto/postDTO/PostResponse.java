package io.scarletgraph.api.dto.postDTO;

import io.scarletgraph.api.domain.User;
import lombok.*;

import java.util.Date;

public class PostResponse {

    @Getter
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Getter
    private String content;

    @Getter
    private Date createdDate;
}






