<%-- 
    Document   : alterarEmpresa
    Created on : 13/10/2019, 18:04:16
    Author     : Thiago
--%>

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
		<div class="container">
			<h2>Alterar Dados da Empresa</h2>
			<form action="\TadsGames\cadastroEmpresa" method="post">
				<div>
                                        <label>Nome Empresa</label>
					<input type="text" name="nome" required>
					
				</div>
				<div>
                                        <label>CNPJ</label>
					<input type="text" name="cnpj" required>
					
				</div>
				<div>
                                        <label>Data de Criação</label>
					<input type="date" name="dataCriacao" required>
					
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
                                    <select name="cidade" required="">
                                            <option disabled selected="">Escolha a Cidade</option>
                                            <c:forEach var="cid" items="${cids}">
                                                <option value="${cid.getIdCidade()}"><c:out value="${cid.getNomeCidade()}"/></option>
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
                            <button type="submit">Cadastrar</button>
			</form>
		</div>
	</body>
</html>
