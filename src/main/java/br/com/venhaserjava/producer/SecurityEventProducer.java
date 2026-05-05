package br.com.venhaserjava.producer;


import br.com.venhaserjava.model.SecurityEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class SecurityEventProducer {

    @Inject
    @Channel("security-audit") // Nome do canal interno que mapearemos para o tópico Kafka
    Emitter<SecurityEvent> eventEmitter;

    public void sendEvent(SecurityEvent event) {
        eventEmitter.send(event);
    }
}