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
            <h2 class="titulo">Cadastro de Clientes</h2>
            <form method="post" action="${pageContext.request.contextPath}/inputCliente?action=CadastrarCliente" novalidate >
                
                    <label for="nome">Nome</label>
                    <input required="" type="text" id="nome" name="nome" placeholder="Digite seu nome...">

                    <label for="sobrenome">Sobrenome</label>
                    <input required="" type="text" id="sobrenome" name="sobrenome" placeholder="Digite seu Sobrenome...">

                    <label for="cpf">CPF</label>
                    <input required="" type="text" id="cpf" name="cpf" placeholder="Digite o CPF...">

                    
                        <label for="dtNasc">Data de Nascimento</label>
                        <input required="" type="date" id="dtNasc" name="dtNasc" placeholder="Digite o CPF...">
                    

                    
                        <label>Sexo</label>
                        <input type="radio" name="sexo"  id="optSexoF" value="F" checked />
                        <label for="optSexoF"> Feminino </label>

                        <input type="radio" name="sexo" id="optSexoM" value="M" />
                        <label for="optSexoM"> Masculino </label>
                        <br>
                        <br>
                        
                         <label>Status</label>

                        <input type="radio" name="status" id="optStatusTrue" value="true" checked />
                        <label for="optAtivo">Ativo</label>

                        <input type="radio" name="status" id="optoptStatusFalse" value="false" />
                        <label for="optInativo"> Inativo</label>
                    
                        <br>
                        <br>
                    <label for="tpEmpresa" >Empresa</label>
                    <select id="empresa" required="" name="tpEmpresa" >
                        <option selected="" disabled=""><c:out value="Selecione uma Empresa"/></option>
                        <c:forEach items="${listaEmpresa}" var="e">
                            <option value="${e.getIdEmpresa()}"><c:out value="${e.getNome()}"/></option>
                        </c:forEach>
                    </select>

                    
                       
                    
                    <div class="teste">
                        <button type="submit">Cadastrar</button>
                        <button type="reset">Resetar dados</button>
                        <button type="submit" ><a href="${pageContext.request.contextPath}">Sair</a></button>
                        <!--<a href="#" role="button">Cancelar</a>-->
                    </div>
                
            </form>
        </div>

    </body>
</html>