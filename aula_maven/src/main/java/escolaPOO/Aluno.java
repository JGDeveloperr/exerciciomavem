package escolaPOO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Aluno extends Pessoa {
	public Aluno(String nome, String cpf, String email) {
		super(nome, cpf, email);
		
	}

	String matricula;
	
	
	//==============================================================================================//	
		public void salvar(String matricula, String cpf, String nome, String email) {
			
			this.cpf = cpf;
			this.nome = nome;
			this.email = email;
		
			
			Connection conexao = conectaBanco.getConexaoMySQL();
			
			
			try {
				
				String sql = "insert into aluno(matricula, cpf, nome, email)values(?,?,?,?)";
				
				PreparedStatement  ps = conexao.prepareStatement(sql);
				
				ps.setString(1, matricula);
				ps.setString(2, this.cpf);
				ps.setString(3, this.nome);
				ps.setString(4, this.email);
				
				
				ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
			
		//==============================================================================================//
		
		public void find_one(String matricula) {
			
			Connection conexao = conectaBanco.getConexaoMySQL();
			
			
			try {
				
				String sql = "select *from aluno where (matricula = ?)";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, matricula);
				
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					
					this.matricula = rs.getString("matricula");
					String cpf = rs.getString("cpf");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					
					
					System.out.println("MATRICULA: " +this.matricula+ "\nCPF: " +cpf + " \nNOME: " + nome + " \nEMAIL: " + email);
					System.out.println();
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		//==============================================================================================//
		
		public void delete(String matricula) {
			
			
				
				Connection conexao = conectaBanco.getConexaoMySQL();
			
			
				try {
				
					String sql = "delete from aluno where matricula = ?";
					
					PreparedStatement ps = conexao.prepareStatement(sql);
					ps.setString(1, matricula);
				
					
					ps.executeUpdate();
					
					
					
					
					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
}
