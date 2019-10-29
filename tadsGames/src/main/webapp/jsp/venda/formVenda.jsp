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
        <title>Venda</title>
    </head>
    <body>
        <div class="container">
            <form id="formAdiciona">
                <select name="empresa" required="" id="empresa">
                    <option disabled="" selected="" >Escolha uma Empresa</option>
                    <option value="1">Loja 1</option>
                </select>

                <select name="produto" required="" id="produto">
                    <option disabled="" selected="" >Escolha um produto</option>
                    <option value="1">God of War</option>
                </select>

                <select name="cliente" required="" id="cliente">
                    <option disabled="" selected="" >Escolha um Cliente</option>
                    <option value="1">Jose</option>
                </select>


                <label for="qtdComprada">Quantidade</label>
                <input  id="qtdComprada" name="qtdComprada" required="">

                <label for="vlrUnitario">Valor Unitario</label>
                <input  id="vlrUnitario" name="vlrUnitario" required="">

                <label for="dtEntrada">Data de Entrada</label>
                <input type="date" id="dtEntrada" name="dtEntrada" required="">

                <table id="tabela-detalhe-venda">
                    <thead>

                    <th>idProduto</th>
                    <th>Produto</th>
                    <th>Quantidade</th>
                    <th>Valor Unitario</th>
                    <th>Valor Total</th>
                    <th>Remover</th>

                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <button id="add">Add</button>

            </form>
            <button>Salvar</button>
        </div>
        <script type="text/javascript" src="venda.js"></script>
    </body>
</html>
