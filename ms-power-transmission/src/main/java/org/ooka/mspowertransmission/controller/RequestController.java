package org.ooka.mspowertransmission.controller;

import org.ooka.mspowertransmission.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/analyse")
    public ResponseEntity analyse() {
        new Algorithm(kafkaTemplate).start();

        return ResponseEntity.ok().build();
    }

}
