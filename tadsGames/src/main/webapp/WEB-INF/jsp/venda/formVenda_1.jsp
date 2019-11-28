<%-- 
    Document   : formCompra
    Created on : 28/10/2019, 18:12:33
    Author     : thiago.srocha4
action="\TadsGames\inputVenda?action=CadastrarVenda"
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <title>Venda</title>
        <link rel="stylesheet" type="text/css" href="../css/venda.css">

    </head>
    <body>
        <form autocomplete="off" method="POST" id="form" 
              action="${pageContext.request.contextPath}/tads/inputVenda?action=<c:if test="${idCliente!=null}">CadastrarItemVenda</c:if><c:if test="${idCliente==null}">AdiconarCliente</c:if>"> 

            <div class="fundo"></div>

            <div class="procuraCliente <c:if test="${idCliente!=null}"> oculta</c:if>"   id="telaCliente">
                    <div  class="fundo2">
                        <h3 class="erro oculta">Um cliente deve ser Selecionado</h3>

                        <div class="procuraClienteB" id="procuraClienteB">
                            <h3>Selecione um Cliente: </h3>

                            <input type="text" id="inputNomeCliente" name="nomeCpf" class="inputNomeCliente" placeholder="Digite o nome ou CPF do Cliente">
                            <input hidden type="text" readonly="" name="idCliente" id="inputIdCliente">
                            <input hidden type="text" readonly="" name="cpfCliente" id="inputCpfCliente">

                            <table  class="tblProcuraClientes" id="tblListaClientes" hidden="">
                                <thead>
                                    <tr>
                                        <th hidden="">idCliente</th>
                                        <th>Nome Cliente</th>
                                        <th>CPF</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div class="divAddCliente">
                                <a href="${pageContext.request.contextPath}/home"><button class="btnCadastrarVenda voltaMenu" type="button">Voltar ao Menu</button></a>
                            <button type="button" class="btnDivCliente" id="btnEditarCliente">Editar</button>
                            <button type="submit" class="btnDivCliente" id="btnSelecionarCliente">Confirmar</button>
                        </div>
                    </div>
                </div>
            </div>
            <div id="dadosClientes" class="<c:if test="${idCliente==null}"> oculta</c:if>" >
                    <div class="dadosClientesContent">
                        <table id="tblResumoCliente">
                            <tr>
                                <td>Cliente:</td>
                                <td class="tdNome"><c:out value="${nomeCliente2}"/></td>

                        </tr>
                        <tr>
                            <td>CPF:</td>
                            <td class="tdCpf"><c:out value="${cpfCliente}"/></td>

                        </tr>
                        <tr>
                            <td>Total:</td>
                            <td class="tdValor"><f:formatNumber value="${vlrTotal}" type="currency" /></td>
                        </tr>
                    </table>

                    <button type="button" id="btnAlterarCliente">Alterar Cliente</button>
                </div>
            </div>
            <div  class="container <c:if test="${idCliente==null}"> oculta</c:if>" id="container">

                    <div class="procuraProduto">
                        <h3>Selecione o Produto: </h3>
                        <input id="inputNomeProduto" name="nomeProduto" class="inputNomeProduto" placeholder="Digite o nome do Produto">
                    <c:if test="${erroCampos}">
                        <div class="erro-input com-erro">
                            É necessário adicionar itens ao carrinho.
                        </div>
                    </c:if>

                    <input value="0" type="number" min="0" id="inputQuantidade" name="quantideComprada" class="inputQuantidade" placeholder="Informe a quantidade">

                    <input id="inputVlrTotal" class="inputVlrTotal" name="inputVlrTotal" readonly="" value="0,00">

                    <table id="listaPesquisaProduto" class="" hidden="">
                        <thead>
                            <tr>
                                <th hidden="">idProduto</th>
                                <th>Produto</th>
                                <th>Estoque</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyListaProdutos">
                        </tbody>

                    </table>

                    <input type="text" hidden="" name="qtdEstoque" id="qtdEstoque">
                    <input type="text" disabled="" hidden="" name="idCliente" id="a">
                    <div class="divBtnProduto">
                        <button type="button" class="btnAddProduto" id="btnEditarItem">Editar Item</button>
                        <button class="btnAddProduto">Adicionar Item</button>
                    </div>
                </div>

                <div class="divTabelaItensVenda">

                    <table class="tblItensVenda" id="tblItensVenda">
                        <thead>
                            <tr>
                                <th>idProduto</th>
                                <th>Produto</th>
                                <th>Valor Unitario</th>
                                <th>Quantidade</th>
                                <th>Valor Total</th>
                                <th>Remover</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyItensVenda">
                            <c:forEach items="${itemVenda}" var="v">
                                <tr>
                                    <td class="tdIdProduto"><c:out value="${v.getIdProduto()}"/></td>
                                    <td class="tdNomeProduto"><c:out value="${v.getNomeProduto()}"/></td>
                                    <td class="tdVlrUnitario tdVlr"><c:out value="${v.getVlrUnitario()}"/></td>
                                    <td class="tdQtd"><c:out value="${v.getQtdVenda()}"/></td>
                                    <td class="tdVlrTotal tdVlr"><c:out value="${v.getVlrTotal()}"/></td>
                                    <td class="tdRemover"><a href="${pageContext.request.contextPath}/tads/inputVenda?action=ExcluirItemVenda&itemVenda=${v.getItem()}">remover</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <input readonly="" hidden="" id="inputIdProduto" name="inputIdProduto">
                        <input hidden="" readonly="" id="inputVlrUnitario" name="inputVlrUnitario">

                    </table>
                    <div id="divBtnCadastrarVenda">
                        <a href="${pageContext.request.contextPath}/home"><button class="btnCadastrarVenda voltaMenu" type="button">Voltar ao Menu</button></a>
                        <button id="btnCadastrarVenda" class="btnCadastrarVenda">Cadastrar Venda</button>
                    </div>

                </div>
            </div>

        </form>
        <script src="../javaScript/autoCompleteProdutoNovo.js"></script>
        <script src="../javaScript/autoCompleteClienteNovo.js"></script>
        <script src="../javaScript/alteraAcaoForm.js"></script>

    </body>
</html>