package entidades;

public class Carona {

	long id;
	String data;
	String horarioSaida;
	int numVagas;
	long idVeiculo;
	long idGrupo;
	long logOrigem;
	long logDestino;
	
	
	public Carona(long id, String data, String horarioSaida, int numVagas, long idVeiculo, long idGrupo,
		long logOrigem, long logDestino) {
		super();
		this.id = id;
		this.data = data;
		this.horarioSaida = horarioSaida;
		this.numVagas = numVagas;
		this.idVeiculo = idVeiculo;
		this.idGrupo = idGrupo;
		this.logOrigem = logOrigem;
		this.logDestino = logDestino;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public long getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
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
