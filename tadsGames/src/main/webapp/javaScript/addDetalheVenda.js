var add = document.querySelector("#add");

add.addEventListener('click',function(){
	var tabela = document.querySelector("#tabela-detalhe-venda");
	var tbody = tabela.querySelector("tbody");
	
	//criando a tr para colocar na tabela
	var linha = document.createElement("tr");

//criando as td para inserir no tr
	
	var tdIdProduto = document.createElement("td");
	var tdProduto = document.createElement("td");
	var tdQuantidade = document.createElement("td");
	var tdVlrUnitario = document.createElement("td");
	var tdVlrTotal = document.createElement("td");

//pegando os valores do formulario
	var produto =document.querySelector("#produto");
	var idProduto = produto.value;
	var txtProduto = produto.options[produto.selectedIndex].text;
	var quantidade = document.querySelector("#qtdComprada").value;
	var vlrUnitario = document.querySelector("#vlrUnitario").value;
	var vlrTotal = vlrUnitario*quantidade;



//atribuindo valor para as tds
	tdIdProduto.textContent = idProduto;
	tdProduto.textContent = txtProduto;
	tdQuantidade.textContent = quantidade;
	tdVlrUnitario.textContent =vlrUnitario;vlrUnitario;
	tdVlrTotal.textContent = vlrTotal;




//colocando as colunas na linha

	linha.appendChild(tdIdProduto);
	linha.appendChild(tdProduto);
	linha.appendChild(tdQuantidade);
	linha.appendChild(tdVlrUnitario);
	linha.appendChild(tdVlrTotal);

//colocando a linha na tabela

	tbody.appendChild(linha);
	console.log(obterDadosFormulario(form));
});

var form = document.querySelector("#formAdiciona");

console.log(form.produto.value);

function obterDadosFormulario(form){
	var detalheVenda={
		idProduto:form.produto.value,
		nomeProduto:form.produto.options[produto.selectedIndex].text,
		qtd:form.qtdComprada.value,
		vlrUnitario:form.vlrUnitario.value,
		tdVlrTotal:form.qtdComprada.value*form.vlrUnitario.value
		
	}
	return detalheVenda;
}

