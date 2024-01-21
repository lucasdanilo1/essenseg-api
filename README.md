--------------------------------------------------------------------

# EssensegAPI

API Restful desenvolvida com Spring para uma corretora de planos de saúde. 


## Description

Principal foco a gestão de Segurados, Dependentes, Operadoras, Administradoras, Corretores e Planos de Saúde.
Cadastro, atualização, listagem com filtros e detalhamento de todas as entidades citadas acima. 
Além da possibilidade de anexo de arquivos, vinculados aos Segurados. Geração de relatórios PDF de extratos, 
baseados na venda dos planos feitas para Segurados, de um Corretor.

--------------------------------------------------------------------

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

--------------------------------------------------------------------

## 1. Install dependencies

```shell
- Java JDK 8 ou superior
- Maven
- Docker
```

--------------------------------------------------------------------

## 2. Start project

```shell
mvn spring-boot:run
```

--------------------------------------------------------------------

## Cadastro de Usuário

**Endpoint:** `/auth/registrar` 
**Método:** POST

#### Parâmetros da Solicitação

- `login` (required)
- `senha` (required)
- `role` (required): ("USER" OU "ADMIN")

```json
{
	"login" : "",
	"senha" : "",
	"role" : ""
}
```

#### Resposa de sucesso

- **Status:** 200 OK

#### Resposa de Falha

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

## Login de Usuário

**Endpoint:** `/auth/login`
**Método:** GET

#### Parâmetros da Solicitação

- `login` (required)
- `senha` (required)

```json
{
	"login" : "",
	"senha" : ""
}
```

#### Resposta de Sucesso

- **Status:** 200 OK

```json
{
	"token": "token"
}
```

#### Resposta de Falha

```json
{
	"status": 403,
	"message": "Usuário inexistente ou senha inválida"
}
```

--------------------------------------------------------------------

## Cadastro de Cliente

**Endpoint:** `/cliente/cadastro/save` 
**Método:** POST

#### Parâmetros da Solicitação -

- `nome` (string, required) 
- `dataNascimento` (string, required) 
- `telefone` (string, required) 
- `endereco` (string, required) 
- `cep` (string, required) 
- `email` (string, required) 
- `corretorId` (integer, required) 
- `operadoraId` (integer, required) 
- `administradoraId` (integer, required) 
- `vigencia` (string, required) 
- `planoId` (integer, required) 
- `valorDoPlanoBruto` (number, required) 
- `percentualComissao` (number, required) 
- `adesao` (number, required) 
- `segmentacao` (string, required)
- `cpf` (string, required) 
- `peso` (number, required) 
- `altura` (number, required) 

```json
{
	"dadosPessoaisSeguradoDTO": {
		"nome": "",
		"dataNascimento": "2003-10-10",
		"telefone": "XXXXXXXXXXX",
		"endereco": "",
		"cep": "",
		"email": ""
	},
	"dadosParaContratacaoSeguradoDTO": {
		"corretorId": ,
		"operadoraId": ,
		"administradoraId": ,
		"vigencia": "2024-10-10",
		"planoId": ,
		"valorDoPlanoBruto": , 
		"percentualComissao": ,
		"adesao": ,
		"segmentacao": ""
	},
	"dadosEspecificosCadastroClienteDTO": {
		"cpf": "",
		"peso": ,
		"altura": 
	}
}
```

#### Resposta de sucesso

- **Status:** 201 Created

#### Resposta de Falha

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

## Detalhamento do Cliente

**Endpoint:** `/cliente/{id}` 
**Método:** POST

#### Resposta de Sucesso

- **Status:** 200 OK

```json
{
	"dadosSeguradoDetalhadoDTO": {
		"nome": "",
		"dataNascimento": "",
		"telefone": "",
		"cep": "",
		"endereco": "",
		"email": "",
		"corretorId": 0,
		"operadoraId": 0,
		"administradoraId": 0,
		"vigencia": "",
		"planoId": 0,
		"valorDoPlanoBruto": 0.0,
		"percentualComissaoDaOperadora": 0.0,
		"adesao": 0.0,
		"segmentacao": ""
	},
	"dadosEspecificosClienteDetalhadoDTO": {
		"cpf": "",
		"nomeResponsavel": "",
		"cpfResponsavel": "",
		"peso": 0.0,
		"altura": 0.0
	},
	"observacoes": null
}
```

#### Resposta de Falha

```json
{
	"status": 404,
	"message": "Não foi possível encontrar a entidade"
}

```

--------------------------------------------------------------------
