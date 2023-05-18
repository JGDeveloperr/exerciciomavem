package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public void consultar(){
		
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from clientes";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				System.out.println(id + " " + nome + " " + email);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update(int id, String nome, String cpf, String email) {

		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
		
			String sql = "UPDATE clientes SET cpf_cnpj = ?, nome = ?, email = ? WHERE (id = ?)";
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, this.cpf);
			ps.setString(2, this.nome);
			ps.setString(3, this.email);
			ps.setInt(4, this.id);
			
			
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