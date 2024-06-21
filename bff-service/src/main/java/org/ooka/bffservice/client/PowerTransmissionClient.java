package org.ooka.bffservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("power-transmission-service")
public interface PowerTransmissionClient {

}
