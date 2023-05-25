package lojacoisasecoisas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class bancodedados{

	public static String status = "Não conectou...";
	
	static String url= "jdbc:mysql://localhost:3306/lojacoisasecoisas";
	static String user = "root";
	static String senha = "root";
	
	static Connection conexao;
	//Método Construtor da Classe//

	 private bancodedados() {}
	
	
	 //==========================================================================//
	 
	public static Connection getConexaoMySQL() {
		
		
		
		try {
		
			if (conexao == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection(url, user, senha);
				status = ("STATUS--->Conectado com sucesso!");
				

			}

			return conexao;
		
			
		
		
		} catch (ClassNotFoundException e) {  //Driver não encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;
		

		} catch (SQLException e) {

			//Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

			}

			
	}
	
	//==========================================================================//
	

    //Método que retorna o status da sua conexão//

    public static String statusConection() {

        return status;

    }

  //==========================================================================//

   //Método que fecha sua conexão//

    public static boolean FecharConexao() {

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
