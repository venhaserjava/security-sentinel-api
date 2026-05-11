package br.com.venhaserjava.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class DebugConsumer {

    public DebugConsumer() {
        System.out.println(">>> [SISTEMA] DebugConsumer CDI Bean inicializado com sucesso! <<<");
    }

    @Incoming("security-audit-in")
    public CompletionStage<Void> receive(Message<String> msg) {
        String payload = msg.getPayload();
        
        // FORÇAR A FALHA: Se o payload contiver "admin", vamos simular um erro
        if (payload.contains("admin")) {
            System.out.println(">>> [FALHA SIMULADA] Mensagem de admin detectada. Enviando para DLQ... <<<");
            
            // Retornar nack (negative acknowledgment) dispara a failure-strategy
            return msg.nack(new RuntimeException("Usuário admin não autorizado para processamento automático"));
        }

        System.out.println("PAYLOAD PROCESSADO: " + payload);
        return msg.ack();
    }

}
