package com.dev.dmd.aicvreviewer.utils;

import com.dev.dmd.aicvreviewer.config.properties.AiCvReviewerProps;
import com.dev.dmd.aicvreviewer.model.request.LlmRequest;
import com.dev.dmd.aicvreviewer.model.request.Message;
import com.dev.dmd.aicvreviewer.model.response.AnalyzeCvResponse;
import com.dev.dmd.aicvreviewer.model.response.LlmResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Configuration
public class Llama3WebClient {

    private final AiCvReviewerProps props;
    private final RestClient restClient;

    public String callLlama3(String prompt) {
        var bodyRequest = LlmRequest.builder()
                .model(props.getModel())
                .messages(List.of(Message.builder()
                        .role("user")
                        .content(prompt)
                        .build())
                ).build();

        var response = restClient.post()
                .uri(props.getUrl().getChatCompletions())
                .body(bodyRequest)
                .retrieve()
                .body(LlmResponse.class);

        return response.choices.get(0).message.content;
    }

    public AnalyzeCvResponse parseResultToModel(String result) {
        var analysis = AnalyzeCvResponse.builder();

        var scorePattern = Pattern.compile("Score:\\s*(\\d+)");
        var scoreMatcher = scorePattern.matcher(result);
        if (scoreMatcher.find()) {
            analysis.score(Integer.parseInt(scoreMatcher.group(1)));
        }

        var strengthsPattern = Pattern.compile("Strengths:\\s*(.*?)\\n(?:Improvements|$)", Pattern.DOTALL);
        var strengthsMatcher = strengthsPattern.matcher(result);
        if (strengthsMatcher.find()) {
            analysis.strengths(strengthsMatcher.group(1).trim());
        }

        var improvementsPattern = Pattern.compile("Improvements:\\s*(.*?)\\n(?:Summary|$)", Pattern.DOTALL);
        var improvementsMatcher = improvementsPattern.matcher(result);
        if (improvementsMatcher.find()) {
            analysis.improvements(improvementsMatcher.group(1).trim());
        }

        var summaryPattern = Pattern.compile("Summary:\\s*(.*)", Pattern.DOTALL);
        var summaryMatcher = summaryPattern.matcher(result);
        if (summaryMatcher.find()) {
            analysis.summary(summaryMatcher.group(1).trim());
        }

        return analysis.build();
    }
}
