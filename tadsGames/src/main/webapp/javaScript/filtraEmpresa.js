
var nomePesquisado = document.querySelector("#nomePesquisa");

nomePesquisado.addEventListener("input",function (){
	
	var pesquisado = nomePesquisado.value;
	var empresas = document.querySelectorAll(".empresa");


	for(var i =0;i<empresas.length;i++){
		var empresa = empresas[i];
		var nomeEmpresa = empresa.querySelector(".nome").textContent;
		var expressao = new RegExp(this.value,"i");
		
		if(this.value.length>0){
                        
			if(!expressao.test(nomeEmpresa)){
				empresa.setAttribute("hidden","");
			}else{
				empresa.removeAttribute("hidden");
			}
		}else{
			for (var i = 0; i <empresas.length; i++) {
				var empresa = empresas[i];
				empresa.removeAttribute("hidden");
			}

		}

		


	}

});

