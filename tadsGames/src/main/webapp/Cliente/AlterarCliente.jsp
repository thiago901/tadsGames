<%-- 
    Document   : Cliente
    Created on : 10/10/2019, 20:04:59
    Author     : henrique.abastos
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Cliente</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box;}

            /* ENTRADAS ONDE O TIPO SEJA TEXTO, COMBO E TEXTAREA */
            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
                resize: vertical;
            }

            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            fieldset{
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
                resize: vertical;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                position: absolute;
                left: 25%;
                width: 50%;
                border: 2px solid gray;
                border-radius: 5px;
                padding: 20px;
            }

            .teste{
                text-align: center;

            }

            form{


            }
        </style>
    </head>
    <body>

        <h3 class="teste">Alterar de Clientes</h3>

        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/inputCliente?action=EditarCliente" novalidate >
                <fieldset>
                    <label for="nome">Nome</label>
                    <input type="text" id="idCliente" hidden="" name="idCliente" value="${c.getIdCliente()}">
                    <input type="text" id="nome" name="nome" value="${c.getNome()}" placeholder="Digite seu nome...">

                    <label for="sobrenome">Sobrenome</label>
                    <input type="text" id="sobrenome" name="sobrenome"  value="${c.getSobrenome()}" placeholder="Digite seu Sobrenome...">

                    <label for="cpf">CPF</label>
                    <input type="text" id="cpf" name="cpf" value="${c.getCPF()}"  placeholder="Digite o CPF...">

                    <fieldset>
                        <label for="dtNasc">Data de Nascimento</label>
                        <input type="date" id="dtNasc" name="dtNasc"  value="${c.getDtNasc()}" placeholder="Digite o CPF...">
                    </fieldset>

                    <fieldset>
                        <legend>Sexo</legend>
                        <input type="radio" name="sexo"  id="optSexoF" value="F" checked />
                        <label for="optSexoF"> Feminino </label>

                        <input type="radio" name="sexo" id="optSexoM" value="M" />
                        <label for="optSexoM"> Masculino </label>
                    </fieldset>

                    <label for="tpEmpresa" >Empresa</label>
                    <select id="empresa"  required=""name="tpEmpresa" >
                        <option selected="" value="${c.getIdempresa()}"><c:out value="${c.getNomeEmpresa()}"/></option>
                        <c:forEach items="${listaEmpresa}" var="e">
                            <option value="${e.getIdEmpresa()}"><c:out value="${e.getNome()}"/></option>
                        </c:forEach>
                    </select>

                    <fieldset>
                        <legend>Status</legend>

                        <input type="radio" name="status" id="optStatusTrue" value="true" checked />
                        <label for="optAtivo">Ativo</label>

                        <input type="radio" name="status" id="optoptStatusFalse" value="false" />
                        <label for="optInativo"> Inativo</label>
                    </fieldset>
                    <fieldset>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Sobrenome</th>
                                    <th>CPF</th>
                                    <th>Data Nasc.</th>
                                    <th>Sexo</th>
                                    <th>Empresa</th>
                                    <th>Status</th>
                                    <th>Alterar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listaCliente}" var="c">
                                    <tr>
                                        <td value="${c.getIdCliente()}">${c.getNome()}</td>
                                        <td>${c.getSobrenome()}</td>
                                        <td>${c.getCPF()}</td>
                                        <td>${c.getDtNasc()}</td>
                                        <td>${c.getSexo()}</td>
                                        <td value="${c.getIdempresa()}">${c.getNomeEmpresa()}</td>
                                        <td>${c.getAtivo()}</td>
                                        <td value="${c.getIdCliente()}"><a href="inputCliente?action=FormEditarCliente&idCliente=${c.getIdCliente()}">Alterar</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </fieldset>
                    <div class="teste">
                        <button type="submit">Enviar</button>
                        <button type="reset">Resetar dados</button>
                        <button type="submit" value="">Cancelar</button>
                        <!--<a href="#" role="button">Cancelar</a>-->
                    </div>
                </fieldset>
            </form>
        </div>

    </body>
</html>