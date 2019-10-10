<%-- 
    Document   : cadastrarEmpresa
    Created on : 10/10/2019, 17:54:51
    Author     : thiago.srocha4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "utf-8">
		<title>Cadastro de Empresa</title>
		<link rel="stylesheet" type="text/css" href="css/cadastroEmpresa.css">
	</head>
	<body>
		<div class="box">
			<h2>Cadastre a Empresa</h2>
			<form action="\TadsGames\cadastroEmpresa" method="post">
				<div>
					<input type="text" name="nome" required>
					<label>Nome Empresa</label>
				</div>
				<div>
					<input type="text" name="cnpj" required>
					<label>CNPJ</label>
				</div>
				<div>
					<input type="text" name="endereco" required>
					<label>Endereço</label>
				</div>
		
					<button>Enviar</button>
				</div>
			</form>
		</div>
	</body>
</html>
