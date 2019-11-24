
var estado = document.querySelector("#selEstado");
var tableCidades = document.querySelector("#opcoesCidades");
var inputCidade = document.querySelector("#inputCidade");




inputCidade.addEventListener("input", function () {

    var cidades = document.querySelectorAll(".cidade");

//    limparAutoComplete(cidades);
    

    
    if(inputCidade.value.length>2){
        tableCidades.removeAttribute("hidden")
        for (var i = 0; i < cidades.length; i++) {
        var cidade = cidades[i];
        var tdNome = cidade.querySelector(".nomeCidade");
        var nome = tdNome.textContent;
        var expressao = new RegExp(this.value, "i");
            if (expressao.test(nome)) {
                cidade.removeAttribute("hidden");
            } else {
                cidade.setAttribute("hidden", "");
            }
        }
    }else{
        
        tableCidades.setAttribute("hidden", "");
    }
    


});

function limparAutoComplete(tr) {
    for (var i = 0; i < tr.length; i++) {
        tr[i].remove();
        console.log(tr[i]);

    }
}
tableCidades.addEventListener("click", function (event) {
    var selecionado = event.target;
    var trSelecionada = selecionado.parentNode;

    var idCidade = trSelecionada.querySelector(".idCidade");
    var nomeCidade = trSelecionada.querySelector(".nomeCidade");
    var inputIdCidade = document.querySelector("#idCidade");

    inputIdCidade.value = idCidade.textContent;
    inputCidade.value = nomeCidade.textContent;
    this.setAttribute("Hidden", "");
});

function ocultarTabela(tabela) {
    tabela.setAttribute("hidden", "");
}
function mostrarTabela(tabela) {
    tabela.removeAttribute("hidden");
}

estado.addEventListener("input", function () {
    var valueItemSelecionado = estado.options[estado.selectedIndex].value;
    //var textItemSelecionado = estado.options[estado.selectedIndex].text;

    buscarCidades(valueItemSelecionado);
});

function buscarCidades(idUf) {
    var xhl = new XMLHttpRequest();
    xhl.open("GET", "/tadsGames/tads/input?action=ListarCidades&nome=" + idUf);
    xhl.addEventListener("load", function () {
        var text = xhl.responseText;

        var cidades = JSON.parse(text);

        cidades.forEach(function (cidade) {
            adicionarNoSelect(cidade);


        });


    });
    xhl.send();

}

function adicionarNoSelect(cidade) {
    var opcoes = document.createElement("option");
    opcoes.setAttribute("value", cidade.idCidade);
    opcoes.textContent = cidade.nomeCidade;

    var tableSelect = document.querySelector("#opcoesCidades");


    tableSelect.appendChild(montarTrBuscaCidade(cidade));
    //cidades.options[cidades.selectedIndex].value;
    //cidades.options[cidades.selectedIndex].text;
}

function montarTrBuscaCidade(cidade) {
    var linha = document.createElement("tr");
    linha.classList.add("cidade");

    var tdIdCidade = montarTdBusca(cidade.idCidade, "idCidade");
    var tdNomeCidade = montarTdBusca(cidade.nomeCidade, "nomeCidade");
    tdIdCidade.setAttribute("Hidden", "");
    linha.appendChild(tdIdCidade);
    linha.appendChild(tdNomeCidade);

    return linha;
}

function montarTdBusca(dado, classe) {
    var td = document.createElement("td");
    td.textContent = dado;
    td.classList.add(classe);
    return td;
}