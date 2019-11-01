<%-- 
    Document   : formCompra
    Created on : 28/10/2019, 18:12:33
    Author     : thiago.srocha4
action="\TadsGames\inputVenda?action=CadastrarVenda"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda</title>

        

    </head>

    <body>

        <div class="container">

            <form id="formAdiciona"  method="post" action="inputVenda?action=CadastrarVenda">

                <select name="empresa" required="" id="empresa">
                    <option disabled="">Escolha uma Empresa</option>
                    <c:forEach items="${empresa}" var="e">
                        <option value="${e.getIdEmpresa()}"><c:out value="${e.getNome()}"/></option>
                    </c:forEach>
                    
                </select>
                <select name="produto" required="" id="produto">
                    <option disabled=""  >Escolha um produto</option>
                    <c:forEach items="${produto}" var="p">
                        <option value="${p.getIdProduto()}"><c:out value="${p.getNome()}"/></option>
                    </c:forEach>
                        
                       
                    
                </select>

                <select name="cliente" required="" id="cliente">
                    <option disabled=""  >Escolha um Cliente</option>
                    <c:forEach items="${cliente}" var="c">
                        <option value="${c.getIdCliente()}"><c:out value="${c.getNome()}"/></option>
                    </c:forEach>
                    
                </select>

                <label for="qtdComprada">Quantidade</label>
                <input  id="qtdComprada" name="qtdComprada" required="" value="50">
                <label for="vlrUnitario">Valor Unitario</label>
                <input  id="vlrUnitario" name="vlrUnitario" required="" value="47">
                
                <table id="tabela-detalhe-venda">
                    <thead>
                        <th>idProduto</th>
                        <th>Produto</th>
                        <th>Quantidade</th>
                        <th>Valor Unitario</th>
                        <th>Valor Total</th>
                        <th>Add/Remover</th>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <button id="add">Add</button>
                <input type="submit">
                <input name="vlrTotal" value="600">
            </form>
            
        </div>

        <script type="text/javascript" src="javaScript/addDetalheVenda.js"></script>
        
    </body>

</html>
