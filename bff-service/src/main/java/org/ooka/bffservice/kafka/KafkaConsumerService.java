package org.ooka.bffservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerService {

    private final List<FluxSink<String>> sinks = new ArrayList<>();
    private final List<SseEmitter> emitters = new ArrayList<>();

    @KafkaListener(topics = "employee_clemens", groupId = "consumerGroup10")
    public void messageClient(String message) {
        /*for(var sink : sinks) {
            sink.next(message);
        }*/
        for(var emitter : emitters) {
            try {
                System.out.println("emit message: " + message);
                emitter.send(message);
            } catch (IOException e) {
                emitter.complete();
                emitters.remove(emitter);
            }
        }
    }

    @KafkaListener(topics = "heimermann_weglau_analyse_result", groupId = "consumerGroup10")
    public void analyseResultListener(String message) {
        System.out.println("analyseResultListener: " + message);
    }

    public Flux<String> getMessages() {
        return Flux.create(sink -> sinks.add(sink.onDispose(() -> sinks.remove(sink))));
    }

    public SseEmitter createEmitter() {
        var emitter = new SseEmitter();
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));

        emitters.add(emitter);

        return emitter;
    }
}
