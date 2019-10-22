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
        <link rel="stylesheet" type="text/css" href="css/formularios.css">
    </head>
    <body>
        <h3>Alterar Produtos</h3>

        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/inputProduto?action=EditarProduto">
                
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
