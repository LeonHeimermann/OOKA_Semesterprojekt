package org.ooka.bffservice.client;

import com.netflix.discovery.shared.Application;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "service-registry")
public interface RegistryClient {

    @GetMapping("/registered-apps")
    List<Application> getRegistryData();

}
