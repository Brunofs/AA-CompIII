package entidades;

public class Veiculo {
	
	long id;
	String modelo;
	String placa;
	String cor;
	long idUser;
	
	
	
	public Veiculo(long id, String modelo, String placa, String cor, long idUser) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.idUser = idUser;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
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
