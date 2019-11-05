/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var produto = document.querySelector("#nomeProduto");
var source = document.querySelector("#tbSource");
var listaAutoComplete = source.querySelector("tbody");

source.addEventListener("click",function(event){
    var valor= event.target;
    var opcaoClicada = valor.parentNode;
    var id = opcaoClicada.querySelector(".idProduto");
    var nomeProduto = opcaoClicada.querySelector(".autoCompleteNomeProduto");
    produto.setAttribute("value",id.textContent);
    produto.value = nomeProduto.textContent;
    source.setAttribute("hidden","");
    
    
    
});

produto.addEventListener("input", function (){
    if(produto.value.length==0){
        source.setAttribute("hidden","");
        
        
    }else{
        
        
        source.removeAttribute("hidden");
        var tr = document.getElementsByClassName("asd");
        console.log(tr);
        if(tr.length>0){
           console.log(tr);
           tr.parentNode.removeChild(tr);
        }
        
        var n =produto.value
        buscarProdutos(n);
        
        
    }
    
    
});

function buscarProdutos(n){
    
    var xhl  = new XMLHttpRequest();
    xhl.open("GET","http://localhost:8084/TadsGames/inputProduto?action=ListarProduto2&&nome="+n);
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
    listaAutoComplete.appendChild(montarTr(produto));
    
}

function montarTr(produto) {

    //criando a tr para colocar na tabela

    var linha = document.createElement("tr");
    linha.classList.add("asd")

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