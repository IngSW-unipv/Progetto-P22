package src.it.unipv.ingsw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.database.PiattoDAO;
import src.it.unipv.ingsw.model.Ordine;
import src.it.unipv.ingsw.model.Piatto;
import src.it.unipv.ingsw.view.MenuView;
import src.it.unipv.ingsw.view.panel.PiattoPanel;

public class ContoController implements ActionListener{
	
	private static DBConnectionSingleton dbConnection;
    private static Connection conn;
    private static PiattoDAO pd;
    
    private static Ordine ordine;
    
    private PiattoPanel piattoPanel;
    int quantita;
    
    private static MenuView menuView;
    
	public ContoController(PiattoPanel piatto, MenuView m) {
		super();
		ordine = Ordine.getIstance();
		piattoPanel = piatto;
		menuView = m;
		dbConnection = DBConnectionSingleton.getInstance();
		conn = dbConnection.getConnection();
		pd = new PiattoDAO(conn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
// test		
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()) {
			case "addPiatto":
				addPiatto();
				break;
			case "removePiatto":
				removePiatto();
				break;
			default:
				System.err.println("ERRORE nella lettura del pulsante ContoController");
		}
	}
	
	private void addPiatto() {
		try {
			quantita = piattoPanel.getQuantita();
//			tot = menuView.getTot();
		} catch (Exception e) {
			e.printStackTrace();
		}
// test
		System.out.println("Quantita: " + quantita);
		
		if(!(quantita < 0)) {
			Piatto piatto = pd.selectById(piattoPanel.getId());
			if (piatto.isDisponibile() > 0) {
				ordine.addPiatto(piatto);
				++quantita;
//				piatto.setDisponibile(piatto.isDisponibile() - 1);
//				tot += piattoPanel.getCosto();
// test
				piattoPanel.setQuantita(quantita);
// test
//				System.out.println("PiattoID: " + piattoPanel.getId());
				pd.cambiaDisponibilita(piatto,"-");
				piattoPanel.setDisponibile(ordine.getPiatto(piatto).isDisponibile());
				System.out.println(ordine.getPiatto(piatto).isDisponibile());
				if(ordine.getPiatto(piatto).isDisponibile() < 6)
					piattoPanel.showDisponibile(true);
				menuView.setTot(ordine.getTot());
// test			
//				System.out.println("----------------------------------");
//				ordine.getAll();
			}
		} else
			System.out.println("errore impossibile in quantità");
	}
	
	private void removePiatto() {
		try {
			quantita = piattoPanel.getQuantita();
//			tot = menuView.getTot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!(quantita <= 0)) {
			Piatto piatto = pd.selectById(piattoPanel.getId());
			ordine.removePiatto(piatto);
			--quantita;
//			piatto.setDisponibile(piatto.isDisponibile() + 1);
//			tot -= piattoPanel.getCosto();
			piattoPanel.setQuantita(quantita);
			pd.cambiaDisponibilita(piatto,"+");
			piattoPanel.setDisponibile(piatto.isDisponibile());
			if(piatto.isDisponibile() > 5)
				piattoPanel.showDisponibile(false);
			menuView.setTot(ordine.getTot());
		} else
			System.out.println("quantità minima");
	}
}
