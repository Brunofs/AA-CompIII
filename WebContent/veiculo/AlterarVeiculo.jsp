<%@page import="entidades.Veiculo"%>
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
<%Veiculo veiculo = (Veiculo) request.getAttribute("Veiculo");%>

		<form  action="AlterarVeiculo" method="post">
			<input hidden="true" name="id"value='<%=veiculo.getId() %>'>
			<input hidden="true" name="usuario_id"value='<%=veiculo.getIdUser() %>'>
			Modelo: <input readOnly="true"type="text" name="modelo" value='<%=veiculo.getModelo() %>'><br>
			Placa: <input readOnly="true" type="text" name="placa" value='<%=veiculo.getPlaca()%>'><br>
			cor: <input type="text" name="cor" value='<%=veiculo.getCor()%>'><br>
			<input type="submit" value="criar">
		</form>
</body>
</html>