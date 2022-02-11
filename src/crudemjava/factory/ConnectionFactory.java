package crudemjava.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	//nom do usu�rio do mysql
	private static final String USERNAME = "root";
	
	// senha do banco
	private static final String PASSWORD = "";
	
	// caminho do banco de dados, porta, nome do banco de dados
	
	private static final String DATABASE_URL = "jdbc:mysql://localhots:3306/contato";
	
	/*
	 * conex�o com o banco de dados
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		// faz com que a classe  seja carregada pela JVM
		Class.forName("com.mysql.jbdc.Driver");
		
		java.sql.Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return  connection;
	
	}
	
public static void main(String[] args) throws Exception {
	// recuperar uma conex�o com o banco de dados 
	Connection con = createConnectionToMySQL();
	
	//testar se a conex�o � nula
	if(con!=null) {
		System.out.print("Conex�o obtida com sucesso");
		con.close();
	}
}
	
	
}
