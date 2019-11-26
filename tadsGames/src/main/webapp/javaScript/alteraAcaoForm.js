/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



   
    var botaoSalvarVenda = document.querySelector("#btnCadastrarVenda");
    botaoSalvarVenda.addEventListener("click",function(){
        var f = document.querySelector("#form");
        f.action = "inputVenda?action=CadastrarVenda";
        f.submit();
    });
    