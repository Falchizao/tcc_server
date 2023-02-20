package io.scarletgraph.api.enums;

public enum Level {
    BASIC("basic"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced");

    private String content;

    private Level (String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}

