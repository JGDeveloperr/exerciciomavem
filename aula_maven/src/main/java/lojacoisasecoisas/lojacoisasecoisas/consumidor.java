package lojacoisasecoisas;

public class consumidor{

	public static void main(String[] args) {
		
		
		cliente cli; 
		
		cli = new cliente();
		/*
		cli.nome = "kieletrica";
		cli.registro = "456.789/0001-01";
		cli.email = "kieletrico@gmail.com";
		*/
		
		//cli.delete("455.789000000");
		
		
		
		
		servicos cadastro = new servicos();
		cadastro.registro = "456.789/0001-01";
		cadastro.tiposervico = "Reparos elétricos";
		//cadastro.salvarservico();
		cadastro.find_one("456.789/0001-01");
		
		
		//prestador novo = new prestador();
		//novo.cnpj="456.789/0001-01";
		
		//novo.descricao_servico=" conserto de chuveiro";
		//novo.valor_servico=150.00;
		//novo.salvar();
		//novo.delete("456.789/0001-01");
		
	}

}
