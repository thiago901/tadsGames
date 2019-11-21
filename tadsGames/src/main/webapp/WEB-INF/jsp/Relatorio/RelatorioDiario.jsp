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
	<link rel="stylesheet" type="text/css" href="../css/relatorioDiario.css">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'>
</head>
<body>
	<div class="fundo"></div>
	
	<div class="cards">
		
		<div  class="card">
			<h3 class="title1">Faturamento Total do Dia</h3>
			<h3 class="valor"><f:formatNumber value="${totalDiario}" type="currency" /></h3>
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
                    <h3>Faturamento Diario</h3>
		<table class="relatorio">
                    
			<thead>
				<tr class="titleTable">
					<td>Empresa</td>
					<td>Valor Faturado</td>
					<td>Participação</td>
				</tr>
			</thead>
			<tbody>
                            <c:forEach items="${relatorioDiario}" var="r">
				<tr class="contentTable">
                                    <td class="empresa"><c:out value="${r.getNome()}"/> </td>
                                    <td class="valor"><f:formatNumber value="${r.getValorFaturaB()}" type="currency" /></td>
                                    <td class="percentual"><f:formatNumber type="number" pattern="#.##%" value="${r.getValorFaturaB()/totalDiario}" /></td>
				</tr>
                            </c:forEach>
				
			</tbody>
			
		</table>
		</div>
                <div  class="card cardRelatorio1">
                    <h3>Top 10 Produtos Vendidos Hoje</h3>
		<table class="relatorio">
			<thead>
				<tr class="titleTable">
					<td>Empresa</td>
					<td>Produto</td>
					<td>Quantidade</td>
                                        <td>Valor</td>
				</tr>
			</thead>
			<tbody>
                            <c:forEach items="${top10}" var="r">
				<tr class="contentTable">
                                    <td class="empresa"><c:out value="${r.getEMPRESA()}"/> </td>
                                    <td class="empresa"><c:out value="${r.getPRODUTO()}"/> </td>
                                    <td class="valor"><c:out value="${r.getQUANTIDADE()}"/> </td>
                                    <td class="valor"><f:formatNumber value="${r.getVALOR()}" type="currency" /></td>
                                    
				</tr>
                            </c:forEach>
				
			</tbody>
			
		</table>
		</div>
	</div>	

	</div>


</body>

</html>