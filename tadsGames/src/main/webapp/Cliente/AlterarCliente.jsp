<%-- 
    Document   : Cliente
    Created on : 10/10/2019, 20:04:59
    Author     : henrique.abastos
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Cliente</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/formularios.css">
    </head>
    <body>



        <div class="container">
            <h2 class="titulo">Alterar de Clientes</h2>
            <form method="post" action="${pageContext.request.contextPath}/inputCliente?action=EditarCliente" novalidate >

                <label for="nome">Nome</label>
                <input type="text" id="idCliente" hidden="" name="idCliente" value="${c.getIdCliente()}">
                <input type="text" id="nome" name="nome" value="${c.getNome()}" placeholder="Digite seu nome...">

                <label for="sobrenome">Sobrenome</label>
                <input type="text" id="sobrenome" name="sobrenome"  value="${c.getSobrenome()}" placeholder="Digite seu Sobrenome...">

                <label for="cpf">CPF</label>
                <input type="text" id="cpf" name="cpf" value="${c.getCPF()}"  placeholder="Digite o CPF...">


                <label for="dtNasc">Data de Nascimento</label>
                <input type="date" id="dtNasc" name="dtNasc"  value="${c.getDtNasc()}" placeholder="Digite o CPF...">



                <label>Sexo</label>
                <input type="radio" name="sexo"  id="optSexoF" value="F" checked />
                <label for="optSexoF"> Feminino </label>

                <input type="radio" name="sexo" id="optSexoM" value="M" />
                <label for="optSexoM"> Masculino </label>

                <br><br>
                <label for="tpEmpresa" >Empresa</label>
                <select id="empresa"  required=""name="tpEmpresa" >
                    <option selected="" value="${c.getIdempresa()}"><c:out value="${c.getNomeEmpresa()}"/></option>
                    <c:forEach items="${listaEmpresa}" var="e">
                        <option value="${e.getIdEmpresa()}"><c:out value="${e.getNome()}"/></option>
                    </c:forEach>
                </select>


                <label>Status</label>

                <input type="radio" name="status" id="optStatusTrue" value="true" checked />
                <label for="optAtivo">Ativo</label>

                <input type="radio" name="status" id="optoptStatusFalse" value="false" />
                <label for="optInativo"> Inativo</label>

                <div class="teste">
                    <button type="submit">Enviar</button>
                    <button type="reset">Resetar dados</button>
                    <button type="submit" value="">Cancelar</button>
                    <!--<a href="#" role="button">Cancelar</a>-->
                </div>

            </form>
        </div>

    </body>
</html>