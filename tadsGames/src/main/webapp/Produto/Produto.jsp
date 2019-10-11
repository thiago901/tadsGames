<%-- 
    Document   : Funcionario
    Created on : Oct 5, 2019, 7:18:16 PM
    Author     : marcoaureli - loc-b
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* ENTRADAS ONDE O TIPO SEJA TEXTO, COMBO E TEXTAREA */
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  position: absolute;
  left: 4em;
  width: 50%;
  border: 2px solid gray;
  border-radius: 5px;
  padding: 20px;
}
</style>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/formulario/funcionarioindefined" novalidate>
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="Codigo" placeholder="Digite seu codigo...">

    <label for="cpf">Valor de compra</label>
    <input type="text" id="vlrCompra" name="vlrCompra" placeholder="Digite a valor de compra...">
    
    <label for="salario">Salário</label>
    <input type="text" id="salario" name="salario" placeholder="Informe o salário...">
    
    <label for="Status">Cargo</label>
    <input type="text" id="status" name="status" placeholder="Digite o status...">
    
    
    <label for="tpFuncionario">Status</label>
    <select id="tpFuncionario" name="tpFuncionario">
      <option value="fdiretor">Ativo</option>
      <option value="fadm">Não ativo</option>
    </select>
    <button type="submit">Enviar</button>
  </form>
</div>

</body>
</html>
