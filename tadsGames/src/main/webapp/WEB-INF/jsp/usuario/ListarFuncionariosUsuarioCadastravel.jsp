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
        <title>Solicitações RH</title>
        <link rel="stylesheet" type="text/css" href="../css/tabelasListagem.css">
        <link rel="icon" href="../img/icon-controle-pequeno.png">
    </head>
    <body>
        <div class="fundo"></div>
        <div class="container">
        <h1 class="titulo">Solicitações do RH</h1>
        <input type="text" id="pesquisaUsuario" placeholder="Digite o nome de um funcionário">
        <table border="1" id="tabela">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                        <th>Departamento</th>
                        <th>Cargo</th>
                        <th>Cadastrar</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="f" items="${lista}">
                        <tr class="users">
                            <td class="nome"><c:out value="${f.nomeFuncionario}" /></td>
                            <td class="sobrenome"><c:out value="${f.sobrenome}" /></td>
                            <td class="departamento"><c:out value="${f.departamento}" /></td>
                            <td class="cargo"><c:out value="${f.cargo}" /></td>
                            <td class="altera"><a href="inputUsuario?action=FormCadastrarUsuario&idFuncionario=${f.idFuncionario}"><img src="../img/alterar.png"></a></td>
                        </tr>
                    </c:forEach>

                </tbody>
                </div>
            </table>
        <a href="${pageContext.request.contextPath}/home"><button type="button">Sair</button></a>
        <script type="text/javascript" src="../javaScript/filtraFuncionarioSemUsuario.js"></script>
    </body>
</html>
