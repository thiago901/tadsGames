/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var cliente = document.querySelector("#resumoCliente");
var tabela = document.getElementById("tabelaClientes");
var tabelaBody = document.getElementById("tbodyListaClientes");






tabela.addEventListener("click",function(event){
    
    var selecionado= event.target;
    var paiSelecionado = selecionado.parentNode;
    var id = paiSelecionado.querySelector(".idCliente");
    var nomeCliente = paiSelecionado.querySelector(".nomeCliente");
    
    
    
    console.log(id);
    console.log(id.textContent);
    //Atribui ao Input os dados do nome produto e id
    //cliente.setAttribute("value",id.textContent);
    cliente.value = id.textContent;


    //depois de clicado a tabela fica escondida
    ocultarTabela(tabela);
    var divCliente = document.getElementById("divCliente");

    
    var h1NomeCliente = document.getElementById("h1NomeCLiente");

    h1NomeCliente.textContent = "Cliente: "+nomeCliente.textContent;
    

});


cliente.addEventListener("input", function (){
    var tr = document.getElementsByClassName("cliente");
    
    
    limparAutoComplete(tr);
    if(this.value.length==0){
        ocultarTabela(tabela);
        limparAutoComplete(tr);
    }else{
        
        mostrarTabela(tabela);
        var nomeProcurado =cliente.value;
        buscarClientes(nomeProcurado);
    }
});

function buscarClientes(nomeProcurado){
    var xhl  = new XMLHttpRequest();
    xhl.open("GET","/TadsGames/inputCliente?action=ListarCliente2&&nomeCliente="+nomeProcurado);
    xhl.addEventListener("load",function(){
        var text =xhl.responseText;
        var clientes = JSON.parse(text);

        clientes.forEach(function(cliente){
            addTblClientes(cliente);
            
        });
        
        
    });
    xhl.send();

}

function addTblClientes(cliente){
    //coloca na lista de produtos buscados uma linha
    
    tabelaBody.appendChild(montarTrBuscaCliente(cliente));
    
}

function montarTrBuscaCliente(cliente) {

    //criando a tr para colocar na tabela
    var linha = document.createElement("tr");
    linha.classList.add("cliente");

    var tdIdCliente = montarTdBusca(cliente.id, "idCliente");
    var tdNomeCliente = montarTdBusca(cliente.nome, "nomeCliente");
    tdIdCliente.setAttribute("Hidden","");
    
    
    linha.appendChild(tdIdCliente);
    linha.appendChild(tdNomeCliente);

    return linha;

}
