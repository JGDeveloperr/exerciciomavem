package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cliente {
	 String  cpf;
	 String nome;
	 String email;

	
	public cliente(){}
	
	
	
	public void inserir(String cpf, String nome, String email){
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "insert into clientes(cpf_cnpj, nome, email)values(?,?,?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			ps.setString(1, this.cpf);
			ps.setString(2, this.nome);
			ps.setString(3, this.email);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public void consultar(){
		
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from clientes";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String cpf = rs.getString("cpf_cnpj");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				System.out.println("CPF: " +cpf + " \nNOME: " + nome + " \nEMAIL: " + email);
				System.out.println();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update(String cpf, String nome, String email) {

		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
		
		try {
		
			String sql = "UPDATE clientes SET nome = ?, email = ? WHERE (cpf_cnpj = ?)";
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ps.setString(1, this.nome);
			ps.setString(2, this.email);
			ps.setString(3, this.cpf);
			
			
			int retorno = ps.executeUpdate();
			
			if(retorno != 0) {
				System.out.println("Cadastro Atualizado!");
			}
			
		}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public void delete(String cpf) {
		
		this.cpf = cpf;
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
		
			String sql = "delete from clientes where cpf_cnpj = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
		
			ps.setString(1, this.cpf);
			
			ps.executeUpdate();
			
			
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
