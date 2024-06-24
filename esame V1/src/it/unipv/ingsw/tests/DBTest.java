package src.it.unipv.ingsw.tests;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.database.DBCreatorDAO;
import src.it.unipv.ingsw.database.RistoranteDAO;
import src.it.unipv.ingsw.database.ClienteDAO;
import src.it.unipv.ingsw.database.PiattoDAO;
import src.it.unipv.ingsw.model.Cliente;
import src.it.unipv.ingsw.model.Ristorante;
import src.it.unipv.ingsw.model.Piatto;

public class DBTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DBConnectionSingleton dbConnection = DBConnectionSingleton.getInstance();

        // Esempio di utilizzo della connessione
        Connection connection = dbConnection.getConnection();
        
/*      ClienteDAO ud = new ClienteDAO(connection);
//      Cliente c = new Cliente("a@a.com", "a", "qwerty");
//      System.out.println(c.toString());
        
//      u.insertCliente(c);
        ArrayList<Cliente> ris= ud.selectAll();

		for(Cliente c1 : ris)
			System.out.println(c1.toString());
		
//-------------------------------------------------------------------------------
		System.out.println("-----------------------------------------------------");
//-------------------------------------------------------------------------------
		RistoranteDAO rd = new RistoranteDAO(connection);
		ArrayList<Ristorante> ris= rd.selectAll();
        Ristorante r = new Ristorante("a", "via a", "a city", "a@a.com");
        System.out.println(r.toString());
        
        rd.insertRistorante(r);
		for(Ristorante r1 : ris)
			System.out.println(r1.toString());
			
		System.out.println("-----------------------------------------------------");
		
		ris = rd.selectByCitta("Pavia");
		for(Ristorante r2 : ris)
			System.out.println(r2.toString());

 */   
//-------------------------------------------------------------------------------
//        System.out.println("-----------------------------------------------------");
//-------------------------------------------------------------------------------
 /*     		
        PiattoDAO pd = new PiattoDAO(connection);
        
        ArrayList<Piatto> ris= pd.selectAll();
		for(Piatto p : ris)
			System.out.println(p.toString());
		
		System.out.println("-----------------------------------------------------");
		
		ris = pd.selectByRestaurantsId(1);
		for(Piatto p : ris)
			System.out.println(p.toString());
*/
        DBCreatorDAO creator = new DBCreatorDAO(connection);
        creator.CreaDB();
        creator.PopolaDB();
// Chiusura della connessione quando hai finito
        dbConnection.closeConnection();
	}

}
