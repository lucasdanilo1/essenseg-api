
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
openapi: 3.0.1
info:
  title: Essenseg
  version: 1.0.0
servers:
  - url: http://localhost:8080
    description: Generated server url
paths:
  /auth/login:
    post:
      tags:
        - 1 - Autenticação de usuário
      operationId: login
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosAutenticacao'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/RespostaLoginDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /empresa/{id}/atualizar:
    put:
      tags:
        - 3 - Gestão de Empresas
      operationId: atualizarEmpresa
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/AtualizaDadosEmpresaDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosEmpresaDetalhadaDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /dependente/{id}/update:
    put:
      tags:
        - 4.2 - Gestão de Dependentes dos Segurados
      summary: Atualização de Dependente
      description: Retorna a lista geral de Dependentes
      operationId: atualizarDependente
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosAtualizaDependenteDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: object
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /corretor/{id}/update:
    put:
      tags:
        - 6 - Gestão de Corretores
      operationId: atualizarCorretor
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosAtualizaCorretorDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosCorretorDetalhadoDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /cliente/{id}/atualizar:
    put:
      tags:
        - 2 - Gestão de Clientes
      summary: Atualização de Cliente
      description: Atualiza um Cliente a partir no Id
      operationId: atualizarCliente
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/AtualizaDadosClienteDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosClienteDetalhadoDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /anexo/segurado/{seguradoId}:
    put:
      tags:
        - 4.1 - Gestão de Anexos dos Segurados
      summary: Upload de anexos a um Segurado
      description: Associa multiplos documentos (anexos) a determinado Segurado
      operationId: uploadAnexos
      parameters:
        - name: seguradoId
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              required:
                - file
              type: object
              properties:
                file:
                  type: array
                  items:
                    type: string
                    format: binary
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: object
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /segurado/listagem:
    get:
      tags:
        - 4 - Listagem dos Segurados (Clientes e Empresas)
      summary: Listagem geral dos Segurados (Cliente e Empresa)
      description: Retorna a lista de todos os clientes e empresas cadastrados
      operationId: listarmSegurados
      parameters:
        - name: page
          in: query
          required: true
          schema:
            $ref: '#/components/schemas/Pageable'
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PageDadosListagemSegurado'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
    post:
      tags:
        - 4 - Listagem dos Segurados (Clientes e Empresas)
      summary: Listagem geral filtrada dos Segurados (Cliente e Empresa)
      description: Retorna a lista filtrada de todos os clientes e empresas cadastrados
      operationId: listarSeguradosFiltrados
      requestBody:
        content:
          application/json:
            schema:
              type: object
              properties:
                filtros:
                  $ref: '#/components/schemas/FiltrosSeguradoDTO'
                page:
                  $ref: '#/components/schemas/Pageable'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PageDadosListagemSegurado'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /plano/novo/cadastro/save:
    post:
      tags:
        - 5 - Gestão de Planos de Saúde
      operationId: cadastrarPlano
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosPlanoDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosDetalhamentoPlano'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /operadora/novo/cadastro/salvar:
    post:
      tags:
        - 7 - Gestão de Operadoras
      operationId: cadastrarOperadora
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosOperadoraDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: string
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /extrato/gerar/corretor/{id}:
    post:
      tags:
        - 6.1 - Gestão de Extratos dos Corretores
      operationId: gerarExtratoPdf
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              type: array
              items:
                $ref: '#/components/schemas/SeguradoSelecionado'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: string
                format: binary
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /empresa/new/cadastro/save:
    post:
      tags:
        - 3 - Gestão de Empresas
      operationId: cadastrarEmpresa
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosCadastroEmpresaDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosEmpresaDetalhadaDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /empresa/listagem:
    get:
      tags:
        - 3 - Gestão de Empresas
      operationId: listarEmpresas
      parameters:
        - name: page
          in: query
          required: true
          schema:
            $ref: '#/components/schemas/Pageable'
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PageDadosListagemEmpresa'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
    post:
      tags:
        - 3 - Gestão de Empresas
      operationId: listarmEmpresasFiltradas
      parameters:
        - name: page
          in: query
          required: true
          schema:
            $ref: '#/components/schemas/Pageable'
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/FiltrosEmpresaDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PageDadosListagemEmpresa'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /dependente/segurado/{seguradoId}/addDependente:
    post:
      tags:
        - 4.2 - Gestão de Dependentes dos Segurados
      summary: Cadastro de Dependente e associação a um Segurado
      description: Cadastra um Dependente associado a um Segurado, é possível cadastrar multiplos dependentes a um Segurado
      operationId: cadastroDepentente
      parameters:
        - name: seguradoId
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosCadastroDependenteDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: object
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /corretor/new/cadastro/save:
    post:
      tags:
        - 6 - Gestão de Corretores
      operationId: cadastroCorretor
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosCadastroCorretorDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosCorretorDetalhadoDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /cliente/new/cadastro/save:
    post:
      tags:
        - 2 - Gestão de Clientes
      summary: Cadastro de Cliente
      description: Cadastra um Cliente
      operationId: cadastrarCliente
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosCadastroClienteDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosClienteDetalhadoDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /cliente/listagem:
    get:
      tags:
        - 2 - Gestão de Clientes
      summary: Listagem de Cliente
      description: Lista clientes cadastrados
      operationId: listarClientes
      parameters:
        - name: page
          in: query
          required: true
          schema:
            $ref: '#/components/schemas/Pageable'
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PageDadosListagemCliente'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
    post:
      tags:
        - 2 - Gestão de Clientes
      summary: Listagem com filtros de Cliente
      description: Lista lientes cadastrados a partir da string enviada na requisição
      operationId: listarClientesFiltrados
      parameters:
        - name: page
          in: query
          required: true
          schema:
            $ref: '#/components/schemas/Pageable'
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/FiltrosClienteDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PageDadosListagemCliente'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /auth/registrar:
    post:
      tags:
        - 1 - Autenticação de usuário
      operationId: registrar
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosCadastroUsuario'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: object
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /administradora/new/cadastro/save:
    post:
      tags:
        - 8 - Gestão de Administradoras
      operationId: cadastrarAdministradora
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosAdministradoraDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: string
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /administradora-operadora/relacionar:
    post:
      tags:
        - 9 - Relacionamento entre Operadoras e Administradoras
      operationId: relacionarOperadoraAdministradora
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DadosRelacionamentoDTO'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: object
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /plano/{id}:
    get:
      tags:
        - 5 - Gestão de Planos de Saúde
      operationId: detalharPlano
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosDetalhamentoPlano'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /plano/listagem/operadora/{id}:
    get:
      tags:
        - 5 - Gestão de Planos de Saúde
      operationId: listarplanosPorOperadora
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/DadosDetalhamentoPlano'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /operadora/listagem:
    get:
      tags:
        - 7 - Gestão de Operadoras
      operationId: listarOperadoras
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/DadosListagemOperadora'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /extrato/listagem:
    get:
      tags:
        - 6.1 - Gestão de Extratos dos Corretores
      operationId: listarExtratos
      parameters:
        - name: page
          in: query
          required: true
          schema:
            $ref: '#/components/schemas/Pageable'
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/PageDadosListagemExtrato'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /extrato/download/{id}:
    get:
      tags:
        - 6.1 - Gestão de Extratos dos Corretores
      operationId: downloadExtrato
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: string
                format: binary
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /empresa/{id}:
    get:
      tags:
        - 3 - Gestão de Empresas
      operationId: detalharEmpresa
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosEmpresaDetalhadaDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /dependente/listagem:
    get:
      tags:
        - 4.2 - Gestão de Dependentes dos Segurados
      summary: Listagem de Dependente
      description: Retorna a lista geral de Dependentes
      operationId: listarDependentes
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Dependente'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /corretor/listagem:
    get:
      tags:
        - 6 - Gestão de Corretores
      operationId: listarCorretores
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/DadosListagemCorretor'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /cliente/{id}:
    get:
      tags:
        - 2 - Gestão de Clientes
      summary: Detalhamento de Cliente
      description: Detalha um Cliente a partir no Id
      operationId: detalharCliente
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosClienteDetalhadoDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /anexo/{anexoIndex}/segurado/{seguradoId}:
    get:
      tags:
        - 4.1 - Gestão de Anexos dos Segurados
      summary: Download de anexo de um Segurado
      description: Permite fazer download de determinado anexo de um Segurado
      operationId: downloadAnexo
      parameters:
        - name: seguradoId
          in: path
          required: true
          schema:
            type: integer
            format: int64
        - name: anexoIndex
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: string
                format: binary
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /administradora/listagem:
    get:
      tags:
        - 8 - Gestão de Administradoras
      operationId: listarAdministradoras
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/DadosListagemAdministradoraDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /administradora-operadora/administradora/lista/operadora/{id}:
    get:
      tags:
        - 9 - Relacionamento entre Operadoras e Administradoras
      operationId: listarAdministradoraPorOperadora
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/DadosListagemAdministradoraDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /plano/inativar/{id}:
    delete:
      tags:
        - 5 - Gestão de Planos de Saúde
      operationId: invativarPlano
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: object
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /empresa/{id}/inativar:
    delete:
      tags:
        - 3 - Gestão de Empresas
      operationId: inativarEmpresa
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosEmpresaDetalhadaDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
  /cliente/{id}/inativar:
    delete:
      tags:
        - 2 - Gestão de Clientes
      summary: Inativação um Cliente
      description: Atualiza um Cliente a partir no Id
      operationId: inativarCliente
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/DadosClienteDetalhadoDTO'
        '400':
          description: Bad Request
          content:
            '*/*':
              schema:
                type: object
        '401':
          description: Unauthorized
          content:
            '*/*':
              schema:
                type: object
        '403':
          description: Forbidden
          content:
            '*/*':
              schema:
                type: object
        '404':
          description: Not Found
          content:
            '*/*':
              schema:
                type: object
        '409':
          description: Conflict
          content:
            '*/*':
              schema:
                type: object
        '422':
          description: Unprocessable Entity
          content:
            '*/*':
              schema:
                type: object
        '500':
          description: Internal Server Error
          content:
            '*/*':
              schema:
                type: object
components:
  schemas:
    AtualizaDadosEmpresaDTO:
      type: object
      properties:
        atualizaDadosSeguradoDTO:
          $ref: '#/components/schemas/AtualizaDadosSeguradoDTO'
        atualizaDadosEspecificosEmpresaDTO:
          $ref: '#/components/schemas/AtualizaDadosEspecificosEmpresaDTO'
        observacoes:
          type: string
    AtualizaDadosEspecificosEmpresaDTO:
      type: object
      properties:
        razaoSocial:
          type: string
        nomeFantasia:
          type: string
        atvEconomica:
          type: string
        dataAbertura:
          type: string
        observacoes:
          type: string
    AtualizaDadosSeguradoDTO:
      type: object
      properties:
        operadoraId:
          type: integer
          format: int64
        administradoraId:
          type: integer
          format: int64
        planoId:
          type: integer
          format: int64
        vigencia:
          type: string
          format: date
        valorDoPlano:
          type: number
        percentualComissao:
          type: number
        adesao:
          type: number
        segmentacao:
          type: string
          enum:
            - INDIVIDUAL
            - ADESAO
            - EMPRESARIAL
        nome:
          type: string
        telefone:
          pattern: \d{10}
          type: string
        cep:
          pattern: \d{5}-\d{3}
          type: string
        endereco:
          type: string
        email:
          type: string
    DadosEmpresaDetalhadaDTO:
      type: object
      properties:
        dadosSeguradoDetalhadoDTO:
          $ref: '#/components/schemas/DadosSeguradoDetalhadoDTO'
        dadosEspecificosEmpresaDetalhadaDTO:
          $ref: '#/components/schemas/DadosEspecificosEmpresaDetalhadaDTO'
        observacoes:
          type: string
    DadosEspecificosEmpresaDetalhadaDTO:
      type: object
      properties:
        razaoSocial:
          type: string
        nomeFantasia:
          type: string
        cnpj:
          type: string
        atvEconomica:
          type: string
        dataAbertura:
          type: string
          format: date
    DadosSeguradoDetalhadoDTO:
      type: object
      properties:
        nome:
          type: string
        dataNascimento:
          type: string
          format: date
        telefone:
          type: string
        cep:
          type: string
        endereco:
          type: string
        email:
          type: string
        corretorId:
          type: integer
          format: int64
        operadoraId:
          type: integer
          format: int64
        administradoraId:
          type: integer
          format: int64
        vigencia:
          type: string
          format: date
        planoId:
          type: integer
          format: int64
        valorDoPlanoBruto:
          type: number
        percentualComissaoDaOperadora:
          type: number
        adesao:
          type: number
        segmentacao:
          type: string
          enum:
            - INDIVIDUAL
            - ADESAO
            - EMPRESARIAL
    DadosAtualizaDependenteDTO:
      type: object
      properties:
        nome:
          type: string
        dataNascimento:
          type: string
        parentesco:
          type: string
        telefone:
          type: string
        email:
          type: string
    DadosAtualizaCorretorDTO:
      type: object
      properties:
        nome:
          type: string
        email:
          type: string
        telefone:
          type: string
    DadosCorretorDetalhadoDTO:
      type: object
      properties:
        nome:
          type: string
        email:
          type: string
        telefone:
          type: string
    AtualizaDadosClienteDTO:
      type: object
      properties:
        atualizaDadosSeguradoDTO:
          $ref: '#/components/schemas/AtualizaDadosSeguradoDTO'
        atualizaDadosEspecificosClienteDTO:
          $ref: '#/components/schemas/AtualizaDadosEspecificosClienteDTO'
        observacoes:
          type: string
    AtualizaDadosEspecificosClienteDTO:
      type: object
      properties:
        nomeResponsavel:
          type: string
        peso:
          type: number
        altura:
          type: number
        observacoes:
          type: string
    DadosClienteDetalhadoDTO:
      type: object
      properties:
        dadosSeguradoDetalhadoDTO:
          $ref: '#/components/schemas/DadosSeguradoDetalhadoDTO'
        dadosEspecificosClienteDetalhadoDTO:
          $ref: '#/components/schemas/DadosEspecificosClienteDetalhadoDTO'
        observacoes:
          type: string
    DadosEspecificosClienteDetalhadoDTO:
      type: object
      properties:
        cpf:
          type: string
        nomeResponsavel:
          type: string
        cpfResponsavel:
          type: string
        peso:
          type: number
        altura:
          type: number
    FiltrosSeguradoDTO:
      type: object
      properties:
        filtroGlobal:
          type: string
        segmentacao:
          type: string
          enum:
            - INDIVIDUAL
            - ADESAO
            - EMPRESARIAL
        administradoraId:
          type: integer
          format: int64
        operadoraId:
          type: integer
          format: int64
        primeiraDataVigencia:
          type: string
          format: date
        segundaDataVigencia:
          type: string
          format: date
    Pageable:
      type: object
      properties:
        page:
          minimum: 0
          type: integer
          format: int32
        size:
          minimum: 1
          type: integer
          format: int32
        sort:
          type: array
          items:
            type: string
    DadosListagemSegurado:
      type: object
      properties:
        tipo:
          type: string
        id:
          type: integer
          format: int64
        dataCadastro:
          type: string
          format: date
        nome:
          type: string
        telefone:
          type: string
        email:
          type: string
        cpfCnpj:
          type: string
    PageDadosListagemSegurado:
      type: object
      properties:
        totalPages:
          type: integer
          format: int32
        totalElements:
          type: integer
          format: int64
        size:
          type: integer
          format: int32
        content:
          type: array
          items:
            $ref: '#/components/schemas/DadosListagemSegurado'
        number:
          type: integer
          format: int32
        sort:
          $ref: '#/components/schemas/SortObject'
        numberOfElements:
          type: integer
          format: int32
        first:
          type: boolean
        last:
          type: boolean
        pageable:
          $ref: '#/components/schemas/PageableObject'
        empty:
          type: boolean
    PageableObject:
      type: object
      properties:
        offset:
          type: integer
          format: int64
        sort:
          $ref: '#/components/schemas/SortObject'
        pageNumber:
          type: integer
          format: int32
        pageSize:
          type: integer
          format: int32
        unpaged:
          type: boolean
        paged:
          type: boolean
    SortObject:
      type: object
      properties:
        empty:
          type: boolean
        sorted:
          type: boolean
        unsorted:
          type: boolean
    DadosPlanoDTO:
      required:
        - nome
        - operadoraId
      type: object
      properties:
        operadoraId:
          type: integer
          format: int64
        nome:
          type: string
    DadosDetalhamentoPlano:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
        nomeOperadora:
          type: string
    DadosOperadoraDTO:
      required:
        - nome
      type: object
      properties:
        nome:
          type: string
    SeguradoSelecionado:
      required:
        - clienteId
        - percentualComissaoDoCorretor
        - percentualDoImposto
      type: object
      properties:
        clienteId:
          type: integer
          format: int64
        percentualComissaoDoCorretor:
          type: number
        percentualDoImposto:
          type: number
    DadosCadastroEmpresaDTO:
      type: object
      properties:
        dadosPessoaisSeguradoDTO:
          $ref: '#/components/schemas/DadosPessoaisSeguradoDTO'
        dadosParaContratacaoSeguradoDTO:
          $ref: '#/components/schemas/DadosParaContratacaoSeguradoDTO'
        dadosEspecificosCadastroEmpresaDTO:
          $ref: '#/components/schemas/DadosEspecificosCadastroEmpresaDTO'
        observacoes:
          type: string
    DadosEspecificosCadastroEmpresaDTO:
      required:
        - cnpj
      type: object
      properties:
        razaoSocial:
          type: string
        nomeFantasia:
          type: string
        cnpj:
          type: string
        atvEconomica:
          type: string
        dataAbertura:
          type: string
          format: date
    DadosParaContratacaoSeguradoDTO:
      required:
        - adesao
        - corretorId
        - operadoraId
        - percentualComissao
        - planoId
        - valorDoPlanoBruto
      type: object
      properties:
        operadoraId:
          type: integer
          format: int64
        administradoraId:
          type: integer
          format: int64
        corretorId:
          type: integer
          format: int64
        vigencia:
          type: string
          format: date
        planoId:
          type: integer
          format: int64
        valorDoPlanoBruto:
          type: number
        percentualComissao:
          type: number
        adesao:
          type: number
        segmentacao:
          type: string
          enum:
            - INDIVIDUAL
            - ADESAO
            - EMPRESARIAL
    DadosPessoaisSeguradoDTO:
      required:
        - cep
        - email
        - nome
        - telefone
      type: object
      properties:
        nome:
          type: string
        dataNascimento:
          type: string
          format: date
        telefone:
          type: string
        endereco:
          type: string
        email:
          type: string
        cep:
          type: string
    FiltrosEmpresaDTO:
      type: object
      properties:
        filtroGlobal:
          type: string
        administradoraId:
          type: integer
          format: int64
        operadoraId:
          type: integer
          format: int64
        primeiraDataVigencia:
          type: string
          format: date
        segundaDataVigencia:
          type: string
          format: date
    DadosListagemEmpresa:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nomeFantasia:
          type: string
        cnpj:
          type: string
        responsavelEmpresa:
          type: string
        email:
          type: string
    PageDadosListagemEmpresa:
      type: object
      properties:
        totalPages:
          type: integer
          format: int32
        totalElements:
          type: integer
          format: int64
        size:
          type: integer
          format: int32
        content:
          type: array
          items:
            $ref: '#/components/schemas/DadosListagemEmpresa'
        number:
          type: integer
          format: int32
        sort:
          $ref: '#/components/schemas/SortObject'
        numberOfElements:
          type: integer
          format: int32
        first:
          type: boolean
        last:
          type: boolean
        pageable:
          $ref: '#/components/schemas/PageableObject'
        empty:
          type: boolean
    DadosCadastroDependenteDTO:
      type: object
      properties:
        nome:
          type: string
        dataNascimento:
          type: string
        cpf:
          type: string
        parentesco:
          type: string
        telefone:
          type: string
        email:
          type: string
    DadosCadastroCorretorDTO:
      required:
        - nome
      type: object
      properties:
        nome:
          type: string
        email:
          type: string
        telefone:
          type: string
    DadosCadastroClienteDTO:
      type: object
      properties:
        dadosPessoaisSeguradoDTO:
          $ref: '#/components/schemas/DadosPessoaisSeguradoDTO'
        dadosParaContratacaoSeguradoDTO:
          $ref: '#/components/schemas/DadosParaContratacaoSeguradoDTO'
        dadosEspecificosCadastroClienteDTO:
          $ref: '#/components/schemas/DadosEspecificosCadastroClienteDTO'
        observacoes:
          type: string
    DadosEspecificosCadastroClienteDTO:
      required:
        - cpf
      type: object
      properties:
        cpf:
          type: string
        nomeResponsavel:
          type: string
        cpfResponsavel:
          type: string
        peso:
          type: number
        altura:
          type: number
    FiltrosClienteDTO:
      type: object
      properties:
        filtroGlobal:
          type: string
        segmentacao:
          type: string
          enum:
            - INDIVIDUAL
            - ADESAO
            - EMPRESARIAL
        administradoraId:
          type: integer
          format: int64
        operadoraId:
          type: integer
          format: int64
        primeiraDataVigencia:
          type: string
          format: date
        segundaDataVigencia:
          type: string
          format: date
    DadosListagemCliente:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
        operadoraId:
          type: integer
          format: int64
        vigencia:
          type: string
          format: date
        planoId:
          type: integer
          format: int64
        valorDoPlano:
          type: number
        adesao:
          type: number
        segmentacao:
          type: string
          enum:
            - INDIVIDUAL
            - ADESAO
            - EMPRESARIAL
    PageDadosListagemCliente:
      type: object
      properties:
        totalPages:
          type: integer
          format: int32
        totalElements:
          type: integer
          format: int64
        size:
          type: integer
          format: int32
        content:
          type: array
          items:
            $ref: '#/components/schemas/DadosListagemCliente'
        number:
          type: integer
          format: int32
        sort:
          $ref: '#/components/schemas/SortObject'
        numberOfElements:
          type: integer
          format: int32
        first:
          type: boolean
        last:
          type: boolean
        pageable:
          $ref: '#/components/schemas/PageableObject'
        empty:
          type: boolean
    DadosCadastroUsuario:
      required:
        - login
        - role
        - senha
      type: object
      properties:
        login:
          type: string
        senha:
          type: string
        role:
          type: string
          enum:
            - ADMIN
            - USER
    DadosAutenticacao:
      type: object
      properties:
        login:
          type: string
        senha:
          type: string
    RespostaLoginDTO:
      type: object
      properties:
        token:
          type: string
    DadosAdministradoraDTO:
      required:
        - nome
      type: object
      properties:
        nome:
          type: string
    DadosRelacionamentoDTO:
      required:
        - administradoraId
        - operadoraId
      type: object
      properties:
        operadoraId:
          type: integer
          format: int64
        administradoraId:
          type: integer
          format: int64
    DadosListagemOperadora:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
    DadosListagemExtrato:
      type: object
      properties:
        identificador:
          type: integer
          format: int64
        nome:
          type: string
        dataCriacao:
          type: string
          format: date
        corretor:
          type: string
    PageDadosListagemExtrato:
      type: object
      properties:
        totalPages:
          type: integer
          format: int32
        totalElements:
          type: integer
          format: int64
        size:
          type: integer
          format: int32
        content:
          type: array
          items:
            $ref: '#/components/schemas/DadosListagemExtrato'
        number:
          type: integer
          format: int32
        sort:
          $ref: '#/components/schemas/SortObject'
        numberOfElements:
          type: integer
          format: int32
        first:
          type: boolean
        last:
          type: boolean
        pageable:
          $ref: '#/components/schemas/PageableObject'
        empty:
          type: boolean
    Administradora:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
        operadora:
          uniqueItems: true
          type: array
          items:
            $ref: '#/components/schemas/Operadora'
    Anexo:
      type: object
      properties:
        id:
          type: integer
          format: int64
        segurado:
          $ref: '#/components/schemas/Segurado'
        nomeArquivo:
          type: string
        tipoArquivo:
          type: string
        anexoData:
          type: array
          items:
            type: string
            format: byte
    Corretor:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
        email:
          type: string
        telefone:
          type: string
        extratos:
          type: array
          items:
            $ref: '#/components/schemas/Extrato'
        segurados:
          type: array
          items:
            $ref: '#/components/schemas/Segurado'
    DadosContratacaoSegurado:
      type: object
      properties:
        operadora:
          $ref: '#/components/schemas/Operadora'
        administradora:
          $ref: '#/components/schemas/Administradora'
        corretor:
          $ref: '#/components/schemas/Corretor'
        vigencia:
          type: string
          format: date
        plano:
          $ref: '#/components/schemas/Plano'
        valorDoPlanoBruto:
          type: number
        percentualComissaoDaOperadora:
          type: number
        adesao:
          type: number
        segmentacao:
          type: string
          enum:
            - INDIVIDUAL
            - ADESAO
            - EMPRESARIAL
    DadosEspecificosCliente:
      type: object
      properties:
        cpf:
          type: string
        nomeResponsavel:
          type: string
        cpfResponsavel:
          type: string
        peso:
          type: number
        altura:
          type: number
    DadosEspecificosEmpresa:
      type: object
      properties:
        razaoSocial:
          type: string
        nomeFantasia:
          type: string
        cnpj:
          type: string
        atvEconomica:
          type: string
        dataAbertura:
          type: string
          format: date
    DadosPessoaisDependente:
      type: object
      properties:
        nome:
          type: string
        dataNascimento:
          type: string
          format: date
        cpf:
          type: string
        relacao:
          type: string
        email:
          type: string
        telefone:
          type: string
    DadosPessoaisSegurado:
      type: object
      properties:
        nome:
          type: string
        dataNascimento:
          type: string
          format: date
        telefone:
          type: string
        cep:
          type: string
        endereco:
          type: string
        email:
          type: string
    Dependente:
      type: object
      properties:
        id:
          type: integer
          format: int64
        dadosPessoaisDependente:
          $ref: '#/components/schemas/DadosPessoaisDependente'
        segurado:
          $ref: '#/components/schemas/Segurado'
    Extrato:
      type: object
      properties:
        id:
          type: integer
          format: int64
        randomId:
          type: integer
          format: int64
        nomeArquivo:
          type: string
        corretor:
          $ref: '#/components/schemas/Corretor'
        dataCriacao:
          type: string
          format: date
        extratoData:
          type: array
          items:
            type: string
            format: byte
    Operadora:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
        planos:
          type: array
          items:
            $ref: '#/components/schemas/Plano'
        administradora:
          uniqueItems: true
          type: array
          items:
            $ref: '#/components/schemas/Administradora'
    Plano:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
        operadora:
          $ref: '#/components/schemas/Operadora'
    Segurado:
      type: object
      properties:
        id:
          type: integer
          format: int64
        ativo:
          type: boolean
        dataDoCadastro:
          type: string
          format: date
        dadosPessoaisSegurado:
          $ref: '#/components/schemas/DadosPessoaisSegurado'
        dadosContratacaoSegurado:
          $ref: '#/components/schemas/DadosContratacaoSegurado'
        dadosEspecificosCliente:
          $ref: '#/components/schemas/DadosEspecificosCliente'
        dadosEspecificosEmpresa:
          $ref: '#/components/schemas/DadosEspecificosEmpresa'
        dependentes:
          type: array
          items:
            $ref: '#/components/schemas/Dependente'
        anexos:
          type: array
          items:
            $ref: '#/components/schemas/Anexo'
        observacoes:
          type: string
    DadosListagemCorretor:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string
        email:
          type: string
    DadosListagemAdministradoraDTO:
      type: object
      properties:
        id:
          type: integer
          format: int64
        nome:
          type: string

