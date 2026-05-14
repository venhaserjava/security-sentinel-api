package br.com.venhaserjava.consumer;

import br.com.venhaserjava.model.SecurityEvent;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class SecurityEventDeserializer extends ObjectMapperDeserializer<SecurityEvent> {
    public SecurityEventDeserializer() {
        super(SecurityEvent.class);
    }
}