package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import dados.Conexao;
import excecoes.ConexaoException;


public class UsuarioGateway {
	
	public long id;
	public String nome;
	public String email;
	public String telefone;
	
	public UsuarioGateway(){
	}
	
	
	
	public UsuarioGateway(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}



	public void alterarUsuario()throws ConexaoException, SQLException, ClassNotFoundException {
		
		Conexao.initConnection();
		
		String sql = "UPDATE USUARIO SET nome = ?, telefone =? WHERE ID = " + this.getId() + ";";
		
		PreparedStatement psmt = Conexao.prepare(sql);
		
		psmt.setString(1, this.getNome());
		psmt.setString(2, this.getTelefone());
		
		int linhasAfetadas = psmt.executeUpdate();
		
		if (linhasAfetadas == 0) {
			Conexao.rollBack();
			Conexao.closeConnection();
			throw new ConexaoException();
		}else{
			Conexao.commit();
			Conexao.closeConnection();
		}
		
		
	}
	
	public void deletarUsuario()throws ConexaoException, SQLException, ClassNotFoundException {
		
		Conexao.initConnection();
		String sql = "DELETE from usuario where id = " + this.id + ";";
		Statement smt = Conexao.prepare();
		
		int linhasAfetadas = smt.executeUpdate(sql);
	
		if (linhasAfetadas == 0) {
			Conexao.rollBack();
			Conexao.closeConnection();
			throw new ConexaoException();
		}else{
			Conexao.commit();
		}
	}
	
	public void salvarUsuario()  throws ConexaoException, SQLException, ClassNotFoundException {
			Conexao.initConnection();
			String sql = "INSERT INTO usuario (nome,email,telefone) VALUES(?,?,?);";
			PreparedStatement psmt = Conexao.prepare(sql);
			psmt.setString(1, this.getNome());
			psmt.setString(2, this.getEmail());
			psmt.setString(3, this.getTelefone());
			int linhasAfetadas = psmt.executeUpdate();

			if (linhasAfetadas == 0) {
				throw new ConexaoException();
			}
			
	        Conexao.commit();
			Conexao.closeConnection();
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
