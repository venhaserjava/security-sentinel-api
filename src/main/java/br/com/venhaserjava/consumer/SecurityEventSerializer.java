package br.com.venhaserjava.consumer;

import br.com.venhaserjava.model.SecurityEvent;
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;

public class SecurityEventSerializer extends ObjectMapperSerializer<SecurityEvent> {
    // Esta classe permite que a DLQ serialize o objeto de volta para o Kafka
}