<%@page import="dados.UsuarioGateway"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criar Veiculo</title>
</head>
<body>
<%UsuarioGateway usuario = (UsuarioGateway) request.getAttribute("Usuario");%>

		<form  action="CriarVeiculo" method="post">
			<input hidden="true" name="id"value='<%=usuario.getId() %>'>
			Modelo: <input type="text" name="modelo"><br>
			Placa: <input type="text" name="placa"><br>
			cor: <input type="text" name="cor"><br>
			<input type="submit" value="criar">
		</form>
</body>
</html>