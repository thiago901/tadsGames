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
        <title>Login</title>
        <meta charset="UTF-8"/>
        <link rel="icon" href="img/icon-controle-pequeno.png">
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/inputLogin?action=LoginForm" novalidate>
            <h1>Tela de Login</h1>
            <label>Login</label>
            <input type="text" name="login">
            <label>Senha</label>
            <input type="password" name="senha">

            <input type="hidden" name="acao" value="Login">

            <input type="submit">
        </form>
    </body>
</html>
