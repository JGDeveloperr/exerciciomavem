package lojacoisasecoisas;

public class consumidor_coisasecoisas {

	public static void main(String[] args) {
		
		
		cliente cli = new cliente();
		int id = 1;
		String nome="joao";
		String cpf="123456";
		String email="joao@mail.com";
		
		
		cli.inserir(id, cpf, nome, email);
		
		

	}

}
