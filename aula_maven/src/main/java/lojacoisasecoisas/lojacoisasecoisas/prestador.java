
package lojacoisasecoisas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class prestador {
	
		String cnpj;
		String descricao_servico;
	 	double valor_servico;
	 	
	 public prestador() {}

	
	 
	 public void salvar(){
		 
		 	
		 Connection conexao = bancodedados.getConexaoMySQL();
	
	
		 try {
			 
			//=================================================================//
				
			 //pegar data e hora atual para inseiri no banco;
			 LocalDateTime agora = LocalDateTime.now();
	
			 DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu-MM-dd");
			 String dataatual = formatterData.format(agora);
	
		
			 //=================================================================//
			 
			 int id_prestador = retorna_id(this.cnpj);
		
			 String sql = "insert prestador(idprestador, descricaoservico, date, valor)values(?,?,?,?)";
		
			 PreparedStatement  ps = conexao.prepareStatement(sql);
		
		
		
			 ps.setInt(1, id_prestador);
			 ps.setString(2, this.descricao_servico);
			 ps.setString(3, dataatual);
			 ps.setDouble(4, this.valor_servico);
			 
			 int status = ps.executeUpdate();
				
			if(status!= 0) {
				System.out.println("servico realizado....!!!");
				}
			if(status == 0) {
				System.out.println("Serviço não realizado...!!");
			}
		
		
		 	} catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 	}
	

	 }

	 
	 public void find_all(){
			
			
			
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT * FROM lojacoisasecoisas.find_all";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					String id = rs.getString("cnpj_prestador");
					String nome1 = rs.getString("nome");
					String servico = rs.getString("tiposervico");
					String servico2 = rs.getString("descricaoservico");
					String data = rs.getString("date");
					double valor = rs.getDouble("valor");
					
					
					System.out.println("CNPJ: " +id + 
										"\nNOME: "+nome1+
										" \nTIPO SERVICO: " + servico +
										"\nDESCRICAO: "+servico2+
										" \nVALOR: " + valor+
										"\nDATA: "+data);
					System.out.println();
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	 
	 public void find_one(String registro){
			
			
			
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT cnpj_prestador, nome, tiposervico, descricaoservico,date,valor FROM prestador inner join servicos on prestador.idprestador = servicos.id inner join clientes on clientes.registro = servicos.cnpj_prestador where cnpj_prestador = ?";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, registro);
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					String id = rs.getString("cnpj_prestador");
					String nome1 = rs.getString("nome");
					String servico = rs.getString("tiposervico");
					String servico2 = rs.getString("descricaoservico");
					String data = rs.getString("date");
					double valor = rs.getDouble("valor");
					
					
					System.out.println("CNPJ: " +id + 
										"\nNOME: "+nome1+
										" \nTIPO SERVICO: " + servico +
										"\nDESCRICAO: "+servico2+
										"\nDATA: "+data+
										" \nVALOR: " + valor);
										
					System.out.println();
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	 
	 public void delete(String registro) {
			
			this.cnpj = registro;
			
			
			Connection conexao = bancodedados.getConexaoMySQL();
		
		
			try {
				
				int id_cliente = retorna_id(this.cnpj);
				
			
				String sql = "delete from prestador where idprestador = ?";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
			
				ps.setInt(1, id_cliente);
				
				ps.executeUpdate();
				
				int status = ps.executeUpdate();
				
				if(status!= 0) {
					System.out.println("Registo deletado..");
					}
				if(status == 1) {
					System.out.println("Registro não deletado..!!");
				}
				
				
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	 
	 private int retorna_id(String registro){
		  
		 this.cnpj = registro;
		
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT idcliente FROM clientes where registro = ?";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, this.cnpj);
				
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