<%@page import="entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
				<td>Nome</td>
				<td>Alterar</td>
				<td>Deletar</td>
			</tr>
	<% 
		List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("Usuarios");
	
		for (Usuario usuarioi : listaUsuarios){
	%>
		<tr>
			<td><%=usuarioi.getNome()%></td><td><form action="AlterarUsuario" method="get"><input hidden="true" name="id" value='<%=usuarioi.getId()%>'><input type="submit" value="Editar"></form></td>
			<td><form action="DeletarUsuario" method="post"><input hidden="true" name="id" value='<%=usuarioi.getId()%>'><input type="submit" value="Deletar"></form></td></td>
		</tr>
		<% } %>
	</table>
</body>
</html>