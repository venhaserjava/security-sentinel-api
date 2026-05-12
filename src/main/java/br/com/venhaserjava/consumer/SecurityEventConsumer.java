package br.com.venhaserjava.consumer;

import br.com.venhaserjava.model.SecurityEvent;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;
//import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class SecurityEventConsumer {

    @Incoming("security-audit-in")
    public CompletionStage<Void> receive(Message<SecurityEvent> msg) {
        SecurityEvent event = msg.getPayload();

        // ESTE TRECHO ESTÁ COMENTADO POIS ELE SERVE APNEAS PARA TESTAR O COMPORTAMENTO DE FALHA E ENVIO PARA DLQ. DESCOMENTE PARA TESTAR.
        
        // if ("CRITICAL_ACCESS".equalsIgnoreCase(event.getType())) {
        //     System.err.println("\n[ALERTA] Evento crítico detectado! Enviando para DLQ via Nack...");
            
        //     // Em vez de 'throw', usamos o 'nack' (Negative Acknowledgement).
        //     // Isso avisa ao Quarkus: "Não consegui processar, aplique a failure-strategy (DLQ)".
        //     return msg.nack(new RuntimeException("Falha simulada: Auditoria manual necessária."));
        // }

        System.out.println("\n==========================================");
        System.out.println(">>> [SECURITY SENTINEL] EVENTO RECEBIDO <<<");
        System.out.println("Tipo: " + event.getType());
        System.out.println("Usuário: " + event.getUser());
        System.out.println("IP: " + event.getIpAddress());
        System.out.println("Timestamp: " + event.getTimestamp());
        System.out.println("Detalhes: " + event.getDetails());
        System.out.println("==========================================\n");

        return msg.ack();
    }
}