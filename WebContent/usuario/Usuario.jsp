<%@page import="entidades.Usuario"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Usuario usuario = (Usuario) request.getAttribute("Usuario");%>
	<table>
	<tr>
		<h1>Bem vindo <%=usuario.getNome()%>!</h1><br>
		
		<h2>Alterar suas informações</h2>
		<form  action="AlterarUsuario" method="get">
			<input hidden="true" name="id"value='<%=usuario.getId() %>'>
			<input type="submit" value="Atualizar">
		</form>
	</tr>
	
	<tr>
	<h2>Grupo</h2>
	<td>
		<form action="CriarGrupo" method="get">
			<input hidden="true" name="id"value='<%=usuario.getId()%>'>
			<input type="submit" value="Criar Grupo">
		</form>
	</td>
		
	<td>
		<form action="ListarGrupos" method="get">
			<input hidden="true" name="id"value='<%=usuario.getId()%>'>
			<input type="submit" value="Meus Grupos">
		</form>
	</td>
	</tr>
	
	<tr><td>
		<h2>Carro</h2>
		<form action="CriarVeiculo" method="get">
			<input hidden="true" name="id"value='<%=usuario.getId()%>'>
			<input type="submit" value="Criar Veiculo">
		</form>
		
		<form action="ListarVeiculos" method="get">
			<input hidden="true" name="id"value='<%=usuario.getId()%>'>
			<input type="submit" value="Meus Veiculos">
		</form>
	</td>
	</tr>
	</table>
</body>
</html>