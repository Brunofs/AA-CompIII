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


	<tr>
		<h2>Contatos do Motorista</h2>
		<form  action="AlterarUsuario" method="post">
			Nome: <input readOnly="true" type="text" name="nome" value='<%=usuario.getNome()%>'><br>
			Email: <input  readOnly="true" type="text" name="email" value='<%=usuario.getEmail()%>'><br>
			Telefone <input readOnly="true" type="text" name="telefone" value='<%=usuario.getTelefone()%>'><br>
		</form>
	</tr>

</body>
</html>