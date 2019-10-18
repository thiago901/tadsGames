<%-- 
    Document   : alterarProduto
    Created on : 17/10/2019, 18:10:26
    Author     : lucas.sfaria5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h3>Alterar Produtos</h3>

        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/editarProduto">
                
                <label for="nome">Nome</label>
                <input type="text" name="nome" value = "${p.getNome()}">
                <input type="text" name="id" hidden="" value = "${p.getIdProduto()}">

                <label for="tipo">Tipo</label>
                <select name="tipo" >
                    <option value="${p.getTipo()}">${p.getTipo()}</option>
                    <option value="Componente">Componente</option>
                    <option value="Console">Console</option>
                    <option value="Jogo">Jogo</option>
                </select>

                <br><br>
                <label for="descricao">Descricao</label><br>
                <textarea cols="30" rows="5" name="descricao" value="${p.getDescricao()}">${p.getDescricao()}</textarea>
                

                 
                <label for="ativo">Ativo</label>
                <input type="radio" name="ativo" value="true"</input>
                <label for="inativo">Inativo</label>
                <input type="radio" name="ativo" value="false"</input><br><br>
                
                <button type="submit">Salvar</button>
                <button type="reset">Reset</button>
                
                

            </form>
        </div>

    </body>
</html>
