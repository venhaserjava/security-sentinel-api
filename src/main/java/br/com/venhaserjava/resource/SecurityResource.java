package br.com.venhaserjava.resource;

import br.com.venhaserjava.model.SecurityEvent;
import br.com.venhaserjava.producer.SecurityEventProducer;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/audit")
public class SecurityResource {

    @Inject
    SecurityEventProducer producer;

    @POST
    public Response logEvent(SecurityEvent event) {
        producer.sendEvent(event);
        return Response.accepted().build(); // 202: "Recebi, vou processar"
    }
}