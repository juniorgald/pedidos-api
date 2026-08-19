# API de Pedidos com Padrões de Projeto

Projeto desenvolvido para o desafio "Explorando Padrões de Projetos na Prática com Java" (DIO), aplicando os padrões Strategy, Singleton e Facade em uma API REST com Spring Boot.

## Sobre o projeto

API simples de criação de pedidos, onde o valor de desconto varia de acordo com o tipo de cliente (Normal ou VIP).

## Padrões de Projeto aplicados

### Strategy
Implementado no cálculo de desconto (`DescontoNormal` e `DescontoVip`), evitando um `if/else` que cresceria a cada novo tipo de cliente. Cada estratégia é uma classe própria, seguindo o contrato `EstrategiaDesconto`.

### Singleton
Implementado manualmente na classe `ContadorPedidos`, com construtor privado e método estático `getInstance()`, garantindo uma única instância compartilhada em todo o programa. Também é possível observar o Singleton sendo aplicado automaticamente pelo Spring através da annotation `@Component`, usada nas próprias classes de Strategy.

### Facade
Implementado na classe `PedidoFacade`, que orquestra a criação de um pedido: escolhe a estratégia de desconto correta, salva no banco via `PedidoRepository` e incrementa o contador — tudo isso escondido atrás de um único método, `processarPedido()`.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI (springdoc)
- Maven

## Como rodar o projeto

\`\`\`bash
git clone https://github.com/juniorgald/pedidos-api.git
cd pedidos-api
./mvnw spring-boot:run
\`\`\`

A aplicação sobe em `http://localhost:8080`.

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| POST | `/pedidos` | Cria um novo pedido, calculando o desconto conforme o tipo de cliente |
| GET | `/pedidos/contador` | Retorna o total de pedidos processados desde que a aplicação iniciou |

## Documentação interativa (Swagger)

Com a aplicação rodando, acesse:

\`\`\`
http://localhost:8080/swagger-ui.html
\`\`\`