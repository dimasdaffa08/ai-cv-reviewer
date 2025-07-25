package com.dev.dmd.aicvreviewer.config;

import com.dev.dmd.aicvreviewer.config.properties.AiCvReviewerProps;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

    private final AiCvReviewerProps props;

    @Bean
    public RestClient restClient() {

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(props.getConnectTimeoutMs());
        requestFactory.setReadTimeout(props.getReadTimeoutMs());

        return RestClient.builder()
                .baseUrl(props.getBaseUrl())
                .requestFactory(requestFactory)
                .build();
    }
}
