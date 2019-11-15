
var estado = document.querySelector("#selEstado");
var cidades = document.querySelector("#selCidade");




estado.addEventListener("input",function(){
    var valueItemSelecionado = estado.options[estado.selectedIndex].value;
    var textItemSelecionado = estado.options[estado.selectedIndex].text;
    console.log(valueItemSelecionado);
    console.log(textItemSelecionado);
});

function buscarCidades(idUf){
    var xhl  = new XMLHttpRequest();
    xhl.open("GET","/TadsGames/inputProduto?action=ListarProduto2&&nome="+idUf);
    xhl.addEventListener("load",function(){
        var text =xhl.responseText;
        var cidades = JSON.parse(text);
        
        cidades.forEach(function(cidade){
            adicionarNoSelect(cidade);
            
        });
        
        
    });
    xhl.send();

}

function adicionarNoSelect(cidade){
    var opcoes = document.createElement("option");
    opcoes.setAttribute("value",cidade);
    opcoes.textContent = cidade;
    cidades.options[cidades.selectedIndex].value;
    cidades.options[cidades.selectedIndex].text;
}