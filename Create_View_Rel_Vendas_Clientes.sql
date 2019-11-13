CREATE VIEW Rel_vendas_cliente AS 
select 	b.idCliente
		,a.datavenda as DATA_VENDA
		,f.nome as EMPRESA
        ,b.nome as CLIENTE
        ,c.nomeFuncionario as VENDEDOR
        ,e.nome as PRODUTO
        ,d.vlrVenda as VALOR_PROD
        ,d.qtdVenda as QTD
        ,d.vlrTotalItem as TOTAL
from venda a
inner join cliente b
	on b.idCliente = a.idCliente
inner join funcionario c
	on c.idFuncionario = a.idFuncionario
inner join detalheVenda d
	on d.idVenda = a.idVenda
inner join produto e
	on e.idProduto = d.idProduto
inner join empresa f
	on f.idEmpresa = a.idEmpresa;