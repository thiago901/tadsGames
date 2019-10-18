<%-- 
    Document   : AlterarFuncionario
    Created on : Oct 15, 2019, 11:56:56 PM
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
    input[type=text], input[type=date], input[type=password], select, textarea {
      width: 100%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      margin-top: 6px;
      margin-bottom: 16px;
      resize: vertical;
    }

    button[type=submit] {
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

    h1 {
        text-align: center;
    }
    
    table, tr, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    
    th {
        padding: 5px;
    }
    
    td {
        padding: 10px;
    }

    .container {
      position: absolute;
      top: 80%;
      left: 50%;
      width: 50%;
      transform: translate(-50%, -50%);
      border: 2px solid gray;
      border-radius: 5px;
      padding: 20px;
    }
</style>
</head>
<body>

<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/alterarFuncionario" novalidate>
      <h1>Cadastro de Funcionários</h1> 
      <input type="hidden" name="idFuncionario" value="${fe.id}">
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome" value="${fe.nome}">
    
    <label for="sobrenome">Sobrenome</label>
    <input type="text" id="sobrenome" name="sobrenome" value="${fe.sobrenome}">

    <label for="cpf">CPF</label>
    <input type="text" id="cpf" name="cpf" value="${fe.cpf}">
    
    <label for="dtNasc">Data de Nascimento</label>
    <input type="date" id="dtNasc" name="dtNasc" value="${fe.dtNasc}">
    
    <label for="login">Login</label>
    <input type="text" id="login" name="login" value="${fe.login}">
    
    <label for="senha">Senha</label>
    <input type="password" id="senha" name="senha" value="${fe.senha}">
    
    <label for="salario">Salario</label>
    <input type="text" id="salario" name="salario" value="${fe.salario}">
    
    <label for="depto">Departamento</label>
    <input type="text" id="depto" name="depto" value="${fe.departamento}">   
    
    <label for="tpEmpresa">Empresa</label>
    <select id="empresa" name="tpEmpresa">
        <option selected value="${fe.idEmpresa}">${fe.nomeEmpresa}</option>
        <c:forEach items="${empresasAttr}" var="empresa">
            <c:if test="${empresa.cod != fe.idEmpresa}">
                <option value="${empresa.cod}">${empresa.nome}</option>
            </c:if>
        </c:forEach>
    </select>
    
    <label for="tpFuncionario">Cargo</label>
    <select id="tpFuncionario" name="tpFuncionario">
        <option selected value="${fe.cargo}">${fe.cargo}</option> 
        <c:if test="${fe.cargo == 'Diretor'}">
            <option value="Funcionario Administrativo">Funcionário Administrativo</option>
            <option value="Funcionario TI">Funcionário TI</option>
            <option value="Funcionario Venda">Funcionário Venda</option>
            <option value="Funcionario Retaguarda">Funcionário Retaguarda</option>
            <option value="Gerente Global">Gerente Global</option>
        </c:if>
        <c:if test="${fe.cargo == 'Funcionario Administrativo'}">
            <option value="Diretor">Diretor</option>
            <option value="Funcionario TI">Funcionário TI</option>
            <option value="Funcionario Venda">Funcionário Venda</option>
            <option value="Funcionario Retaguarda">Funcionário Retaguarda</option>
            <option value="Gerente Global">Gerente Global</option>
        </c:if>
        <c:if test="${fe.cargo == 'Funcionario TI'}">
            <option value="Diretor">Diretor</option>
            <option value="Funcionario Administrativo">Funcionário Administrativo</option>
            <option value="Funcionario Venda">Funcionário Venda</option>
            <option value="Funcionario Retaguarda">Funcionário Retaguarda</option>
            <option value="Gerente Global">Gerente Global</option>
        </c:if>
        <c:if test="${fe.cargo == 'Funcionario Venda'}">
            <option value="Diretor">Diretor</option>
            <option value="Funcionario Administrativo">Funcionário Administrativo</option>
            <option value="Funcionario TI">Funcionário TI</option>
            <option value="Funcionario Retaguarda">Funcionário Retaguarda</option>
            <option value="Gerente Global">Gerente Global</option>
        </c:if>
        <c:if test="${fe.cargo == 'Funcionario Retaguarda'}">
            <option value="Diretor">Diretor</option>
            <option value="Funcionario Administrativo">Funcionário Administrativo</option>
            <option value="Funcionario TI">Funcionário TI</option>
            <option value="Funcionario Venda">Funcionário Venda</option>
            <option value="Gerente Global">Gerente Global</option>
        </c:if>
        <c:if test="${fe.cargo == 'Gerente Global'}">
            <option value="Diretor">Diretor</option>
            <option value="Funcionario Administrativo">Funcionário Administrativo</option>
            <option value="Funcionario TI">Funcionário TI</option>
            <option value="Funcionario Venda">Funcionário Venda</option>
            <option value="Funcionario Retaguarda">Funcionário Retaguarda</option>
        </c:if>
    </select>
    
    <div>
        <p>Sexo</p>
        <c:if test="${fe.sexo == 'Masculino'}">
            <input type="radio" name="sexo" value="Masculino" checked>
            <label>Masculino</label>
            <input type="radio" name="sexo" value="Feminino">
            <label>Feminino</label>
        </c:if>
        <c:if test="${fe.sexo == 'Feminino'}">
            <input type="radio" name="sexo" value="Masculino">
            <label>Masculino</label>
            <input type="radio" name="sexo" value="Feminino" checked>
            <label>Feminino</label>
        </c:if> 
    </div>

    <div>
        <p>Status</p>
        <c:if test="${fe.status == true}">
            <input type="radio" name="status" value="true" checked>
            <label>Ativo</label>
            <input type="radio" name="status" value="false">
            <label>Inativo</label>   
        </c:if>
        <c:if test="${fe.status == false}">
            <input type="radio" name="status" value="true">
            <label>Ativo</label>
            <input type="radio" name="status" value="false" checked>
            <label>Inativo</label>   
        </c:if>                                
    </div>
    <br>
    <button type="submit">Enviar</button>        
  </form>
</div>

</body>
</html>
