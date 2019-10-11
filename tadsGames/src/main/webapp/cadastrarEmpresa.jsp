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
					<input type="text" name="nome" required>
					<label>Nome Empresa</label>
				</div>
				<div>
					<input type="text" name="cnpj" required>
					<label>CNPJ</label>
				</div>
				<div>
					<input type="date" name="dataCriacao" required>
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
                                    <p> Status da Empresa</p>
                                    <input type="radio" name="status" value="true" checked="">
                                    <label>Ativa</label>
                                    <input type="radio" name="status" value="false">
                                    <label>Inativa</label>
			
				</div>
                                <div>
                                    <p> Empresa Matiz</p>
                                    <input type="radio" name="matriz" value="true" id="matrizSim">
                                    <label for="matrizSim">Sim</label>
                                    <input type="radio" name="matriz" value="false" id="matrizNao" checked="">
                                    <label for="matrizNao">Não</label>
                                </div>
                            <button>Cadastrar</button>
			</form>
		</div>
	</body>
</html>
