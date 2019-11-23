<%-- 
    Document   : formCompra
    Created on : 28/10/2019, 18:12:33
    Author     : thiago.srocha4
action="\TadsGames\inputVenda?action=CadastrarVenda"
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <title>Venda</title>
        <link rel="stylesheet" type="text/css" href="../css/venda.css">

    </head>
    <body>
        <form autocomplete="off" method=""> 

            <div class="fundo"></div>
            <div   class="procuraCliente">
                <div  class="fundo2">

                    <div class="procuraClienteB">
                        <h3>Selecione um Cliente: </h3>

                        <input type="" name="nomeCpf" class="inputNomeCliente" placeholder="Digite o nome ou CPF do Cliente">
                        <button type="button" class="btnAddCliente">Confirmar</button>

                        <input hidden="" type="" name="idCliente">
                        <table hidden="" class="tblProcuraClientes">
                            <thead>

                                <tr>
                                    <th>idCliente</th>
                                    <th>Nome Cliente</th>
                                    <th>CPF</th>
                                </tr>


                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container">


                <div class="procuraProduto">
                    <h3>Selecione o Produto: </h3>
                    <input id="inputNomeProduto" name="nomeProduto" class="inputNomeProduto" placeholder="Digite o nome do Produto">
                    <table id="listaPesquisaProduto" class="oculta">
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
                    <input hidden type="" name="idProduto">
                    <button class="btnAddProduto">Adicionar</button>
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
                        <tbody id="#tbodyItensVenda">
                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>

                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>
                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>
                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>
                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>
                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>
                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>
                            <tr>
                                <td class="tdIdProduto">1</td>
                                <td class="tdNomeProduto">BatmanBatmanBatmanBatman</td>
                                <td class="tdVlrUnitario tdVlr">R$ 450,50</td>
                                <td class="tdQtd"><input type="number" name="qtd" class="inputQtd" value="1"></td>
                                <td class="tdVlrTotal tdVlr">R$ 123.000,00</td>
                                <td class="tdRemover"><a href="#">remover</a></td>
                            </tr>





                        </tbody>
                    </table>
                </div>
            </div>
        </form>
        <script src="../javaScript/autoCompleteProdutoNovo.js"></script>
    </body>
</html>