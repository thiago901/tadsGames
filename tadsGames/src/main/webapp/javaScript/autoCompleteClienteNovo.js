/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var inputNomeCliente = document.querySelector("#inputNomeCliente");
var inputIdCliente = document.querySelector("#inputIdCliente");
var inputCpfCliente = document.querySelector("#inputCpfCliente");
var listaPesquisa = document.querySelector("#tblListaClientes");
var tbodyPesquisa = listaPesquisa.querySelector("tbody");
var tblResumoCliente = document.querySelector("#tblResumoCliente");
var dadosClientes = document.querySelector("#dadosClientes");

var telaCliente = document.querySelector("#telaCliente");
var telaProduto = document.querySelector("#container");
var btnSelecionarCliente = document.querySelector("#btnSelecionarCliente");
var btnEditarCliente = document.querySelector("#btnEditarCliente");
var btnAlterarCliente = document.querySelector("#btnAlterarCliente");




btnAlterarCliente.addEventListener("click",function (){
    
    visibilidade(telaProduto);
    visibilidade(telaCliente);
    visibilidade(dadosClientes);
    
});

btnSelecionarCliente.addEventListener("click",function (){
    if(inputIdCliente.value==""||inputNomeCliente.value==""){
        visibilidade(document.querySelector(".erro"));
        return;
    }
    
    visibilidade(telaProduto);
    visibilidade(telaCliente);
    
});
btnEditarCliente.addEventListener("click",function (){
    editavel(inputNomeCliente);
    inputNomeCliente.value="";
    inputIdCliente.value="";
    inputCpfCliente.value="";
    inputNomeCliente.focus();
    var tbody = tblResumoCliente.querySelector("tbody");
    
    var tdNome = tbody.querySelector(".tdNome");
    var tdCPF = tbody.querySelector(".tdCpf");
    
    tdNome.textContent = "";
    tdCPF.textContent = "";
    
    
});
listaPesquisa.addEventListener("click",function (e){
    var tr = e.target.parentNode;
    var id = tr.querySelector(".tdIdCliente");
    var nome = tr.querySelector(".tdNomeCliente");
    var cpf = tr.querySelector(".tdCpfCliente");
    
    inputIdCliente.value = id.textContent;
    inputNomeCliente.value = nome.textContent;
    inputCpfCliente.value = cpf.textContent;
    
    var tbody = tblResumoCliente.querySelector("tbody");
    
    var tdNome = tbody.querySelector(".tdNome");
    var tdCPF = tbody.querySelector(".tdCpf");
    
    tdNome.textContent = nome.textContent;
    tdCPF.textContent = cpf.textContent;
    
    
    editavel(inputNomeCliente);
    visibilidade(listaPesquisa);
    
    
});
inputNomeCliente.addEventListener("input", function () {
    var nomePesquisado = inputNomeCliente.value;
    var tr = document.querySelectorAll(".trCliente");
    limparLista(tr);
    if (this.value.length == 0) {
        visibilidade(listaPesquisa);
    } else {
        buscarClientes(nomePesquisado);
        visibilidade(listaPesquisa);
    }


});

function buscarClientes(nomePesquisado) {
    var ajax = new XMLHttpRequest();

    ajax.open("GET", "/tadsGames/tads/inputCliente?action=ListarCliente2&&nomeCliente=" + nomePesquisado);
    ajax.addEventListener("load", function () {

        var textJason = ajax.responseText;
        var clientes = JSON.parse(textJason);

        clientes.forEach(function (cliente) {
            addClientePesquisa(cliente);
            
        });
    });
    ajax.send();

}
function addClientePesquisa(cliente) {
    tbodyPesquisa.appendChild(montarTr(cliente));
}

function montarTr(cliente) {
    var tr = document.createElement("tr");
    tr.classList.add("trCliente");
    tr.appendChild(montarTd(cliente.id, "tdIdCliente","Hidden"));
    tr.appendChild(montarTd(cliente.nome, "tdNomeCliente"));
    tr.appendChild(montarTd(cliente.cpf, "tdCpfCliente"));
    cpf = cliente.cpf;
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
function visibilidade(elemento) {
    elemento.classList.toggle("oculta");
}
function editavel(elemento){
    elemento.toggleAttribute("readonly");
}

