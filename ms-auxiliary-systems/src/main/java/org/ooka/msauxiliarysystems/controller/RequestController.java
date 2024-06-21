package org.ooka.msauxiliarysystems.controller;

import org.ooka.msauxiliarysystems.Algorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @PostMapping("/analyse")
    public ResponseEntity analyse() {
        new Algorithm().start();

        return ResponseEntity.ok().build();
    }

}
