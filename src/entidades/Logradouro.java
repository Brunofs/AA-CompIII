package entidades;

public class Logradouro {
	String cep;
	String endereco;
	String cidade;
	String distrito;

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	String estado;
	Integer numero;
	
	public Logradouro(String cep, String endereco, String bairro, String cidade, String estado, Integer numero) {
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}
	
	public String getDistrito() {
		return distrito;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
