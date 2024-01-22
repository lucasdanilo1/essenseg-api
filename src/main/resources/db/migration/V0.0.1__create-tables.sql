CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE corretor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(255)
);

CREATE TABLE operadora (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE plano (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    operadora_id BIGINT,
    FOREIGN KEY (operadora_id) REFERENCES operadora(id)
);

CREATE TABLE administradora (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE operadora_administradora (
    operadora_id BIGINT,
    administradora_id BIGINT,
    PRIMARY KEY (operadora_id, administradora_id),
    FOREIGN KEY (operadora_id) REFERENCES operadora(id),
    FOREIGN KEY (administradora_id) REFERENCES administradora(id)
);

CREATE TABLE segurado (
    tipo VARCHAR(31) NOT NULL,
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ativo BOOLEAN NOT NULL,
    adesao DECIMAL(10,2) NOT NULL,
    percentual_comissao_da_operadora DECIMAL(38,2) NOT NULL,
    valor_do_plano_bruto DECIMAL(10,2),
    data_do_cadastro DATE,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    telefone VARCHAR(20),
    cep VARCHAR(10),
    endereco VARCHAR(255),
    email VARCHAR(255),
    operadora_id BIGINT NOT NULL,
    administradora_id BIGINT,
    corretor_id BIGINT NOT NULL,
    vigencia DATE,
    segmentacao VARCHAR(50) NOT NULL,
    cpf VARCHAR(20),
    nome_responsavel VARCHAR(255),
    cpf_responsavel VARCHAR(20),
    peso DECIMAL(10,2),
    altura DECIMAL(10,2),
    razao_social VARCHAR(255),
    nome_fantasia VARCHAR(255),
    cnpj VARCHAR(20),
    atv_economica VARCHAR(255),
    data_abertura DATE,
    observacoes VARCHAR(1000),
    plano_id BIGINT,
    FOREIGN KEY (operadora_id) REFERENCES operadora(id),
    FOREIGN KEY (administradora_id) REFERENCES administradora(id),
    FOREIGN KEY (corretor_id) REFERENCES corretor(id),
    FOREIGN KEY (plano_id) REFERENCES plano(id)
);

CREATE TABLE dependente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(255),
    relacao VARCHAR(255) NOT NULL,
    segurado_id BIGINT,
    FOREIGN KEY (segurado_id) REFERENCES segurado(id)
);

CREATE TABLE anexo (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    segurado_id BIGINT NOT NULL,
    nome_arquivo VARCHAR(255),
    anexo_data LONGBLOB NOT NULL,
    tipo_arquivo VARCHAR(255) NOT NULL,
    FOREIGN KEY (segurado_id) REFERENCES segurado(id)
);

CREATE TABLE extrato (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    randomId BIGINT,
    data_nascimento DATE,
    nome_arquivo VARCHAR(255),
    extrato_data LONGBLOB NOT NULL,
    corretor_id BIGINT,
    FOREIGN KEY (corretor_id) REFERENCES corretor(id)
);

CREATE TABLE corretor_extratos (
    corretor_id BIGINT NOT NULL,
    extratos_id BIGINT NOT NULL PRIMARY KEY,
    FOREIGN KEY (corretor_id) REFERENCES corretor(id)
);

CREATE TABLE corretor_segurados (
    corretor_id BIGINT NOT NULL,
    segurados_id BIGINT NOT NULL PRIMARY KEY,
    FOREIGN KEY (corretor_id) REFERENCES corretor(id)
);
