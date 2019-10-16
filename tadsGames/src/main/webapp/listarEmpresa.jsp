<%-- 
    Document   : listarEmpresa
    Created on : 13/10/2019, 13:16:06
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Listar Empresa</title>
	<link rel="stylesheet" type="text/css" href="css/cadastroEmpresa.css">
</head>
	<body>
		<div class="container">
                    <label for="nomePesquisa">Digite um Nome</label>
                    <input type="text" id="nomePesquisa">
                    
                    <table>
                        <thead>
                                <tr>
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>CNPJ</th>
                                        <th>Data de Criação</th>
                                        <th>UF</th>
                                        <th>Cidade</th>
                                        <th>Região</th>
                                        <th>Status</th>
                                        <th>Matiz</th>
                                        <th>Editar</th>
                                </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="e" items="${lista}">
                                <tr class="empresa">
                                    <td class="idEmpresa"><c:out value="${e.getIdEmpresa()}"/></td>
                                    <td class="nome"><c:out value="${e.getNome()}"/></td>
                                    <td class="cnpj"><c:out value="${e.getCnpj()}"/></td>
                                    <td class="dataCriacao"><c:out value="${e.getDataCriacao()}"/></td>
                                    <td class="idEstado" hidden=""><c:out value="${e.getIdEstado()}"/></td>
                                    <td class="uf"><c:out value="${e.getUf()}"/></td>
                                    <td class="idCidade" hidden><c:out value="${e.getIdCidade()}"/></td>
                                    <td class="cidade"><c:out value="${e.getNomeCidade()}"/></td>
                                    <td class="regiao"><c:out value="${e.getRegiao()}"/></td>
                                    <td class="status"><c:out value="${e.getAtivo()}"/></td>
                                    <td class="matiz"><c:out value="${e.getMatriz()}"/></td>
                                    <td class="idEmpresa" value="${e.getIdEmpresa()}"><a href="input?action=FormEditarEmpresa&id=${e.getIdEmpresa()}">Alterar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
			<button>Sair</button>
		</div>
            <script type="text/javascript" src="javaScript/filtraEmpresa.js"></script>
	</body>
</html>