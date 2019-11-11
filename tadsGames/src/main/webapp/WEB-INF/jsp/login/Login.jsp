<%-- 
    Document   : Login
    Created on : 07/11/2019, 17:06:05
    Author     : gabriel.gisidorio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <link rel="icon" href="img/icon-controle-pequeno.png">
        <title>Login</title>
        <meta charset="UTF-8"/>        
    </head>
    <body>
        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/inputLogin?action=Login" novalidate>
                <h1 class="titulo">Tades Games</h1>
                <c:if test="${msgErro != null}">
                    <div class="erro-input com-erro">
                        <h3>${msgErro}</h3>
                    </div>
                </c:if>
                <label>Usuário</label>
                <input type="text" name="login" autofocus>
                <label>Senha</label>
                <input type="password" name="senha">

                <input type="hidden" name="acao" value="Login">

                <button type="submit">Acessar</button>
            </form>
        </div>
    </body>
</html>
