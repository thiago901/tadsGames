
var add = document.querySelector("#add");

var form = document.querySelector("#formAdiciona");
var arrayDetalheVenda = [];
var salvar = document.querySelector("#salvar");




add.addEventListener('click', function () {

    event.preventDefault();
    var tabela = document.querySelector("#tabela-detalhe-venda");
    var tbody = tabela.querySelector("tbody");





    var detalheVenda = obterDadosFormulario(form);
    arrayDetalheVenda.push(detalheVenda);
    console.log(arrayDetalheVenda);
    var linhaDetalheVenda = montarTr(detalheVenda);



    tbody.appendChild(linhaDetalheVenda);



});



function obterDadosFormulario(form) {

    var detalheVenda = {

        idProduto: form.produto.value,
        nomeProduto: form.produto.options[produto.selectedIndex].text,
        qtd: form.qtdComprada.value,
        vlrUnitario: form.vlrUnitario.value,
        vlrTotal: form.qtdComprada.value * form.vlrUnitario.value
    }

    return detalheVenda;

}



function montarTr(detalheVenda) {

    //criando a tr para colocar na tabela

    var linha = document.createElement("tr");





    var tdIdProduto = montarTd(detalheVenda.idProduto, "idProduto");
    var tdProduto = montarTd(detalheVenda.nomeProduto, "nomeProduto");
    var tdQuantidade = montarTd(detalheVenda.qtd, "qtd");
    var tdVlrUnitario = montarTd(detalheVenda.vlrUnitario, "vlrUnitario");
    var tdVlrTotal = montarTd(detalheVenda.vlrTotal, "vlrTotal");



    var imgAdd = document.createElement("img");
    imgAdd.setAttribute("href", "img/add.png")


    var imgAddTd = document.createElement("td");

    imgAddTd.appendChild(imgAdd);





    //colocando as colunas na linha



    linha.appendChild(tdIdProduto);

    linha.appendChild(tdProduto);

    linha.appendChild(tdQuantidade);

    linha.appendChild(tdVlrUnitario);

    linha.appendChild(tdVlrTotal);

    linha.appendChild(imgAddTd);



    return linha;



}



function montarTd(dado, classe) {

    var td = document.createElement("td");

    td.textContent = dado;

    td.classList.add(classe);

    return td;



}

salvar.addEventListener("click", function(){
    event.preventDefault();
    
    
    var objeto={
        detalheVenda:arrayDetalheVenda
    };
    
    var xml = new XMLHttpRequest();
    xml.open("POST","http://localhost:8084/TadsGames/inputVenda?action=CadastrarVenda",true);
   
    xml.setRequestHeader("c", JSON.stringify(arrayDetalheVenda));
    
    console.log(objeto.valueOf());
    
    
    
    
    xml.send(JSON.stringify(arrayDetalheVenda));
});