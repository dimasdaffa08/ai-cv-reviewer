package com.dev.dmd.aicvreviewer.model.request;

import lombok.Builder;

@Builder
public class Message {
    public String role;
    public String content;
}