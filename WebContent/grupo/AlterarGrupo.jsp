<%@page import="dados.GrupoGateway"%>
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
	<%GrupoGateway grupo = (GrupoGateway) request.getAttribute("Grupo");%>
	
	<form  action="AlterarGrupo" method="post">
		<input hidden="true" name="id" value=<%=grupo.getId() %>>
		Nome: <input type="text" name="nome" value='<%=grupo.getNome()%>'><br>
		Descri��o: <input  type="text" name="descricao" value='<%=grupo.getDescricao()%>'><br>
		Lista de Regras <input readOnly="true"type="text" name="regras"value='<%=grupo.getRegras()%>'><br>
		Limite de Avalia��es negativas <input type="text" name="limite" value='<%=grupo.getLimAvalicao() %>'><br>
		<input type="submit" value="Atualizar">
	</form>
	
	<form action="ConvidarUsuario" method="post">
		<input hidden="true" name="id" value=<%=grupo.getId() %>>
		Email do convidado: <input type="text" name="email">		
		<input type="submit" value="Convidar">
	</form>

</body>
</html>