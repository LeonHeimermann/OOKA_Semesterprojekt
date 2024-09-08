package org.ooka.bffservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.AnalysisConfigurationRequestModel;
import org.ooka.bffservice.service.AnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AnalysisController {

    private final AnalysisService analysisService;

    @PostMapping
    public ResponseEntity analyseAll(@RequestBody AnalysisConfigurationRequestModel config) {
        System.out.println("received configuration:" + config);
        try {
            analysisService.analyse(config);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }

}
