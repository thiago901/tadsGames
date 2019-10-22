<%-- 
    Document   : Produto
    Created on : Oct 11, 2019, 7:46:21 PM
    Author     : marcoaureli - loc-b
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
       <link rel="stylesheet" type="text/css" href="css/formularios.css">
    </head>
    <body>

        

        <div class="container">
            <h2 class="titulo">Cadastro de Produtos</h2>
            <form method="post" action="${pageContext.request.contextPath}/inputProduto?action=CadastrarProduto">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" placeholder="Digite o nome do produto...">

                <label for="tipo">Tipo</label>
                <select id="tipo" name="tipo">
                    <option selected disabled> Selecione o tipo de produto</option>
                    <option value="Componente">Componente</option>
                    <option value="Console">Console</option>
                    <option value="Jogo">Jogo</option>
                </select>

                <br><br>
                <label for="descricao">Descricao</label><br>
                <textarea cols="30" rows="5" name="descricao" placeholder = "Escreva a descricao do produto aqui..."></textarea>
                

                 
                <label for="ativo">Ativo</label>
                <input type="radio" id="status" name="ativo" value="true" </input>
                <label for="inativo">Inativo</label>
                <input type="radio" id="status" name="ativo" value="false" </input><br><br>
                
                <button type="submit">Salvar</button>
                <button type="reset">Reset</button>
                <button type="button">Cancelar</button> <br><br>
                

                
            </form>
        </div>

    </body>
</html>
