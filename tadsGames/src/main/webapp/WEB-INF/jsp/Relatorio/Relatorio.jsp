<%-- 
    Document   : Relatorio
    Created on : 14/11/2019, 18:29:18
    Author     : thiago.srocha4
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Relatorio</title>
</head>
<body>
	<table id="faturaDiaria">
		<thead>
			<th>DATA_VENDA</th>
			<th>EMPRESA</th>
			<th>TOTAL</th>

		</thead>
		<tbody>
                    <c:forEach items="${faturaDia}" var="v">
                            <tr>
                                <td><c:out value="${v.getDATA_VENDA()}"/></td>
                                <td><c:out value="${v.getEMPRESA()}"/></td>
                                <td><c:out value="${v.getTOTAL()}"/></td>
                            </tr>
                    </c:forEach>
		</tbody>
	</table>

	<table id="top10">
		<thead>
			<th>DATA_VENDA</th>
			<th>PRODUTO</th>
			<th>EMPRESA</th>
			<th>QUANTIDADE</th>

		</thead>
		<tbody>
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>

	<table id="totalEmpresa">
		<thead>
			<th>EMPRESA</th>
			<th>TOTAL_FATURADO</th>
			<th>PORCENTAGEM</th>

		</thead>
		<tbody>
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>