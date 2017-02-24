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

	
	<form  action="CriarGrupo" method="post">
		<input hidden="true" name="idUsuario"value=<%=request.getAttribute("idUsuario")%>>
		Nome: <input type="text" name="nome" ><br>
		Descrição: <input  type="text" name="descricao" ><br>
		Lista de Regras <input type="text" name="regras"><br>
		Limite de Avaliações negativas <input type="text" name="limite"><br>
		<input type="submit" value="Atualizar">
	</form>

</body>
</html>