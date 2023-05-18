package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main_banco {

	public static void main(String[] args) throws SQLException{
		String url= "jdbc:mysql://localhost:3306/bancojava";
		String user = "root";
		String senha = "positivo";
		
		try {
			//==========================================================//
			// carrega o driver JDBC do Mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Estabelecer conexão
			Connection conexao = DriverManager.getConnection(url, user, senha);
			System.out.println(conexao.isValid(0));
			
			
			//==========================================================//
			//EXEMPLO PARA SELECT
			/*
			//montar a instrução para o banco de dados
			String sql = "select*from clientes where nome=?";
			
			//prepara o comando (PreparedStatement)
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//atribui valores aos parametros da instrução sql
			ps.setString(1,  "Pedro de lara");
			
			//execulta o sql e recebe no objeto do tipo ResultSet
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				System.out.println(id + " " + nome + " " + email);
			}
			
			*///FIM EXEMPLO SELECT
		
			//==========================================================//
			/*EXEMPLO PARA INSERT
			
			String sql = "insert into clientes(id, cpf, nome, email)values(?,?,?,?)";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.setString(2, "101010");
			ps.setString(3, "Sergio Malandro");
			ps.setString(4, "malandro@mail.com");
			
			int retorno = ps.executeUpdate();
			System.out.println(retorno);
			
			*///FIM EXEMPLO INSERT
			
			//==========================================================//
			/*EXEMPLO DE UPDADTE
			
			String sql = "Update clientes set email = ? where cpf = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "pedrao@mail.com");
			ps.setString(2, "888");
			int retorno = ps.executeUpdate();
			System.out.println(retorno);
			*///FIM EXEMPLO UPDATE
			
			//==========================================================//
			
			String sql = "delete from clientes where cpf = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, "888");
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		

	}
	

}
