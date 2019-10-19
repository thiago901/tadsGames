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
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/listarFuncionario" novalidate>
        <table border="1">            
  <thead>
    <tr>
      <th>Nome</th>
      <th>Sobrenome</th>
      <th>CPF</th>
      <th>login</th>
      <th>Sexo</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach items="${funcionariosAttr}" var="funcionario">
       <tr>
         <td>${funcionario.nome}</td>
         <td>${funcionario.sobrenome}</td>
         <td>${funcionario.cpf}</td>
         <td>${funcionario.login}</td>
         <td>${funcionario.sexo}</td>
         <td value="${funcionario.id}">
             <a href="alterarFuncionario?id=${funcionario.id}">Editar</a>
         </td>
       </tr>
     </c:forEach>
       </form>
  </tbody>
</table>
    </body>
</html>
