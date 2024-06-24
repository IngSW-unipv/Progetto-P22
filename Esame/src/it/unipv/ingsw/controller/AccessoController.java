package src.it.unipv.ingsw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import src.it.unipv.ingsw.model.Cliente;
import src.it.unipv.ingsw.view.AccessoView;
import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.database.ClienteDAO;
import src.it.unipv.ingsw.view.AppView;

public class AccessoController implements ActionListener {
    
    private static AccessoView accessoView;
    private static AppView appView;
    
    private static DBConnectionSingleton dbConnection;
    private static Connection conn;

    public AccessoController(AccessoView a) {
    	super();
    	accessoView = a;
    }

	
	private void cercaUtenti() {
		dbConnection = DBConnectionSingleton.getInstance();
		conn = dbConnection.getConnection();
		ClienteDAO rd = new ClienteDAO(conn);
		
		String email = accessoView.getEmail();
		System.out.println(email);
		String password = accessoView.getPassword();
		System.out.println(password);
		
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		
//questo metodo è un modo a priori per verificare se la posizione messa nelJTextField va bene oppure no
		clienti = rd.selectAll();

		
//manca un metodo per tutte le possibili posizioni non ammesse (magari si potrebbe creare una enumerazione contenente
//tutte le città ammesse)
//sembra funzionare
		boolean presenza = true;
			for (Cliente r : clienti) {
// test
//				System.out.println("Cliente mail: " + email);
//				System.out.println("Email: " + r.getEmail());
				if(email.equalsIgnoreCase(r.getEmail())) {
					presenza = true;
					Cliente cliente = rd.selectByEmail(email);
					if(cliente.getPassword().equals(password)) {
						System.out.println("Accesso consentito");
						accessoView.setVisible(false);
						appView = new AppView(cliente.getID());
						appView.setLocationRelativeTo(accessoView);
						appView.setVisible(true);
						break;				
					}
					else {
						presenza = true;
						accessoView.emailOK();
						accessoView.errorePassword();
						System.out.println("password errata");
						break;
					}
						
				} else {
					presenza = false;
					System.out.println("email non valida");
				}
			}
		if(!presenza) accessoView.erroreEmail();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
// test
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("AccessoView.accedi"))
			cercaUtenti();
	}
		
}
