package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excecoes.ConexaoException;
import util.Constants;

public class UsuarioGrupoGateway {
	
	long id_usuario;
	long id_grupo;
	
	
	public UsuarioGrupoGateway(long id_grupo){
		super();
		this.id_grupo = id_grupo;
	}
	
	public UsuarioGrupoGateway(long id_usuario, long id_grupo) {
		super();
		this.id_usuario = id_usuario;
		this.id_grupo = id_grupo;
	}

	public void convidarUsuario(String emailConvidado){
		
		
			try {
				Conexao.initConnection();
				String sql = "SELECT * FROM usuario where email='"+emailConvidado+"';";
				Statement psmt = Conexao.prepare();
				ResultSet result = psmt.executeQuery(sql);
				
				if(result.next()) {
					String nome = result.getString("nome");
					String email = result.getString("email");
					String telefone = result.getString("telefone");
					UsuarioGateway user = new UsuarioGateway(nome,email,telefone);
					this.setId_usuario(result.getLong("id"));
				}
				
				sql = "INSERT INTO usuario_grupo (usuario_id,grupo_id,situacao) VALUES(?,?,?);";
				PreparedStatement psmtt = Conexao.prepare(sql);
				psmtt.setLong(1, this.id_usuario);
				psmtt.setLong(2, this.id_grupo);
				psmtt.setString(3, Constants.ATIVO);
				psmtt.executeUpdate();
				
				Conexao.commit();
				Conexao.closeConnection();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}



	public long getId_grupo() {
		return id_grupo;
	}



	public void setId_grupo(long id_grupo) {
		this.id_grupo = id_grupo;
	}
	
	
}
