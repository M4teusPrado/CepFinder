# CepFinder API

A CepFinder API é um serviço REST que permite buscar informações detalhadas de endereços a partir de um CEP fornecido, além de oferecer recursos para monitorar as consultas realizadas, como o ranking dos CEPs mais consultados.

## Funcionalidades

- **Busca de CEP**: Retorna detalhes do endereço associado ao CEP fornecido.
- **Registro de Logs**: Grava logs das consultas realizadas para monitoramento.
- **Ranking de CEPs Mais Consultados**: Lista os CEPs mais frequentemente consultados com base em filtros como datas, cidade e estado.
- **Estatísticas de CEP por Cidade e Estado**: Fornece dados agregados sobre a distribuição dos CEPs consultados por cidade e estado.


## Como Rodar
1. Clone o repositório.
2. Execute o comando mvn spring-boot:run para iniciar o servidor.
3. Acesse a API via localhost:8080


## Dependências
- Spring Boot: Framework principal para a construção da API.
- Swagger/OpenAPI: Para documentação automática da API.
- Jakarta Validation: Para validação de dados de entrada.
- Lombok: Para simplificar a criação de getters, setters e construtores.
- JPA/Hibernate: Para manipulação de dados no banco de dados.


## Estrutura do projeto
![image](https://github.com/user-attachments/assets/68ec76e8-e447-4817-91d9-ad6eaeca406b)

## Endpoints
### Buscar Detalhes de um CEP
- **URL**: `/buscar`
- **Método**: `POST`
- **Descrição**: Realiza a busca de informações detalhadas de um CEP informado.
#### Requisição
```
"cep": "01001000"
```
#### Response
- 200 OK: Detalhes do CEP encontrados com sucesso
```
{
    "cep": "18010-090",
    "logradouro": "Rua José Miguel Saker Filho",
    "bairro": "Centro",
    "localidade": "Sorocaba",
    "uf": "SP"
}
```
### Obter os CEPs Mais Consultados
- **URL**: `/estatisticas/ceps-mais-consultados`
- **Método**: `GET`
- **Descrição**: Retorna a lista de CEPs mais consultados com base no filtro de parâmetros fornecidos.

**Parâmetros**
| Parâmetro       | Tipo          | Obrigatoriedade |  Descrição                                      | Padrão         |
| -------------   | ------------- | -------------   | -------------                                   | -------------  |
| `limite`        | Integer       | -               | Limite de resultados retornados                 |       10       |
| `dataInicial`   | String        | -               | Data inicial para filtro (formato: yyyy-MM-dd)  |       -        |
| `dataFinal`     | String        | -               | Data final para filtro (formato: yyyy-MM-dd)    |       -        |
| `cidade`        | String        | -               | Filtra por cidade                               |       -        |
| `estado`        | String        | -               | Filtra por estado                               |       -        |


#### Response
200 OK: Lista de CEPs mais consultados retornada com sucesso.
```
[
    {
        "cep": "18117-240",
        "totalConsultas": 1
    }
]
```
### Obter os CEPs Mais Consultados por Cidade
- **URL**: `/estatisticas/cidade`
- **Método**: `GET`
- **Descrição**: Retorna a lista de CEPs mais consultados por cidade, com base no filtro de parâmetros fornecidos.

**Parâmetros**
| Parâmetro       | Tipo          | Obrigatoriedade |  Descrição                                      | Padrão         |
| -------------   | ------------- | -------------   | -------------                                   | -------------  |
| `limite`        | Integer       | -               | Limite de resultados retornados                 |       10       |
| `dataInicial`   | String        | -               | Data inicial para filtro (formato: yyyy-MM-dd)  |       -        |
| `dataFinal`     | String        | -               | Data final para filtro (formato: yyyy-MM-dd)    |       -        |
| `estado`        | String        | sim             | Filtra por estado                               |       -        |



#### Response
200 OK: Lista de CEPs mais consultados por cidade retornada com sucesso.
```
[
    {
        "cidade": "Sorocaba",
        "totalConsultas": 4
    },
    {
        "cidade": "Campinas",
        "totalConsultas": 1
    },
    {
        "cidade": "Votorantim",
        "totalConsultas": 1
    }
]
```

### Obter os CEPs Mais Consultados por Estado
- **URL**: `/estatisticas/estado`
- **Método**: `GET`
- **Descrição**: Retorna as estatísticas de alocação de CEP por estado, com base no filtro de parâmetros fornecidos.

**Parâmetros**
| Parâmetro       | Tipo          | Obrigatoriedade |  Descrição                                      | Padrão         |
| -------------   | ------------- | -------------   | -------------                                   | -------------  |
| `limite`        | Integer       | -               | Limite de resultados retornados                 |       10       |
| `dataInicial`   | String        | -               | Data inicial para filtro (formato: yyyy-MM-dd)  |       -        |
| `dataFinal`     | String        | -               | Data final para filtro (formato: yyyy-MM-dd)    |       -        |

#### Response
200 OK: Lista de CEPs mais consultados por cidade retornada com sucesso.
```
[
  {
      "estado": "SP",
      "totalConsultas": 5
  },
  {
    "estado": "RJ",
    "totalConsultas": 3
  }
]
```
### Swagger

Para mais detalhes sobre os endpoints e como utilizá-los, você pode acessar a interface do Swagger da aplicação. Ela fornece uma visão interativa e documentação detalhada de todas as rotas disponíveis.

Após a subida da aplicação localmente acesse a seguinte URL: 
- **URL de acesso**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)



