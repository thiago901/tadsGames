
var estado = document.querySelector("#selEstado");

estado.addEventListener("input",function(){
    var valueItemSelecionado = estado.options[estado.selectedIndex].value;
    //var textItemSelecionado = estado.options[estado.selectedIndex].text;

    buscarCidades(valueItemSelecionado);
});

function buscarCidades(idUf){
    var xhl  = new XMLHttpRequest();
    xhl.open("GET","/TadsGames/input?action=ListarCidades&&nome="+idUf);
    xhl.addEventListener("load",function(){
        var text =xhl.responseText;
        var cidades = JSON.parse(text);
        
        cidades.forEach(function(cidade){
            adicionarNoSelect(cidade);
            console.log(cidade);
            
        });
        
        
    });
    xhl.send();

}

function adicionarNoSelect(cidade){
    var opcoes = document.createElement("option");
    opcoes.setAttribute("value",cidade.idCidade);
    opcoes.textContent = cidade.nomeCidade;
    
    var tableSelect = document.querySelector("#opcoesCidades");
    
    
    tableSelect.appendChild(montarTrBuscaCidade(cidade));
    //cidades.options[cidades.selectedIndex].value;
    //cidades.options[cidades.selectedIndex].text;
}

function montarTrBuscaCidade(cidade){
    var linha = document.createElement("tr");
    
    var tdIdCidade = montarTdBusca(cidade.idCidade,"idCidade");
    var tdNomeCidade = montarTdBusca(cidade.nomeCidade,"nomeCidade");
    
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