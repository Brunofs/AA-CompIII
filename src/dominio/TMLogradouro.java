package dominio;

import java.sql.SQLException;

import dados.UsuarioGateway;
import excecoes.ConexaoException;

public class TMLogradouro {
	
	

	public static Long CriarLogradouro(String cep, String estado, String cidade, String distrito, String endereco,
			Integer numero)  throws ClassNotFoundException, ConexaoException, SQLException{
		System.out.println("TM CR");
		if(nome == null || nome.isEmpty()){
			throw new IllegalArgumentException("nome");
		}
		
		if(email == null || email.isEmpty()){
			throw new IllegalArgumentException("email");
		}
		
		if(telefone == null || telefone.isEmpty()){
			throw new IllegalArgumentException("telefone");
		}
		
		UsuarioGateway usuario = new UsuarioGateway(nome, email, telefone);
		usuario.salvarUsuario();
		long id = usuario.getId();
		return id;
	}

}
