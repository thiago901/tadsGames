<%-- 
    Document   : detalhePorEmpresa
    Created on : 26/11/2019, 15:13:23
    Author     : thiago.srocha4
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<div <c:if test="${top10DetalheEmpresa==null}">hidden=""</c:if> class="conteudoDetalhe">
<div class="fundo2"></div>
<div   class="detalhePorEmpresa">
    <a href="inputRelatorios?action=RelatorioDiario"><img class="icon"src="../img/cross-out.png"></a>
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
        <c:forEach items="${top10Empresa}" var="r">
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