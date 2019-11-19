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
	<link rel="stylesheet" type="text/css" href="css/relatorio.css">
	<style>


		.box{
		display: inline-block;
	}

		#container {
			position: absolute;
			top: 50%;
			left: 50%;
			margin-right: -50%;
			transform: translate(-50%,-50%);
	}

	body{

		display: flex;
		justify-content: center;
		align-items: center;
		min-height: 100vh;
		background: #00d0ff;
		background-image: url("../img/controle.jpg");
		background-size: cover;
		
		background-repeat: no-repeat;
		background-position: center;

}
	
			
		</style>
</head>

<body>
	<f:setLocale value="pt-BR" />

	<div id="container">

		<div id="box1" class="box">
			<table id="faturaDiaria">
				<thead>
					<th>DATA_VENDA</th>
					<th>EMPRESA</th>
					<th>TOTAL</th>

				</thead>
				<tbody>
					<c:forEach items="${faturaDia}" var="v">
						<tr>

							<td>
								<f:formatDate pattern="dd-MM-yyyy" value="${v.getDATA_VENDA()}" />
							</td>
							<td>
								<c:out value="${v.getEMPRESA()}" />
							</td>
							<td>
								<f:formatNumber value="${v.getTOTAL()}" type="currency" />
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div id="box2" class="box">
			<table id="top10">
				<thead>
					<th>DATA_VENDA</th>
					<th>PRODUTO</th>
					<th>EMPRESA</th>
					<th>QUANTIDADE</th>

				</thead>
				<tbody>
					<c:forEach items="${top10}" var="t">
						<tr>

							<td>
								<f:formatDate pattern="dd-MM-yyyy" value="${t.getDATA_VENDA()}" />
							</td>
							<td>
								<c:out value="${t.getPRODUTO()}" />
							</td>
							<td>
								<c:out value="${t.getEMPRESA()}" />
							</td>
							<td>
								<c:out value="${t.getQUANTIDADE()}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div id="box3" class="box">
			<table id="totalEmpresa">
				<thead>
					<th>EMPRESA</th>
					<th>TOTAL_FATURADO</th>
					<th>PORCENTAGEM</th>

				</thead>
				<tbody>
					<c:forEach items="${totalEmpresa}" var="t">
						<tr>
							<td>
								<c:out value="${t.getEMPRESA()}" />
							</td>
							<td>
								<f:formatNumber value="${t.getTOTAL_FATURADO()}" type="currency" />
							</td>
							<td>
								<f:formatNumber type="number" pattern="#.##%" value="${t.getPORCENTAGEM()}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>

</html>