package org.ooka.mspowertransmission;

import org.ooka.mspowertransmission.dto.AnalysisResult;
import org.springframework.kafka.core.KafkaTemplate;


public class Algorithm extends Thread {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Algorithm(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void run() {
        try {
            System.out.println("Algorithm started");
            int duration = (int) (Math.random()*3000)+1500; // random duration between 1.5 and 4.5 seconds
            Thread.sleep(duration);

            boolean algorithmSucceeded = Math.random() <= 0.7; // simulate errors in calculation
            if (algorithmSucceeded) {
                System.out.println("Algorithm completed");
                kafkaTemplate.send("heimermann_weglau_analyse_result", new AnalysisResult("powertransmission", true).toString());
            } else {
                System.out.println("Algorithm failed");
                kafkaTemplate.send("heimermann_weglau_analyse_result", new AnalysisResult("powertransmission", false).toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
