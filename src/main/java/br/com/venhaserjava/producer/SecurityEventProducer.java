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
    // CORREÇÃO: Mudamos de String para o objeto real SecurityEvent.
    // O Quarkus usará o SecurityEventSerializer automaticamente.
    Emitter<SecurityEvent> eventEmitter; 

    public void sendEvent(SecurityEvent event) {
        
        try {
            // Removido o ObjectMapper e a conversão manual para String.
            // O log agora mostra o objeto sendo enviado para o pipeline do Quarkus.
            System.out.println(">>> PRODUCER -> Enviando SecurityEvent para o canal: " + event.getType());
            
            eventEmitter.send(event);
            
        } catch (Exception e) {
            // Como agora o Quarkus cuida da serialização, erros aqui serão raros,
            // mas mantemos o log para segurança da operação.
            System.err.println("Erro ao disparar evento para o Kafka: " + e.getMessage());
            throw new RuntimeException("Erro no envio do evento", e);
        }
    }
}