ToolsChallenge - API de Pagamentos 💳
Este projeto é uma API REST para gerenciamento de pagamentos e estornos de transações com cartões de crédito. A API foi desenvolvida utilizando Java Spring Boot e segue as melhores práticas de desenvolvimento, como Orientação a Objetos, tratamento de exceções, validação de dados, testes unitários e uso de padrões de projeto.

🚀 Funcionalidades

- Pagamento: Permite realizar um pagamento com cartão de crédito.
- Estorno: Possibilita o cancelamento de uma transação realizada.
- Consulta: Obtém todas as transações ou uma específica pelo ID.

📌 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- JUnit 5 (Testes Unitários)
- Maven
- Git (Controle de versão)

🛠 Como Executar o Projeto

    git clone https://github.com/seu-usuario/ToolsChallenge.git

1. Clone o repositório:

    `git clone https://github.com/seu-usuario/ToolsChallenge.git`

2. Acesse a pasta do projeto:

    `git clone https://github.com/seu-usuario/ToolsChallenge.git`

3. Compile e execute a aplicação:

    `git clone https://github.com/seu-usuario/ToolsChallenge.git`


📌 Endpoints Disponíveis

🔹 Criar um pagamento

POST /pagamentos

- Request Body:

```
{
  "transacao": {
    "cartao": "4444**********1234",
    "id": "1132132132132132",
    "descricao": {
      "valor": "500.50",
      "dataHora": "01/05/2021 18:30:00",
      "estabelecimento": "Petshop Mundo Cão"
    },
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    }
  }
}

```

- Response:

```
{
  "transacao": {
    "cartao": "4444**********1234",
    "id": "1132132132132132",
    "descricao": {
      "valor": "500.50",
      "dataHora": "01/05/2021 18:30:00",
      "estabelecimento": "Petshop Mundo Cão",
      "nsu": "1234567890",
      "status": "AUTORIZADO"
    },
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    }
  }
}

```

🔹 Estornar um pagamento

POST /pagamentos/estornos/{id}

🔹 Consultar pagamentos

GET /pagamentos → Retorna todos os pagamentos.
GET /pagamentos/{id} → Retorna um pagamento específico.

✅ Testes

    mvn test
