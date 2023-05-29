package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class bancodedados{

	
	
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url= "jdbc:mysql://localhost:3306/lojacoisasecoisas";
	static String user = "root";
	static String senha = "root";
	
	static Connection conexao;
	

	 private bancodedados() {}
	
	
	 //==========================================================================//
	 
	public static Connection getConexaoMySQL() {
		
		Connection conexao = null;
		
		try {
		
			if (conexao == null) {
				Class.forName(driver);
				conexao = DriverManager.getConnection(url, user, senha);
				
			}

			
		} catch (ClassNotFoundException e) {  //Driver não encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;
		

		} catch (SQLException e) {

			//Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

			}
		return conexao;
			
	}
	


  //==========================================================================//

   //Método que fecha sua conexão//

    public static boolean fecharConexao() {

        try {

           if(conexao != null) {
        	  conexao.close();
           }

            return true;

        } catch (SQLException e) {

            return false;

        }



    }
   
  //==========================================================================//
	}
