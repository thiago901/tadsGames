//-------------Declaração de Variaveis
var tblItemVenda = document.querySelector("#tblItensVenda");
var tbodyItemVenda = tblItemVenda.querySelector("tbody");
var inputNomeProduto = document.querySelector("#inputNomeProduto");



//--------A cada alteração no Input faca
inputNomeProduto.addEventListener("input", function () {
    var tr = document.querySelectorAll(".trProduto");
    var listaPesquisa = document.querySelector("#listaPesquisaProduto");
    limparLista(tr);
    
    if (this.value.length == 0) {
        visibilidade(listaPesquisa);
    } else {
        visibilidade(listaPesquisa);
        var nomePesquisado = inputNomeProduto.value;
        buscarProdutos(nomePesquisado);
    }
});

function buscarProdutos(nomePesquisado) {

    var ajax = new XMLHttpRequest();
    ajax.open("GET", "/TadsGames/tads/inputProduto?action=ListarProduto2&&nome=" + nomePesquisado);
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
    var listaPesquisa = document.querySelector("#listaPesquisaProduto");
    var tbodyPesquisa = listaPesquisa.querySelector("tbody");
    tbodyPesquisa.appendChild(montarTr(produto));
}

function montarTr(produto) {
    var tr = document.createElement("tr");
    tr.classList.add("trProduto");
    tr.appendChild(montarTd(produto.idProduto, "tdIdProduto", "Hidden"));
    tr.appendChild(montarTd(produto.nome, "tdNomeProduto"));
    tr.appendChild(montarTd(produto.qtdEstoque, "tdQtdEstoque"));
    tr.appendChild(montarTd(produto.vlrUnitario, "tdVlrUnitario", "Hidden"));

    return tr;
}

function montarTd(valor, classe) {
    var td = document.createElement("td");
    td.textContent = valor;
    td.classList.add(classe);
    return td;
}
function montarTd(valor, classe, attr) {
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
    elemento.classList.toggle("oculta");
}

