<%-- 
    Document   : alterarEmpresa
    Created on : 13/10/2019, 18:04:16
    Author     : Thiago
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset = "utf-8">
		<title>Alterar de Empresa</title>
		<link rel="stylesheet" type="text/css" href="css/formularios.css">
	</head>
	<body>
		<div class="container">
                    <h2 class="titulo">Alterar Dados da Empresa</h2>
			<form action="\TadsGames\input?action=EditarEmpresa" method="post">
				<div>
                                    <input type="hidden" name="idEmpresa" value="${e.getIdEmpresa()}">
                                        <label>Nome Empresa</label>
                                        <input type="text" name="nome" required value="${e.getNome()}">
					
				</div>
				<div>
                                        <label>CNPJ</label>
					<input type="text" name="cnpj" required value="${e.getCnpj()}">
					
				</div>
				<div>
                                        <label>Data de Criação</label>
					<input type="date" name="dataCriacao" required value="${e.getDataCriacao()}">
					
				</div>
                               <div>
                                    
					<select name="estado" required="">
                                            <option selected="" value="${e.getIdEstado()}"><c:out value="${e.getUf()}"/></option>
                                                <c:forEach var="uf" items="${ufs}">
                                                    <option value="${uf.getId()}"><c:out value="${uf.getUf()}"/></option>
                                                </c:forEach>
					</select>
					
				</div>
                                <div>
                                    <select name="cidade" required="">
                                        <option selected="" value="${e.getIdCidade()}"><c:out value="${e.getNomeCidade()}"/></option>
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
