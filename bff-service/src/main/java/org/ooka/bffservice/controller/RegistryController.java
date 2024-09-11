package org.ooka.bffservice.controller;

import lombok.RequiredArgsConstructor;
import org.ooka.bffservice.model.RegistryDto;
import org.ooka.bffservice.service.RegistryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registry")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class RegistryController {

    private final RegistryService registryService;

    @GetMapping
    public List<RegistryDto> getRegistryData() {
        return registryService.getRegistryData();
    }
}
