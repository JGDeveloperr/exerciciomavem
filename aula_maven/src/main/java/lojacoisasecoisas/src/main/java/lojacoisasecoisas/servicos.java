
//ALUNO: JHONNY GUIMARAES
//CURSO: BSI

package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class servicos {
	
	
	String tiposervico;
	
	public servicos() {}
	
	
	///==========================================================================================//
	//metodos principais;
	
	
	public void salvar(){
		 
		
		 Connection conexao = bancodedados.getConexaoMySQL();
	
	
		 try {
		
		
			 int id = retorna_idservico(this.tiposervico);//variavel para evitar duplicidade de servico dentro do banco
			 
			 
			 if(id != 0 ) {
				 
				 update(this.tiposervico);
				 
			 }
			 else {
				 
				 
				 String sql = "insert into servicos(tiposervico)values(?)";
					
				 PreparedStatement  ps = conexao.prepareStatement(sql);
			
				 ps.setString(1, this.tiposervico);
				 int status = ps.executeUpdate();
				
				 if(status!= 0) {
				 System.out.println("Servico adicionado....!!!");
				 
				 }
			 
			 }
			 
		 
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	

}
	
	
	private void update(String tipo){//metodo para atualizar tipo de serviço;
		
		
		this.tiposervico = tipo;
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
			
			
			String sql = "UPDATE servicos SET tiposervico = ? WHERE (id= ?)";
			
			int id = retorna_idservico(this.tiposervico);
			
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			 
			 ps.setString(1, this.tiposervico);
			 ps.setInt(2, id);
			
			 
			int retorno = ps.executeUpdate();
			
			if(retorno != 0) {
				System.out.println("Servico Atualizado!");
			}
			
			
			
		}catch (SQLException e) {
					
					e.printStackTrace();
					
					//System.out.println("SQL STATE: " + e.getSQLState());
			        //System.out.println("ERROR CODE: " + e.getErrorCode());
			        //System.out.println("MESSAGE: " + e.getMessage());
			        //System.out.println();
				}
		
	}


	public void delete() {//METODO PARA DELETAR O TIPO DE SERVICO SOMENTE PELO TIPO
		
		
		Connection conexao = bancodedados.getConexaoMySQL();
	
	
		try {
			
			int id = retorna_idservico(this.tiposervico);
		
			String sql = "delete from servicos where id = ?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
		
			ps.setInt(1, id);
			
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

	
	//============================================================================================//
	//metododos de apoio aos outro metodos principais acima;
	
	
	public int retorna_idservico(String tipo){//metodo para descobrir id tipo de serviço e passar para o update e delete
		  
		 this.tiposervico = tipo;
		
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT id FROM servicos where tiposervico = ?";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, this.tiposervico);
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					int id = rs.getInt("id");
					
					return id;
										
					
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			
			
		}
		 
	
	//============================================================================================//
	//metododos extras para consulta;
	
	
	public void find_all(){//METODO PARA CONSULTAR OS TIPOS DE SERVICO CADASTRADO
		
		
		
		Connection conexao = bancodedados.getConexaoMySQL();
		
		
		try {
			
			String sql = "select * from servicos";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String descricao = rs.getString("tiposervico");
				
				System.out.println("ID SERVICO " +id + " \nTIPO SERVICO: " + descricao);
				System.out.println();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	}


