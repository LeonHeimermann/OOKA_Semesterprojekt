package org.ooka.bffservice.controller;

import org.ooka.bffservice.dto.ConfigurationDTO;
import org.ooka.bffservice.persistence.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
@CrossOrigin(origins = "*")
public class ConfigurationController {

    @Autowired
    ConfigurationRepository configurationRepository;

    @GetMapping()
    public List<ConfigurationDTO> getConfigurations() {
        return configurationRepository
                .findAll()
                .stream()
                .map(ConfigurationDTO::new)
                .toList();
    }

    @PostMapping()
    public void persistConfiguration(@RequestBody ConfigurationDTO configurationDTO) {
        configurationRepository.save(configurationDTO.convertToModel());
    }
}
