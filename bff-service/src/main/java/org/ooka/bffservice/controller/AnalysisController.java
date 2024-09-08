package org.ooka.bffservice.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.client.AuxiliarySystemsClient;
import org.ooka.bffservice.model.AnalysisConfigurationRequestModel;
import org.ooka.bffservice.service.AnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AnalysisController {

    private final AuxiliarySystemsClient auxiliarySystemsClient;
    private final AnalysisService analysisService;

    @PostMapping
    public ResponseEntity analyseAll(@RequestBody AnalysisConfigurationRequestModel config) {
        System.out.println("received configuration:" + config);
        analysisService.analyse(config);
        return ResponseEntity.ok().build();
    }

}
