package com.dev.dmd.aicvreviewer.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AnalyzeCvResponse {
    private Integer score;
    private String strengths;
    private String improvements;
    private String summary;
}
