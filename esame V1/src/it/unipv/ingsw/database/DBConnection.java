package src.it.unipv.ingsw.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "andrea";
    private static final String PASSWORD = "Vaiviatu";
    
    private String schema;

    private static Connection connection;

    public DBConnection(String schema) {
        try {
            // Caricamento del driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String s = JDBC_URL + schema;

            // Creazione della connessione al database
            connection = DriverManager.getConnection(s, USERNAME, PASSWORD);
            System.out.println("Connessione al database riuscita!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
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


