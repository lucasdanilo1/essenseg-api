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

# Funcionalidades e Documentação

Explicação sobre as funcionalidades gerais e peculiaridades de cada uma.

Documentação completa detalhada, citando rotas dos endpoints, metodos de um, tipos de retorno e parâmetros requeridos 
disponível em: https://lucasdanilo1.github.io/essenseg-api/


## 1. Autenticação de Usuários

A autenticação de usuários é essencial para controlar o acesso ao sistema, garantindo que apenas usuários autorizados possam utilizar as funcionalidades disponíveis na API. O processo de autenticação envolve o cadastro de novos usuários e o login de usuários já registrados.

#### Funcionalidades

1. **Cadastro:**
   
   - **Descrição:** Permite o registro de novos usuários no sistema.
   - **Método:** POST
   - **Endpoint:** `/auth/registrar`

3. **Cadastro:**
   
   - **Descrição:** Acesso de usuários já cadastrados, exigindo autenticação para utilizar as demais funcionalidades da API.
   - **Método:** POST
   - **Endpoint:** `/auth/login`


#### Tipo de Sistema e Medidas de Segurança

O sistema adotado para garantir a autenticidade dos usuários e a segurança das informações segue as melhores práticas disponíveis. Para obter detalhes sobre as medidas de segurança implementadas, consulte a [documentação específica](link) relacionada à segurança da API.

## 2. Gestão de Segurados 

Os Segurados desempenham um papel fundamental no sistema, representando o ponto central da gestão e estabelecendo relações com outras entidades.
Existem dois tipos de Segurados: Cliente e Empresa. 

Para cada um dos dois tipos de Segurado, foram desenvolvidos dois endpoints para cada operação CRUD (Create, Read, Update, Delete). A lógica por trás dessa abordagem, é explicada de forma mais específica no tópico [Estratégia utilizada para distinção de tipos de Segurado](#estratégia-utilizada-para-distinção-de-tipos-de-segurado).

#### Funcionalidades

1. **Cadastro:**
   - **Descrição:** Permite o cadastro de um novo Segurado.
   - **Método:** POST
   - **Endpoint Cliente:** `/cliente/new/cadastro/save`
   - **Endpoint Empresa:** `/empresa/new/cadastro/save`

2. **Detalhamento:**
   - **Descrição:** Exibe todas as informações de determinado Segurado, de acordo com o id informado na URL.
   - **Método:** GET
   - **Endpoint Cliente:** `/cliente/{id}`
   - **Endpoint Empresa:** `/empresa/{id}`

3. **Listagem:**
   - **Descrição:** Exibe a lista de Cliente ou Empresa.
   - **Método:** GET
   - **Endpoint Cliente:** `/auth/registrar`
   - **Endpoint Empresa:** `/auth/registrar`

4. **Listagem com filtros:**
   - **Descrição:** Exibe uma lista filtrada de Cliente ou Empresa. A filtragem traz todos os itens da lista geral que contenham uma parte ou um todo do parâmetro informado na requisição.
   - **Método:** POST
   - **Endpoint Cliente:** `/auth/registrar`
   - **Endpoint Empresa:** `/auth/registrar`

5. **Atualização:**
   - **Descrição:** Atualiza as informações de um Segurado, de acordo com o id informado na URL.
   - **Método:** PUT
   - **Endpoint Cliente:** `/cliente/{id}/atualizar`
   - **Endpoint Empresa:** `/empresa/{id}/atualizar`

6. **Inativação:**
   - **Descrição:** Inativa um Segurado, de acordo com o id informado na URL.
   - **Método:** DELETE
   - **Endpoint Cliente:** `/cliente/{id}/inativar`
   - **Endpoint Empresa:** `/empresa/{id}/inativar`

## 3. Gestão de Operadora e Administradora

A inclusão conjunta de Operadora e Administradora neste tópico se justifica devido à estreita relação entre ambas.

A função da Operadora reside na oferta de planos de saúde específicos ao público. Frequentemente, é necessária a colaboração com Administradoras para gerenciar e administrar os Segurados que adquiriram um plano dessa mesma Operadora.

Uma Operadora pode ter várias Administradoras, e uma Administradora pode administrar diversas Operadoras. Portanto foi adotado uma relação de muitos para muitos dessas duas entidades.

Logo fez-se necessário um Controller específico para relacionar as diversas possibilidades de relação entre as duas entidades.

#### Funcionalidades




------------------------------------------------------------------------------

### Estratégia utilizada para distinção de tipos de Segurado

**Modelo:**

Na base de dados, tanto Clientes quanto Empresas compartilham características semelhantes, levando à escolha de uma abordagem unificada com uma única tabela para ambos. A diferenciação entre Cliente e Empresa é realizada por meio de uma coluna denominada "tipo".

No contexto do sistema, Cliente e Empresa são tratados como duas sub-classes distintas que estendem todos os atributos e métodos de uma super-classe comum chamada Segurado. Essa super-classe, por sua vez, é definida como uma classe abstrata. A relação de herança entre Cliente e Empresa segue o modelo de herança de tipo SINGLE TABLE disponibilizada pelo Hibernate.

**Justificativa:**

Esta abordagem foi adotada visando aprimorar a legibilidade do código, promover uma estrutura mais limpa e garantir um baixo acoplamento. A escolha do tipo de herança SINGLE TABLE no JPA contribui para uma representação eficiente e unificada na base de dados, enquanto no código do sistema, Clientes e Empresas mantêm uma hierarquia de classes que reflete suas similaridades e diferenças de forma clara e modular.

Dito isso, optei por fazer Controllers diferentes para cada tipo de Segurado, pois para cada um, campos específicos são utilizados. Isso é importante para o tratamento específico de cada tipo e especialmente a validação dos campos obrigatórios para as funcionalidades de cadastro e atualização.

**Justificativa:**

Logo, mesmo que 

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
| [![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=essenseg-api&uri=https%3A%2F%2Fraw.githubusercontent.com%2Flucasdanilo1%2Fessenseg-api%2Fmain%2Finsomnia-requests)|

## Como usar 

Após importar as requisições, você verá uma coleção no menu à esquerda.

Basta clicar nas requisições individuais para abri-las e começar a testar a API.

Agora você está pronto para explorar e testar as funcionalidades da aplicação localmente usando algum dos API Client.

------------------------------------------------------------------------------




