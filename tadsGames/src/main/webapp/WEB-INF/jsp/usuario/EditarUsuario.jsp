<%-- 
    Document   : EditarUsuario
    Created on : Nov 20, 2019, 7:33:00 PM
    Author     : gabri
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Edição de Usuário</title>
        <link rel="icon" href="../img/icon-controle-pequeno.png">
        <link rel="stylesheet" type="text/css" href="../css/formularios.css"
    </head>
    <body>
        <div class="container">
            <h2 class="titulo">Edição de Usuário</h2>
            <form method="post" action="${pageContext.request.contextPath}/tads/inputUsuario?action=EditarUsuario">
                <input type="hidden" name="idUsuario" value="${u.idUsuario}">
                <label for="nome">Login</label>                
                <input type="text" maxlength="50" id="nome" name="login" value="${u.nomeUsuario}">                

                <c:if test="${validacaoNome}">
                    <div class="erro-input com-erro">
                        Digite mais de 1 caracter e menos de 50 caracteres
                    </div>
                </c:if>
                <c:if test="${validacaoNome2}">
                    <div class="erro-input com-erro">
                        É permitido somente caracteres numericos e alfabeticos sem acentuação
                    </div>
                </c:if>

                <label for="nome">Senha</label>                
                <input type="password" maxlength="50" id="senha" name="senha" value="${u.senha}">                

                <c:if test="${erroSenha}">
                    <div class="erro-input com-erro">
                        Digite mais de 5 caracter e menos de 16 caracteres
                    </div>
                </c:if> 
                
                <c:if test="${erroSenha2}">
                    <div class="erro-input com-erro">
                        É permitido somente caracteres numericos e alfabeticos sem acentuação
                    </div>
                </c:if>
                
                <div>
                    <p>Status</p>
                    <c:if test="${u.status == true}">
                        <input type="radio" name="status" value="true" checked>
                        <label>Ativo</label>
                        <input type="radio" name="status" value="false">
                        <label>Inativo</label>   
                    </c:if>
                    <c:if test="${u.status == false}">
                        <input type="radio" name="status" value="true">
                        <label>Ativo</label>
                        <input type="radio" name="status" value="false" checked>
                        <label>Inativo</label>   
                    </c:if>                                
                </div>
                
                <div class="teste">
                        <button type="submit">Alterar</button>
                        <button type="reset">Resetar dados</button>
                        <button type="submit" ><a href="${pageContext.request.contextPath}">Sair</a></button>
                        <!--<a href="#" role="button">Cancelar</a>-->
                    </div>                               
            </form>
        </div>

    </body>
</html>
