
# 🛡️ Security Sentinel API

O **Security Sentinel** é um ecossistema de auditoria de segurança de alto desempenho, desenvolvido para demonstrar a implementação de uma arquitetura **Event-Driven** utilizando a stack reativa do Quarkus. 

O projeto foca em resiliência, baixo consumo de recursos e integridade de dados através de processamento assíncrono.

---

## 🚀 Diferenciais do Projeto (Senior Level)

* **Reactive Stack Nativa:** Utilização de Mutiny para operações non-blocking I/O da API até o banco de dados.
* **Resiliência com DLQ:** Estratégia de *Dead Letter Queue* implementada para isolamento de mensagens com falha, garantindo que o pipeline nunca pare.
* **Persistência Reativa:** Integração entre SmallRye Reactive Messaging e Hibernate Reactive com Panache.
* **Encapsulamento Rígido:** Domínio modelado respeitando os princípios da O.O. e Clean Code.

---

## 🏗️ Arquitetura do Sistema

O fluxo de dados segue o padrão de processamento assíncrono:

1.  **Producer (REST API):** Recebe eventos e os despacha para o tópico `security-audit-topic`.
2.  **Broker (Kafka):** Gerencia a retenção e entrega confiável das mensagens.
3.  **Consumer (Worker):** Consome os eventos e realiza a persistência no **PostgreSQL**.
4.  **DLQ:** Caso ocorra falha na persistência, a mensagem é movida para o tópico `security-audit-dead-letter`.


---

## 🛠️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Quarkus](https://img.shields.io/badge/Quarkus-4695EB?style=for-the-badge&logo=quarkus&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate_Reactive-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Kafka](https://img.shields.io/badge/SmallRye_Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white)
![Jackson](https://img.shields.io/badge/Jackson_JSON-000000?style=for-the-badge&logo=json&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)

---

## 🚦 Como Executar o Projeto

### Pré-requisitos
* Java 21+
* Docker & Docker Compose
* Maven 3.9+

### 1. Subir a Infraestrutura

Na raiz do projeto, inicie os containers do Kafka e PostgreSQL:
```bash
docker-compose up -d

```

### 2. Rodar a Aplicação (Dev Mode)

O Quarkus gerencia o hot-reload e a conexão com os serviços:

```bash
./mvnw quarkus:dev

```

### 3. Testar a API (Swagger UI)

Acesse o console interativo para disparar eventos:
🔗 [http://localhost:8080/q/swagger-ui](https://www.google.com/search?q=http://localhost:8080/q/swagger-ui)

---

## 📊 Monitoramento e Debug

* **Kafdrop:** Visualize as mensagens nos tópicos (incluindo a DLQ) em: `http://localhost:9000`
* **Health Checks:** Verifique o status da aplicação e conexões: `http://localhost:8080/q/health`

---

## 📝 Exemplo de Payload (POST)

Para testar o fluxo de sucesso, envie para o endpoint `/audit`:

```json
{
  "type": "LOGIN_SUCCESS",
  "userName": "admin_user",
  "ipAddress": "192.168.1.10",
  "details": "Acesso administrativo via terminal reativo"
}

```

---

# 👨‍💻 Desenvolvido por

**Mário Ramos Rossatti Junior** *Senior Software Developer | Especialista Java & Cloud Native*

## 🤝 Contato & Redes

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mario-ramos-rossatti-junior-471aa0246/)
[![YouTube](https://img.shields.io/badge/YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/channel/UCyk8yUhlni-dfDtaISmTBhw)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:venhaserjava@gmail.com)

```