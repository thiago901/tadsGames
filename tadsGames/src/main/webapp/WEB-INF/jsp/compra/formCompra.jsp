<%-- 
    Document   : formCompra
    Created on : 28/10/2019, 18:12:33
    Author     : thiago.srocha4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra</title>
        <link rel="stylesheet" href="../css/formularios.css">
    </head>
    <body>
        <div class="container">
            <form action="\TadsGames\inputCompra?action=CadastrarCompra" method="post">
                <select name="empresa" required="">
                    <option disabled="" selected="" >Escolha um empresa</option>
                    <c:forEach items="${empresas}" var="e">
                        <option value="${e.getIdEmpresa()}"><c:out value="${e.getNome()}"/></option>
                    </c:forEach>
                </select>
                <select name="produto" required="">
                    <option disabled="" selected="" >Escolha um produto</option>
                    <c:forEach items="${produtos}" var="p">
                        <option value="${p.getIdProduto()}"><c:out value="${p.getNome()}"/></option>
                    </c:forEach>
                </select>
                
                <label for="qtdComprada">Quantidade</label>
                
                <input  id="qtdComprada" name="qtdComprada" required="">
                <label for="vlrUnitario">Valor Unitario</label>
                <input  id="vlrUnitario" name="vlrUnitario" required="">
                
                <button>Salvar</button>
                
            </form>
            
        </div>
    </body>
</html>
