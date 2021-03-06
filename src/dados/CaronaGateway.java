package dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import excecoes.ConexaoException;

public class CaronaGateway {

	long idCarona;
	long idGrupo;
	long idVeiculo;
	String data;
	String horarioSaida;
	int numVagas;
	long logOrigem;
	long logDestino;
	
	public void salvarCarona()  throws ConexaoException, SQLException, ClassNotFoundException {
		Conexao.initConnection();
		String sql = "INSERT INTO public.carona(grupo_id,veiculo_id,data,horariosaida,num_vagas,logOrigem_id,logDestino_id) VALUES(?,?,?,?,?,?,?);";
			PreparedStatement psmt = Conexao.prepare(sql);
			psmt.setLong(1, this.getIdGrupo());
			psmt.setLong(2, this.getIdVeiculo());
			psmt.setString(3, this.getData());
			psmt.setString(4, this.getHorarioSaida());
			psmt.setInt(5, this.getNumVagas());
			psmt.setLong(6, this.getLogOrigem());
			psmt.setLong(7, this.getLogDestino());
			int linhasAfetadas = psmt.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new ConexaoException();
			}
			
	        Conexao.commit();
			Conexao.closeConnection();
	}
	
		public void FinalizarCarona()  throws ConexaoException, SQLException, ClassNotFoundException {
			Conexao.initConnection();
			System.out.println(this.getIdCarona());
			String sql = "UPDATE carona SET situacao = "+0+" WHERE ID = " + this.getIdCarona() +";";
			
			PreparedStatement psmt = Conexao.prepare(sql);
			
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
	
	public CaronaGateway() {
		// TODO Auto-generated constructor stub
	}

	public long getIdCarona() {
		return idCarona;
	}
	public void setIdCarona(long idCarona) {
		this.idCarona = idCarona;
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
