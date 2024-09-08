package org.ooka.msmountingsystems.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.msmountingsystems.model.AnalysisConfigurationRequestModel;
import org.ooka.msmountingsystems.service.MountingSystemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MountingSystemsController {

    private final MountingSystemsService mountingSystemsService;

    @PostMapping("/analyse")
    public ResponseEntity<String> analyse(@RequestBody AnalysisConfigurationRequestModel analysisConfigurationRequestModel) {
        mountingSystemsService.analyse(analysisConfigurationRequestModel);
        return ResponseEntity.ok("Engine System Analysis");
    }
}
