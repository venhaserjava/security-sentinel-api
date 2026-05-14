package br.com.venhaserjava.consumer;

import br.com.venhaserjava.model.SecurityEvent;
import br.com.venhaserjava.repository.SecurityEventRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class SecurityEventConsumer {

    @Inject
    SecurityEventRepository repository;

    @Incoming("security-audit-in")
    public CompletionStage<Void> receive(Message<SecurityEvent> msg) {
        SecurityEvent event = msg.getPayload();

        // Usando o Getter para garantir o encapsulamento
        System.out.println(">>> [CONSUMER] Processando evento de: " + event.getUserName());

        return Panache.withTransaction(() -> {
            if ("CRITICAL_ACCESS".equalsIgnoreCase(event.getType())) {
                // Simulando a falha que o Sr. viu no terminal
                return Uni.createFrom().failure(new RuntimeException("ERRO SIMULADO: Falha crítica!"));
            }
            return repository.persist(event);
        })
        .onItem().transformToUni(saved -> Uni.createFrom().completionStage(msg.ack()))
        .onFailure().recoverWithUni(err -> {
            System.err.println(">>> [RESILIÊNCIA] Enviando para DLQ: " + err.getMessage());
            // O nack com causa faz o SmallRye jogar a mensagem no tópico de Dead Letter automaticamente
            return Uni.createFrom().completionStage(msg.nack(err));
        })
        .subscribeAsCompletionStage();
    }

}