package org.ooka.bffservice.controller;

import org.ooka.bffservice.persistence.Configuration;
import org.ooka.bffservice.persistence.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/configuration")
@CrossOrigin(origins = "*")
public class ConfigurationController {

    @Autowired
    ConfigurationRepository configurationRepository;

    @GetMapping()
    public List<Configuration> getConfigurations() {
        return configurationRepository.findAll();
    }
}
