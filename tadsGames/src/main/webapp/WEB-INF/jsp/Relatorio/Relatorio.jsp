<%-- 
    Document   : Relatorio
    Created on : 14/11/2019, 18:29:18
    Author     : henrique.abastos
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
	<title>Relatorio</title>
	<link rel="stylesheet" type="text/css" href="../css/relatorio.css">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'>
</head>
<body>
	<div class="fundo"></div>
	
	<div class="cards">
		
		<div  class="card">
			<h3 class="title1">Faturamento Total do Dia</h3>
			<h3 class="valor"><f:formatNumber value="${totalMensal}" type="currency" /></h3>
		</div>
		<div  class="card">
			<h3 class="title1">Produto + Vendido do Dia</h3>
			<h3 class="title2">Jogo God Of War</h3>
			<h3 class="value">93 Unidades</h3>
		</div>
		<div  class="card card5">
			<h3 class="title1">Produto + Vendido do Dia</h3>
			<h3 class="title2">Jogo God Of War</h3>
			<h3 class="value">93 Unidades</h3>
		</div>
		<div class="card card6">
			<h3 class="title1">Produto + Vendido do Dia</h3>
			<h3 class="title2">Jogo God Of War</h3>
			<h3 class="value">93 Unidades</h3>
		</div>
		<div  class="card cardRelatorio">
		<table class="relatorio">
			<thead>
				<tr class="titleTable">
					<td>Empresa</td>
					<td>Valor Faturado (A)*</td>
					<td>Valor Faturado (B)**</td>
					<td>Variação</td>
					<td>Participação**</td>
				</tr>
			</thead>
			<tbody>
                            <c:forEach items="${relatorioGeral}" var="r">
				<tr class="contentTable">
                                    <td class="empresa"><c:out value="${r.getNome()}"/> </td>
                                    <td class="valor"><f:formatNumber value="${r.getValorFaturaA()}" type="currency" /></td>
					<td class="valor"><f:formatNumber value="${r.getValorFaturaB()}" type="currency" /></td>
					<td class="percentual"><f:formatNumber type="number" pattern="#.##%" value="${r.getVariacao()}" /></td>
					<td class="percentual"><f:formatNumber type="number" pattern="#.##%" value="${r.getValorFaturaB()/totalMensal}" /></td>
				</tr>
                            </c:forEach>
				
			</tbody>
			
		</table>
		<p>* (A) Referencia mês anterior</p>
		<p>**(B) Referencia mês corrente</p>
		</div>
	</div>
                <a href="${pageContext.request.contextPath}/home"><button class="btnCadastrarVenda voltaMenu" type="button">Voltar ao Menu</button></a>

	</div>


</body>

</html>