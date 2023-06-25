package Universidade;

public abstract class Curso implements intercurso {
	// classes abstratas não podem ser ultilizadas para construir objetos;
	//somente podem servir como SUPER CLASSE
	
	
	public String nome_curso;
	public int carga_horaria;
	public double valor_parcela;
	public double valor_total;
	
	public void salvar() {
		
		System.out.println("salvando...");
		
	}
	
	public void delete() {
		System.out.println("Deletando...");
	}
	
	
	public void find_one() {
		System.out.println("Localizando...");
	}
	
}
