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
        <title>Vendas</title>
        <link rel="stylesheet" type="text/css" href="../css/reset.css">
        
        <link rel="stylesheet" type="text/css" href="../css/telaVendas.css">
        
        
    </head>
    <body>

        <form action="\TadsGames\tads\inputVenda?action=CadastrarVenda" method="post">
            <div id="divNomeCLiente" >  
                <img src="../img/cliente.png">
                        <h1 id="h1NomeCLiente"> Cliente: </h1>
                        <img id="alterarCliente" src="../img/alterar.png">
                
            </div>
            <div id="divCliente" class="divCliente">
                <div  class="divClienteConteudo">
                    
                        <input id="resumoCliente" name="nomeCliente" class="" placeholder="Digite o nome do Cliente">
                    
                        <table id="tabelaClientes" hidden="">

                            <tbody id="tbodyListaClientes">

                            </tbody>

                        </table>
                    
                </div>
                </div>    
            <div class="conteudo-principal">

                <div class="insere-produto">

                    <div class="insere-nome-produto">
                        <input value=""  id="nomeProduto" type="text" name="nomeProduto" class="procuraNomeProduto" placeholder="Digite o Codigo ou nome do Item">
                        <div class="divAutocomplete">
                            <table id="tbSource" hidden="">

                                <tbody id="tbodyListaProdutos">

                                </tbody>

                            </table>
                        </div>

                    </div>
                    <div class="QuantidadeEstoque">
                        <span>Quantidade Estoque</span>
                        <span id="SpanQtdEstoque">0,00</span>
                    </div>
                    <div class="Quantidade">
                        <span>Quantidade</span>
                        <input id="qtd" type="number"  min="0" name="qtd" class="dadosQtd" value="0">
                    </div>
                    
                    <div class="valorUnitario">
                        <span>Valor Unit?rio</span>
                        <span  id="SpanvlrUnitario">0,00</span>
                    </div>

                    <div class="valorTotal">
                        <span>Valor Total</span>
                        <span id="vlrTotal" >0,00</span>
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
                        <th>Add/Remover</th>
                        </thead>
                        <tbody id="tbodyDetalheVenda">
                        </tbody>
                    </table>

                    <button type="subimit" id="salvar" class="salvar" >Salvar</button>

                </div>
            </div>
                         
                

           
        </form>
        <script src="../javaScript/autoCompleteProduto.js"></script>
        <script src="../javaScript/autoCompleteCliente.js"></script>
        <script src="../javaScript/addDetalheVenda.js"></script>
        <script src="../javaScript/alterarCliente.js"></script>

    </body>
</html>
