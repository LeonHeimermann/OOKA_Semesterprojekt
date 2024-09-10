package org.ooka.bffservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.service.AnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AnalysisController {

    private final AnalysisService analysisService;

    @GetMapping()
    public ResponseEntity<SseEmitter> analyseAll(@RequestParam String data) {
        System.out.println("received configuration:" + data);
        try {
            SseEmitter sseEmitter = analysisService.analyse(data);
            return ResponseEntity.ok(sseEmitter);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
