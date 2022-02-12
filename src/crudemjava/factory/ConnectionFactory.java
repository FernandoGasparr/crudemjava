package crudemjava.factory;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private ConnectionFactory() {
    }

    public static Connection createConnectionToMySQL()  {
        try {
            return DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/contato", "root", "Zimbabue00*");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
