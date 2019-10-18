/ * MER_-_ Loja_Games (v2): * /
criar  banco de dados dbGames;
use dbGames;
/ * solte o banco de dados dbgames; * / /
/ * MER_-_ Loja_Games (v3): * /

CRIAR  TABELA EstadoRegiao (
    idEstado INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    de VARCHAR ( 2 ) ÚNICO,
    estado VARCHAR ( 50 )
    capital VARCHAR ( 50 ),
    região VARCHAR ( 15 )
    pais VARCHAR ( 2 )
    
    
);
CRIAR  TABELA cidade (
	idCidade INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    nomeCidade VARCHAR ( 50 ),
    idEstado Inteiro ,
    CHAVE ESTRANGEIRA (idEstado) REFERÊNCIAS EstadoRegiao (idEstado)
);

CREATE  TABLE Empresa (
    idEmpresa INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    nome VARCHAR ( 50 ),
    cnpj VARCHAR ( 14 ) ÚNICO,
    dataCriacao DATE ,
	idEstado INTEGER  NOT  NULL ,
    idCidade INTEGER  NOT  NULL ,
    matriz BOOLEAN ,
    ativo BOOLEAN ,
    CHAVE ESTRANGEIRA (idEstado) REFERÊNCIAS EstadoRegiao (idEstado)
);

CRIAR  TABELA Produto (
    idProduto INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    nome VARCHAR ( 50 ),
    descrição VARCHAR ( 264 ),
    tipo VARCHAR ( 50 ),
    ativo BOOLEAN
);

CREATE  TABLE EmpresaProduto (
    idEmpresa INTEGER ,
    idProduto INTEGER ,
     CHAVE PRIMÁRIA (idEmpresa, idProduto),
    CHAVE ESTRANGEIRA (idEmpresa) REFERÊNCIAS Empresa (idEmpresa),
    CHAVE ESTRANGEIRA (idProduto) REFERÊNCIAS Produto (idProduto)
);

CRIAR  TABELA Cliente (
	idCliente INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    nome VARCHAR ( 50 ),
    sobrenome VARCHAR ( 50 ),
    sexo varchar ( 1 )
    idEmpresa INTEGER ,
    cpf VARCHAR ( 11 ),
    dtNasc date ,
    ativo boolean
);

CRIAR  TABELA Estoque (
    idEstoque INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    qtdEstoque INTEGER ,
    valorVendaUnitario float ,
    idProduto INTEGER ,
    CHAVE ESTRANGEIRA (idProduto) REFERÊNCIAS Produto (idProduto)    
);

CRIAR  TABELA Compra (
    idCompra INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    dataEntrada DATE ,
    qtdComprada INTEGER ,
    valorCompraUnitario float ,
    idEmpresa INTEGER ,
    CHAVE ESTRANGEIRA (idEmpresa) REFERÊNCIAS Empresa (idEmpresa)
);



CRIAR  TABELA pedido (
    idPedido INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    valorTotal float ,
    dataSolicitaco INTEGER ,
    dataFinalizacao DATE ,
    statusPedido VARCHAR ( 20 ),
    Servico BOOLEAN ,
    idCliente inteiro ,
    CHAVE ESTRANGEIRA (idCliente) REFERÊNCIAS Cliente (idCliente)
    
);
CRIAR  TABELA DetalheProduto (
    idPedido INTEGER ,
    idProduto INTEGER ,
    qtdVenda INTEGER ,
    vlrVenda float ,
     CHAVE PRIMÁRIA (idPedido, idProduto),
	CHAVE ESTRANGEIRA (idPedido) REFERÊNCIAS Pedido (idPedido),
    CHAVE ESTRANGEIRA (idProduto) REFERÊNCIAS Produto (idProduto)
);



CREATE  TABLE Funcionario (
    idFuncionario INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    idEmpresa INTEGER ,
    nome VARCHAR ( 50 ),
    sobrenome VARCHAR ( 30 ),
    sexo VARCHAR ( 12 )
    cpf VARCHAR ( 11 ) ÚNICO,
    dtNasc DATE ,
    ativo BOOLEAN ,
    faça login no  VARCHAR ( 50 ),
    senha VARCHAR ( 20 ),
flutuador de     salario ,
    carga VARCHAR ( 50 ),
    departamento VARCHAR ( 50 ),
    CHAVE ESTRANGEIRA (idEmpresa) REFERÊNCIAS Empresa (idEmpresa)    
);

CRIAR  TABELA Usuario (
    idUsuario INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    email VARCHAR ( 50 ),
    senha VARCHAR ( 16 ),
    idFuncionario INTEGER ,
    ativo BOOLEAN ,
    UNIQUE (email, idFuncionario),
    CHAVE ESTRANGEIRA (idFuncionario) REFERÊNCIAS Funcionario (idFuncionario)
);

CREATE  TABLE Servicos (
    idServicos INTEGER AUTO_INCREMENT PRIMARY  KEY ,
    nomeServico VARCHAR ( 50 ),
texto     descritivo ,
    ativo BOOLEAN ,
    valorServico FLOAT
);

CRIAR  TABELA DetalheServico (
    idServico INTEGER ,
    idPedido INTEGER ,
    valorServico FLOAT ,
     CHAVE PRIMÁRIA (idServico, idPedido),
    CHAVE ESTRANGEIRA (idPedido) REFERÊNCIAS Pedido (idPedido),
    CHAVE ESTRANGEIRA (idServico) REFERÊNCIAS Servicos (idServicos)
);



Selecione  *  em Produto;
Inserir  no produto (idProduto, nome, descrição, tipo, ativo) Valores ( 1 , ' Dragon Ball Xenoverse: 2' , ' Sequência de Dragon Ball Xenoverse' , ' Jogo' , true)

INSERT INTO Produto (nome, descricao, tipo,ativo)
VALUES ('God Of War', 'GOD', 2, true);

INSERT INTO Produto (nome, descricao, tipo,ativo)
VALUES ('GTA', 'San Andreas', 3, true);


INSERT INTO Produto (nome, descricao, tipo,ativo)
VALUES ('Need for speed', 'Underground', 1, true);

INSERT INTO Produto (nome, descricao, tipo,ativo)
VALUES ('Counter Strike', 'CS go', 4, true);

INSERT INTO Produto (nome, descricao, tipo,ativo)
VALUES ('Mine', 'Minecrafts', 2, true);
