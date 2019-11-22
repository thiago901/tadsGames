<%-- 
    Document   : ListarFuncionariosUsuarioCadastravel
    Created on : Nov 2, 2019, 3:24:30 AM
    Author     : gabri
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Listar Usuários</title>
        <link rel="stylesheet" type="text/css" href="../css/tabelasListagem.css">
        <link rel="icon" href="../img/icon-controle-pequeno.png">
    </head>
    <body>
        <div class="fundo"></div>
        <div class="container">
        <h1 class="titulo">Listar Usuários</h1>
        <input type="text" id="pesquisaUsuario" placeholder="Digite um Usuário">
        <table border="1" id="tabela">
                <thead>
                    <tr>
                        <th>Usuário</th>
                        <th>Nome</th>
                        <th>Sobrenome</th>                        
                        <th>Status</th>
                        <th>Alterar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${usuarios}">
                        <tr class="users">
                            <td class="nomeUsuario"><c:out value="${u.nomeUsuario}" /></td>
                            <td class="nome"><c:out value="${u.nomeFuncionario}" /></td>
                            <td class="sobrenome"><c:out value="${u.sobrenome}" /></td>  
                            <td class="ativo">
                                <c:if test="${u.statusUsuario==true}">Sim</td></c:if>
                                <c:if test="${u.statusUsuario==false}">Não</td></c:if>
                            <td class="altera"><a href="inputUsuario?action=FormEditarUsuario&idUsuario=${u.idUsuario}"><img src="../img/alterar.png"></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </div>
            </table>
        
        <script type="text/javascript" src="../javaScript/filtraUsuario.js"></script>
        <a href="${pageContext.request.contextPath}/home"><button type="button">Sair</button></a>       
    </body>
</html>
