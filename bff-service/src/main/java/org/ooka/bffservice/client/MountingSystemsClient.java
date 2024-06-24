package org.ooka.bffservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("mounting-systems-service")
public interface MountingSystemsClient {

    @PostMapping("/analyse")
    public ResponseEntity analyse();

}
