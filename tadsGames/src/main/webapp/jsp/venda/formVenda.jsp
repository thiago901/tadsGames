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

            <form id="formAdiciona"  method="post">

                <select name="empresa" required="" id="empresa">

                    <option disabled="">Escolha uma Empresa</option>

                    <option value="1"  selected="" >Loja 1</option>

                </select>

 

                <select name="produto" required="" id="produto">

                    <option disabled=""  >Escolha um produto</option>

                    <option value="1" selected="">God of War</option>

                </select>

 

                <select name="cliente" required="" id="cliente">

                    <option disabled=""  >Escolha um Cliente</option>

                    <option value="1" selected="">Jose</option>

                </select>

 

 

                <label for="qtdComprada">Quantidade</label>

                <input  id="qtdComprada" name="qtdComprada" required="" value="50">

 

                <label for="vlrUnitario">Valor Unitario</label>

                <input  id="vlrUnitario" name="vlrUnitario" required="" value="47">

 

                <label for="dtEntrada">Data de Entrada</label>

                <input type="date" id="dtEntrada" name="dtEntrada" >

 

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

 

            </form>

            <button id="salvar">Salvar</button>

           

        </div>

        <script type="text/javascript" src="javaScript/addDetalheVenda.js"></script>

    </body>

</html>
