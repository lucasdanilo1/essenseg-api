
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

```json
{
	"login" : "",
	"senha" : "",
	"role" : "USER or ADMIN"
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

- `nome` (required) 
- `dataNascimento` (required) 
- `telefone` (required) 
- `endereco` 
- `cep` 
- `email` (required) 
- `corretorId` (required) 
- `operadoraId` (required) 
- `administradoraId` (required) 
- `vigencia` (required) 
- `planoId` (required) 
- `valorDoPlanoBruto` (required) 
- `percentualComissao` (required) 
- `adesao` ( required) 
- `segmentacao` (required)
- `cpf` (required) 
- `peso` 
- `altura` 

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

- **Status:** 422 Unprocessable Entity

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

**Método:** GET

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

## Lista de Clientes

**Endpoint:** `/cliente/lista` 

**Método:** GET

#### Resposta de Sucesso

- **Status:** 200 OK

```json
{
	"content": [
		{
			"id": ,
			"nome": "",
			"operadoraId": ,
			"vigencia": "4",
			"planoId": 1,
			"valorDoPlano": ,
			"adesao": ,
			"segmentacao": ""
		},
		{
			"id": ,
			"nome": "",
			"operadoraId": ,
			"vigencia": "",
			"planoId": ,
			"valorDoPlano":,
			"adesao": ,
			"segmentacao": ""
		}
	],
	"pageable": {
		"pageNumber": 0,
		"pageSize": 30,
		"sort": {
			"empty": true,
			"unsorted": true,
			"sorted": false
		},
		"offset": 0,
		"unpaged": false,
		"paged": true
	},
	"last": true,
	"totalElements": 2,
	"totalPages": 1,
	"size": 30,
	"number": 0,
	"sort": {
		"empty": true,
		"unsorted": true,
		"sorted": false
	},
	"first": true,
	"numberOfElements": 2,
	"empty": false
}

```

--------------------------------------------------------------------

## Lista de Clientes Filtrada

**Endpoint:** `/cliente/lista/filtrada` 

**Método:** POST

#### Parâmetros da Solicitação -

- `filtroGlobal` (required)

```json
{
	"filtroGlobal" : ""
}

```

#### Resposta de Sucesso

- **Status:** 200 OK

```json
{
	{
	"content": [
		{
			"id": ,
			"nome": "",
			"operadoraId": ,
			"vigencia": "2023-10-24",
			"valorDoPlano": ,
			"adesao": ,
			"segmentacao": ""
		},
		{
			"id": ,
			"nome": "",
			"operadoraId": ,
			"vigencia": "2023-10-24",
			"valorDoPlano": ,
			"adesao": ,
			"segmentacao": ""
		}
	],
	"pageable": {
		"pageNumber": 0,
		"pageSize": 20,
		"sort": {
			"empty": true,
			"sorted": false,
			"unsorted": true
		},
		"offset": 0,
		"unpaged": false,
		"paged": true
	},
	"last": true,
	"totalPages": 1,
	"totalElements": 2,
	"size": 20,
	"number": 0,
	"sort": {
		"empty": true,
		"sorted": false,
		"unsorted": true
	},
	"first": true,
	"numberOfElements": 2,
	"empty": false
	}
}

```
