
var nomePesquisado = document.querySelector("#pesquisaFuncionario");

nomePesquisado.addEventListener("input",function (){
	
	var pesquisado = nomePesquisado.value;
	var funcionarios = document.querySelectorAll(".funcionario");


	for(var i =0;i<funcionarios.length;i++){
		var funcionario = funcionarios[i];
		var nomeFuncionario = funcionario.querySelector(".nome").textContent;
		var expressao = new RegExp(this.value,"i");
		
		if(this.value.length>0){
                        
			if(!expressao.test(nomeFuncionario)){
				funcionario.setAttribute("hidden","");
			}else{
				funcionario.removeAttribute("hidden");
			}
		}else{
			for (var i = 0; i <funcionarios.length; i++) {
				var funcionario = funcionarios[i];
				funcionario.removeAttribute("hidden");
			}

		}

		


	}

});