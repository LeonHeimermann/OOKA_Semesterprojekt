package org.ooka.bffservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("control-systems-service")
public interface ControlSystemsClient {

}
