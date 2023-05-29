//ALUNO: JHONNY GUIMARAES
//CURSO: BSI

package lojacoisasecoisas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class prestador {
		String cpf;
		String cnpj;
		String tipo_servico;
		String descricao_servico;
	 	double valor_servico;
	 	
	 public prestador() {}
	 
	 
	///==========================================================================================//
	 //metodos principais;
	 
	 
	 public void salvar(){
		 
		 
		 	
		 Connection conexao = bancodedados.getConexaoMySQL();
	
	
		 try {
			 
			//=================================================================//
				
			 //pegar data e hora atual para inseiri no banco;
			 LocalDateTime agora = LocalDateTime.now();
	
			 DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu-MM-dd");
			 String dataatual = formatterData.format(agora);//pegando a data do dia atual;
	
		
			 //=================================================================//
			 
			 
			 
			 servicos novoservico = new servicos();
			 int id = novoservico.retorna_idservico(this.tipo_servico);//descobre o id do servico e insere na tbl_prestador
			 
			 
			 String sql = "insert prestador(empresa, idtiposervico, date, valor, descricaoservico, cliente)values(?,?,?,?,?,?)";
		
			 PreparedStatement  ps = conexao.prepareStatement(sql);
		
		
		
			 ps.setString(1, this.cnpj);
			 ps.setInt(2, id);
			 ps.setString(3, dataatual);
			 ps.setDouble(4, this.valor_servico);
			 ps.setString(5, this.descricao_servico);
			 ps.setString(6, this.cpf);
			 
			 int status = ps.executeUpdate();
				
			if(status!= 0) {
				System.out.println("servico prestado salvo....!!!");
				}
			if(status == 0) {
				//se acaso o sql devolver falso a tentativa de salvar o registro acima, ele tenta um update inteligente de registro;
				
				update(this.cnpj, id, dataatual, this.valor_servico, this.descricao_servico, this.cpf);
				
			}
		
		
		 	} catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 			
					System.out.println("SQL STATE: " + e.getSQLState());
			        System.out.println("ERROR CODE: " + e.getErrorCode());
			        System.out.println("MESSAGE: " + e.getMessage());
			        System.out.println();
		 	}
	

	 }
	 
	 private void update(String empresa, int idtiposervico, String data, double valor, String descricaoservico, String cpf) {

			this.cnpj = empresa;
			this.descricao_servico = descricaoservico;
			this.valor_servico = valor;
			this.cpf = cpf;
			
			Connection conexao = bancodedados.getConexaoMySQL();
		
		
			try {
				
				int id = descobrirID(data);//metodo que retorna o id da operação
				
				
				
				// se acaso o serviço for no mesmo dia atualizo o registro;
				
				String sql = "UPDATE prestador SET empresa =?, idtiposervico = ?, date = ?,  valor =?, descricaoservico = ?, cliente = ? WHERE (id = ?);";
				
			
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				
				 ps.setString(1, this.cnpj);
				 ps.setInt(2, idtiposervico);
				 ps.setString(3, data);
				 ps.setDouble(4, this.valor_servico);
				 ps.setString(5, this.descricao_servico);
				 ps.setString(6, this.cpf);
				 ps.setInt(7, id);
				 
				int retorno = ps.executeUpdate();
				
				if(retorno == 1) {
					System.out.println("Servico Atualizado!");
				}
				
				if(retorno == 0) {//se acaso não for no mesmo dia, insere novo registro;
					
					String sql1 = "insert prestador(empresa, idtiposervico, date, valor, descricaoservico, cliente)values(?,?,?,?,?,?)";
					
					PreparedStatement  ps1 = conexao.prepareStatement(sql1);
				
					ps1.setString(1, this.cnpj);
					ps1.setInt(2, idtiposervico);
					ps1.setString(3, data);
					ps1.setDouble(4, this.valor_servico);
					ps1.setString(5, this.descricao_servico);ps1.setString(5, this.descricao_servico);
					ps1.setString(6, this.cpf); 
					 
					int status = ps1.executeUpdate();
					
					if(status!= 0) {
						System.out.println("servico prestado salvo....!!!");
						} 
					
				}
				
				
			}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("SQL STATE: " + e.getSQLState());
				        System.out.println("ERROR CODE: " + e.getErrorCode());
				        System.out.println("MESSAGE: " + e.getMessage());
				        System.out.println();
					}
			
		}

	 public void delete(String registro, String data, String cliente) {//metodo que deleta o registro por id do prestador e dia do servico;
			
			this.cnpj = registro;
			this.cpf = cliente;
			
			Connection conexao = bancodedados.getConexaoMySQL();
		
		
			try {
				
			
				String sql = "delete from prestador where empresa = ? and date = ? and cliente = ?";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
			
				ps.setString(1, this.cnpj);
				ps.setString(2, data);
				ps.setString(3, this.cpf);
				
				ps.executeUpdate();
				
				int status = ps.executeUpdate();
				
				if(status == 0) {
					System.out.println("Registo deletado..");
					}
				if(status == 1) {
					System.out.println("Registro nao deletado ou inexistente..!!");
				}
				
				
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("SQL STATE: " + e.getSQLState());
		        System.out.println("ERROR CODE: " + e.getErrorCode());
		        System.out.println("MESSAGE: " + e.getMessage());
		        System.out.println();
			}
		}
	 
	 
	  
	///==========================================================================================//
	//metododos extras para consulta;
	 
	 
	 public void find_all(){
			
			
			
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT * FROM lojacoisasecoisas.find_all";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					String id = rs.getString("empresa");
					String nome = rs.getString("nome");
					String registro1 = rs.getString("registro");
					String t_servico = rs.getString("tiposervico");
					String data = rs.getString("date");
					double valor = rs.getDouble("valor");
					String s_descricao = rs.getString("descricaoservico");
					String cpf1 = rs.getString("cliente");
					
							System.out.println("ID: "+id+
							"\nNOME: "+nome+
							"\nREGISTRO: " +registro1 + 
							" \nTIPO SERVICO: " + t_servico +
							"\nDATA: "+data+
							" \nVALOR: " + valor+
							"\nDESCRICAO: "+s_descricao+
							"\nCLIENTE: "+cpf1);
							System.out.println();
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	 public void find_one_cliente(String registro){
			
			this.cpf = registro;
			
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT \r\n"
						+ "p.empresa, e.nome, e.registro, s.tiposervico,  p.date, p.valor, p.descricaoservico, c.registro as cliente\r\n"
						+ "FROM\r\n"
						+ "prestador as p\r\n"
						+ "inner JOIN clientes as c\r\n"
						+ "on p.cliente = c.registro	\r\n"
						+ "inner JOIN empresas as e\r\n"
						+ "ON p.empresa = e.registro\r\n"
						+ "inner JOIN servicos as s\r\n"
						+ "ON p.idtiposervico = s.id\r\n"
						+ "where cliente = ?";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, this.cpf);
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					String id = rs.getString("empresa");
					String nome = rs.getString("nome");
					String registro1 = rs.getString("registro");
					String t_servico = rs.getString("tiposervico");
					String data = rs.getString("date");
					double valor = rs.getDouble("valor");
					String s_descricao = rs.getString("descricaoservico");
					String cliente = rs.getString("cliente");
					
					
					
					
					System.out.println("EMPRESA: "+id+
										"\nNOME: "+nome+
										"\nREGISTRO: " +registro1 + 
										" \nTIPO SERVICO: " + t_servico +
										"\nDATA: "+data+
										" \nVALOR: " + valor+
										"\nDESCRICAO: "+s_descricao+
										"\nCLIENTE: "+cliente);
							
					System.out.println();
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	 
	 public void find_one_data(String data){
			
			
			
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "SELECT \r\n"
						+ "p.empresa, e.nome, e.registro, s.tiposervico,  p.date, p.valor, p.descricaoservico, c.registro as cliente\r\n"
						+ "FROM\r\n"
						+ "prestador as p\r\n"
						+ "inner JOIN clientes as c\r\n"
						+ "on p.cliente = c.registro	\r\n"
						+ "inner JOIN empresas as e\r\n"
						+ "ON p.empresa = e.registro\r\n"
						+ "inner JOIN servicos as s\r\n"
						+ "ON p.idtiposervico = s.id\r\n"
						+ "where date = ?";
						
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, data);
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					String id = rs.getString("empresa");
					String nome = rs.getString("nome");
					String registro1 = rs.getString("registro");
					String t_servico = rs.getString("tiposervico");
					String data1 = rs.getString("date");
					double valor = rs.getDouble("valor");
					String s_descricao = rs.getString("descricaoservico");
					String cliente = rs.getString("cliente");
					
					
					
					
					System.out.println("EMPRESA: "+id+
										"\nNOME: "+nome+
										"\nREGISTRO: " +registro1 + 
										" \nTIPO SERVICO: " + t_servico +
										"\nDATA: "+data1+
										" \nVALOR: " + valor+
										"\nDESCRICAO: "+s_descricao+
										"\nCLIENTE: "+cliente);
							
					System.out.println();
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	 private int descobrirID(String data) {
		 
		 Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				// se acaso o serviço for no mesmo dia atualizo o registro;
				
				String sql = "select id from prestador where empresa = ? and cliente = ? and date = ?";
				
			
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				
				 ps.setString(1, this.cnpj);
				 ps.setString(2, this.cpf);
				 ps.setString(3, data);
				 
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					int id = rs.getInt("id");
					return id;
				}
				
				
			}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			return 0;
			
		}
		 
	
}
