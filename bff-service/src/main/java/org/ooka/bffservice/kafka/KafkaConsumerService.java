package org.ooka.bffservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.FluxSink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class KafkaConsumerService {

    private final List<FluxSink<String>> sinks = new ArrayList<>();
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "heimermann_weglau_analyse_result", groupId = "consumerGroup10")
    public void analyseResultListener(String message) {
        System.out.println("analyseResultListener: " + message);

        for(var emitter : emitters) {
            try {
                emitter.send(message);
            } catch (IOException e) {
                emitter.complete();
                emitters.remove(emitter);
            }
        }
    }

    public SseEmitter createEmitter() {
        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));

        return emitter;
    }
}
