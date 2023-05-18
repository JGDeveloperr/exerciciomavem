package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cliente {
	 int id;
	 String cpf;
	 String nome;
	 String email;

	
	public cliente(){}
	
	
	
	public void inserir(int id, String cpf, String nome, String email){
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "insert into clientes(id, cpf_cnpj, nome, email)values(?,?,?,?)";
			PreparedStatement  ps = conexao.prepareStatement(sql);
			ps.setInt(1, this.id);
			ps.setString(2, this.cpf);
			ps.setString(3, this.nome);
			ps.setString(4, this.email);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}