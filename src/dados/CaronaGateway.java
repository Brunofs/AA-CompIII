package dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import excecoes.ConexaoException;

public class CaronaGateway {

	long idCarona;
	long idUsuario;
	long idGrupo;
	long idVeiculo;
	String data;
	String horarioSaida;
	int numVagas;
	long logOrigem;
	long logDestino;
	
	public void salvarUsuario()  throws ConexaoException, SQLException, ClassNotFoundException {
		Conexao.initConnection();
		System.out.println("VAi porra!");
		String sql = "INSERT INTO carona(idGrupo,idVeiculo,data,horarioSaida,numVagas,logOrigem,logDestino) VALUES(?,?,?,?,?,?,?);";
			PreparedStatement psmt = Conexao.prepare(sql);
			psmt.setLong(1, this.getIdGrupo());
			psmt.setLong(2, this.getIdVeiculo());
			psmt.setString(3, this.getData());
			psmt.setString(4, this.getHorarioSaida());
			psmt.setInt(5, this.getNumVagas());
			psmt.setLong(6, this.getLogOrigem());
			psmt.setLong(7, this.getLogDestino());
			int linhasAfetadas = psmt.executeUpdate();
			System.out.println("DEU MERD NO EXEC DSAASSADD");
			if (linhasAfetadas == 0) {
				throw new ConexaoException();
			}
			
	        Conexao.commit();
			Conexao.closeConnection();
	}
	
	public CaronaGateway( long idGrupo, long veiculo, String data, String horarioSaida, int numVagas,
			long logOrigem, long logDestino) {
		super();
		this.idGrupo = idGrupo;
		this.idVeiculo = veiculo;
		this.data = data;
		this.horarioSaida = horarioSaida;
		this.numVagas = numVagas;
		this.logOrigem = logOrigem;
		this.logDestino = logDestino;
	}
	
	public long getIdCarona() {
		return idCarona;
	}
	public void setIdCarona(long idCarona) {
		this.idCarona = idCarona;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	public long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorarioSaida() {
		return horarioSaida;
	}
	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	public int getNumVagas() {
		return numVagas;
	}
	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}
	public long getLogOrigem() {
		return logOrigem;
	}
	public void setLogOrigem(long logOrigem) {
		this.logOrigem = logOrigem;
	}
	public long getLogDestino() {
		return logDestino;
	}
	public void setLogDestino(long logDestino) {
		this.logDestino = logDestino;
	}
	
	
	

}
