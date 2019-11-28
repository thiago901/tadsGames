<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requer Autorização</title>
        <link rel="stylesheet" type="text/css" href="css/formularios.css">
    </head>
    <body>
        <div class="container">
            <h2>Usuário não tem permissão para acessar esta tela</h2>
            <a href="${pageContext.request.contextPath}/home"><button type="button">Voltar</button></a>
        </div>
    </body>
</html>
