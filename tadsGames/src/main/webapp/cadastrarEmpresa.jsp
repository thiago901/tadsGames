<%-- 
    Document   : cadastrarEmpresa
    Created on : 10/10/2019, 17:54:51
    Author     : thiago.srocha4
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.unidospi.model.EstadoRegiao"%>
<%@page import="br.com.unidospi.Controller.EstadoRegiaoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset = "utf-8">
		<title>Cadastro de Empresa</title>
		<link rel="stylesheet" type="text/css" href="css/cadastroEmpresa.css">
	</head>
	<body>
		<div class="box">
			<h2>Cadastre a Empresa</h2>
			<form action="\TadsGames\cadastroEmpresa" method="post">
				<div>
					<input type="text" name="" required>
					<label>Nome Empresa</label>
				</div>
				<div>
					<input type="text" name="" required>
					<label>CNPJ</label>
				</div>
				<div>
					<input type="date" name="data" required>
					<label>Data de Criação</label>
				</div>
				<div>
                                    
					<select name="estado" required="">
						<option disabled selected="">Escolha a UF</option>
                                                <c:forEach var="uf" items="${ufs}">
                                                    <option value="${uf.getId()}"><c:out value="${uf.getUf()}"/></option>
                                                </c:forEach>
					</select>
					
				</div>
				<div>
					<select name="estado" required="">
						<option disabled selected="">Status</option>
						<option>Ativo</option>
					</select>
				</div>
					<div>
					<select name="matiz" required="">
						<option disabled selected="">Matriz</option>
						<option>Sim</option>
						<option>Não</option>
					</select>
			</form>
		</div>
	</body>
</html>
