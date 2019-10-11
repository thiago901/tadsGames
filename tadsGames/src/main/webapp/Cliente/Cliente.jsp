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

        <h3 class="teste">Cadastro de Clientes</h3>

        <div class="container">
            <form method="post" action="${pageContext.request.contextPath}/formulario/funcionario" novalidate >
                <fieldset>
                    <label for="nome">Nome</label>
                    <input type="text" id="nome" name="nome" placeholder="Digite seu nome...">

                    <label for="nome">Sobrenome</label>
                    <input type="text" id="sobrenome" name="sobrenome" placeholder="Digite seu Sobrenome...">

                    <label for="cpf">CPF</label>
                    <input type="text" id="cpf" name="cpf" placeholder="Digite o CPF...">

                    <fieldset>
                        <label for="dtNasc">Data de Nascimento</label>
                        <input type="date" id="dtNasc" name="dtNasc" placeholder="Digite o CPF...">
                    </fieldset>

                    <fieldset>
                        <legend>Sexo</legend>
                        <input type="radio" name="sexo"  id="optSexoF" value="0" checked />
                        <label for="optSexoF"> Feminino </label>

                        <input type="radio" name="sexo" id="optSexoM" value="1" />
                        <label for="optSexoM"> Masculino </label>
                    </fieldset>

                    <fieldset>
                        <legend>Status</legend>

                        <input type="radio" name="status" id="optSexoF" value="0" checked />
                        <label for="optAtivo">Ativo</label>

                        <input type="radio" name="status" id="optSexoM" value="1" />
                        <label for="optInativo"> Inativo</label>

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