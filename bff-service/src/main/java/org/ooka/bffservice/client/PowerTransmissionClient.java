package org.ooka.bffservice.client;

import org.ooka.bffservice.model.AnalysisConfigurationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("power-transmission-service")
public interface PowerTransmissionClient {

    @PostMapping("/analyse")
    ResponseEntity<String> analyse(AnalysisConfigurationDto analysisConfigurationDto);

}
