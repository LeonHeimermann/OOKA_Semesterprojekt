package org.ooka.bffservice.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.client.RegistryClient;
import org.ooka.bffservice.model.RegistryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistryService {

    private final RegistryClient registryClient;

    public List<RegistryDto> getRegistryData() {
        List<Application> applications = registryClient.getRegistryData();
        return applications.stream()
                .filter(this::isApplicationActive)
                .map(this::mapApplicationToDto).toList();
    }

    private boolean isApplicationActive(Application application) {
        return application.getInstances().stream()
                .anyMatch(instance -> instance.getStatus().equals(InstanceInfo.InstanceStatus.UP));
    }

    private RegistryDto mapApplicationToDto(Application application) {
        return RegistryDto.builder()
                .id(application.getName().toLowerCase())
                .build();
    }
}
