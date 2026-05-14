package br.com.venhaserjava.producer;

import br.com.venhaserjava.model.SecurityEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class SecurityEventProducer {

    @Inject
    @Channel("security-audit-out")
    Emitter<SecurityEvent> eventEmitter; 

    public void sendEvent(SecurityEvent event) {
        try {
            // Acesso direto ao campo público 'type' definido na Entity
            System.out.println(">>> PRODUCER -> Enviando SecurityEvent para o canal: " + event.getType());
            eventEmitter.send(event);
        } catch (Exception e) {
            System.err.println("Erro ao disparar evento para o Kafka: " + e.getMessage());
            throw new RuntimeException("Erro no envio do evento", e);
        }
    }
}