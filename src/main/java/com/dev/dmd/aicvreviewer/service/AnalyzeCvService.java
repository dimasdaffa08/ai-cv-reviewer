package com.dev.dmd.aicvreviewer.service;

import com.dev.dmd.aicvreviewer.model.response.AnalyzeCvResponse;
import com.dev.dmd.aicvreviewer.utils.FileParser;
import com.dev.dmd.aicvreviewer.utils.Llama3WebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AnalyzeCvService {

    private final Llama3WebClient llama3WebClient;

    public ResponseEntity<AnalyzeCvResponse> execute(MultipartFile file) {
        var content = FileParser.parsePDF(file);
        String prompt = """
            You are a career advisor.
            
            Please analyze this CV and provide the results in the following strict format (do not include any styling, markdown, or numbering):
            
            Score:
            <number between 1 and 100>
            
            Strengths:
            ...
            
            Improvements:
            ...
            
            Summary:
            <one paragraph rewritten summary>
            
            CV CONTENT:
        """ + content;

        var result = llama3WebClient.callLlama3(prompt);

        return ResponseEntity.ok(llama3WebClient.parseResultToModel(result));
    }
}
