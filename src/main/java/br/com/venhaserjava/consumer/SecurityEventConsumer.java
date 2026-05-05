package br.com.venhaserjava.consumer;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.enterprise.context.ApplicationScoped;
import br.com.venhaserjava.model.SecurityEvent; // Import correto do seu model

@ApplicationScoped
public class SecurityEventConsumer {

    @Incoming("security-audit")
    public void consume(SecurityEvent event) {
        System.out.println(">>> Evento Recebido: " + event.getUser());
        
        // Simulação de erro para testarmos a DLQ no vídeo
        if ("admin".equals(event.getUser())) {
            System.err.println("!!! Erro detectado para o usuario admin. Enviando para DLQ...");
            throw new RuntimeException("Falha simulada");
        }
    }
}