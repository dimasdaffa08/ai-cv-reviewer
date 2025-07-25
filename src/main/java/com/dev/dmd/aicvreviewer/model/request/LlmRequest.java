package com.dev.dmd.aicvreviewer.model.request;

import lombok.Builder;

import java.util.List;

@Builder
public class LlmRequest {
    public String model;
    public List<Message> messages;
}
