/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var produto = document.querySelector("#nomeProduto");
var source = document.querySelector("#tbSource");

produto.addEventListener("input", function (){
    source.removeAttribute("hidden");
});
