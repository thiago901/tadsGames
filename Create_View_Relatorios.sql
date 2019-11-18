/*CRIA VIEW DE RELATORIO DE VENDAS POR CLIENTE*/
CREATE VIEW Rel_vendas_cliente AS
    SELECT 
        b.idCliente,
        a.datavenda AS DATA_VENDA,
        f.nome AS EMPRESA,
        b.nome AS CLIENTE,
        c.nomeFuncionario AS VENDEDOR,
        e.nome AS PRODUTO,
        d.vlrVenda AS VALOR_PROD,
        d.qtdVenda AS QTD,
        d.vlrTotalItem AS TOTAL
    FROM
        venda a
            INNER JOIN
        cliente b ON b.idCliente = a.idCliente
            INNER JOIN
        funcionario c ON c.idFuncionario = a.idFuncionario
            INNER JOIN
        detalheVenda d ON d.idVenda = a.idVenda
            INNER JOIN
        produto e ON e.idProduto = d.idProduto
            INNER JOIN
        empresa f ON f.idEmpresa = a.idEmpresa;
	
	
/*CRIA VIEW DE QUANTIDADE DE PROPDUTO EM ESTOQUE*/
CREATE VIEW Rel_Qtd_Prod_Estoque AS
    SELECT 
        a.nome AS PRODUTO,
        a.descricao AS DESCRICAO,
        b.qtdEstoque AS ESTOQUE
    FROM
        produto a
            INNER JOIN
        estoque b ON b.idProduto = a.idProduto;
	
	
/*REALTORIO DE PRODUTO SEM ESTOQUE*/
CREATE VIEW Rel_Prod_Sem_Estoq AS
    SELECT 
        CASE
            WHEN B.qtdEstoque = 0 THEN a.nome
        END AS PRODUTO
    FROM
        produto a
            INNER JOIN
        estoque b ON b.idProduto = a.idProduto
    WHERE
        B.qtdEstoque = 0 OR B.qtdEstoque IS NULL;



/*RELATORIO DE COOMPRA*/
CREATE VIEW Rel_Compra AS
    SELECT 
        a.dataEntrada AS DATA_ENTRADA,
        b.nome AS EMPRESA,
        c.nome AS PRODUTO,
        a.qtdComprada AS QTD,
        a.valorCompraUnitario AS PRECO
    FROM
        compra a
            INNER JOIN
        empresa b ON b.idEmpresa = a.idEmpresa
            INNER JOIN
        produto c ON c.idProduto = a.idProduto;
        
        
/*RELATORIO DE FATURA DIARIA*/
CREATE VIEW Rel_Fatura_Dia AS
	SELECT 
        a.datavenda AS DATA_VENDA,
        c.nome as EMPRESA,
        sum(b.vlrTotalItem) AS TOTAL
    FROM venda a
	INNER JOIN detalheVenda b
		ON b.idVenda = a.idVenda
    INNER JOIN empresa c
		on c.idempresa = a.idEmpresa    
	where a.datavenda = CURDATE();



/*RELATORIO DOS 10 PRODUTOS MAIS VENDIDOS NO DIA ATUAL*/
CREATE VIEW Rel_Top10_vendas_dia AS
	SELECT distinct(a.datavenda)AS DATA_VENDA,
        c.nome AS PRODUTO,
        d.nome as EMPRESA,
        SUM(B.qtdVenda) as QUANTIDADE
	FROM venda a
    INNER JOIN detalheVenda b 
		ON b.idVenda = a.idVenda
    INNER JOIN produto c 
        ON c.idProduto = b.idProduto
	INNER JOIN empresa d
		on d.idempresa = a.idEmpresa
	where a.datavenda = CURDATE()
    
    group by PRODUTO
    order by QUANTIDADE desc
    limit 10;

    
    /*RELATORIO TOTAL POR EMPRESA E PORCENTAGEM*/
 CREATE VIEW Rel_Total_Empresa_Porcentagem AS       
	SELECT c.nome as EMPRESA,
        sum(b.vlrTotalItem) AS TOTAL_FATURADO,
        (select sum(b.vlrTotalItem)/sum(vlrTotalItem) from detalheVenda) as PORCENTAGEM
        FROM venda a
    INNER JOIN detalheVenda b 
		ON b.idVenda = a.idVenda
   INNER JOIN empresa c
		on c.idempresa = a.idempresa
        group by c.nome;
