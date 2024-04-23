package src.it.unipv.ingsw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import src.it.unipv.ingsw.model.Ristorante;
import src.it.unipv.ingsw.view.AppView;
import src.it.unipv.ingsw.view.panel.RistorantePanel;
import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.database.RistoranteDAO;

public class PosizioneController implements ActionListener {
//	qua bisogna mettere il metodo per la posizione e per aprire il menu dei ristoranti
    
    private AppView appView;
    
//    private ArrayList<RistorantePanel> ristorantiPanel;
//    private ArrayList<Ristorante> ristoranti;
    
    private static DBConnectionSingleton dbConnection;
    private static Connection conn;

    public PosizioneController(AppView a) {
    	super();
    	appView = a;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//	comado per test
		System.out.println(e.getActionCommand());
		try {
			if (e.getActionCommand().equals("AppView.cercaRistoranti")) {
//				System.out.println("true");
				cercaRistoranti();
			} else
				System.out.println("ERRORE: valore pulsante non valido");
		} catch (NullPointerException n) {
			System.err.println("ERRORE: evento nullo");
		}
	}
	
	private void cercaRistoranti() {
		dbConnection = DBConnectionSingleton.getInstance();
		conn = dbConnection.getConnection();
		RistoranteDAO rd = new RistoranteDAO(conn);
		
		String posizione = appView.getPosizione();
		System.out.println(posizione);
		
		ArrayList<RistorantePanel> ristorantiPanel = new ArrayList<RistorantePanel>();
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		
//questo metodo è un modo a priori per verificare se la posizione messa nelJTextField va bene oppure no
		ristoranti = rd.selectAll();
		if (posizione.equals("")) {
			for(Ristorante r : ristoranti) {
				ristorantiPanel.add(new RistorantePanel(r.getNome(), r.getIndirizzo(), r.getCitta()));
//				System.out.println(r.toString());
			}
//manca un metodo per tutte le possibili posizioni non ammesse (magari si potrebbe creare una enumerazione contenente
//tutte le città ammesse)
//sembra funzionare
		} else {
			for (Ristorante r : ristoranti) {
				if(posizione.equalsIgnoreCase(r.getCitta())) {
					ristoranti = rd.selectByCitta(posizione);
						for(Ristorante r1 : ristoranti) {
							ristorantiPanel.add(new RistorantePanel(r1.getNome(), r1.getIndirizzo(), r1.getCitta()));
//						System.out.println(r.toString());
					} break;
				} else continue;
			}
		}
//		System.out.println("----------------------------------> PosizioneController.cercaRistoranti");
		appView.addRistoranti(ristorantiPanel);
	}
}
