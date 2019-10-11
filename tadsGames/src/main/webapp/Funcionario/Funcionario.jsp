<%-- 
    Document   : Funcionario
    Created on : Oct 5, 2019, 7:18:16 PM
    Author     : gabri
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
  <form method="post" action="${pageContext.request.contextPath}/formulario/funcionario" novalidate>
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome" placeholder="Digite seu nome...">

    <label for="cpf">CPF</label>
    <input type="text" id="cpf" name="cpf" placeholder="Digite o CPF...">
    
    <label for="dtNasc">Data de Nascimento</label>
    <input type="date" id="dtNasc" name="dtNasc" placeholder="Digite o CPF...">
    
    <label for="salario">Salário</label>
    <input type="text" id="salario" name="salario" placeholder="Informe o salário...">
    
    <label for="cargo">Cargo</label>
    <input type="text" id="cargo" name="cargo" placeholder="Digite o cargo...">
    
    <label for="depto">Departamento</label>
    <input type="text" id="depto" name="depto" placeholder="Digite o departamento...">   
    
    <label for="tpFuncionario">Tipo Funcionário</label>
    <select id="tpFuncionario" name="tpFuncionario">
      <option value="fdiretor">Diretor</option>
      <option value="fadm">Funcionário Administrativo</option>
      <option value="fti">Funcionário TI</option>
      <option value="fvenda">Funcionário Venda</option>
      <option value="fretaguarda">Funcionário Retaguarda</option>
    </select>

    <label for="ativo">Ativo</label>
    <input type="checkbox" id="ativo" name="ativo">

    <button type="submit">Enviar</button>
  </form>
</div>

</body>
</html>
