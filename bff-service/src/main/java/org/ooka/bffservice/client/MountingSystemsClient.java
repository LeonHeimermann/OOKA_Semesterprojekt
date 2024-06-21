package org.ooka.bffservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("mounting-systems-service")
public interface MountingSystemsClient {

}
