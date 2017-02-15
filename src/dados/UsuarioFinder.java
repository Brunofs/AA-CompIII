package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.Conexao;

public class UsuarioFinder {
	
	
	public static List<UsuarioGateway> listarTodos(){
		ArrayList<UsuarioGateway> list = new ArrayList<UsuarioGateway>();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM usuario;";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			
			while(result.next()) {
				String nome = result.getString("nome");
				String email = result.getString("email");
				String telefone = result.getString("telefone");
				UsuarioGateway user =new UsuarioGateway(nome,email,telefone);
				user.setId(result.getLong("id"));
				list.add(user);
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return list;
	}
	
	
	public static UsuarioGateway recuperaUsuarioPorEmail(String emaill){
		UsuarioGateway userR = null;
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM usuario where email='"+emaill+"';";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			if(result.next()) {
				String nome = result.getString("nome");
				String email = result.getString("email");
				String telefone = result.getString("telefone");
				UsuarioGateway user = new UsuarioGateway(nome,email,telefone);
				user.setId(result.getLong("id"));
				userR = user;
			}
			
			Conexao.closeConnection();
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	return userR;
	}
	
	public static UsuarioGateway recuperaUsuario(long id){
		UsuarioGateway userR = new UsuarioGateway();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM usuario where id="+id+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			if(result.next()) {
				String nome = result.getString("nome");
				String email = result.getString("email");
				String telefone = result.getString("telefone");
				UsuarioGateway user = new UsuarioGateway(nome,email,telefone);
				user.setId(result.getLong("id"));
				userR = user;
			}
			
			Conexao.closeConnection();
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	return userR;
	}
}
