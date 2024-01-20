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
--------------------------------------------------------------------

# Autenticação de Usuário

### Cadastro de Usuário

**Endpoint:** `/auth/registrar` **Método:** POST


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

#### Resposa de sucesso

Status: 200 OK

```json
{
	No body returned for response
}
```

#### Resposa de Falha

Status: 422 Unprocessable Entity

```json
{
	"status": 422,
	"message": "Erro de validação",
	"errors": [
		{
			"field": "{field}",
			"message": "não deve estar em branco"
		}
	]
}
```

--------------------------------------------------------------------

### Login de Usuário

**Endpoint:** `/auth/login` **Método:** GET

#### Parâmetros da Solicitação

- `login` (string, required)
- `senha` (string, required)

{
	"login" : "",
	"senha" : ""
}

#### Resposta de Sucesso

- **Status:** 200 OK

```json
{
	"token": "token"
}
```

#### Resposta de Falha

Status: 403 Forbidden

```json
{
	"status": 403,
	"message": "Usuário inexistente ou senha inválida"
}
```
--------------------------------------------------------------------

### Cadastro de Cliente

**Endpoint:** `/cliente/cadastro/save`  
**Método:** POST

#### Parâmetros da Solicitação -

- `dadosPessoaisSeguradoDTO.nome` (string, required) 
- `dadosPessoaisSeguradoDTO.dataNascimento` (string, required) 
- `dadosPessoaisSeguradoDTO.telefone` (string, required) 
- `dadosPessoaisSeguradoDTO.endereco` (string, required) 
- `dadosPessoaisSeguradoDTO.cep` (string, required) 
- `dadosPessoaisSeguradoDTO.email` (string, required) 
- `dadosParaContratacaoSeguradoDTO.corretorId` (integer, required) 
- `dadosParaContratacaoSeguradoDTO.operadoraId` (integer, required) 
- `dadosParaContratacaoSeguradoDTO.administradoraId` (integer, required) 
- `dadosParaContratacaoSeguradoDTO.vigencia` (string, required) 
- `dadosParaContratacaoSeguradoDTO.planoId` (integer, required) 
- `dadosParaContratacaoSeguradoDTO.valorDoPlanoBruto` (number, required) 
- `dadosParaContratacaoSeguradoDTO.percentualComissao` (number, required) 
- `dadosParaContratacaoSeguradoDTO.adesao` (number, required) 
- `dadosParaContratacaoSeguradoDTO.segmentacao` (string, required) 
- `dadosEspecificosCadastroClienteDTO.cpf` (string, required) 
- `dadosEspecificosCadastroClienteDTO.peso` (number, required) 
- `dadosEspecificosCadastroClienteDTO.altura` (number, required) 

```json
{
	"dadosPessoaisSeguradoDTO": {
		"nome": "Lucas Danilo Exemplo da Silva",
		"dataNascimento": "2003-10-10",
		"telefone": "6191020695",
		"endereco": "Rua Exemplo, 123",
		"cep": "12345-678",
		"email": "natalia.ales091@gmail.com"
	},
	"dadosParaContratacaoSeguradoDTO": {
		"corretorId": 1,
		"operadoraId": 1,
		"administradoraId": 3,
		"vigencia": "2024-10-10",
		"planoId": 1,
		"valorDoPlanoBruto": 812, 
		"percentualComissao": 50,
		"adesao": 90.00,
		"segmentacao": "ADESAO"
	},
	"dadosEspecificosCadastroClienteDTO": {
		"cpf": "15654472712",
		"peso": 70.5,
		"altura": 1.75
	}
}
```
#### Resposta de sucesso

Status: 201 Created

```json
{
	No body returned for response
}
```

#### Resposta de Falha

```json
{
	"status": 422,
	"message": "Erro de validação",
	"errors": [
		{
			"field": "{field}",
			"message": "não deve estar em branco"
		}
	]
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
