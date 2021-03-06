<%-- 
    Document   : ListarFuncionario
    Created on : Oct 15, 2019, 10:02:24 PM
    Author     : gabri
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionario</title>
        <link rel="stylesheet" type="text/css" href="../css/tabelasListagem.css">
    </head>
    <body>
        <div class="fundo"></div>
        <div class="container">
            <h1 class="titulo">Consulta de Funcion�rios</h1>
            <input type="text" id="pesquisaFuncionario" placeholder="Digite um Nome">
            <form method="post" action="${pageContext.request.contextPath}/listarFuncionario" novalidate>
                <table border="1">            
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Sobrenome</th>
                            <th>CPF</th>
                            <th>Data de Nascimento</th>
                            <th>Sal�rio</th>
                            <th>Departamento</th>
                            <th>Empresa</th>
                            <th>Cargo</th>
                            <th>Sexo</th>
                            <th>Status</th>
                            <th>Op��o</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${funcionarios}" var="funcionario">
                            <tr class="funcionario">
                                <td class="nome">${funcionario.nome}</td>
                                <td>${funcionario.sobrenome}</td>
                                <td>${funcionario.cpf}</td>         
                                <td>${funcionario.dtNasc}</td>
                                <td>${funcionario.salario}</td>
                                <td>${funcionario.departamento}</td>
                                <td>${funcionario.nomeEmpresa}</td>
                                <td>${funcionario.cargo}</td>
                                <td>${funcionario.sexo}</td>
                                <td class="ativo">
                                    <c:if test="${funcionario.status == true}">Sim</td></c:if>
                                <c:if test="${funcionario.status == false}">N�o</td></c:if>
                                <td class="altera" value="${funcionario.id}">
                                    <a href="inputFuncionario?action=FormEditarFuncionario&id=${funcionario.id}"><img src="../img/alterar.png"></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </form>
                        </div>
                    </tbody>
                </table>
                <a href="${pageContext.request.contextPath}/tads/inputFuncionario?action=ListarFuncionarios&pagina=${pagina-1}"><button type="button">Anterior</button></a>
                <h6><c:out value="${pagina}"/> de <c:out value="${qtdPagina}"/></h6>
                <a href="${pageContext.request.contextPath}/tads/inputFuncionario?action=ListarFuncionarios&pagina=${pagina+1}"><button type="button">Proximo</button></a>
                <a href="${pageContext.request.contextPath}/home"><button type="button">Sair</button></a>
                

                <script type="text/javascript" src="../javaScript/filtraFuncionario.js"></script>
                </body>
                </html>
