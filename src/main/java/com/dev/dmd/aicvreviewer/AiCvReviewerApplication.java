package com.dev.dmd.aicvreviewer;

import com.dev.dmd.aicvreviewer.config.properties.AiCvReviewerProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AiCvReviewerProps.class)
public class AiCvReviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCvReviewerApplication.class, args);
    }

}
