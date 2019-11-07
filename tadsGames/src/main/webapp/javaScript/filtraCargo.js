var depto = document.getElementById("depto");
var cargo = document.getElementById("tpFuncionario");

depto.onchange = function(){
    if (depto.options[depto.selectedIndex].value === "Diretoria"){
        cargo.options.length = 0;
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Diretor");
        var t = document.createTextNode("Diretor");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
    }
    if (depto.options[depto.selectedIndex].value === "Retaguarda"){
        cargo.options.length = 0;
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Gerente global");
        var t = document.createTextNode("Gerente global");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Funcionario matriz");
        var t = document.createTextNode("Funcionario matriz");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Gerente regional");
        var t = document.createTextNode("Gerente regional");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Funcionario regional");
        var t = document.createTextNode("Funcionario regional");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
    }
    if (depto.options[depto.selectedIndex].value === "Vendas"){
        cargo.options.length = 0;
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Gerente global");
        var t = document.createTextNode("Gerente global");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Gerente regional");
        var t = document.createTextNode("Gerente regional");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Vendedor regional");
        var t = document.createTextNode("Vendedor regional");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
    }
    if (depto.options[depto.selectedIndex].value === "TI"){
        cargo.options.length = 0;
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Gerente global");
        var t = document.createTextNode("Gerente global");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Gerente regional");
        var t = document.createTextNode("Gerente regional");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Suporte tecnico");
        var t = document.createTextNode("Suporte tecnico");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
    }
    if (depto.options[depto.selectedIndex].value === "Administrativo"){
        cargo.options.length = 0;
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Gerente global");
        var t = document.createTextNode("Gerente global");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
        
        var x = document.createElement("OPTION");
        x.setAttribute("value", "Funcionário");
        var t = document.createTextNode("Funcionário");
        x.appendChild(t);
        document.getElementById("tpFuncionario").appendChild(x);
    }
        
};
