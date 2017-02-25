<%@page import="entidades.Grupo"%>
<%@page import="entidades.Usuario"%>
<%@page import="entidades.Logradouro"%>
<%@page import="entidades.Veiculo"%>
<%@page import="java.util.*"%>
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
		<% 
			List<Logradouro> logs = (List<Logradouro>) request.getAttribute("Logradouros");
			List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("Veiculos");
		%>
		<form  action="CriarCarona" method="post">
			<input hidden="true" name="idUsuario" value='<%=request.getAttribute("Usuario")%>'>
			<input hidden="true" name="idGrupo" value='<%=request.getAttribute("Grupo")%>'>
			Veiculo: <select name="idVeiculo"><% for (Veiculo vei : veiculos){ %> <option value="<%=vei.getId()%>"><%=vei.getPlaca()%></option><%}%></select><br>
			dia: <input  type="text" name="dia" ><br>
			horario de saida: <input type="text" name="horarioSaida"><br>
			Numero de vagas :<input type="text" name="numVagas"><br>
			Origem : <select name="logOrigem"><% for (Logradouro log : logs){ %> <option value="<%=log.getId()%>"><%=log.getCep()%></option><%}%><option value = "adc-ori">Adicionar</option></select>
			 CEP: <input type="text" name="cep-ori" id="cep-ori">
			 Complemento: <input type="text" name="complemento-ori"><br>
			Destino :<select name="logDestino"><% for (Logradouro log : logs){ %> <option value="<%=log.getId()%>"><%=log.getCep()%></option><%}%><option value = "adc-des">Adicionar</option></select>
			CEP: <input type="text" name="cep-dest" id="cep-dest">
			Complemento: <input type="text" name="complemento-dest"><br>
			
			<table >
			<input hidden="true" type="text" name="endereco-ori" id="rua-ori">
			<input hidden="true" type="text" name="bairro-ori" id="bairro-ori">
			<input hidden="true" type="text" name="cidade-ori" id="cidade-ori">
			<input hidden="true" type="text" name="estado-ori" id = "estado-ori">
			<input hidden="true" type="text" name="endereco-dest" id="rua-dest">
			<input  hidden="true" type="text" name="bairro-dest" id="bairro-dest">
			<input hidden="true" type="text" name="cidade-dest" id="cidade-dest">
			<input hidden="true" type="text" name="estado-dest" id = "estado-dest">
			</table>
			
			<input type="submit" value="Criar">
		</form>
</body>
</html>