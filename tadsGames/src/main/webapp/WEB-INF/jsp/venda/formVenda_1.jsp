<%-- 
    Document   : formCompra
    Created on : 28/10/2019, 18:12:33
    Author     : thiago.srocha4
action="\TadsGames\inputVenda?action=CadastrarVenda"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <title>Vendas</title>        
        <link rel="stylesheet" type="text/css" href="../css/venda.css">
    </head>
    <body>
<div class="container">
    
    <form autocomplete="off" id="form" action="${pageContext.request.contextPath}/tads/inputVenda?action=CadastrarItemVenda" method="post">
            
            <div id="divNomeCLiente" >  
                        
                
            </div>
            <div id="divCliente" class="divCliente">
                <div  class="divClienteConteudo">
                    
                    <input value="${nomeCliente2}" id="resumoCliente" name="nomeCliente" class="" placeholder="Insira um nome ou CPF" disabled="">
                    <img class="imgAltera" src="../img/alterar.png">
                    <input value="${idCliente}" id="idCliente" name="idCliente" hidden="">
                        
                        
                        
                        <table id="tabelaClientes" hidden="">

                            <tbody id="tbodyListaClientes">
                            <thead>
                                <tr>
                                    <th hidden="">id</th>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                </tr>
                            </thead>
                                
                                
                                

                            </tbody>

                        </table>
                    
                </div>
                </div>    
            <div class="conteudo-principal">
                <div class="insere-produto-botao">
                <div class="insere-produto">

                    <div class="insere-nome-produto">
                        <input value=""  id="nomeProduto" type="text" name="nomeProduto" class="procuraNomeProduto" placeholder="Digite o Codigo ou nome do Item">
                        <div class="divAutocomplete">
                            <table id="tbSource" hidden="">

                                <tbody id="tbodyListaProdutos">
                                <thead>
                                    <tr>
                                        <th>Produto</th>
                                        <th>Estoque</th>
                                    </tr>
                                </thead>
                                    
                                </tbody>

                            </table>
                        </div>

                    </div>
                    <div class="insere-produto2">
                    <div class="Quantidade">
                        
                        <input value="0" id="qtd" type="number"  min="0" name="qtd" class="dadosQtd" placeholder="Informe a quantidade">
                    </div>
                    
                    <div class="valorUnitario">
                        <span>Valor Unitario</span>
                        <span  id="SpanvlrUnitario">0,00</span>
                    </div>

                    <div class="valorTotal">
                        <span>Valor Total</span>
                        <span id="vlrTotal" >0,00</span>
                    </div>
                   
                </div>

                </div>
                <div class="botao">
                    <button id="add" class="add">Incluir Produto</button>
                </div>
                </div>
                <div class="tabelas-itens">
                    <table id="tabela-detalhe-venda" class="tabela">
                        <thead>
                        <th>idProduto</th>
                        <th>Produto</th>
                        <th>Quantidade</th>
                        <th>Valor Unitario</th>
                        <th>Valor Total</th>
                        <th>Remover</th>
                        </thead>
                        <tbody id="tbodyDetalheVenda">
                        <input id="idProduto" name="idProduto" value="" hidden="">
                        <input id="vlrUnitario" name="vlrUnitario" value="" hidden="">
                       
                            <c:forEach items="${itemVenda}" var="i">
                                <tr class="itemVenda">
                                    <td hidden="" class="idLinha"><c:out value="${i.getItem()}"/></td>
                                    <td class="idProdutoD"><c:out value="${i.getIdProduto()}"/></td>
                                    <td class="nomeProduto"><c:out value="${i.getNomeProduto()}"/></td>
                                    <td class="qtd"><c:out value="${i.getQtdVenda()}"/></td>
                                    <td class="vlrUnitario"><c:out value="${i.getVlrUnitario()}"/></td>
                                    <td class="vlrTotal"><c:out value="${i.getVlrTotal()}"/></td>
                                    <td><a href="inputVenda?action=ExcluirItemVenda&&itemVenda=${i.getItem()}"><img class="imgAltera" src="../img/alterar.png"></a></td>
                                    <input name="idProdutos[]" value="${i.getIdProduto()}" hidden="">
                                    <input name="qtds[]" value="${i.getQtdVenda()}" hidden="">
                                    <input name="vlrUnitarios[]" value="${i.getVlrUnitario()}" hidden="">
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="divBotoes">
                        
                        <button><a href="${pageContext.request.contextPath}/home">Voltar ao Menu</a></button>
                        <button type="reset" id="reset" class="reset" >Limpar</button>
                        <button type="subimit" id="salvar" class="salvar" >Salvar</button>
                    </div>

                </div>
            </div>
                         
                

          
        </form>
         </div>
        <script src="../javaScript/autoCompleteProduto.js"></script>
        <script src="../javaScript/autoCompleteCliente.js"></script>
        <script src="../javaScript/alteraAcaoForm.js"></script>
        
        


    </body>
</html>
