/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var botaoAlterar = document.querySelector("#alterarCliente");

botaoAlterar.addEventListener('click', function (){
    var divCliente = document.getElementById("divCliente");
    mostrarTabela(divCliente);
});

