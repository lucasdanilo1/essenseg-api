
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

## Data Base Schema
<div>
<img src="https://github.com/lucasdanilo1/essenseg-api/blob/main/db_schema.png"/>
</div>

--------------------------------------------------------------------

## API Documentation

https://lucasdanilo1.github.io/essenseg-api/

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

A aplicação estará disponível em http://localhost:8080.

--------------------------------------------------------------------

## Disparando as Requisições com Insomnia

Para testar as requisições da API, é recomendado o uso do Insomnia, um cliente de API versátil e fácil de usar. 
Siga os passos abaixo para importar as requisições prontas:

### Baixar as Requisições Insomnia

Clique aqui para baixar o arquivo JSON com as requisições.

### Importar as Requisições no Insomnia

Abra o Insomnia e vá para o menu File > Import/Export > Import Data.
Selecione a opção From File e escolha o arquivo JSON que você baixou.

### Usar as Requisições

Após importar as requisições, você verá uma coleção no menu à esquerda.
Basta clicar nas requisições individuais para abri-las e começar a testar a API.

Agora você está pronto para explorar e testar as funcionalidades da aplicação localmente usando o Insomnia. Certifique-se de ajustar as configurações de ambiente conforme necessário.






