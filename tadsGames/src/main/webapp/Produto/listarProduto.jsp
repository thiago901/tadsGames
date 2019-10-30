<%-- 
    Document   : listarProdutos
    Created on : 15/10/2019, 16:02:55
    Author     : lucas
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head><meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/tabelasListagem.css">
        <title>Listar Produto</title>

    </head>

    <body>

        <div class="container">
            <h1 class="titulo">Listar Produtos</h1>
            <input type="text" id="pesquisaProduto" placeholder="Digite um nome..."</input>


            <table border="1" id="tabela">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Descricao</th>
                        <th>Tipo</th>
                        <th>Ativo</th>
                        <th>Editar</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="p" items="${lista}">
                        <tr class="produto">
                            <td class="idProduto"><c:out value="${p.getIdProduto()}" /></td>
                            <td class="nome"><c:out value="${p.getNome()}" /></td>
                            <td class="descricao"><c:out value="${p.getDescricao()}" /></td>
                            <td class="tipo"><c:out value="${p.getTipo()}" /></td>
                            
                            <td class="ativo">
                                <c:if test="${p.getAtivo()==true}">Sim</td></c:if>
                                <c:if test="${p.getAtivo()==false}">Não</td></c:if>
                            <td class="altera"><a href="inputProduto?action=FormEditarProduto&idProduto=${p.getIdProduto()}"><img src="img/alterar.png"></a></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <div class="teste">
                <button type="submit" ><a href="${pageContext.request.contextPath}">Sair</a></button>
            </div>
        </div>
        <script type="text/javascript" src="javaScript/filtraProduto.js"></script>
    </body>
</html> 