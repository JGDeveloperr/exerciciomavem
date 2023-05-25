package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class cliente {
	 
	 String registro;
	 String nome;
	 String email;

	
	public cliente(){}
	
	
	
	public void salvar(){
		
		//this.registro = registro;
		//this.nome = nome;
		//this.email = email;
	
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "insert into clientes(nome, registro, email)values(?,?,?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			ps.setString(1, this.nome);
			ps.setString(2, this.registro);
			ps.setString(3, this.email);
			
			
			
			int status = ps.executeUpdate();
			
			if(status!= 0) {
				System.out.println("Cliente Salvo....!!!");
			}
			if(status == 0) {
				update(this.registro, this.nome, this.email);
				
				System.out.println("Atualizando cadastro...!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public void update(String registro, String nome, String email) {

		
		this.registro = registro;
		this.nome = nome;
		this.email = email;
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
			
			int id_cliente = retorna_id(this.registro); 
			
			String sql = "UPDATE clientes SET nome = ?, registro = ?, email = ? WHERE (idcliente= ?)";
		
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ps.setString(2, this.nome);
			ps.setString(3, this.registro);
			ps.setString(4, this.email);
			ps.setInt(1, id_cliente);
			
			
			
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
		
		this.registro = cpf;
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
		
			int id_cliente = retorna_id(this.registro);
			
			String sql = " delete from clientes where idcliente = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
		
			ps.setInt(1, id_cliente);
			
			ps.executeUpdate();
			
			int status = ps.executeUpdate();
			
			if(status!= 0) {
				System.out.println("Registo deletado..");
				}
			if(status == 0) {
				System.out.println("Registro não deletado ou inexistente..!!");
			}
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void find_one(String registro){
		
		this.registro = registro;
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from clientes where registro = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, this.registro);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String id = rs.getString("registro");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				System.out.println("REGISTRO: " +id + " \nNOME: " + nome + " \nEMAIL: " + email);
				System.out.println();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void find_all(){
		
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from clientes";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("registro");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				System.out.println("REGISTRO: " +id + " \nNOME: " + nome + " \nEMAIL: " + email);
				System.out.println();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private int retorna_id(String registro){
		  
		 this.registro = registro;
		
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT idcliente FROM clientes where registro = ?";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, this.registro);
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					int id = rs.getInt("idcliente");
					
					return id;
										
					
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			
			
		}
		 
		 
	 
}