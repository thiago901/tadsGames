<%-- 
    Document   : listarCliente
    Created on : 24/10/2019, 15:08:48
    Author     : lucas
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/tabelasListagem.css">
    </head>
    <body>
        <div class="container">
            <h1 class="titulo">Listar Clientes</h1>
            <input type="text" id="pesquisaClientes" placeholder="Digite um nome..."</input>
        <table border="1">
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Sobrenome</th>
                                    <th>CPF</th>
                                    <th>Data Nasc.</th>
                                    <th>Sexo</th>
                                    <th>Status</th>
                                    <th>Alterar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${lista}" var="c">
                                    <tr>
                                        <td class="idCliente" hidden><c:out value="${c.getIdCliente()}" /></td>
                                        <td class="nome"><c:out value="${c.getNome()}" /></td>
                                        <td class="sobrenome"><c:out value="${c.getSobrenome()}" /></td>
                                        <td class="cpf"><c:out value="${c.getCpf()}" /></td>
                                        <td class="dtNasc"><c:out value="${c.getDtNasc()}" /></td>
                                        <td class="sexo"><c:out value="${c.getSexo()}" /></td>
                                        <td class="idEmpresa" hidden><c:out value="${c.getIdEmpresa()}" /></td>
                                        <td class="ativo"><c:out value="${c.getAtivo()}" /></td>
                                        <td value="${c.getIdCliente()}"><a href="inputCliente?action=FormEditarCliente&idCliente=${c.getIdCliente()}">Alterar</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
        </div>
    </body>
</html>
