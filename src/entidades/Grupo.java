package entidades;

public class Grupo {
	
	long id;
	String nome;
	String descricao;
	String regras;
	int limite;
	
	public Grupo(long id, String nome, String descricao, String regras, int limite) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.regras = regras;
		this.limite = limite;
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
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	
	

}
