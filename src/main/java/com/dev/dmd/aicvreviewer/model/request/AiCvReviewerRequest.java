package com.dev.dmd.aicvreviewer.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AiCvReviewerRequest {
    String message;
}
