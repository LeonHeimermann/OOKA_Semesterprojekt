package org.ooka.msauxiliarysystems.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.msauxiliarysystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msauxiliarysystems.service.AuxiliarySystemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuxiliarySystemsController {

    private final AuxiliarySystemsService auxiliarySystemsService;

    @PostMapping("/analyse")
    public ResponseEntity<String> analyse(@RequestBody AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        auxiliarySystemsService.analyse(analysisConfigurationRequestModel);
        return ResponseEntity.ok("Engine System Analysis");
    }
}
