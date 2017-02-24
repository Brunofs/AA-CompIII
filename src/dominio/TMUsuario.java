package dominio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.UsuarioFinder;
import dados.UsuarioGateway;
import entidades.Usuario;
import excecoes.ConexaoException;

public class TMUsuario {
	

	public TMUsuario(){
	}
	
	public static Long CriarUsuario(String email) throws ClassNotFoundException, ConexaoException, SQLException{
		if(email == null || email.isEmpty()){
			throw new IllegalArgumentException("email");
		}
		
		UsuarioGateway usuario = new UsuarioGateway(email);
		usuario.salvarUsuario();
		long id = usuario.getId();
		return id;
	}
	
	public static long alterarUsuario(long id,String nome,String telefone){
		if(nome == null || nome.isEmpty()){
			throw new IllegalArgumentException("nome");
		}
		
		if(telefone == null || telefone.isEmpty()){
			throw new IllegalArgumentException("telefone");
		}
		
		UsuarioGateway usuarioGateway = UsuarioFinder.recuperaUsuario(id);
		usuarioGateway.setNome(nome);
		usuarioGateway.setTelefone(telefone);
		usuarioGateway.setId(id);
		try {
			usuarioGateway.alterarUsuario();
		} catch (ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarioGateway.getId();
	}
	
	public static Usuario RecuperaUsuario(long id) throws Exception{
		UsuarioGateway u = UsuarioFinder.recuperaUsuario(id);
		Usuario userRet = new Usuario(u.getId(),u.getNome(),u.getEmail(),u.getTelefone());
		return userRet;
	}
	
	public static List<Usuario> RecuperaTodosUsuarios() throws Exception{
		Collection<UsuarioGateway> usuariosGateway = UsuarioFinder.listarTodos();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		for(UsuarioGateway u : usuariosGateway){
			Usuario usuario = new Usuario(u.getId(),u.getNome(), u.getEmail(), u.getTelefone());
			usuarios.add(usuario);
		}
		
		return (List<Usuario>) usuarios;
	}
	
	public static void DeletarUsuario(long id) throws Exception {
		UsuarioGateway u = UsuarioFinder.recuperaUsuario(id);
		u.deletarUsuario();
	}

	public long CriarUsuario(UsuarioGateway userCriacao) {
	
		if(userCriacao.getNome() == null || userCriacao.getNome().isEmpty()){
			throw new IllegalArgumentException("nome");
		}
		
		if(userCriacao.getEmail() == null || userCriacao.getEmail().isEmpty()){
			throw new IllegalArgumentException("email");
		}
		
		if(userCriacao.getTelefone() == null || userCriacao.getTelefone().isEmpty()){
			throw new IllegalArgumentException("telefone");
		}
		long id=-1;
		UsuarioGateway verificacao= UsuarioFinder.recuperaUsuarioPorEmail(userCriacao.getEmail());
		
		if(verificacao ==null){
			try {
				userCriacao.salvarUsuario();
				id = userCriacao.getId();
			} catch (ClassNotFoundException | ConexaoException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}else{
			throw new IllegalArgumentException("Já existe usuario com esse Email!");
		}
		
		return id;
	}
	

}
