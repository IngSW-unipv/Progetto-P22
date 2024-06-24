package src.it.unipv.ingsw.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton extends SchemaDB{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "andrea";
    private static final String PASSWORD = "Vaiviatu";
    
    private static DBConnectionSingleton dbConnection = null;

    private static Connection connection;

    private DBConnectionSingleton() {
        try {
            // Caricamento del driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String s = JDBC_URL + SCHEMA;

            // Creazione della connessione al database
            connection = DriverManager.getConnection(s, USERNAME, PASSWORD);
            System.out.println("Connessione al database riuscita!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static DBConnectionSingleton getInstance() {
    	if(dbConnection == null) {
			dbConnection = new DBConnectionSingleton();
		}
		
		return dbConnection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connessione chiusa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


