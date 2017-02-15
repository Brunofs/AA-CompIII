<%@page import="entidades.Grupo"%>
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
	<%Usuario usuario = (Usuario) request.getAttribute("Usuario");%>
	<%Grupo grupo = (Grupo) request.getAttribute("Grupo");%>
	
	<form  action="AlterarGrupo" method="get">
	<h2>Informações do grupo</h2>	
		<input readOnly="true" hidden="true" name="idUsuario" value=<%=usuario.getId() %>>
		<input readOnly="true" hidden="true" name="idGrupo" value=<%=grupo.getId() %>>
		Nome: <input readOnly="true" type="text" name="nome" value='<%=grupo.getNome()%>'><br>
		Descrição: <input readOnly="true" type="text" name="descricao" value='<%=grupo.getDescricao()%>'><br>
		Lista de Regras <input readOnly="true"type="text" name="regras"value='<%=grupo.getRegras()%>'><br>
		Limite de Avaliações negativas <input readOnly="true" type="text" name="limite" value='<%=grupo.getLimite() %>'><br>
		<input type="submit" value="alterar">
	</form>
	<br>
	<br>
	
	<form action="ConvidarUsuario" method="post">
		<input hidden="true" name="idUser" value=<%=usuario.getId() %>>
		<input hidden="true" name="id" value=<%=grupo.getId() %>>
		Email do convidado: <input type="text" name="email">		
		<input type="submit" value="Convidar">
	</form>


<h2> Caronas</h2>
	<!-- 	Funcionando -->
	<form action="CriarCarona" method="get">
		<input hidden="true" name="idUsuario" value=<%=usuario.getId() %>>
		<input hidden="true" name="idGrupo" value=<%=grupo.getId() %>>
		<input type="submit" value="Criar Carona neste Grupo">
	</form>
	
	<!-- Pronto -->
	<form action="ListarCaronas" method="get">
		<input hidden="true" name="idUsuario" value=<%=usuario.getId() %>>
		<input hidden="true" name="idGrupo" value=<%=grupo.getId() %>>
		<input type="submit" value="VerCaronas">
	</form>
		
	
<!-- 	Botão ainda não funciona Criar Servlet -->
	<form action="SairUsuario" method="post">
		<input hidden="true" name="idUser" value=<%=usuario.getId() %>>
		<input hidden="true" name="id" value=<%=grupo.getId() %>>
		<input type="submit" value="Sair desse Grupo">
	</form>

</body>
</html>