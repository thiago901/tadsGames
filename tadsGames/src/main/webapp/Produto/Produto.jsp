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
    </head>
    <body>

        <h3>Cadastro de Produtos</h3>

        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/formularioProduto">
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
                <button type="reset">Novo</button>
                <button type="button">Alterar</button>
                <button type="reset">Cancelar</button> <br><br>
                

                
            </form>
        </div>

    </body>
</html>
