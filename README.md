# Java API Challenge - Loja Virtual

## 💻 Projeto
API REST Java com Spring Boot para gerenciar uma loja virtual

O projeto está disponível em:

Documentação da API:

## 🔨 Como executar a aplicação

### Requisitos
    - Maven
    - Docker
    - Java 17

```bash
# Clone o repositório
$ git clone https://github.com/lukastteles/java-api-challenge.git

# Vá para a pasta do repositório
$ cd java-api-challenge

# Instale as dependências
$ mvn clean install

# Execute o container Docker com o banco de dados
$ docker-compose up -d

# Rode o projeto
$ mvn spring-boot:run

# Agora está rodando na porta 8080 
```

## 🧩 Tecnologias
-   **Java 17**
-   **Spring Boot**
-   **JUnit**
-   **Swagger**

## 📚 Arquitetura
A API segue a divisão de camadas e responsabilidades da Clean Architecture,
usando as seguites camadas:

-   **Gateways**
    -   **Inputs** (HTTP REST Controllers)
    -   **Outputs** (Postgres DB)
-   **Use Cases**
    -   Lógica da aplicação
-   **Domain**
    -   Estrutura de domínio da aplicação e seus relacionamentos

---
**Feito por Lukas Teles**

