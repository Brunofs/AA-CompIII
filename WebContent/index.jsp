<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Pagina Principal</h1>

<h1>Usuario</h1>

<table>
<tr>
	<td>
		<form action="./CriarUsuario.jsp" method="get">
			<input type="submit" name="navegacao" value="criar">
		</form>
	</td>
	<td>
		<form action="ListarUsuario" method="post">
			<input type="submit" name="navegacao" value="listar usuarios">
		</form>
	</td>
	<td>	
		<form action="AtualizarUsuario" method="post">
			<input type="submit" name="navegacao" value="atualizar">
		</form>
	</td>
	<td>
		<form action="deletarUsuario" method="post">
			<input type="submit" name="navegacao" value="voltar">
		</form>
	</td>
	
</tr>
</table>
</body>
</html>