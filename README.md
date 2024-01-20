# Essenseg - Rest Api

API Restful desenvolvida com Spring para uma corretora de planos de saúde. 

## 1. Description

Principal foco a gestão de Segurados, Dependentes, Operadoras, Administradoras, Corretores e Planos de Saúde.
Cadastro, atualização, listagem com filtros e detalhamento de todas as entidades citadas acima. 
Além da possibilidade de anexo de arquivos, vinculados aos Segurados. Geração de relatórios PDF de extratos, 
baseados na venda dos planos feitas para Segurados, de um Corretor.
## technologies in use

<div>
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/Java-Light.svg"/>
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/Spring-Light.svg" />
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/MySQL-Light.svg" />
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/Docker.svg"/>
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/AWS-Light.svg"/>
</div>

Spring Boot, Data JPA, Security, Swagger, Tokens JWT para segurança, Jasper Report para a geração dos relatórios,
Docker e Flyway para as migrations. Deploy usando AWS (EC2 e RDS).

### Install dependencies

```shell
- Java JDK 8 ou superior
- Maven
- Docker
```

### Start project

```shell
mvn spring-boot:run - Na raiz do projeto
```

## Autenticação de Usuário

### Login

Endpoint: `/auth/registrar`
Método: POST

Registro de usuário no sistema

#### Parâmetros da Solicitação

- `login` (string, required)
- `senha` (string, required)
- `role` (string, required): Tipo de perfil; (USER ou ADMIN)

```json
{
  "login" : "",
	"senha" : "",
	"role" : ""
}
```

#### Resposta de Sucesso

Status: 200 OK

```json
{
  "token": "seu-token-de-autenticação"
}
```

#### Resposta de erro

Status: 401 Unauthorized

```json
{
 "message": "Invalid email or password",
 "error": "Unauthorized",
 "statusCode": 401
}
```

## Registro

**Endpoint:** `/auth/register`

**Método:** POST

Este endpoint é usado para criar um novo usuário no sistema.

#### Parâmetros da Solicitação

- `name` (string, obrigatório): Nome do usuário.
- `email` (string, obrigatório): O endereço de e-mail do usuário.
- `password` (string, obrigatório): A senha do usuário.
- `phone` (string, opcional): Número de telefone do usuário.
- `crmv` (string, opcional): Número do CRMV (se aplicável).
- `office` (string, opcional): Cargo do usuário.
- `owner` (boolean, opcional): Indica se o usuário é um proprietário (true/false).
- `work_areas` (array de strings, opcional): Áreas de trabalho do usuário.
- `status` (string, opcional): Status do usuário se está ativo ou não.
- `commissioned` (boolean, opcional): Indica se o usuário é comissionado (true/false).
- `commission_date` (string, opcional): Data de comissão do usuário.

#### Resposta de Sucesso

- **Status:** 201 Created

```json
{
 "user": {
  "id": 143,
  "name": "test",
  "office": null,
  "crmv": null,
  "owner": false,
  "profile": {
   "id": 3
  }
 }
}
```

## Atualização de Usuário

Este endpoint é usado para atualizar as informações de um usuário existente no sistema. Para acessar essa funcionalidade, você precisa estar autenticado com um token válido.

- **Endpoint:** `/user/{id}`
- **Método:** PATCH

#### Parâmetros da Solicitação

- `id` (número, obrigatório): O ID do usuário que você deseja atualizar.
- `name` (string, opcional): Nome do usuário.
- `password` (string, opcional): A nova senha do usuário (se você desejar alterá-la).
- `phone` (string, opcional): Novo número de telefone do usuário.
- `crmv` (string, opcional): Novo número do CRMV (se aplicável).
- `office` (string, opcional): Novo cargo do usuário.
- `owner` (boolean, opcional): Indica se o usuário é um proprietário (true/false).
- `work_areas` (array de strings, opcional): Novas áreas de trabalho do usuário.
- `status` (string, opcional): Novo status do usuário (ativo/inativo).
- `commissioned` (boolean, opcional): Indica se o usuário é comissionado (true/false).
- `commission_date` (string, opcional): Nova data de comissão do usuário.

#### Resposta de Sucesso

- **Status:** 200 OK

```json
{
 "id": 153,
 "name": "Joe Doe",
 "phone": "(12) 34567-8900",
 "crmv": null,
 "office": null,
 "email": "joedoe@test.com",
 "owner": false,
 "work_areas": null,
 "status": "Ativo",
 "commissioned": false,
 "commission_date": null,
 "last_access": "2023-10-18 14:54:25",
 "profile": {
  "id": 3,
  "name": "Gestor da Clínica",
  "type": "Modelo",
  "performs_service": true
 }
}
```

## Deleção de Usuário

Este endpoint permite excluir um usuário do sistema, desde que o usuário autenticado seja um proprietário (owner) e que o usuário alvo não seja outro proprietário. Um proprietário também pode excluir a si mesmo.

- **Endpoint:** `/user/{id}`
- **Método:** DELETE

#### Parâmetros da Solicitação

- `id` (número, obrigatório): O ID do usuário que você deseja excluir.

#### Resposta de Sucesso

- **Status:** 204 No Content

Esta resposta indica que o usuário foi excluído com sucesso e não há conteúdo de resposta.
