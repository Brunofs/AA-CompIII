<%@page import="entidades.Grupo"%>
<%@page import="entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<form  action="CriarCarona" method="post">
			<input hidden="true" name="idUsuario" value='<%=request.getAttribute("Usuario")%>'>
			<input hidden="true" name="idGrupo" value='<%=request.getAttribute("Grupo")%>'>
			Veiculo: <input type="text" name="idVeiculo" ><br>
			dia: <input  type="text" name="dia" ><br>
			horario de saida: <input type="text" name="horarioSaida"><br>
			Numero de vagas :<input type="text" name="numVagas"><br>
			Origem :<input type="text" name="logOrigem"><br>
			Destino :<input type="text" name="logDestino"><br>
			<input type="submit" value="Atualizar">
			<select name="tipoDocumento" id="tipoDocumento" onchange="atualizaOM()" emptyOption="true" cssClass="css_combobox" list="tipoDocumentoSet" listKey="idTipoDocumento" listValue="descricao" />
			
		</form>
</body>
</html>