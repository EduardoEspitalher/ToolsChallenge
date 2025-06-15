#  Projeto: API de Pagamentos

Este projeto foi desenvolvido como parte de um desafio simulado no contexto de um time de tecnologia de um banco, mais especificamente na área de cartões de crédito. O objetivo foi criar uma **API RESTful para gerenciamento de pagamentos**, incluindo funcionalidades de **pagamento, estorno e consulta de transações**.

##  Cenário

Você trabalha em um banco, na área de cartões de crédito, e faz parte do **Time Elite**. O time recebeu uma demanda:

> Desenvolver uma **API de Pagamentos** que permita:
>
> - Registrar pagamentos (solicitação e resposta via JSON)
> - Estornar pagamentos (consulta por ID e retorno em JSON)
> - Consultar transações (todas ou por ID)

A aplicação deve utilizar os padrões REST, JSON e protocolo HTTP para comunicação. O servidor pode ser Tomcat, JBoss ou o Spring Boot (utilizado neste projeto).

##  Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- Jackson (para JSON)
- Lombok
- JUnit (para testes)

##  Regras de Negócio

- `transacao.id`: deve ser único
- `transacao.status`:
    - `"AUTORIZADO"`
    - `"NEGADO"`
- `formaPagamento.tipo`:
    - `"AVISTA"`
    - `"PARCELADO LOJA"`
    - `"PARCELADO EMISSOR"`

## Observação
  Utilizando DAO para armazenar informações em lista

##  Como executar

1. Compile e execute com Maven:
```bash
./mvnw spring-boot:run
```

##  Autor

**Eduardo Espitalher Dias**  
Desenvolvedor Java  
[LinkedIn](https://www.linkedin.com/in/eduardo-espitalher-dias13/)
