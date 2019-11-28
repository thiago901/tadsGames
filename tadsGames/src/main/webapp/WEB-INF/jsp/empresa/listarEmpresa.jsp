<%-- 
    Document   : listarEmpresa
    Created on : 13/10/2019, 13:16:06
    Author     : Thiago
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listar Empresa</title>	
        <link rel="stylesheet" type="text/css" href="../css/tabelasListagem.css">
        <link rel="icon" href="../img/icon-controle-pequeno.png">
    </head>
    <body>
        <div class="fundo"></div>
        <div class="container">
            <h1 class="titulo">Lista de Empresas</h1>
            
            
            
            <input type="text" id="nomePesquisa" placeholder="Digite um Nome">

            <table>
                <thead>
                    <tr>
                        <th hidden="">Id</th>
                        <th>Nome</th>
                        <th>CNPJ</th>
                        <th>Data de Criação</th>
                        <th>UF</th>
                        <th>Cidade</th>
                        <th>Região</th>
                        <th>Status</th>
                        <th hidden="">Matiz</th>
                        <th>Editar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="e" items="${lista}">
                        <tr class="empresa">
                            <td class="idEmpresa" hidden=""><c:out value="${e.getIdEmpresa()}"/></td>
                            <td class="nome"><c:out value="${e.getNome()}"/></td>
                            <td class="cnpj"><c:out value="${e.getCnpj()}"/></td>
                            <td class="dataCriacao"><c:out value="${e.getDataCriacao()}"/></td>
                            <td class="idEstado" hidden=""><c:out value="${e.getIdEstado()}"/></td>
                            <td class="uf"><c:out value="${e.getUf()}"/></td>
                            <td class="idCidade" hidden><c:out value="${e.getIdCidade()}"/></td>
                            <td class="cidade"><c:out value="${e.getNomeCidade()}"/></td>
                            <td class="regiao"><c:out value="${e.getRegiao()}"/></td>
                            <td class="status">
                                <c:if test="${e.getAtivo()==true}">Sim</td></c:if>
                            <c:if test="${e.getAtivo()==false}">Não</td></c:if>
                            <td class="matiz" hidden=""><c:out value="${e.getMatriz()}"/></td>
                            <td class="altera" value="${e.getIdEmpresa()}"><a href="input?action=FormEditarEmpresa&id=${e.getIdEmpresa()}"><img src="../img/alterar.png"></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="teste">
                <input name="alteraPagina" hidden="">
                <a href="${pageContext.request.contextPath}/tads/input?action=ListarEmpresas&pagina=${pagina-1}"><button type="button">Anterior</button></a>
                <h6><c:out value="${pagina}"/> de <c:out value="${qtdPagina}"/></h6>
                <a href="${pageContext.request.contextPath}/tads/input?action=ListarEmpresas&pagina=${pagina+1}"><button type="button">Proximo</button></a>
                <a href="${pageContext.request.contextPath}/home"><button type="button">Sair</button></a>
            </div>
        </div>
        <script type="text/javascript" src="../javaScript/filtraEmpresa.js"></script>
    </body>
</html>