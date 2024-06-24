package org.ooka.bffservice.controller;

import feign.FeignException;
import org.ooka.bffservice.client.AuxiliarySystemsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.ServiceUnavailableException;

@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
public class AnalysisController {

    @Autowired
    AuxiliarySystemsClient auxiliarySystemsClient;


    @PostMapping
    public ResponseEntity analyseAll(@RequestBody String config) {
        System.out.println("received configuration:" + config);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/auxiliary-systems")
    public ResponseEntity test() {
        try {
            auxiliarySystemsClient.analyse();
        } catch (FeignException.ServiceUnavailable e) {
            return ResponseEntity.internalServerError().body("Service unavailable");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

}
