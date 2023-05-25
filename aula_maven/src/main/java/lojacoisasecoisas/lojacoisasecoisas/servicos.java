package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class servicos {
	
	
	String registro;
	String tiposervico;
	
	public servicos() {}
	
	
	public void salvarservico(){
		 
		
		 Connection conexao = bancodedados.getConexaoMySQL();
	
	
		 try {
		
		
			 
		
			 String sql = "insert into servicos(cnpj_prestador, tiposervico)values(?,?)";
		
			 PreparedStatement  ps = conexao.prepareStatement(sql);
		
		
		
		
			 ps.setString(1,this.registro);
		
			 ps.setString(2, this.tiposervico);
		
			 
			 
		
			 int status = ps.executeUpdate();
				
			 if(status!= 0) {
				 System.out.println("Servico adicionado....!!!");
				}
			 if(status == 0) {
					System.out.println("Tente novamente...!!");
					}
			 
			 
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	

}
	
	
	public void find_one(String registro){
		
		this.registro = registro;
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from servicos where cnpj_prestador = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, this.registro);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String id = rs.getString("cnpj_prestador");
				String descricao = rs.getString("tiposervico");
				
				System.out.println("CNPJ: " +id + " \nTIPO SERVICO: " + descricao);
				System.out.println();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void delete(String registro) {
		
		this.registro = registro;
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
			
			int id_servicos = retorna_id(this.registro);
		
			String sql = "delete from servicos where id = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
		
			ps.setInt(1, id_servicos);
			
			ps.executeUpdate();
			
			int status = ps.executeUpdate();
			
			if(status == 0) {
				System.out.println("Registo deletado..");
				}
			if(status !=0 ) {
				System.out.println("Registro não deletado..!!");
			}
			
			
			
		}catch (SQLException e) {
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
