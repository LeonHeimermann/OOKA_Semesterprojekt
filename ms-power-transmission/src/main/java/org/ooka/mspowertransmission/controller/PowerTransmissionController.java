package org.ooka.mspowertransmission.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.mspowertransmission.model.AnalysisConfigurationRequestModel;
import org.ooka.mspowertransmission.service.PowerTransmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PowerTransmissionController {

    private final PowerTransmissionService powerTransmissionService;

    @PostMapping("/analyse")
    public ResponseEntity<String> analyse(@RequestBody AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        powerTransmissionService.analyse(analysisConfigurationRequestModel);
        return ResponseEntity.ok("Engine System Analysis");
    }
}
