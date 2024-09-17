package org.ooka.bffservice.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.ConfigurationDTO;
import org.ooka.bffservice.persistence.ConfigurationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationRepository configurationRepository;

    @GetMapping()
    public List<ConfigurationDTO> getConfigurations() {
        var configurations = configurationRepository
                .findAll()
                .stream()
                .map(ConfigurationDTO::new)
                .toList();

        return configurations;
    }

    @PostMapping()
    public void persistConfiguration(@RequestBody ConfigurationDTO configurationDTO) {
        configurationRepository.save(configurationDTO.convertToModel());
    }
}
