<%@page import="entidades.Veiculo"%>
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
				<td>Modelo</td>
				<td>Alterar</td>
			</tr>
<% 
		List<Veiculo> listaVeiculos = (List<Veiculo>) request.getAttribute("Veiculos");
	
		for (Veiculo veiculoi : listaVeiculos){
	%>
		<tr>
			<td><%=veiculoi.getModelo() %></td>
			<td><form action="AlterarVeiculo" method="get"><input hidden="true" name="id" value='<%=veiculoi.getId()%>'><input type="submit" value="Editar"></form></td>
		</tr>
		
		<% } %>
</table>
</body>
</html>