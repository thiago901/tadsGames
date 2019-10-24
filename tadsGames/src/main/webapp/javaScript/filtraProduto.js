
var nomePesquisado = document.querySelector("#pesquisaProduto");

nomePesquisado.addEventListener("input", function () {
    var produtos = document.querySelectorAll(".produto");
    for (var i = 0; i < produtos.length; i++) {
        var produto = produtos[i];
        var nomeProduto = produto.querySelector(".nome").textContent;
        var expressao = new RegExp(this.value, "i");

        if (this.value.length > 0) {

            if (!expressao.test(nomeProduto)) {
                produto.setAttribute("hidden", "");
            } else {
                produto.removeAttribute("hidden");
            }
        } else {
            for (var i = 0; i < produtos.length; i++) {
                var produto = produtos[i];
                produto.removeAttribute("hidden");
            }
        }
    }
});

