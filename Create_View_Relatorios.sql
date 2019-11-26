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
	select c.idEmpresa,
		c.nome as NomeEmpresa,
		sum(a.valorTotal) as TOTAL
        from Venda a 
INNER JOIN Empresa c on
	c.idEmpresa = a.idEmpresa
where dataVenda =curdate()
group by c.nome,c.idEmpresa;



/*RELATORIO DOS 10 PRODUTOS MAIS VENDIDOS NO DIA ATUAL*/
CREATE VIEW Rel_Top10_vendas_dia AS
	SELECT distinct
		d.idempresa as idEmpresa,
        c.nome AS PRODUTO,
        d.nome as EMPRESA,
        SUM(b.qtdVenda) as Quantidade,
        sum(b.vlrTotalItem) as Valor
	FROM Venda a
    INNER JOIN DetalheVenda b 
		ON b.idVenda = a.idVenda
    INNER JOIN Produto c 
        ON c.idProduto = b.idProduto
	INNER JOIN Empresa d
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


CREATE VIEW TotalFaturadoMes as
SELECT sum(a.valorTotal) AS TOTAL
    FROM venda a
	where month(a.dataVenda) = month(curdate()) AND
			YEAR(a.dataVenda) = YEAR(curdate());


CREATE VIEW TotalFaturadoDia as
SELECT sum(a.valorTotal) AS TOTAL
    FROM venda a
	where a.dataVenda = curdate();
						 
//Regiao
CREATE VIEW RelTotalRegiaoDiario AS
select 	c.regiao,
        sum(e.qtdVenda) as Quantidade,
        sum(e.vlrTotalItem) as Valor
from Venda a
	inner join DetalheVenda e on
			e.idVenda = a.idVenda
	inner join Empresa b on
		b.idEmpresa =a.idEmpresa
    inner join EstadoRegiao c on
		c.idEstado = b.idEstado 
	inner join Produto d on
		d.idProduto = e.idProduto
where dataVenda =curdate()
group by c.regiao ;
//Regiao
						 
CREATE VIEW RelTopProdutoRegiao AS
select 	c.regiao,
		d.nome,
        sum(e.qtdVenda) as Quantidade,
        sum(e.vlrTotalItem) as Valor
from Venda a
	inner join DetalheVenda e on
			e.idVenda = a.idVenda
	inner join Empresa b on
		b.idEmpresa =a.idEmpresa
    inner join EstadoRegiao c on
		c.idEstado = b.idEstado 
	inner join Produto d on
		d.idProduto = e.idProduto
where dataVenda =curdate()
group by c.regiao,d.nome 
limit 10;
						 
//TotalFaturadoDiaEmpresa
CREATE VIEW TotalFaturadoDiaEmpresa as
SELECT 	b.idEmpresa,
		b.nome,
        count(a.idVenda) AS TOTAL,
		sum(a.valorTotal) AS TOTAL
    FROM Venda a
    inner join Empresa b on	
    a.idEmpresa = b.idEmpresa
	where a.dataVenda = curdate()
    group by idEmpresa;
