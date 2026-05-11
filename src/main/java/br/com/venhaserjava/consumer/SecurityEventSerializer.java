package br.com.venhaserjava.consumer;

import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;
import br.com.venhaserjava.model.SecurityEvent;

public class SecurityEventSerializer extends ObjectMapperSerializer<SecurityEvent> {
    // Esta classe permite que a DLQ serialize o objeto de volta para o Kafka
}