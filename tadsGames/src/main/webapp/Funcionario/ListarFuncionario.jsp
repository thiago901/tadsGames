<%-- 
    Document   : ListarFuncionario
    Created on : Oct 15, 2019, 10:02:24 PM
    Author     : gabri
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1 {
        text-align: center;
    }
    
    .container {
        position: absolute;
        top: 40%;
        left: 30%;
        width: 50%;
        transform: translate(-50%, -50%);
    }
    
    table, tr, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    
    th, tr, td {
        padding: 5px;
    }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Consulta de Funcionários</h1>
        <form method="post" action="${pageContext.request.contextPath}/listarFuncionario" novalidate>
        <table border="1">            
  <thead>
    <tr>
      <th>Nome</th>
      <th>Sobrenome</th>
      <th>CPF</th>
      <th>Data de Nascimento</th>
      <th>Login</th>
      <th>Salário</th>
      <th>Departamento</th>
      <th>Empresa</th>
      <th>Cargo</th>
      <th>Sexo</th>
      <th>Status</th>
      <th>Opção</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach items="${funcionarios}" var="funcionario">
       <tr>
         <td>${funcionario.nome}</td>
         <td>${funcionario.sobrenome}</td>
         <td>${funcionario.cpf}</td>         
         <td>${funcionario.dtNasc}</td>
         <td>${funcionario.login}</td>
         <td>${funcionario.salario}</td>
         <td>${funcionario.departamento}</td>
         <td>${funcionario.nomeEmpresa}</td>
         <td>${funcionario.cargo}</td>
         <td>${funcionario.sexo}</td>
         <td>${funcionario.status}</td>
         <td value="${funcionario.id}">
             <a href="inputFuncionario?action=FormEditarFuncionario&id=${funcionario.id}">Editar</a>
         </td>
       </tr>
     </c:forEach>
       </form>
        </div>
  </tbody>
</table>
    </body>
</html>
