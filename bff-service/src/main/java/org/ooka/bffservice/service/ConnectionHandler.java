package org.ooka.bffservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConnectionHandler {

    private final Map<String, SseEmitter> connections = new HashMap<>();

    public SseEmitter addConnection(String id) {
        SseEmitter sseEmitter = new SseEmitter(10000L);
        connections.put(id, sseEmitter);
        return sseEmitter;
    }

    public void send(String id, String data) {
        SseEmitter emitter = connections.get(id);
        try {
            emitter.send(data);
        } catch (Exception ignored) {}
    }

    public void removeConnection(String id) {
        SseEmitter emitter = connections.remove(id);
        try {
            emitter.complete();
        } catch (Exception ignored) {}
    }

}
