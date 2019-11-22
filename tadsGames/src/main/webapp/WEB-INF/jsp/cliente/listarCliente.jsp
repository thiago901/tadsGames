<%-- 
    Document   : listarCliente
    Created on : 24/10/2019, 15:08:48
    Author     : lucas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Clientes</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/tabelasListagem.css">
        <link rel="icon" href="../img/icon-controle-pequeno.png">
    </head>
    <body>
        <div class="container">
            <h1 class="titulo">Listar Clientes</h1>
            <input type="text" id="nomePesquisa" placeholder="Digite um nome..."</input>
            <table border="1">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                        <th>CPF</th>
                        <th>Data Nasc.</th>
                        <th>Sexo</th>
                        <th>Status</th>
                        <th>Empresa</th>
                        <th>Alterar</th>
                    </tr>
                </thead>
                <tbody>
                  
                <c:forEach items="${lista}" var="a">
                    <tr class="cliente">
                        <td class="idCliente" hidden><c:out value="${a.getIdCliente()}" /></td>
                        <td class="nome"><c:out value="${a.getNome()}" /></td>
                        <td class="sobrenome"><c:out value="${a.getSobrenome()}" /></td>
                        <td class="cpf"><c:out value="${a.getCPF()}" /></td>
                        <td class="dtNasc"><c:out value="${a.getDtNasc()}" /></td>
                        <td class="sexo"><c:out value="${a.getSexo()}" /></td>
                        <td class="ativo">
                                <c:if test="${a.getAtivo()==true}">Sim</td></c:if>
                                <c:if test="${a.getAtivo()==false}">Não</td></c:if>
                        <td class="idEmpresa" ><c:out value="${a.getNomeEmpresa()}" /></td>
                        
                        <td class="altera" value="${a.getIdCliente()}"><a href="inputCliente?action=FormEditarCliente&idCliente=${a.getIdCliente()}"><img src="../img/alterar.png"></a></td>
                    </tr>
                </c:forEach>
                    
                </tbody>
            </table>
            <div class="teste">
                <button><a href="${pageContext.request.contextPath}/home">Sair</a></button>
            </div>
        </div>
        <script type="text/javascript" src="javaScript/filtraCliente.js"></script>
    </body>
</html>
