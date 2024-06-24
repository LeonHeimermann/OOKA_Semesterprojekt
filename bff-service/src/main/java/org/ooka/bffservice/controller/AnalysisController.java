package org.ooka.bffservice.controller;

import feign.FeignException;
import org.ooka.bffservice.client.*;
import org.ooka.bffservice.kafka.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
public class AnalysisController {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;
    @Autowired
    private AuxiliarySystemsClient auxiliarySystemsClient;
    @Autowired
    private ControlSystemsClient controlSystemsClient;
    @Autowired
    private EngineSystemsClient engineSystemsClient;
    @Autowired
    private MountingSystemsClient mountingSystemsClient;
    @Autowired
    private PowerTransmissionClient powerTransmissionClient;


    @PostMapping
    public ResponseEntity<Object> analyseAll(@RequestBody String config) {
        System.out.println("received configuration:" + config);

        analyseAuxiliarySystems();
        analyseControlSystems();
        analyseEngineSystems();
        analyseMountingSystems();
        analysePowerTransmission();

        return ResponseEntity.ok().build();
    }

    @PostMapping("/auxiliary-systems")
    public ResponseEntity<Object> analyseAuxiliarySystems() {
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
    public ResponseEntity<Object> analyseControlSystems() {
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
    public ResponseEntity<Object> analyseEngineSystems() {
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
    public ResponseEntity<Object> analyseMountingSystems() {
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
    public ResponseEntity<Object> analysePowerTransmission() {
        try {
            powerTransmissionClient.analyse();
        } catch (FeignException.ServiceUnavailable e) {
            return ResponseEntity.internalServerError().body("Service unavailable");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/sse")
    public SseEmitter sseEmitter() {
        return kafkaConsumerService.createEmitter();
    }
}
