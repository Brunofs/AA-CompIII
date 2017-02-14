package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import excecoes.ConexaoException;
import util.Constants;

public class LogradouroGateway {
	
	long id;
	String cep;
	String estado;
	String cidade;
	String distrito;
	String endereco;
	Integer numero;
	
	public void salvarLogradouro()  throws ConexaoException, SQLException, ClassNotFoundException {
		Conexao.initConnection();
		String sql = "INSERT INTO logradouro (cep,estado,cidade,distrito,endereco,numero) VALUES(?,?,?,?,?,?);";
		PreparedStatement psmt = Conexao.prepare(sql);
		psmt.setString(1, this.getCep());
		psmt.setString(2, this.getEstado());
		psmt.setString(3, this.getCidade());
		psmt.setString(4, this.getDistrito());
		psmt.setString(5, this.getEndereco());
		psmt.setInt(6, this.getNumero());
		
		int linhasAfetadas = psmt.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new ConexaoException();
		}
		
        Conexao.commit();
		Conexao.closeConnection();
	}
	
	public LogradouroGateway(String cep, String estado, String cidade, String distrito, String endereco,
			Integer numero) {
		super();
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.distrito = distrito;
		this.endereco = endereco;
		this.numero = numero;
	}
	
	
	public LogradouroGateway() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
		

	
	

}
