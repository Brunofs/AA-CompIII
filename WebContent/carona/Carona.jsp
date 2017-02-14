<%@page import="entidades.Carona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/main.js"></script>
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
		
		<h2> Reservar Carona</h2>
	<form action="ReservarCarona" method="post">
		<input hidden="true" name="id" value=<%=carona.getId() %>>
		Email do convidado: <input type="text" name="email"><br>	
		CEP: <input type="text" name="cep" id="cep"><br>
		Endereço: <input type="text" name="endereco" id="rua"><br>
		Complemento: <input type="text" name="complemento"><br>
		Bairro: <input type="text" name="bairro" id="bairro"><br>
		Cidade: <input type="text" name="cidade" id="cidade"><br>
		Estado: <input type="text" name="cidade" id = "estado"><br>	
		<input type="submit" value="Convidar">
	</form>
		

</body>
</html>