# Essenseg - Rest Api

API Restful desenvolvida com Spring para uma corretora de planos de saúde. 

## description

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

##### Resposa de sucesso

Status: 200 OK

No body returned for response

##### Resposa de Falha

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

No body returned for response

```json
{
	"token": "token"
}
```

##### Resposta de Falha

Status: 403 Forbidden

```json
{
	"status": 403,
	"message": "Usuário inexistente ou senha inválida"
}
```
--------------------------------------------------------------------

##### Cadastro de Cliente

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
##### Resposta de sucesso

Status: 201 Created

No body returned for response

##### Resposta de Falha

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

Endpoint: /cliente/{id} - Método: GET

#### Resposta de Sucesso

Status: 200 OK

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

#### Resposta de Sucesso

- **Status:** 404 Not Found


```json
{
	"status": 404,
	"message": "Não foi possível encontrar a entidade"
}

```

