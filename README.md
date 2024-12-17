 CepFinder API

A CepFinder API é um serviço REST que permite buscar informações detalhadas de endereços a partir de um CEP fornecido, além de oferecer recursos para monitorar as consultas realizadas, como o ranking dos CEPs mais consultados.

## Funcionalidades

- **Busca de CEP**: Retorna detalhes do endereço associado ao CEP fornecido.
- **Registro de Logs**: Grava logs das consultas realizadas para monitoramento.
- **Ranking de CEPs Mais Consultados**: Lista os CEPs mais frequentemente consultados com base em filtros como datas, cidade e estado.
- **Estatísticas de CEP por Cidade e Estado**: Fornece dados agregados sobre a distribuição dos CEPs consultados por cidade e estado.

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
  "cep": "01001000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308"
}
```
### Obter os CEPs Mais Consultados
- **URL**: `/estatisticas/ceps-mais-consultados`
- **Método**: `GET`
- **Descrição**: Retorna a lista de CEPs mais consultados com base no filtro de parâmetros fornecidos.

**Parâmetros**
| Parâmetro     | Tipo          | Descrição                                       | Padrão         |
| ------------- | ------------- | -------------                                   | -------------  |
| limite        | Integer       | Limite de resultados retornados                 |       10       |
| dataInicial   | String        | Data inicial para filtro (formato: yyyy-MM-dd)  |       -        |
| dataFinal     | String        | Data final para filtro (formato: yyyy-MM-dd)    |       -        |
| cidade        | String        | Filtra por cidade                               |       -        |
| estado        | String        | Filtra por estado                               |       -        |
