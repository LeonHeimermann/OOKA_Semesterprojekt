package org.ooka.bffservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("engine-systems-service")
public interface EngineSystemsClient {

    @PostMapping("/analyse")
    public ResponseEntity analyse();

}
