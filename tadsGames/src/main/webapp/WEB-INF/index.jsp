<%-- 
    Document   : index
    Created on : 11/11/2019, 18:50:45
    Author     : thiago.srocha4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>

<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="icon" type="image/png" href="img/icon-controle-pequeno.png"/>                
        <meta charset="UTF-8">
    </head>
    <body>
        
        <div class="container">
            <div class="card">
                <div class="face face1">
                    <div class="content">
                        
                        <a href="input?action=FormCadastrarEmpresa">Nova Empresa</a>
                        <a href="input?action=ListarEmpresas">Listar Empresas</a>
                    </div>
                </div>
                <div class="face face2">
                    <h2>Empresas</h2>
                </div>
            </div>

            <div class="card">
                <div class="face face1">
                    <div class="content">
                        
                        <a href="inputProduto?action=FormCadastrarProduto">Novo Produto</a>
                        <a href="inputProduto?action=ListarProduto">Listar Produtos</a>
                    </div>
                </div>
                <div class="face face2">
                    <h2>Produto</h2>
                </div>
            </div>
            <div class="card">
                <div class="face face1">
                    <div class="content">
                        
                        <a href="inputCliente?action=FormCadastrarCliente">Novo Cliente</a>
                        <a href="inputCliente?action=ListarCliente">Listar Clientes</a>
                    </div>
                </div>
                <div class="face face2">
                    <h2>Cliente</h2>
                </div>
            </div>

            <div class="card">
                <div class="face face1">
                    <div class="content">
                        
                        <a href="inputFuncionario?action=FormCadastrarFuncionario">Novo Funcionario</a>
                        <a href="inputFuncionario?action=ListarFuncionarios">Manutenção de Funcionario</a>
                    </div>
                </div>
                <div class="face face2">
                    <h2>Funcionario</h2>
                </div>
            </div>

             <div class="card">
                <div class="face face1">
                    <div class="content">
                        
                        <a href="inputVenda?action=FormVenda">Nova Venda</a>
                        
                    </div>
                </div>
                <div class="face face2">
                    <h2>Venda</h2>
                </div>
            </div><div class="card">
                <div class="face face1">
                    <div class="content">
                        
                        <a href="inputUsuario?action=ListarFuncionariosUsuarioCadastravel">Novo Usuário</a>                        
                    </div>
                </div>
                <div class="face face2">
                    <h2>Usuários</h2>
                </div>
            </div>
            
            
        </div>

    </body>
</html>
