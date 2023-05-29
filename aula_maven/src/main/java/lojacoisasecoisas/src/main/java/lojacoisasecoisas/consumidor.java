//ALUNO: JHONNY GUIMARAES
//CURSO: BSI


package lojacoisasecoisas;

import java.sql.Connection;

public class consumidor{

	public static void main(String[] args) {
		
		//inserir clientes na tbl_clientes;
		
		//pessoaFisica cli; 
		
		//cli = new pessoaFisica ();
		
		//cli.nome = "joao pedro";
		//cli.registro = "123.456.789";
		//cli.email = "jp@gmail.com";
		
		//cli.salvar();
		//cli.delete();//
		//cli.find_one();
		
		
		//cli = new pessoaFisica ();
		
		//cli.nome = "Maria do bairro";
		//cli.registro = "987.654.321";
		//cli.email = "mbairro@gmail.com";
		
		//cli.salvar();
		//cli.delete();//
		//cli.find_one();
		
		
		
		
		//==============================================================================//
		
		//inserir empresas na tbl_empresas;
		
		
		//pessoaJuridica cli; 
		
		
		//cli = new pessoaJuridica();
		
		//cli.nome="kieletrica";
		//cli.registro="456.789/0001-01";
		//cli.email="kieletrica@gmail.com";
		
		
		
		//cli.salvar();
		//cli.delete();//
		//cli.find_one();
		
		
		//cli = new pessoaJuridica();
		
		//cli.nome = "kihidraulica";
		//cli.registro = "987.562/0001-01";
		//cli.email = "kihidraulica@gmail.com";
		
		//cli.salvar();
		//cli.delete();
		//cli.find_one();
		
		
		
		
		
		//==============================================================================//
		//cadastro de serviços na tbl_serviços
		
		//servicos cadastro;
		//cadastro= new servicos();
		
		//cadastro.tiposervico = "servico eletrico";
		//cadastro.salvar();
		//cadastro.delete();
		
		
		//cadastro = new servicos();
		//cadastro.tiposervico = "servico hidraulico";
		//cadastro.salvar();
		//cadastro.delete();
		
		//cadastro = new servicos();
		//cadastro.tiposervico = "servico alvenaria";
		//cadastro.salvar();
		//cadastro.delete();
		
		
		//cadastro.find_all();
		
		
		
		//==============================================================================//
		
		//prestador novo;
		//novo= new prestador();
		
		
		//novo.cnpj="456.789/0001-01";
		//novo.tipo_servico = "servico eletrico";
		//novo.descricao_servico=" conserto de chuveiro";
		//novo.valor_servico=150.00;
		//novo.cpf = "123.456.789";
		//novo.salvar();
		
		//novo.delete("456.789/0001-01", "2023-05-28", "123.456.789");
		//novo.find_all();
		
		//novo= new prestador();
		
		//novo.cnpj="456.789/0001-01";
		//novo.tipo_servico = "servico eletrico";
		//novo.descricao_servico=" conserto de chuveiro";
		//novo.valor_servico=150.00;
		//novo.cpf = "987.654.321";
		//novo.salvar();
		
		
		//novo.delete("456.789/0001-01", "2023-05-28", "987.654.321");
		//novo.find_all();
		//novo.find_one_cliente("987.654.321");
		//novo.find_one_data("2023-05-29");

		
		//Connection conecta = bancodedados.getConexaoMySQL();
		//((bancodedados) conecta).fecharConexao();

	}
}
