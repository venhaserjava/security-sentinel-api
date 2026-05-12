package br.com.venhaserjava.model;

import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;

public class SecurityEventSerializer extends ObjectMapperSerializer<SecurityEvent> {
    // Esta classe permite que a DLQ serialize o objeto de volta para o Kafka
}