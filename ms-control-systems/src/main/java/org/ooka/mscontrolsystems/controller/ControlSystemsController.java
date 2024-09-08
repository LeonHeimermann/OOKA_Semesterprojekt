package org.ooka.mscontrolsystems.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.mscontrolsystems.model.AnalysisConfigurationRequestModel;
import org.ooka.mscontrolsystems.service.ControlSystemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ControlSystemsController {

    private final ControlSystemsService controlSystemsService;

    @PostMapping("/analyse")
    public ResponseEntity<String> analyse(@RequestBody AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        controlSystemsService.analyse(analysisConfigurationRequestModel);
        return ResponseEntity.ok("Engine System Analysis");
    }
}
