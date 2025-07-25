package com.dev.dmd.aicvreviewer.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openai")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AiCvReviewerProps {
    public String baseUrl;
    public String apiKey = "dummy";
    public String model = "llama3";
    public Integer connectTimeoutMs = 6000;
    public Integer readTimeoutMs = 6000;
    public Url url = new Url();

    @Getter
    public class Url {
        public String chatCompletions = "/v1/chat/completions";
    }
}
