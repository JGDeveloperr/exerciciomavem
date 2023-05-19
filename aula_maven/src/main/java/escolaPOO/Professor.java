package escolaPOO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



//==============================================================================================//

public class Professor extends Pessoa {
	public Professor(String nome, String cpf, String email) {
		super(nome, cpf, email);
		
	}

	String matricula;
	String disciplina;
	
	
	//==============================================================================================//	
	public void salvar(String matricula, String cpf, String nome, String email, String disciplina) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	
		
		Connection conexao = conectaBanco.getConexaoMySQL();
		
		
		try {
			
			String sql = "insert into professor(matricula, cpf, nome, email, disciplina)values(?,?,?,?,?)";
			
			PreparedStatement  ps = conexao.prepareStatement(sql);
			
			ps.setString(1, matricula);
			ps.setString(2, this.cpf);
			ps.setString(3, this.nome);
			ps.setString(4, this.email);
			ps.setString(5, disciplina);
			
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
			
			String sql = "select *from professor where (matricula = ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, matricula);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				this.matricula = rs.getString("matricula");
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String materia = rs.getString("disciplina");
				
				System.out.println("MATRICULA: " +this.matricula+ "\nCPF: " +cpf + " \nNOME: " + nome + " \nEMAIL: " + email + "\nDISCIPLINA: "+ materia);
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
			
				String sql = "delete from professor where matricula = ?";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, matricula);
			
				
				ps.executeUpdate();
				
				
				
				
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	
	
	
