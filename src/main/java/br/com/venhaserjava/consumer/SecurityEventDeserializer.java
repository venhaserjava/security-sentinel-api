package br.com.venhaserjava.consumer;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import br.com.venhaserjava.model.SecurityEvent;

public class SecurityEventDeserializer extends ObjectMapperDeserializer<SecurityEvent> {
    public SecurityEventDeserializer() {
        super(SecurityEvent.class);
    }
}