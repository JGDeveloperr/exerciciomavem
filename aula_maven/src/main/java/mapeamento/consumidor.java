package mapeamento;

public class consumidor {

	public static void main(String[] args) {
		livro Livro = new livro();	
		prateleira Prateleira = new prateleira();
		estante Estante = new estante();	
		
		//criar 3 livros e adicionar a prateleira
		Livro.autor = "Graciliano Ramos";
		Livro.titulo = "Vidas Secas";
		Livro.edicao = "2a. Edição";
		Prateleira.Livros.add(Livro);
		
		Livro = new livro();
		Livro.autor = "Jorge Amado";
		Livro.titulo = "Capitães de areia";
		Livro.edicao = "3a. Edição";
		Prateleira.Livros.add(Livro);
		
		//adicionar prateleira á estante
		Estante.prateleiras.add(Prateleira);
		
		System.out.println("Numero de livros na prateleiras: "+ Prateleira.Livros.size());
		
		for(int i=0; i<Prateleira.Livros.size(); i++) {
			
			System.out.println(Prateleira.Livros.get(i).titulo);
		}
		
		//navegar em todas as prateleiras da estante e imprimir os titulos
		
		for( int j = 0; j<= Estante.prateleiras.size(); j++) {
			System.out.println("Prateleira"+ j+ ":");
			
			//navegar na pratelira
			for(int i=0; i<Estante.prateleiras.get(j).Livros.size();i++) {
				System.out.println(Estante.prateleiras.get(j).Livros.get(i).titulo);
			}
		}
	}

}
