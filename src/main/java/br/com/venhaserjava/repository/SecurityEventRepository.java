package br.com.venhaserjava.repository;

import br.com.venhaserjava.model.SecurityEvent;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SecurityEventRepository implements PanacheRepository<SecurityEvent> {
    // Aqui você pode adicionar métodos de busca customizados depois!
}
