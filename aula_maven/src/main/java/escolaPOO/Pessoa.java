package escolaPOO;

public abstract class Pessoa {
	String nome;
	String cpf;
	String email;
	
	
	
	public Pessoa(String nome, String cpf, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	
	
	
	public void salvar() {}
	
	public void find_one() {}
	
	public void delete() {}
}
