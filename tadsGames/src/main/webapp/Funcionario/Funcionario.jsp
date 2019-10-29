<%-- 
    Document   : Funcionario
    Created on : Oct 5, 2019, 7:18:16 PM
    Author     : gabri
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/formularios.css">
</head>
<body>

<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/inputFuncionario?action=CadastrarFuncionario" novalidate>
      <h2 class="titulo">Cadastro de Funcionários</h2> 
      
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome" placeholder="Digite seu nome...">
    
    <label for="sobrenome">Sobrenome</label>
    <input type="text" id="sobrenome" name="sobrenome" placeholder="Digite seu sobrenome...">

    <label for="cpf">CPF</label>
    <input type="text" id="cpf" name="cpf" placeholder="Digite o CPF...">
    
    <label for="dtNasc">Data de Nascimento</label>
    <input type="date" id="dtNasc" name="dtNasc" placeholder="Digite o CPF...">
    
    <label for="login">Login</label>
    <input type="text" id="login" name="login" placeholder="Digite o login...">
    
    <label for="senha">Senha</label>
    <input type="password" id="senha" name="senha" placeholder="Digite a senha...">
    
    <label for="salario">Salario</label>
    <input type="text" id="salario" name="salario" placeholder="Digite o salario...">
    
    <label for="depto">Departamento</label>
    <input type="text" id="depto" name="depto" placeholder="Digite o departamento...">   
    
    <label for="tpEmpresa">Empresa</label>
    <select id="empresa" name="tpEmpresa">
        <c:forEach items="${empresas}" var="empresa">
            <option value="${empresa.idEmpresa}">${empresa.nome}</option>
        </c:forEach>
    </select>
    
    <label for="tpFuncionario">Cargo</label>
    <select id="tpFuncionario" name="tpFuncionario">
      <option value="Diretor">Diretor</option>
      <option value="Funcionario Administrativo">Funcionário Administrativo</option>
      <option value="Funcionario TI">Funcionário TI</option>
      <option value="Funcionario Venda">Funcionário Venda</option>
      <option value="Funcionario Retaguarda">Funcionário Retaguarda</option>
      <option value="Gerente Global">Gerente Global</option>
    </select>
    
    <div>
        <p>Sexo</p>
        <input type="radio" name="sexo" value="Masculino" checked="">
        <label>Masculino</label>
        <input type="radio" name="sexo" value="Feminino">
        <label>Feminino</label>                                   
    </div>

    <div>
        <p>Status</p>
        <input type="radio" name="status" value="true" checked="">
        <label>Ativo</label>
        <input type="radio" name="status" value="false">
        <label>Inativo</label>                                   
    </div>
    <button type="submit">Enviar</button>        
  </form>
</div>

</body>
</html>
