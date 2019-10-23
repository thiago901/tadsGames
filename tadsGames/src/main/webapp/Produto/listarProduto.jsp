<%-- 
    Document   : listarProdutos
    Created on : 15/10/2019, 16:02:55
    Author     : lucas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head><meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/tabelasListagem.css">
        <title>Listar Produto</title>

    </head>

    <body>
        <form method="post" action="${pageContext.request.contextPath}/formularioProduto" novalidate>

            <div class="container">
                <h1 class="titulo">Listar Produtos</h1>
                <input type="text" id="pesquisa" name="pesquisa" placeholder="Digite um produto"</input>


                <table border="1">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Tipo</th>
                            <th>Descricao</th>
                            <th>Ativo</th>
                            <th>Editar</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="p" items="${lista}">
                            <tr>
                                <td><c:out value="${p.getIdProduto()}" /></td>
                                <td><c:out value="${p.getNome()}" /></td>
                                <td><c:out value="${p.getDescricao()}" /></td>
                                <td><c:out value="${p.getTipo()}" /></td>
                                <td><c:out value="${p.getAtivo()}" /></td>
                                <td class="altera"><a href="inputProduto?action=FormEditarProduto&idProduto=${p.getIdProduto()}"><img src="img/alterar.png"></a></td>
                                
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </form>
    </body>
</html> 