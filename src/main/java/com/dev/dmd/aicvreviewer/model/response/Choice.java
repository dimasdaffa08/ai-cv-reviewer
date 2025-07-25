package com.dev.dmd.aicvreviewer.model.response;

import com.dev.dmd.aicvreviewer.model.request.Message;
import lombok.Builder;

@Builder
public class Choice {
    public Integer index;
    public Message message;
}
