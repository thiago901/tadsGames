/* MER_-_Loja_Games(v3): */
create database dbGames;
use dbGames;
/*drop database dbgames;*//
/* MER_-_Loja_Games(v3): */

CREATE TABLE EstadoRegiao (
    idEstado INTEGER AUTO_INCREMENT PRIMARY KEY,
    uf VARCHAR(2) UNIQUE,
    estado VARCHAR(50),
    capital VARCHAR(50),
    regiao VARCHAR(15),
    pais VARCHAR(2)
    
    
);
CREATE TABLE cidade (
	idCidade INTEGER AUTO_INCREMENT PRIMARY KEY,
    nomeCidade VARCHAR(50),
    idEstado Integer,
    FOREIGN KEY (idEstado) REFERENCES EstadoRegiao (idEstado)
);

CREATE TABLE Empresa (
    idEmpresa INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cnpj VARCHAR(14) UNIQUE,
    dataCriacao DATE,
	idEstado INTEGER NOT NULL,
    idCidade INTEGER NOT NULL,
    matriz BOOLEAN,
    ativo BOOLEAN,
    FOREIGN KEY (idEstado) REFERENCES EstadoRegiao (idEstado)
);

CREATE TABLE Produto (
    idProduto INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    descricao VARCHAR(264),
    tipo VARCHAR(50),
    ativo BOOLEAN
);

CREATE TABLE EmpresaProduto (
    idEmpresa INTEGER,
    idProduto INTEGER,
    PRIMARY KEY (idEmpresa, idProduto),
    FOREIGN KEY (idEmpresa) REFERENCES Empresa (idEmpresa),
    FOREIGN KEY (idProduto) REFERENCES Produto (idProduto)
);

CREATE TABLE Cliente (
	idCliente INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    sobrenome VARCHAR(50),
    sexo varchar(1),
    idEmpresa INTEGER,
    cpf VARCHAR(11),
    dtNasc date,
    ativo boolean
);

CREATE TABLE Estoque (
    
    idProduto INTEGER,
    idEmpresa INTEGER,
    qtdEstoque INTEGER,
    valorVendaUnitario float,
    PRIMARY KEY (idProduto, idEmpresa),
    FOREIGN KEY (idProduto) REFERENCES Produto (idProduto),    
    FOREIGN KEY (idEmpresa) REFERENCES Empresa (idEmpresa)    
);

CREATE TABLE Compra (
    idCompra INTEGER AUTO_INCREMENT PRIMARY KEY,
    idEmpresa INTEGER,
    idProduto INTEGER,
    qtdComprada INTEGER,
    dataEntrada DATE,
    valorCompraUnitario float,
    
    FOREIGN KEY (idEmpresa) REFERENCES Empresa (idEmpresa),
    FOREIGN KEY (idProduto) REFERENCES Produto (idProduto)
);



CREATE TABLE Venda (
    idVenda INTEGER AUTO_INCREMENT PRIMARY KEY,
    valorTotal float,
    dataVenda DATE,
    statusPedido VARCHAR(20),
    idCliente integer,
    idEmpresa integer,
    FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
    
);
CREATE TABLE DetalheProduto (
    idVenda INTEGER,
    idProduto INTEGER,
    qtdVenda INTEGER,
    vlrVendaUnitario float,
    vlrTotal float,
    PRIMARY KEY (idVenda, idProduto),
	FOREIGN KEY (idVenda) REFERENCES Venda (idVenda),
    FOREIGN KEY (idProduto) REFERENCES Produto (idProduto)
);



CREATE TABLE Funcionario (
    idFuncionario INTEGER AUTO_INCREMENT PRIMARY KEY,
    idEmpresa INTEGER,
    nomeFuncionario VARCHAR(50),
    sobrenome VARCHAR(30),
    sexo VARCHAR(12),
    cpf VARCHAR(11) UNIQUE,
    dtNasc DATE,
    ativo BOOLEAN,
    login VARCHAR(50),
    senha VARCHAR(20),
    salario float,
    cargo VARCHAR(50),
    departamento VARCHAR(50),
    FOREIGN KEY (idEmpresa) REFERENCES Empresa (idEmpresa)    
);

CREATE TABLE Usuario (
    idUsuario INTEGER AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50),
    senha VARCHAR(16),
    idFuncionario INTEGER,
    ativo BOOLEAN,
    UNIQUE (email, idFuncionario),
    FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario)
);
