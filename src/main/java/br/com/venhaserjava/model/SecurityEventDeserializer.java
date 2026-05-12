package br.com.venhaserjava.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class SecurityEventDeserializer extends ObjectMapperDeserializer<SecurityEvent> {
    public SecurityEventDeserializer() {
        super(SecurityEvent.class);
    }
}