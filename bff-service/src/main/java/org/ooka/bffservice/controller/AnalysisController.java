package org.ooka.bffservice.controller;

import feign.FeignException;
import org.ooka.bffservice.client.*;
import org.ooka.bffservice.kafka.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
public class AnalysisController {

    @Autowired
    KafkaConsumerService kafkaConsumerService;
    @Autowired
    AuxiliarySystemsClient auxiliarySystemsClient;
    @Autowired
    ControlSystemsClient controlSystemsClient;
    @Autowired
    EngineSystemsClient engineSystemsClient;
    @Autowired
    MountingSystemsClient mountingSystemsClient;
    @Autowired
    PowerTransmissionClient powerTransmissionClient;


    @PostMapping
    public ResponseEntity analyseAll(@RequestBody String config) {
        System.out.println("received configuration:" + config);

        analyseAuxiliarySystems();
        analyseControlSystems();
        analyseEngineSystems();
        analyseMountingSystems();
        analysePowerTransmission();

        return ResponseEntity.ok().build();
    }

    @PostMapping("/auxiliary-systems")
    public ResponseEntity analyseAuxiliarySystems() {
        try {
            auxiliarySystemsClient.analyse();
        } catch (FeignException.ServiceUnavailable e) {
            return ResponseEntity.internalServerError().body("Service unavailable");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/control-systems")
    public ResponseEntity analyseControlSystems() {
        try {
            controlSystemsClient.analyse();
        } catch (FeignException.ServiceUnavailable e) {
            return ResponseEntity.internalServerError().body("Service unavailable");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/engine-systems")
    public ResponseEntity analyseEngineSystems() {
        try {
            engineSystemsClient.analyse();
        } catch (FeignException.ServiceUnavailable e) {
            return ResponseEntity.internalServerError().body("Service unavailable");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/mounting-systems")
    public ResponseEntity analyseMountingSystems() {
        try {
            mountingSystemsClient.analyse();
        } catch (FeignException.ServiceUnavailable e) {
            return ResponseEntity.internalServerError().body("Service unavailable");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/power-transmission")
    public ResponseEntity analysePowerTransmission() {
        try {
            powerTransmissionClient.analyse();
        } catch (FeignException.ServiceUnavailable e) {
            return ResponseEntity.internalServerError().body("Service unavailable");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    /*
    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> SseEmitter sseEmitter() {

        return kafkaConsumerService.getMessages()
                .map(message -> {
                    System.out.println("sending message: " + message);
                    return ServerSentEvent.<String>builder()
                        .data(message)
                        .id(String.valueOf(System.currentTimeMillis()))
                        .build();
                });

        return kafkaConsumerService.createEmitter();
    }
    */
}
