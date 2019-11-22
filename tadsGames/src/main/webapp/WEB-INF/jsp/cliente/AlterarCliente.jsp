<%-- 
    Document   : Cliente
    Created on : 10/10/2019, 20:04:59
    Author     : henrique.abastos
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edição de Cliente</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../css/formularios.css">
        <link rel="icon" href="../img/icon-controle-pequeno.png">
    </head>
    <body>



        <div class="container">
            <h2 class="titulo">Alterar de Clientes</h2>
            <form method="post" action="${pageContext.request.contextPath}/tads/inputCliente?action=EditarCliente" novalidate >

                <label for="nome">Nome</label>
                <input type="text" id="idCliente" hidden="" name="idCliente" value="${c.getIdCliente()}">
                <input type="text" id="nome" name="nome" value="${c.getNome()}" placeholder="Digite seu nome...">
                <c:if test="${validacaoNome}">
                    <div class="erro-input com-erro">
                        Digite mais de 1 e menos de 50 caracteres
                    </div>
                </c:if>
                <c:if test="${validacaoNome2}">
                    <div class="erro-input com-erro">
                        É permitido somente caracteres alfabeticos sem acentuação
                    </div>
                </c:if>
                <label for="sobrenome">Sobrenome</label>
                <input type="text" id="sobrenome" name="sobrenome"  value="${c.getSobrenome()}" placeholder="Digite seu Sobrenome...">
                <c:if test="${validacaoSobrenome}">
                        <div class="erro-input com-erro">
                            Digite mais de 1 e menos de 50 caracteres
                        </div>
                </c:if>
                <c:if test="${validacaoSobrenome2}">
                    <div class="erro-input com-erro">
                        É permitido somente caracteres alfabeticos sem acentuação
                    </div>
                </c:if>
                <label for="dtNasc">Data de Nascimento</label>
                <input type="date" id="dtNasc" name="dtNasc"  value="${c.getDtNasc()}" placeholder="Digite o CPF...">
                <c:if test="${validacaoDtNasc}">
                    <div class="erro-input com-erro">
                        Escolha uma data válida
                    </div>
                </c:if>

                <c:if test="${c.getSexo() == 'F'}">
                <label>Sexo</label>
                <input type="radio" name="sexo"  id="optSexoF" value="F" checked />
                <label for="optSexoF"> Feminino </label>
                <input type="radio" name="sexo" id="optSexoM" value="M" />
                <label for="optSexoM"> Masculino </label>
                </c:if>
                <c:if test="${c.getSexo() == 'M'}">
                <label>Sexo</label>
                <input type="radio" name="sexo"  id="optSexoF" value="F"  />
                <label for="optSexoF"> Feminino </label>
                <input type="radio" name="sexo" id="optSexoM" value="M" checked/>
                <label for="optSexoM"> Masculino </label>
                </c:if>
                

                <br><br>
                <label for="tpEmpresa" >Empresa</label>
                <select id="empresa"  required=""name="tpEmpresa" >
                    <option selected="" value="${c.getIdempresa()}"><c:out value="${c.getNomeEmpresa()}"/></option>
                    <c:forEach items="${listaEmpresa}" var="e">
                        <option value="${e.getIdEmpresa()}"><c:out value="${e.getNome()}"/></option>
                    </c:forEach>
                </select>
                <c:if test="${validacaoEmpresa}">
                    <div class="erro-input com-erro">
                        É obrigatório selecionar uma empresa
                    </div>
                </c:if>

                <label>Status</label>
                <c:if test="${c.getAtivo() == true}">
                <input type="radio" name="status" id="optStatusTrue" value="true" checked />
                <label for="optAtivo">Ativo</label>
                <input type="radio" name="status" id="optoptStatusFalse" value="false" />
                <label for="optInativo"> Inativo</label>
                </c:if>
                <c:if test="${c.getAtivo() == false}">
                <input type="radio" name="status" id="optStatusTrue" value="true"  />
                <label for="optAtivo">Ativo</label>
                <input type="radio" name="status" id="optoptStatusFalse" value="false" checked />
                <label for="optInativo"> Inativo</label>
                </c:if>
                
                <div class="teste">
                    <button type="submit">Enviar</button>
                    <button type="reset">Resetar dados</button>
                    <button><a href="${pageContext.request.contextPath}/home">Sair</a></button>
                    <!--<a href="#" role="button">Cancelar</a>-->   
                </div>

            </form>
                    


        </div>

    </body>
</html>