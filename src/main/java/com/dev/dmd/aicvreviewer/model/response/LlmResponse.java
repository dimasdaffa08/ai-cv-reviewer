package com.dev.dmd.aicvreviewer.model.response;

import lombok.Builder;

import java.util.List;

@Builder
public class LlmResponse {
    public String id;
    public String object;
    public String model;
    public String systemFingerprint;
    public List<Choice> choices;
}
