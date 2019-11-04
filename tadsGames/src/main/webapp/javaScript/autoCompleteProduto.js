/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var produto = document.querySelector("#nomeProduto");
var source = document.querySelector("#tbSource");
console.log(produto);
produto.addEventListener("input", function (){
    
    if(produto.value.length==0){
        source.setAttribute("hidden","");
        
        
    }else{
        source.removeAttribute("hidden");
        console.log(buscarProdutos());
    }
    
});

function buscarProdutos(){
    
    var xhl  = new XMLHttpRequest();
    xhl.open("GET","http://localhost:8084/TadsGames/inputProduto?action=ListarProduto2");
    xhl.addEventListener("load",function(){
        var text =xhl.responseText;
        var produtos = JSON.parse(text);
        console.log(produtos);
        produtos.forEach(function(produto){
            adicionarNaPesquisa(produto);
        });
        
        
    });
    xhl.send();

    
}

function adicionarNaPesquisa(produto){
    console.log(produto);
    var tbody = source.querySelector("tbody");
    tbody.appendChild(montarTr(produto));
    
}

function montarTr(produto) {

    //criando a tr para colocar na tabela

    var linha = document.createElement("tr");

    var tdIdProduto = montarTd(produto.idProduto, "idProduto");
    var tdProduto = montarTd(produto.nome, "autoCompleteNomeProduto");
    linha.appendChild(tdIdProduto);
    linha.appendChild(tdProduto);

    return linha;



}



function montarTd(dado, classe) {

    var td = document.createElement("td");

    td.textContent = dado;

    td.classList.add(classe);

    return td;



}