package src.it.unipv.ingsw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.*;

import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.database.PiattoDAO;
import src.it.unipv.ingsw.database.RistoranteDAO;
import src.it.unipv.ingsw.model.Ordine;
import src.it.unipv.ingsw.model.Piatto;
import src.it.unipv.ingsw.model.Ristorante;
import src.it.unipv.ingsw.view.AppView;
import src.it.unipv.ingsw.view.MenuView;
import src.it.unipv.ingsw.view.panel.PiattoPanel;

public class MenuController implements ActionListener{
	
	private static DBConnectionSingleton dbConnection;
    private static Connection conn;
    
    private RistoranteDAO rd;
    private PiattoDAO pd;
    
    private int restaurantID;
    private int clienteID;
    private Ordine ordine;
	
	private static MenuView menuView;
	private static AppView appView;
	
	public MenuController(AppView a) {
		super();
		dbConnection = DBConnectionSingleton.getInstance();
		appView = a;
	}
	
	public MenuController(MenuView m) {
		super();
		dbConnection = DBConnectionSingleton.getInstance();
		menuView = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//------------- NOTE --------------
// il getInstance è qui perche se messo nella definione del controller andreebe a creare un loop infinito andando a riempire lo stack e di conseguenza
// in un errore
//------------------------------
		conn = dbConnection.getConnection();
		rd = new RistoranteDAO(conn);
		pd = new PiattoDAO(conn);
		clienteID = appView.getClienteId();
// comando di test
		System.out.println(e.getActionCommand());
		
		try {
			if (e.getActionCommand().equals("MenuView.indietro")) {
// comando di test
				System.out.println("if funzia");
				showAppView();
			} else {
// ho visto una soluzione con try catch with success(try-catch da considereare come un if: se non c'é eccezione esegui altrimenti catch)
				restaurantID = Integer.valueOf(e.getActionCommand());
				
				ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
				ristoranti = rd.selectAll();
// questo dovrebbe controllare se esiste un ristorante con tale id
				boolean result = false;
				for (Ristorante r : ristoranti) {
					if (restaurantID == r.getId()) {
						result = true;
						break;
					}
				}
				if (result){
					showMenuView(restaurantID);
				} else 
					System.out.println("ERRORE! MenuController ha un preoblema con l'actionCommand: " + e.getActionCommand());
			}
		}catch (NullPointerException n) {
			System.err.println("ERRORE: MenuController ha Evento nullo!");
			n.printStackTrace();
		}
	}
	
	private void showMenuView(int restaurantID) {
		appView.dispose();
		
		PiattoDAO pd = new PiattoDAO(conn);
		
		ArrayList<Piatto> piatti = pd.selectByRestaurantsId(restaurantID);
		ArrayList<PiattoPanel> piattiPanel = new ArrayList<PiattoPanel>();
		
// PS: questa query dovrebbe e da un solo ristorante (ID chiave primaria) quindi si portebbe modificare senza restituire un array list
		Ristorante nomeRistorante = rd.selectByID(restaurantID);
		String nome = nomeRistorante.getNome();
		
		for(Piatto p : piatti) {
			if(p.isDisponibile() > 0) {
				if (p.isDisponibile( ) < 6) {
					PiattoPanel pp = new PiattoPanel(p.getNome(), p.getCosto(), p.getPrepTime(), p.isDisponibile(), p.getId());
					pp.showDisponibile(true);
					piattiPanel.add(pp);
				} else
					piattiPanel.add(new PiattoPanel(p.getNome(), p.getCosto(), p.getPrepTime(), p.isDisponibile(), p.getId()));
			} else
				continue;
		}
		
		menuView = new MenuView(nome, clienteID);
		menuView.setLocationRelativeTo(appView);
		menuView.addPiatti(piattiPanel);
		menuView.setTot(0);
		menuView.setVisible(true);
	}
	
	private void showAppView() {
		gestisciDB();
		if(!(menuView == null) & !(appView == null)) {
			if (menuView.isVisible() & !appView.isVisible()) {
				appView.setLocationRelativeTo(menuView);
				menuView.dispose();
				appView.setVisible(true);
			} else
				System.err.println("ERRORE! MenuController, showAppView visibility");
		} else
			System.err.println("ERRORE! MenuController, showAppView pointing null");
	}
	
	private void gestisciDB(){
		ordine= Ordine.getIstance();
		for (Piatto p : ordine.getAll()) {
			pd.cambiaDisponibilita(p, "+");
		}
		ordine.removeAll();
	}
}
