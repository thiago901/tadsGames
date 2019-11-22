
var nomePesquisado = document.querySelector("#pesquisaUsuario");

nomePesquisado.addEventListener("input",function (){
	
	var pesquisado = nomePesquisado.value;
	var usuarios = document.querySelectorAll(".users");


	for(var i =0;i<usuarios.length;i++){
		var usuario = usuarios[i];
		var nomeUsuario = usuario.querySelector(".nome").textContent;
		var expressao = new RegExp(this.value,"i");
		
		if(this.value.length>0){
                        
			if(!expressao.test(nomeUsuario)){
				usuario.setAttribute("hidden","");
			}else{
				usuario.removeAttribute("hidden");
			}
		}else{
			for (var i = 0; i <usuarios.length; i++) {
				var usuario = usuarios[i];
				usuario.removeAttribute("hidden");
			}

		}

		


	}

});