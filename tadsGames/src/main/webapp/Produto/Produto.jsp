<%-- 
    Document   : Funcionario
    Created on : Oct 5, 2019, 7:18:16 PM
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
            <form method="post" action="${pageContext.request.contextPath}/formulario/produtoindefined" novalidate>
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" placeholder="Digite o nome do produto...">

                <label for="quantidade">Quantidade</label><br>
                <input type="number" id="quantidade" name="quantidade" size="100" maxlength="9" placeholder="Digite a quantidade de produtos..."><br><br>

                <label for="valorUnitario">Valor Unitario</label><br>
                <input type="number" id="valorUnitario" name="valorUnitario" placeholder="Informe o valor da unidade do produto..."><br><br>

                <label for="tipo">Tipo</label>
                <select id="tipo" name="tipo">
                    <option selected disabled> Selecione o tipo de produto</option>
                    <option value="pComponente">Componente</option>
                    <option value="pConsole">Console</option>
                    <option value="pJogo">Jogo</option>
                </select>

                <label for ="empresa">Empresa</label>
                <select id="empresa" name ="empresa">
                    <option selected disabled> Selecione o tipo da empresa</option>
                    <option value="eMatriz">Matriz</option>
                    <option value="eFilial">Filial</option>
                </select>
                <label>Descricao</label><br>
                <textarea cols="30" rows="5" placeholder = "Escreva a descricao do produto aqui..."></textarea>

                 
                <label for="ativo">Ativo</label>
                <input type="radio" id="status" name="status" </input>
                <label for="inativo">Inativo</label>
                <input type="radio" id="status" name="status" </input>
                
                <select id="status" name="status">
                    <option selected disabled>Defina o status do produto </option>
                    <option value="pAtivo">Ativo</option>
                    <option value="pInativo">Inativo</option>
                </select>

                <button type="submit">Salvar</button>
                <button type="reset">Novo</button>
                <button type="button">Alterar</button>
                <button type="reset">Cancelar</button> <br><br>
                
                <label for="pesquisa">Pesquisa</label>
                <input type="search" id="pesquisa" name="pesquisa"</input>
                <button type="button">Buscar</button><br><br>
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Quantidade</th>
                            <th>Valor Unitario</th>
                            <th>Tipo</th>
                            <th>Empresa</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${produtosAttr}" var="produto">
                            <tr>
                                <td>${produto.nome}</td>
                                <td>${produto.quantidade}</td>
                                <td>${produto.valorUnitario}</td>
                                <td>${produto.tipo}</td>
                                <td>${produto.empresa}</td>
                                <td>${produto.status}</td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </form>
        </div>

    </body>
</html>
