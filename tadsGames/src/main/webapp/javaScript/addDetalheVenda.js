
var add = document.querySelector("#add");
var form = document.querySelector("#formAdiciona");
var arrayDetalheVenda = [];
var salvar = document.querySelector("#salvar");
var i=0;




add.addEventListener('click', function () {
    //event.preventDefault();
    //var tbody = document.querySelector("#tbodyDetalheVenda");
    //var detalheVenda=montarObjetoDetalhe();
    //var linhaDetalheVenda = montarTr(detalheVenda);
    //tbody.appendChild(linhaDetalheVenda);
    limparVenda();



});

function criarInputsItemVenda(name,valor){
    
    var input = document.createElement("input");
    input.setAttribute("name",name);
    input.setAttribute("value",valor);
    input.setAttribute("Hidden","");
    return input;
}

function montarObjetoDetalhe() {
    
    var inputNomeProduto = document.querySelector("#nomeProduto");
    var inputQtd= document.querySelector("#qtd");
    var spanValorUnitario = document.querySelector("#SpanvlrUnitario");
    var spanValorTotal = document.querySelector("#vlrTotal");
    
    
    
    var detalheVenda ={
        idProduto: inputNomeProduto.getAttribute("value"),
        nomeProduto: inputNomeProduto.value,
        qtd: inputQtd.value,
        vlrUnitario: spanValorUnitario.textContent,
        vlrTotal: spanValorTotal.textContent
    };
    
    
    arrayDetalheVenda.push(detalheVenda);
    
    

    return detalheVenda;

}



function montarTr(detalheVenda) {

    //criando a tr para colocar na tabela

    var linha = document.createElement("tr");
    
    linha.classList.add("itemVenda");
    
    var tdIdProduto = montarTd(detalheVenda.idProduto, "idProdutoD");
    var tdProduto = montarTd(detalheVenda.nomeProduto, "nomeProduto");
    var tdQuantidade = montarTd(detalheVenda.qtd, "qtd");
    var tdVlrUnitario = montarTd(detalheVenda.vlrUnitario, "vlrUnitario");
    var tdVlrTotal = montarTd(detalheVenda.vlrTotal, "vlrTotal");
    
    //cria os inputs
    var inputIdProduto =criarInputsItemVenda("idProdutos[]",detalheVenda.idProduto);
    var inputQuantidadeComprada =criarInputsItemVenda("qtds[]",detalheVenda.qtd);
    var inputValorUnitario =criarInputsItemVenda("vlrUnitarios[]",detalheVenda.vlrUnitario);
    
    


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
    linha.appendChild(inputIdProduto);
    linha.appendChild(inputQuantidadeComprada);
    linha.appendChild(inputValorUnitario);
    return linha;
}



function montarTd(dado, classe) {

    var td = document.createElement("td");
    td.textContent = dado;
    td.classList.add(classe);

    return td;

}

/*salvar.addEventListener("click", function(){
    event.preventDefault();
    
    
    var objeto={
        detalheVenda:arrayDetalheVenda
    };
    
    var xml = new XMLHttpRequest();
    xml.open("POST","http://localhost:8084/TadsGames/inputVenda?action=CadastrarItem",true);
   
    xml.setRequestHeader("itemVenda", JSON.stringify(arrayDetalheVenda));
    
    console.log(objeto.valueOf());
    
    
    
    
    xml.send(JSON.stringify(arrayDetalheVenda));
});*/