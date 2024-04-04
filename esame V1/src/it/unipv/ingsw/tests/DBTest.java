package src.it.unipv.ingsw.tests;

import java.sql.Connection;
import java.util.ArrayList;

import src.it.unipv.ingsw.database.DBConnection;
import src.it.unipv.ingsw.database.UtenteDAO;
import src.it.unipv.ingsw.model.Cliente;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection dbConnection = new DBConnection("splash_db");

        // Esempio di utilizzo della connessione
        Connection connection = dbConnection.getConnection();
        
        UtenteDAO u = new UtenteDAO(connection);
        Cliente c = new Cliente("a@a.com", "a", "qwerty");
        System.out.println(c.toString());
        
        u.insertCliente(c);
        ArrayList<Cliente> res= u.selectAll();

		for(Cliente r : res)
			System.out.println(r.toString());

        // Chiusura della connessione quando hai finito
        dbConnection.closeConnection();
	}

}
