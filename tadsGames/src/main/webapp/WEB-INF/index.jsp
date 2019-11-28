<%-- 
    Document   : index
    Created on : 11/11/2019, 18:50:45
    Author     : thiago.srocha4
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>

<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/geral.css">
        <link rel="icon" type="image/png" href="img/icon-controle-pequeno.png"/>                
        <meta charset="UTF-8">
    </head>
    <body>
        <c:import url="jsp/logout/logout.jsp"/>
        <div class="container">
            <div class="card">
                <div class="face face1">
                    <div class="content">
                        
                        <a href="${pageContext.request.contextPath}/tads/input?action=FormCadastrarEmpresa">Nova Empresa</a>
                        <a href="${pageContext.request.contextPath}/tads/input?action=ListarEmpresas&pagina=0">Listar Empresas</a>
                    </div>
                </div>
                <div class="face face2">
                    <h2>Empresas</h2>
                </div>
            </div>

            <c:if test="${sessionScope.usuario.departamento == 'Retaguarda' || sessionScope.usuario.cargo == 'Diretor'}">
                <div class="card">
                    <div class="face face1">
                        <div class="content">

                            <a href="${pageContext.request.contextPath}/tads/inputProduto?action=FormCadastrarProduto">Novo Produto</a>
                            <a href="${pageContext.request.contextPath}/tads/inputProduto?action=ListarProduto&pagina=1">Listar Produtos</a>
                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Produto</h2>
                    </div>
                </div>
            </c:if>

            <c:if test="${sessionScope.usuario.departamento == 'Vendas' || sessionScope.usuario.cargo == 'Diretor'}">
                <div class="card">
                    <div class="face face1">
                        <div class="content">

                            <a href="${pageContext.request.contextPath}/tads/inputCliente?action=FormCadastrarCliente">Novo Cliente</a>
                            <a href="${pageContext.request.contextPath}/tads/inputCliente?action=ListarCliente">Listar Clientes</a>
                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Cliente</h2>
                    </div>
                </div>
            </c:if>

            <div class="card">
                <div class="face face1">
                    <div class="content">

                        <a href="${pageContext.request.contextPath}/tads/inputFuncionario?action=FormCadastrarFuncionario">Novo Funcionario</a>
                        <a href="${pageContext.request.contextPath}/tads/inputFuncionario?action=ListarFuncionarios">Manutenção de Funcionario</a>
                    </div>
                </div>
                <div class="face face2">
                    <h2>Funcionario</h2>
                </div>
            </div>

            <c:if test="${sessionScope.usuario.departamento == 'Vendas' || sessionScope.usuario.cargo == 'Diretor'}">
                <div class="card">
                    <div class="face face1">
                        <div class="content">

                            <a href="${pageContext.request.contextPath}/tads/inputVenda?action=FormVenda">Nova Venda</a>

                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Venda</h2>
                    </div>
                </div>
            </c:if> 

            <c:if test="${sessionScope.usuario.departamento == 'TI' || sessionScope.usuario.cargo == 'Diretor'}">
                <div class="card">
                    <div class="face face1">
                        <div class="content">
                            <a href="${pageContext.request.contextPath}/tads/inputUsuario?action=ListarFuncionariosUsuarioCadastravel">Novo Usuário</a>    
                            <a href="${pageContext.request.contextPath}/tads/inputUsuario?action=ListarUsuarios">Manutenção de Usuários</a>
                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Usuários</h2>
                    </div>
                </div>
            </c:if>

            <c:if test="${sessionScope.usuario.cargo == 'Diretor'}">
                <div class="card">
                    <div class="face face1">
                        <div class="content">
                            <a href="${pageContext.request.contextPath}/tads/inputCompra?action=FormComprar">Nova Compra</a>
                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Compra</h2>
                    </div>
                </div>
            </c:if>
            <c:if test="${sessionScope.usuario.departamento == 'TI' || sessionScope.usuario.cargo == 'Diretor'}">
                <div class="card">
                    <div class="face face1">
                        <div class="content">
                            <a href="${pageContext.request.contextPath}/tads/inputRelatorios?action=Relatorio">Relatorio</a>    
                            <a href="${pageContext.request.contextPath}/tads/inputRelatorios?action=RelatorioDiario">Relatorio Diario</a>
                            <a href="${pageContext.request.contextPath}/tads/inputRelatorios?action=RelatorioRegionalDiario">Diario Regional</a>    
                            <a href="${pageContext.request.contextPath}/tads/inputRelatorios?action=RelatorioEmpresa">Relatorio só da empresa</a>    
                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Relatorio</h2>
                    </div>
                </div>
            </c:if>

            <div class="card">
                <div class="face face1">
                    <div class="content">
                        <a href="${pageContext.request.contextPath}/logout">Sair</a>                                
                    </div>
                </div>
                <div class="face face2">
                    <h2>Sair</h2>
                </div>
            </div>                
        </div>
                    <div hidden="" class="integrantes">
            <h3>Desenvolvedores</h3>
            <ul class="listaDevs">
                <li>Henrique Bastos</li>
                <li>Gabriel Isidorio</li>
                <li>Marco Aurelio</li>
                <li>Lucas Souza</li>
                <li>Thiago Santos</li>            
            </ul>
        </div>
    </body>
</html>


<%-- VERIFICAR O QUE É ISSO

<%-- 
    Document   : index
    Created on : 11/11/2019, 18:50:45
    Author     : thiago.srocha4
--% >

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>

<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="icon" type="image/png" href="img/icon-controle-pequeno.png"/>                
        <meta charset="UTF-8">
    </head>
    <body>
                <div class="container">
                <div class="card">
                    <div class="face face1">
                        <div class="content">

                            <a href="input?action=FormCadastrarEmpresa">Nova Empresa</a>
                            <a href="input?action=ListarEmpresas">Listar Empresas</a>
                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Empresas</h2>
                    </div>
                </div>
                    
                <c:if test="${sessionScope.usuario.departamento == 'Retaguarda'}">
                    <div class="card">
                        <div class="face face1">
                            <div class="content">

                                <a href="${pageContext.request.contextPath}/tads/inputProduto?action=FormCadastrarProduto">Novo Produto</a>
                                <a href="inputProduto?action=ListarProduto">Listar Produtos</a>
                            </div>
                        </div>
                        <div class="face face2">
                            <h2>Produto</h2>
                        </div>
                    </div>
                </c:if>
                
                <c:if test="${sessionScope.usuario.departamento == 'Vendas'}">
                    <div class="card">
                        <div class="face face1">
                            <div class="content">

                                <a href="${pageContext.request.contextPath}/tads/inputCliente?action=FormCadastrarCliente">Novo Cliente</a>
                                <a href="inputCliente?action=ListarCliente">Listar Clientes</a>
                            </div>
                        </div>
                        <div class="face face2">
                            <h2>Cliente</h2>
                        </div>
                    </div>
                </c:if>
                    
                <div class="card">
                    <div class="face face1">
                        <div class="content">

                            <a href="${pageContext.request.contextPath}/tads/inputFuncionario?action=FormCadastrarFuncionario">Novo Funcionario</a>
                            <a href="${pageContext.request.contextPath}/tads/inputFuncionario?action=ListarFuncionarios">Manutenção de Funcionario</a>
                        </div>
                    </div>
                    <div class="face face2">
                        <h2>Funcionario</h2>
                    </div>
                </div>
                    
                <c:if test="${sessionScope.usuario.departamento == 'Vendas'}">
                    <div class="card">
                       <div class="face face1">
                           <div class="content">

                               <a href="inputVenda?action=FormVenda">Nova Venda</a>

                           </div>
                       </div>
                       <div class="face face2">
                           <h2>Venda</h2>
                       </div>
                   </div>
                </c:if> 
                            <c:if test="${sessionScope.usuario.departamento == 'Vendas'}">
                    <div class="card">
                       <div class="face face1">
                           <div class="content">

                               <a href="inputVenda?action=FormVenda">Nova Venda</a>

                           </div>
                       </div>
                       <div class="face face2">
                           <h2>Venda</h2>
                       </div>
                   </div>
                </c:if> 
                    
                
                    <div class="card">
                        <div class="face face1">
                            <div class="content">
                                <a href="inputUsuario?action=ListarFuncionariosUsuarioCadastravel">Novo Usuário</a>    
                                <a href="inputUsuario?action=ListarUsuarios">Manutenção de Usuários</a>
                            </div>
                        </div>
                        <div class="face face2">
                            <h2>Compra</h2>
                        </div>
                    </div>
                
            </div>
    </body>
</html>


--%>