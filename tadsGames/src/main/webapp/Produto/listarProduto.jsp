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
    <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box;}

            /* ENTRADAS ONDE O TIPO SEJA TEXTO, COMBO E TEXTAREA */
            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
                resize: vertical;
            }

            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                position: absolute;
                left: 25%;
                width: 50%;
                border: 2px solid gray;
                border-radius: 5px;
                padding: 20px;
            }

            h3 {
                text-align: center;
            }
            

        </style>
        <title>Listar Produto</title>
        
    </head>
    
    <body>
          <form method="post" action="${pageContext.request.contextPath}/formularioProduto" novalidate>

        <div class="container">
                <label for="pesquisa">Pesquisa</label>
                <input type="search" id="pesquisa" name="pesquisa"</input>
                <button type="button">Buscar</button><br><br>

            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Tipo</th>
                        <th>Descricao</th>
                        <th>Ativo</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="p" items='${listar}'>
                        <tr class="produto">
                            <td class="idProduto"><c:out value="${p.getIdProduto()}"/></td>
                            <td class="nome"><c:out value="${p.getNome()}"/></td>
                            <td class="descricao"><c:out value="${p.getDescricao()}"/></td>
                            <td class="tipo"><c:out value="${p.getTipo()}"/></td>
                            <td class="ativo"><c:out value="${p.getAtivo()}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
          </form>
    </body>
</html> 