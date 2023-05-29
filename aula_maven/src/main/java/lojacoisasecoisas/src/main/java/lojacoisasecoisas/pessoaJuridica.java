//ALUNO: JHONNY GUIMARAES
//CURSO: BSI

package lojacoisasecoisas;
	
	import java.util.Scanner;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	

	public class pessoaJuridica extends pessoa {
		 
		 public pessoaJuridica(String registro, String nome, String email) {
			super(registro, nome, email);
			
		}
		 public pessoaJuridica() {}
		 
		 
		 
		///==========================================================================================//
		//metododos principais;
		
		
		public void salvar(){//salva empresa na tabela empresa;
			
			
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "insert into empresas(registro, nome, email)values(?,?,?)";
				
				PreparedStatement  ps = conexao.prepareStatement(sql);
				
				
				ps.setString(1, this.registro);
				ps.setString(2, this.nome);
				ps.setString(3, this.email);
				
				int status = ps.executeUpdate();
				
				
				if(status == 1) {
					
					System.out.println("Cadastro realizado..!!");
				}
				
			} catch (SQLException e) {
				
				//e.printStackTrace();
				//System.out.println("SQL STATE: " + e.getSQLState());
		        //System.out.println("ERROR CODE: " + e.getErrorCode());
		        //System.out.println("MESSAGE: " + e.getMessage());
		        //System.out.println();
				String msg = "Duplicate entry '"+this.registro+"' for key 'empresas.PRIMARY'";
					
				if(e.getMessage().equals(msg)) {
		           
					System.out.println("ja existe cadastro para esse cpf ou cpnj...!!!\n");
					
					System.out.print("Deseja atualizar o registro com esses dados? (S/N)");
					Scanner teclado = new Scanner(System.in);
					String opcao = teclado.nextLine();
					
					if(opcao.equals("s") || opcao.equals("S")) {
						update(this.registro, this.nome, this.email);//atualiza o registro com os dados existentes nas variaveis.
						
					}
					if(opcao.equals("n") || opcao.equals("N")){
						System.out.println("\nCaso deseje alterar seu nome e email para \neste cadastro altere os dados no inicio e \nselecione 's' na opcao anterior para atualizar..!!");
					}
					
				}
			}
		}
				
		
		public void delete() {//metodo para deletar empresa da tabela empresa;
			
			//this.registro = registro1;
			
			Connection conexao = bancodedados.getConexaoMySQL();
		
		
			try {
			
				
				
				String sql = "delete from empresas where registro = ?";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
			
				ps.setString(1, this.registro);
				
				
				ps.executeUpdate();
				
				int status = ps.executeUpdate();
				
				if(status == 1) {
					System.out.println("Registo deletado..");
					}
				if(status == 0) {
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
		
		
		private void update(String registro, String nome, String email) {

			
			this.registro = registro;
			this.nome = nome;
			this.email = email;
			
			Connection conexao = bancodedados.getConexaoMySQL();
		
		
			try {
				
				
				String sql = "UPDATE empresas SET nome = ?, email = ? WHERE (registro= ?)";
			
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				
				ps.setString(1, this.nome);
				ps.setString(2, this.email);
				ps.setString(3, this.registro);
				
				int retorno = ps.executeUpdate();
				
				if(retorno != 0) {
					System.out.println("Cadastro Atualizado!");
				}
				
			}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("MESSAGE: " + e.getMessage());
					}
			
		}
		 
		
		///==========================================================================================//
		//metododos extras para consulta;
		
		
		public void find_one(){//metodo para imprimir uma empresa especifica;
			
			//this.registro = registro;
			
			Connection conexao = bancodedados.getConexaoMySQL();
			
			
			try {
				
				String sql = "select * from empresas where registro = ?";
				
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

		 
	}


