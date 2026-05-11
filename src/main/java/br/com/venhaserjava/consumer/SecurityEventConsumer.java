package br.com.venhaserjava.consumer;

//import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import jakarta.enterprise.context.ApplicationScoped;
//import io.smallrye.common.annotation.Blocking; // Use este import se disponível, ou o smallrye.reactive

@ApplicationScoped
public class SecurityEventConsumer {

    // Removi o @Startup para deixar o CDI gerenciar o ciclo de vida sob demanda do canal
    public SecurityEventConsumer() {
        System.out.println("\n>>> [SISTEMA] Consumer instanciado e aguardando canal...\n");
    }

//    @Incoming("security-audit-in-OLD")
//    @Blocking // Indica que este processamento pode demorar (System.out/DB)
    @Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)
    public void consume(String eventJson) {
        // Usando System.err para forçar a cor diferente no terminal e facilitar o seu vídeo
        System.err.println("==============================================");
        System.err.println(">>> MENSAGEM CAPTURADA PELO CONSUMER! <<<");
        System.err.println(">>> CONTEÚDO: " + eventJson);
        System.err.println("==============================================");

        if (eventJson != null && eventJson.contains("\"user\":\"admin\"")) {
            System.err.println("!!! ALERTA: Usuário ADMIN detectado. Disparando Exception para DLQ !!!");
            throw new RuntimeException("Falha de segurança simulada: Usuário Admin");
        }
    }
}
