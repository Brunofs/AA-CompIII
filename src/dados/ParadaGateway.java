package dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import excecoes.ConexaoException;

public class ParadaGateway {

	long idUsuario;
	long idCarona;
	long idLogradouro;
	
	
	public void salvarParada()  throws ConexaoException, SQLException, ClassNotFoundException {
		Conexao.initConnection();
		String sql = "INSERT INTO  (usuario_id,carona_id,logradouro_id) VALUES(?,?,?);";
		PreparedStatement psmt = Conexao.prepare(sql);
		psmt.setLong(1, this.getIdUsuario());
		psmt.setLong(2, this.getIdCarona());
		psmt.setLong(3, this.getIdLogradouro());
		int linhasAfetadas = psmt.executeUpdate();
		if (linhasAfetadas == 0) {
			throw new ConexaoException();
		}
        Conexao.commit();
		Conexao.closeConnection();
	}
	
	
	public ParadaGateway(long idUsuario, long idCarona, long idLogradouro) {
		super();
		this.idUsuario = idUsuario;
		this.idCarona = idCarona;
		this.idLogradouro = idLogradouro;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdCarona() {
		return idCarona;
	}
	public void setIdCarona(long idCarona) {
		this.idCarona = idCarona;
	}
	public long getIdLogradouro() {
		return idLogradouro;
	}
	public void setIdLogradouro(long idLogradouro) {
		this.idLogradouro = idLogradouro;
	}
	
	
	
	
	
}
