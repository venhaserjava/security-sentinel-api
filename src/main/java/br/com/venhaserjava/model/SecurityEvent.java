package br.com.venhaserjava.model;


import java.time.LocalDateTime;


public class SecurityEvent {
    private String type;
    private String user;
    private String ipAddress;
    private String details;
    private String timestamp;
    
    public SecurityEvent() {}

    public SecurityEvent(String type, String user, String ipAddress, String details) {
        this.type = type;
        this.user = user;
        this.ipAddress = ipAddress;
        this.details = details;
        this.timestamp = LocalDateTime.now().toString();
        System.out.println("\n>>> [SISTEMA] SecurityEvent instanciado...\n");
    }

    
    // Getters e Setters
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getDetails() { return details;     }
    public void setDetails(String details) { this.details = details;    }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

}