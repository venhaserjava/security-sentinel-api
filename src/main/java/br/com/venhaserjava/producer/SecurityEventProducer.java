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
Emitter<String> eventEmitter; // Mudado de SecurityEvent para String

@Inject
com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    public void sendEvent(SecurityEvent event) {
        try {
            String json = objectMapper.writeValueAsString(event);
            System.out.println(">>> PRODUCER -> SendEvent: Converteu o EventSecurity em String. <<<"+json);
            
            eventEmitter.send(json);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar evento", e);
        }
    }
}