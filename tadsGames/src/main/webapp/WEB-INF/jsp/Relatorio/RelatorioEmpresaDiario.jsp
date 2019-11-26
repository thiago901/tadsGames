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
        <link rel="stylesheet" type="text/css" href="../css/relatorioRegiao.css">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'>
    </head>
    <body>
        <div class="fundo"></div>
        <div class="container">
        <h2>Valor Total <c:out value="${ListaRegiao.get(0).getEMPRESA()}"/>: <f:formatNumber value="${valorTotal}" type="currency" /></h2>

        <table class="relatorio">
            <thead>
                <tr class="titleTable">
                    <td>Produto</td>
                    <td>Quantidade</td>
                    <td>Valor Faturado</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ListaRegiao}" var="r">
                    <tr class="contentTable">
                        <td class="empresa"><c:out value="${r.getPRODUTO()}"/> </td>
                        <td class="valor"><c:out value="${r.getQUANTIDADE()}"/></td>
                        <td class="valor"><f:formatNumber value="${r.getVALOR()}" type="currency" /></td>
                    </tr>
                </c:forEach>

            </tbody>

        </table>
        <a href="${pageContext.request.contextPath}/home"><button class="btnCadastrarVenda voltaMenu" type="button">Voltar ao Menu</button></a>
        </div>


    </body>

</html>