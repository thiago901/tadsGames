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
                                        <input type="text" name="nome"  value="${e.getNome()}">
					<c:if test="${erroNome}">
                                            <div class="erro-input com-erro">
                                                Digite mais de 1 caracter e menos de 50 caracteres
                                            </div>
                                         </c:if> 
				</div>
				<div>
                                        <label>CNPJ</label>
					<input type="text" name="cnpj"  value="${e.getCnpj()}">
					<c:if test="${erroCNPJ}">
                                            <div class="erro-input com-erro">
                                                Digite um CNPJ válido
                                            </div>
                                        </c:if>
				</div>
				<div>
                                        <label>Data de Criação</label>
					<input type="date" name="dataCriacao"  value="${e.getDataCriacao()}">
                                            <c:if test="${erroData}">
                                                <div class="erro-input com-erro">
                                                    Selecione uma data
                                                </div>
                                            </c:if>
					
				</div>
                               <div>
                                    
					<select name="estado" >
                                            <option selected="" value="${e.getIdEstado()}"><c:out value="${e.getUf()}"/></option>
                                                <c:forEach var="uf" items="${ufs}">
                                                    <option value="${uf.getId()}"><c:out value="${uf.getUf()}"/></option>
                                                </c:forEach>
					</select>
                                        <c:if test="${erroUF}">
                                            <div class="erro-input com-erro">
                                                Selecione uma UF
                                            </div>
                                        </c:if>
					
				</div>
                                <div>
                                    <select name="cidade" >
                                        <option selected="" value="${e.getIdCidade()}"><c:out value="${e.getNomeCidade()}"/></option>
                                            <c:forEach var="cid" items="${cids}">
                                                <option value="${cid.getIdCidade()}"><c:out value="${cid.getNomeCidade()}"/></option>
                                            </c:forEach>
                                    </select>
                                    <c:if test="${erroCidade}">
                                        <div class="erro-input com-erro">
                                            Selecione uma cidade
                                        </div>
                                    </c:if>
					
				</div>
				<div>
                                    <p> Status da Empresa</p>
                                    <c:if test="${e.getAtivo() == true}">
                                        <input type="radio" name="status" value="true" checked="">
                                        <label>Ativa</label>
                                        <input type="radio" name="status" value="false">
                                        <label>Inativa</label>
                                    </c:if>
                                    <c:if test="${e.getAtivo() == false}">
                                        <input type="radio" name="status" value="true" >
                                        <label>Ativa</label>
                                        <input type="radio" name="status" value="false"checked="">
                                        <label>Inativa</label>
                                    </c:if>
				</div>
                                <div>
                                    <p> Empresa Matiz</p>
                                    <input type="radio" name="matriz" value="true" id="matrizSim" >
                                    <label for="matrizSim">Sim</label>
                                    <input type="radio" name="matriz" value="false" id="matrizNao" checked="">
                                    <label for="matrizNao">Não</label>
                                </div>
                            <button type="submit">Cadastrar</button>
			</form>
		</div>
	</body>
</html>
