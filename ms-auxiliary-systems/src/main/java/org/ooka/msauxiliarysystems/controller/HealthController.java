package org.ooka.msauxiliarysystems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health")
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/alive")
    public ResponseEntity isAlive() {
        return ResponseEntity.ok().build();
    }
}