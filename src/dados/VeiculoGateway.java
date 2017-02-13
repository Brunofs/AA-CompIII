package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import excecoes.ConexaoException;

public class VeiculoGateway {
	
	long id;
	String modelo;
	String placa;
	String cor;
	long usurio_id;
	
	public VeiculoGateway(){
		
	}
	
	public void salvarVeiculo(long idUser) throws SQLException, ClassNotFoundException, ConexaoException{
		Conexao.initConnection();
		String sql = "INSERT INTO veiculo (modelo,placa,cor,usuario_id) VALUES(?,?,?,?);";
		PreparedStatement psmt = Conexao.prepare(sql);
		psmt.setString(1, this.getModelo());
		psmt.setString(2, this.getPlaca());
		psmt.setString(3, this.getCor());
		psmt.setLong(4,idUser);
		int linhasAfetadas = psmt.executeUpdate();

		if (linhasAfetadas == 0) {
			throw new ConexaoException();
		}

		try (ResultSet generatedKeys = psmt.getGeneratedKeys()) {
		    if (generatedKeys.next()) {
		        this.setId(generatedKeys.getInt(1));
		    }
		    else {
		        throw new SQLException("Ocorreu um erro ao adquirir o id do novo grupo.");
		    }
		 }
		
        Conexao.commit();
		Conexao.closeConnection();
	}
	
	public void alterarVeiculo()throws ConexaoException, SQLException, ClassNotFoundException {
		
		Conexao.initConnection();
		
		String sql = "UPDATE veiculo SET cor = ? WHERE ID = " + this.getId() + ";";
		
		PreparedStatement psmt = Conexao.prepare(sql);
		System.out.println(this.getCor());
		psmt.setString(1, this.getCor());
		
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
	
	public VeiculoGateway(String modelo, String placa, String cor,long usuario_id) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.usurio_id= usuario_id;
	}
	
	public VeiculoGateway(String modelo, String placa, String cor) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
	}
	
	

	public long getUsurio_id() {
		return usurio_id;
	}

	public void setUsurio_id(long usurio_id) {
		this.usurio_id = usurio_id;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	

}
