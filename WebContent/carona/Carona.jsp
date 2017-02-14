<%@page import="entidades.Carona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 	Carona carona = (Carona) request.getAttribute("Carona");
		%>
	
	<form  action="AltearCarona" method="get">
			<input hidden="true" name="idUsuario" value='<%=request.getAttribute("Usuario")%>'>
			Veiculo: <input type="text" name="idVeiculo" value='<%=carona.getIdVeiculo()%>' ><br>
			dia: <input  type="text" name="dia" value='<%=carona.getData()%>'><br>
			horario de saida: <input type="text" name="horarioSaida" value='<%=carona.getHorarioSaida()%>'><br>
			Numero de vagas :<input type="text" name="numVagas" value='<%=carona.getNumVagas()%>'><br>
			Origem :<input type="text" name="logOrigem" value='<%=carona.getLogOrigem()%>'><br>
			Destino :<input type="text" name="logDestino" value='<%=carona.getLogDestino()%>'><br>
			<input type="submit" value="Atualizar">
			
		</form>

</body>
</html>