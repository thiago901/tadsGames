


var btnTop10 = document.querySelector("#btnTop10Consolidado");
var btnFaturamento = document.querySelector("#btnFaturamentoTotal");
var divTop10 = document.querySelector(".cardRelatorio1");
var divFaturamento = document.querySelector(".cardRelatorio");

btnTop10.addEventListener("click",function (){
    mostra(divTop10);
    oculta(divFaturamento);
});

btnFaturamento.addEventListener("click",function (){
    mostra(divFaturamento);
    oculta(divTop10);
});
    