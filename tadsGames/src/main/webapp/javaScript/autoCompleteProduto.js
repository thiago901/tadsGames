/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var inputNomeProduto = document.querySelector("#nomeProduto");
var tblListaProdutos = document.querySelector("#tbSource");
var listaProdutos = tblListaProdutos.querySelector("#tbodyListaProdutos");
var spanQtdEstoque = document.querySelector("#SpanQtdEstoque");
var spanVlrUnitarios = document.querySelector("#SpanvlrUnitario");
var qtdComprada = document.querySelector("#qtd");
var vlrCompradaTotal = document.querySelector("#vlrTotal");



function limparVenda(){
    //spanQtdEstoque.textContent = "0,00";
    spanVlrUnitarios.textContent = "0,00";
    qtdComprada.value = 0;
    vlrCompradaTotal.textContent = "0,00";
    inputNomeProduto.removeAttribute("value");
    inputNomeProduto.value="";
}
function ocultarTabela(tabela){
    tabela.setAttribute("hidden","");
}
function mostrarTabela(tabela){
    tabela.removeAttribute("hidden");
}

qtdComprada.addEventListener("input",function(){
    var textVlrUni = document.querySelector("#SpanvlrUnitario").textContent;
    
    var textqtdComprada = this.value;
    var qtdComprada = eval(textqtdComprada);
    var vlrUni=eval(textVlrUni);
    
    
    
    
    vlrCompradaTotal.textContent = formatoReal(somaValorTotalItem(qtdComprada,vlrUni));
});

function somaValorTotalItem(qtd,vlrUnitario){
    return qtd*vlrUnitario;
};
tblListaProdutos.addEventListener("click",function(event){
    
    var produtoSelecionado= event.target;
    var paiProdutoSelecionado = produtoSelecionado.parentNode;
    var id = paiProdutoSelecionado.querySelector(".idProduto");
    var nomeProduto = paiProdutoSelecionado.querySelector(".autoCompleteNomeProduto");
    var qtdEs= paiProdutoSelecionado.querySelector(".qtdEstoque");
    var vlrUni = paiProdutoSelecionado.querySelector(".vlrUnitario");
    
    //Atribui ao Input os dados do nome produto e id
    inputNomeProduto.setAttribute("value",id.textContent);
    inputNomeProduto.value = nomeProduto.textContent;
    
    //atribui informação do qtd de estoque e o valor unitario
    //spanQtdEstoque.textContent = qtdEs.textContent;
    spanVlrUnitarios.textContent = vlrUni.textContent;
    
    
    //depois de clicado a tabela fica escondida
    ocultarTabela(tblListaProdutos);
    
    var idProduto =document.querySelector("#idProduto");
    var vlrUni2 =document.querySelector("#vlrUnitario");
    
    idProduto.value = id.textContent;
    vlrUni2.value =vlrUni.textContent;

});

function limparAutoComplete(tr){
    for(var i=0;i<tr.length;i++){
        tr[i].remove();
        
    }
}
inputNomeProduto.addEventListener("blur", function (e){

        //ocultarTabela(tblListaProdutos);

});
inputNomeProduto.addEventListener("input", function (){
    var tr = document.querySelectorAll(".produto");
    limparAutoComplete(tr);
    if(inputNomeProduto.value.length==0){
        ocultarTabela(tblListaProdutos);
    }else{
        mostrarTabela(tblListaProdutos);
        var vlrInputNomeProduto =inputNomeProduto.value;
        buscarProdutos(vlrInputNomeProduto);
    }
    
});

function buscarProdutos(vlrInputNomeProduto){
    var xhl  = new XMLHttpRequest();
    xhl.open("GET","/TadsGames/inputProduto?action=ListarProduto2&&nome="+vlrInputNomeProduto);
    xhl.addEventListener("load",function(){
        var text =xhl.responseText;
        var produtos = JSON.parse(text);
        
        produtos.forEach(function(produto){
            adicionarNaPesquisa(produto);
            
        });
        
        
    });
    xhl.send();

}

function adicionarNaPesquisa(produto){
    //coloca na lista de produtos buscados uma linha
    listaProdutos.appendChild(montarTrBusca(produto));
    
}

function montarTrBusca(produto) {

    //criando a tr para colocar na tabela
    var linha = document.createElement("tr");
    linha.classList.add("produto");

    var tdIdProduto = montarTdBusca(produto.idProduto, "idProduto");
    var tdProduto = montarTdBusca(produto.nome, "autoCompleteNomeProduto");
    var tdQtdEstoque = montarTdBusca(produto.qtdEstoque, "qtdEstoque");
    var tdVlrUnitario = montarTdBusca(formatoReal(produto.vlrUnitario), "vlrUnitario");
    //tdQtdEstoque.setAttribute("hidden","");
    tdVlrUnitario.setAttribute("hidden","");
    linha.appendChild(tdIdProduto);
    linha.appendChild(tdProduto);
    linha.appendChild(tdQtdEstoque);
    linha.appendChild(tdVlrUnitario);
    return linha;

}

function formatoReal(valor){
    return valor.toFixed(2);/*toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' })*/
}
function montarTdBusca(dado, classe) {
    var td = document.createElement("td");
    td.textContent = dado;
    td.classList.add(classe);
    return td;
}