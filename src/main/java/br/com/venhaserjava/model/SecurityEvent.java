package br.com.venhaserjava.model;


import java.time.LocalDateTime;

public class SecurityEvent {
    public String type;      // Ex: LOGIN_SUCCESS, ACCESS_DENIED
    public String user;      // Usuário que gerou o evento
    public String ipAddress; // IP de origem
    public String details;   // Descrição extra
    public String timestamp;

    public SecurityEvent() {}

    public SecurityEvent(String type, String user, String ipAddress, String details) {
        this.type = type;
        this.user = user;
        this.ipAddress = ipAddress;
        this.details = details;
        this.timestamp = LocalDateTime.now().toString();
    }
}