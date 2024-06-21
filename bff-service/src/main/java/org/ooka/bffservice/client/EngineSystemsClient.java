package org.ooka.bffservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("engine-systems-service")
public interface EngineSystemsClient {

}
