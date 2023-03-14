package io.scarletgraph.api.domain.social;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    @Getter
    @Setter
    private String sender;

    @Getter
    @Setter
    private String receiver;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String date;
}
