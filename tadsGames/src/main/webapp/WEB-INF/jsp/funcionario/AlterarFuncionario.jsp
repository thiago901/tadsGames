<%-- 
    Document   : AlterarFuncionario
    Created on : Oct 15, 2019, 11:56:56 PM
    Author     : gabri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css/formularios.css">
</head>
<body>

<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/tads/inputFuncionario?action=EditarFuncionario">
      <h1>Cadastro de Funcionários</h1> 
      <input type="hidden" name="idFuncionario" value="${funcionario.id}">
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome" value="${funcionario.nome}">
    <c:if test="${validacaoNome}">
        <div class="erro-input com-erro">
            Digite mais de 1 e menos de 50 caracteres
        </div>
    </c:if>
    
    <label for="sobrenome">Sobrenome</label>
    <input type="text" id="sobrenome" name="sobrenome" value="${funcionario.sobrenome}">
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
    <input type="date" id="dtNasc" name="dtNasc" value="${funcionario.dtNasc}">    
    <c:if test="${validacaoDtNasc}">
        <div class="erro-input com-erro">
            Escolha uma data válida
        </div>
    </c:if>
    <label for="salario">Salario</label>
    <input type="text" id="salario" name="salario" value="${funcionario.salario}">
    <c:if test="${validacaoSalario}">
        <div class="erro-input com-erro">
            Defina um salario
        </div>
    </c:if>
    <label for="depto">Departamento</label>
    <select id="depto" name="depto">
      <option selected value="${funcionario.departamento}">${funcionario.departamento}</option> 
        <c:if test="${funcionario.departamento == 'Diretoria'}">
            <option value="Retaguarda">Retaguarda</option>
            <option value="Vendas">Vendas</option>
            <option value="TI">TI</option>
            <option value="Administrativo">Administrativo</option>
        </c:if>
        <c:if test="${funcionario.departamento == 'Retaguarda'}">
            <option value="Diretor">Diretor</option>
            <option value="Vendas">Vendas</option>
            <option value="TI">TI</option>
            <option value="Administrativo">Administrativo</option>
        </c:if>
        <c:if test="${funcionario.departamento == 'Vendas'}">
            <option value="Diretor">Diretor</option>
            <option value="Retaguarda">Retaguarda</option>
            <option value="TI">TI</option>
            <option value="Administrativo">Administrativo</option>
        </c:if>
        <c:if test="${funcionario.departamento == 'TI'}">
            <option value="Diretor">Diretor</option>
            <option value="Retaguarda">Retaguarda</option>
            <option value="Vendas">Vendas</option>
            <option value="Administrativo">Administrativo</option>
        </c:if>
        <c:if test="${funcionario.departamento == 'Administrativo'}">
            <option value="Diretor">Diretor</option>
            <option value="Retaguarda">Retaguarda</option>
            <option value="Vendas">Vendas</option>
            <option value="TI">TI</option>
        </c:if>
    </select>
    <c:if test="${validacaoDept}">
        <div class="erro-input com-erro">
            Defina um departamento
        </div>
    </c:if>
    <label for="tpEmpresa">Empresa</label>
    <select id="empresa" name="tpEmpresa">
        <option selected value="${funcionario.idEmpresa}">${funcionario.nomeEmpresa}</option>
        <c:forEach items="${empresas}" var="empresa">
            <c:if test="${empresa.idEmpresa != funcionario.idEmpresa}">
                <option value="${empresa.idEmpresa}">${empresa.nome}</option>
            </c:if>
        </c:forEach>
    </select>
    <c:if test="${validacaoEmpresa}">
        <div class="erro-input com-erro">
            É obrigatório selecionar uma empresa
        </div>
    </c:if>
    <label for="tpFuncionario">Cargo</label>
    <select id="tpFuncionario" name="tpFuncionario">
        <option selected value="${funcionario.cargo}">${funcionario.cargo}</option> 
    </select>
    <c:if test="${validacaoCargo}">
        <div class="erro-input com-erro">
            É obrigatório selecionar um cargo
        </div>
    </c:if>
    <div>
        <p>Sexo</p>
        <c:if test="${funcionario.sexo == 'Masculino'}">
            <input type="radio" name="sexo" value="Masculino" checked>
            <label>Masculino</label>
            <input type="radio" name="sexo" value="Feminino">
            <label>Feminino</label>
        </c:if>
        <c:if test="${funcionario.sexo == 'Feminino'}">
            <input type="radio" name="sexo" value="Masculino">
            <label>Masculino</label>
            <input type="radio" name="sexo" value="Feminino" checked>
            <label>Feminino</label>
        </c:if> 
    </div>

    <div>
        <p>Status</p>
        <c:if test="${funcionario.status == true}">
            <input type="radio" name="status" value="true" checked>
            <label>Ativo</label>
            <input type="radio" name="status" value="false">
            <label>Inativo</label>   
        </c:if>
        <c:if test="${funcionario.status == false}">
            <input type="radio" name="status" value="true">
            <label>Ativo</label>
            <input type="radio" name="status" value="false" checked>
            <label>Inativo</label>   
        </c:if>                                
    </div>
    <br>
    <button type="submit">Enviar</button>        
  </form>
</div>
<script type="text/javascript" src="../javaScript/filtraCargo.js"></script>
</body>
</html>
