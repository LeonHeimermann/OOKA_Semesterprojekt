package org.ooka.bffservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.ConfigurationDTO;
import org.ooka.bffservice.service.AnalysisService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AnalysisController {

    private final AnalysisService analysisService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SseEmitter> analyseAll(@RequestBody ConfigurationDTO configuration) {
        try {
            SseEmitter sseEmitter = analysisService.analyse(configuration);
            return ResponseEntity.ok(sseEmitter);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
