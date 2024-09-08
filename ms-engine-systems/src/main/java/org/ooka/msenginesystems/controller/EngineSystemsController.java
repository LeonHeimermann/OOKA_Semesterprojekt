package org.ooka.msenginesystems.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.msenginesystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msenginesystems.service.EngineSystemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EngineSystemsController {

    private final EngineSystemsService engineSystemsService;

    @PostMapping("/analyse")
    public ResponseEntity<String> analyse(@RequestBody AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        engineSystemsService.analyse(analysisConfigurationRequestModel);
        return ResponseEntity.ok("Engine System Analysis");
    }
}
