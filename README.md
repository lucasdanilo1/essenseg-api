
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

# 1. Installation

## Requirements

Make sure you have all these requirements are running and working on your system.

- Java JDK 8 or above
- Maven
- Docker
- Git

## Clone and run with:

### Step 1 - Clone project

```shell
cd ~
git clone https://github.com/lucasdanilo1/essenseg-api.git
cd essenseg-api
```

### Step 2 - Run project

```shell
mvn spring-boot:run
```

--------------------------------------------------------------------
## Data Base Schema
<div>
<img src="https://github.com/lucasdanilo1/essenseg-api/blob/main/db_schema.png"/>
</div>

# 1. Getting Started

By default, the application server must be running on localhost and the default Spring port - 8080.

If you follow all the steps and run the application correctly, you can trigger requests to application endpoints in the localhost:8080 domain.

To trigger requests, you can use any API testing tools, like insomnia or postman.

## Documentação da API

<iframe src="https://raw.githubusercontent.com/lucasdanilo1/essenseg-api/blob/main/redoc-static.html" width="100%" height="500"></iframe>

