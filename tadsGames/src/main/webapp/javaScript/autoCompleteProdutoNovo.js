//-------------Declaração de Variaveis
var tblItemVenda = document.querySelector("#tblItensVenda");
var tbodyItemVenda = tblItemVenda.querySelector("tbody");
var inputIdProduto=document.querySelector("#inputIdProduto");
var inputNomeProduto = document.querySelector("#inputNomeProduto");
var listaPesquisa = document.querySelector("#listaPesquisaProduto");
var tbodyPesquisaProduto = listaPesquisa.querySelector("tbody");
var btnEditarItem = document.querySelector("#btnEditarItem");
var inputVlrUnitario =document.querySelector("#inputVlrUnitario");
var inputVlrTotal =document.querySelector("#inputVlrTotal");



inputQuantidade.addEventListener("input",function (){
    inputVlrTotal.value =inputVlrUnitario.value * eval(this.value);
    
});
btnEditarItem.addEventListener("click",function (){
    editavel(inputNomeProduto);
    inputNomeProduto.value="";
    inputIdProduto.value = "";
    inputVlrTotal.value="0,00";
    inputQuantidade.value="0";
    
});

listaPesquisa.addEventListener("click",function (e){
    var tr =e.target.parentNode;
    var tdIdProduto = tr.querySelector(".tdIdProduto").textContent;
    var tdVlrUnitario = tr.querySelector(".tdVlrUnitario").textContent;
    var tdNomeProduto = tr.querySelector(".tdNomeProduto").textContent;
    var tdQtdEstoque = tr.querySelector(".tdQtdEstoque").textContent;
    
    var estoque = document.querySelector("#qtdEstoque");
    estoque.value =tdQtdEstoque;
    console.log(estoque);
    console.log(tdQtdEstoque);
    
    
    inputIdProduto.value = tdIdProduto;
    inputVlrUnitario.value =tdVlrUnitario; 
    inputNomeProduto.value =tdNomeProduto;
    oculta(this);
    editavel(inputNomeProduto);
    
});

//--------A cada alteração no Input faça
inputNomeProduto.addEventListener("input", function () {
    var tr = document.querySelectorAll(".trProduto");
    var listaPesquisa = document.querySelector("#listaPesquisaProduto");
    limparLista(tr);
    
    if (this.value.length == 0) {
        oculta(listaPesquisa);
    } else {
        
        var nomePesquisado = inputNomeProduto.value;
        buscarProdutos(nomePesquisado);
        mostra(listaPesquisa);
    }
});

function buscarProdutos(nomePesquisado) {
    
    var ajax = new XMLHttpRequest();
    ajax.open("GET", "/tadsGames/tads/inputProduto?action=ListarProduto2&&nome=" + nomePesquisado);
    ajax.addEventListener("load", function () {

        var textJason = ajax.responseText;
        var produtos = JSON.parse(textJason);

        produtos.forEach(function (produto) {

            addProdutoPesquisa(produto);

        });
    });
    ajax.send();

}

function addProdutoPesquisa(produto) {
    
    tbodyPesquisaProduto.appendChild(montarTrProduto(produto));
    
}

function montarTrProduto(produto) {
    var tr = document.createElement("tr");
    tr.classList.add("trProduto");
    
    tr.appendChild(montarTdProduto(produto.idProduto, "tdIdProduto", "Hidden"));
    tr.appendChild(montarTdProduto(produto.nome, "tdNomeProduto"));
    tr.appendChild(montarTdProduto(produto.qtdEstoque, "tdQtdEstoque"));
    tr.appendChild(montarTdProduto(produto.vlrUnitario, "tdVlrUnitario", "Hidden"));

    return tr;
}

function montarTdProduto(valor, classe) {
    var td = document.createElement("td");
    td.textContent = valor;
    td.classList.add(classe);
    return td;
}
function montarTdProduto(valor, classe, attr) {
    var td = document.createElement("td");
    td.textContent = valor;
    td.classList.add(classe);
    td.setAttribute(attr, "")
    return td;
}
function limparLista(tr) {
    tr.forEach(function (linha) {
        linha.remove();

    });
}
function visibilidade(elemento){
    elemento.toggleAttribute("oculta");
}

function editavel(elemento){
    elemento.toggleAttribute("readonly");
}

function oculta(elemento) {
    elemento.setAttribute("Hidden","");
}
function mostra(elemento) {
    elemento.removeAttribute("Hidden");
}