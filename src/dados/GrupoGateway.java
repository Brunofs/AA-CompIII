package dados;

import dados.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excecoes.ConexaoException;
import util.Constants;

public class GrupoGateway {
	
	long id;
	String nome;
	String descricao;
	String regras;
	int limAvalicao;
	
	public GrupoGateway(){
		
	}
	
	public GrupoGateway(long id, String nome, String descricao, String regras, int limAvalicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.regras = regras;
		this.limAvalicao = limAvalicao;
	}

	public GrupoGateway(String nome, String descricao, String regras, int limAvalicao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.regras = regras;
		this.limAvalicao = limAvalicao;
	}
	
	public void alterarGrupo()throws ConexaoException, SQLException, ClassNotFoundException {
			
			Conexao.initConnection();
			
			String sql = "UPDATE GRUPO SET nome = ?, descricao =?,limite =? WHERE ID = " + this.getId() + ";";
			
			PreparedStatement psmt = Conexao.prepare(sql);
			
			psmt.setString(1, this.getNome());
			psmt.setString(2, this.getDescricao());
			psmt.setInt(3, this.getLimAvalicao());
			
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
	
	public void salvarGrupo(long user_id)  throws ConexaoException, SQLException, ClassNotFoundException {
			
			Conexao.initConnection();
			String sql = "INSERT INTO grupo (nome,descricao,regra,limite) VALUES(?,?,?,?);";
			PreparedStatement psmt = Conexao.prepare(sql);
			psmt.setString(1, this.getNome());
			psmt.setString(2, this.getDescricao());
			psmt.setString(3, this.getRegras());
			psmt.setInt(4, this.getLimAvalicao());
			int linhasAfetadas = psmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new ConexaoException();
			}
			
			try (ResultSet generatedKeys = psmt.getGeneratedKeys()) {
			    if (generatedKeys.next()) {
			        this.setId(generatedKeys.getInt(1));
			        System.out.println(this.getId());
			    }
			    else {
			        throw new SQLException("Ocorreu um erro ao adquirir o id do novo grupo.");
			    }
			 }
			
			sql = "INSERT INTO usuario_grupo (usuario_id,grupo_id,situacao) VALUES(?,?,?);";
			psmt = Conexao.prepare(sql);
			psmt.setLong(1, user_id);
			psmt.setLong(2, this.getId());
			psmt.setString(3, Constants.ATIVO);
			psmt.executeUpdate();
			
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getRegras() {
		return regras;
	}
	public void setRegras(String regras) {
		this.regras = regras;
	}
	public int getLimAvalicao() {
		return limAvalicao;
	}
	public void setLimAvalicao(int limAvalicao) {
		this.limAvalicao = limAvalicao;
	}
	
	
}
