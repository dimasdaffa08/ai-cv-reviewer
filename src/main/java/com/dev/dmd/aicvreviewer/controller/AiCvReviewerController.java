package com.dev.dmd.aicvreviewer.controller;

import com.dev.dmd.aicvreviewer.model.response.AnalyzeCvResponse;
import com.dev.dmd.aicvreviewer.service.AnalyzeCvService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "cv/v1")
public class AiCvReviewerController {

    private final AnalyzeCvService analyzeCvService;

    @PostMapping("/analyze")
    public ResponseEntity<AnalyzeCvResponse> chat(@RequestParam MultipartFile file) {
        return analyzeCvService.execute(file);
    }
}
