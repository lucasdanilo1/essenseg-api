# EssensegAPI

API Restful desenvolvida com Spring para uma corretora de planos de saúde. 


## Descrição

Principal foco a gestão de Segurados, Dependentes, Operadoras, Administradoras, Corretores e Planos de Saúde.
Cadastro, atualização, listagem com filtros e detalhamento de todas as entidades citadas acima. 
Além da possibilidade de anexo de arquivos, vinculados aos Segurados. Geração de relatórios PDF de extratos, 
baseados na venda dos planos feitas para Segurados, de um Corretor.

## Tecnologias usadas

<div>
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/Java-Light.svg"/>
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/Spring-Light.svg" />
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/MySQL-Light.svg" />
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/Docker.svg"/>
<img height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/AWS-Light.svg"/>
</div>

## Db Schema
<div>
<img src="https://github.com/lucasdanilo1/essenseg-api/blob/main/db_schema.png"/>
</div>

------------------------------------------------------------------------------

## Funcionalidades e Documentação

Breve explicação sobre as funcionalidades gerais e peculiaridades de cada uma.

Documentação completa detalhada, citando rotas dos endpoints, metodos de um, tipos de retorno e parâmetros requeridos 
disponível em: https://lucasdanilo1.github.io/essenseg-api/


### 1. Autenticação de Usuários

A autenticação de usuários é essencial para controlar o acesso ao sistema, garantindo que apenas usuários autorizados possam utilizar as funcionalidades disponíveis na API. O processo de autenticação envolve o cadastro de novos usuários e o login de usuários já registrados.

#### Funcionalidades

1. **Cadastro de Novo Usuário:**
   - Endpoint: `/auth/registrar`
   - Descrição: Permite o registro de novos usuários no sistema.

2. **Login de Usuário:**
   - Endpoint: `/auth/login`
   - Descrição: Facilita o acesso de usuários já cadastrados, exigindo autenticação para utilizar as demais funcionalidades da API.

#### Tipo de Sistema e Medidas de Segurança

O sistema adotado para garantir a autenticidade dos usuários e a segurança das informações segue as melhores práticas disponíveis. Para obter detalhes sobre as medidas de segurança implementadas, consulte a [documentação específica](link) relacionada à segurança da API.

### 2. Gestão de Segurados.

Um Segurado é a parte mais importante do sistema, pois é o principal foco de gestão, e onde todas as outras entidades fazem relação.
Um Segurado é um Cliente 


------------------------------------------------------------------------------

# 1. Instalação

Como instalar e executar o projeto.

## Requerimentos

- Java JDK 8 ou superior
- Maven
- Docker
- Git

Certifique-se que você tem todos os requerimentos devidamente instalandos na sua máquina.

Caso contrário, não será possível instalar nem executar o projeto.

## Clone e execução do projeto

#### Passo 1 - Clone o projeto

```shell
cd \
git clone https://github.com/lucasdanilo1/essenseg-api.git
```

#### Passo 2 - Acesse a pasta do projeto

```shell
cd essenseg-api
```

#### Passo 3 - Execute o projeto

```shell
mvn spring-boot:run
```

#### Observações
- É obrigatório que o Docker esteja em execução para ser possível concluir o Passo 3.

Após isso, a aplicação estará disponível em http://localhost:8080.

------------------------------------------------------------------------------

# 2. Teste e Disparo das requisições

É possível importar a coleção completa de requisições disponíveis na API. 

Para isso, disponibilizo a coleção nos dois principais API Client do mercado, [Insomnia](https://insomnia.rest/download) e [Postman](https://www.postman.com/downloads/).

## Importação da coleção de requisições

| API Collection                                                                             |
|--------------------------------------------------------------------------------------------|
| [![Run in Insomnia](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=essenseg-api&uri=https%3A%2F%2Fraw.githubusercontent.com%2Flucasdanilo1%2Fessenseg-api%2Fmain%2Fessenseg-requisicoes) |
| [<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" width="135" height="30">](https://god.gw.postman.com/run-collection/:collection_id) |

## Como usar 

Após importar as requisições, você verá uma coleção no menu à esquerda.

Basta clicar nas requisições individuais para abri-las e começar a testar a API.

Agora você está pronto para explorar e testar as funcionalidades da aplicação localmente usando algum dos API Client.

------------------------------------------------------------------------------




