<%@page import="entidades.Carona"%>
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

	<table>
			<tr>
				<td>Numero de Vagas</td>
				<td>Alterar</td>
			</tr>
<% 
		List<Carona> listaCaronas = (List<Carona>) request.getAttribute("Caronas");
		for (Carona caronai : listaCaronas){
	%>
		<tr>
			<td><%=caronai.getNumVagas() %></td>
			<td><form action="LerCarona" method="get"><input hidden="true" name="idCarona" value='<%=caronai.getId()%>'><input hidden="true" name="idUsuario" value='<%=request.getAttribute("idUsuario")%>'><input type="submit" value="Editar"></form></td>
			<td><form action="FinalizarCarona" method="post"><input hidden="true" name="idCarona" value='<%=caronai.getId()%>'><input hidden="true" name="idUsuario" value='<%=request.getAttribute("idUsuario")%>'><input type="submit" value="Finalizar Carona"></form></td>
				
		</tr>
		
		<% } %>
</table>
	
</body>
</html>