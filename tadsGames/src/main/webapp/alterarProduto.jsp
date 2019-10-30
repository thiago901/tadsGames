<%-- 
    Document   : alterarProduto
    Created on : 17/10/2019, 18:10:26
    Author     : lucas.sfaria5
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/formularios.css">
    </head>
    <body>
        <h3>Alterar Produtos</h3>

        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/inputProduto?action=EditarProduto">
                
                <label for="nome">Nome</label>
                <input type="text" name="nome" value="${p.getNome()}">
                <%--<div id="validacaoNome" hidden="true">--%>
                    <c:if test="${erroNome}">
                        <div class="erro-input com-erro">
                            Digite mais de 1 caracter e menos de 50 caracteres
                        </div>
                    </c:if>
                <%--</div>    --%>
                <input type="text" name="idProduto" hidden="" value = "${p.getIdProduto()}">

                <label for="tipo">Tipo</label>
                <select name="tipo" >
                    <option value="${p.getTipo()}">${p.getTipo()}</option>
                    <option value="Componente">Componente</option>
                    <option value="Console">Console</option>
                    <option value="Jogo">Jogo</option>
                </select>
                <div class="validacao" hidden="true">
                    <c:if test="${erroTipo}">
                        <div class="erro-input com-erro">
                            É obrigatório escolher um tipo de produto!
                        </div>
                    </c:if>
                </div>
                <br><br>
                <label for="descricao">Descricao</label><br>
                <textarea cols="30" rows="5" name="descricao" value="${p.getDescricao()}">${p.getDescricao()}</textarea>
                

                <c:if test="${p.getAtivo() == true}">
                    <label for="ativo">Ativo</label>
                    <input type="radio" name="ativo" value="true" checked>
                    <label for="inativo">Inativo</label>
                    <input type="radio" name="ativo" value="false"><br><br>
                </c:if>
                <c:if test="${p.getAtivo() == false}">
                    <label for="ativo">Ativo</label>
                    <input type="radio" name="ativo" value="true" >
                    <label for="inativo">Inativo</label>
                    <input type="radio" name="ativo" value="false"checked><br><br>
                </c:if>
                <button type="submit" id="btnSalvar">Salvar</button>
                <button type="reset">Reset</button>
                
                

            </form>
        </div>
                <%--<script>
                    document.getElementById('btnSalvar')
                            .addEventListener('click', function() {
                                document.getElementById('validacaoNome').hidden = false;
                            }, false);
                </script>--%>
    </body>
</html>
