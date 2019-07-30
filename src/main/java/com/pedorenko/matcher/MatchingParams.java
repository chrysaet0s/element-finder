package com.pedorenko.matcher;

import java.util.Map;

public class MatchingParams {

    private String tagName;

    private Map<String, String> attributes;

    private String content;

    public MatchingParams(String tagName, Map<String, String> attributes, String content) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.content = content;
    }

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getContent() {
        return content;
    }
}
