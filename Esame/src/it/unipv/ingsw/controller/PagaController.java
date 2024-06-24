package src.it.unipv.ingsw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import src.it.unipv.ingsw.database.ClienteDAO;
import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.database.PiattoDAO;
import src.it.unipv.ingsw.model.Cliente;
import src.it.unipv.ingsw.model.Ordine;
import src.it.unipv.ingsw.model.Piatto;
import src.it.unipv.ingsw.view.MenuView;
import src.it.unipv.ingsw.view.NullaDaPagareView;
import src.it.unipv.ingsw.view.PagamentiView;

public class PagaController implements ActionListener{
	
	private static DBConnectionSingleton dbConnection;
    private static Connection conn;
    private static PiattoDAO pd;
    private static ClienteDAO cd;
    
	private int tot;
	private int clienteId;
	private Ordine ordine;
	
	private static MenuView menuView;
	private static PagamentiView pagamentiView;
	
	public PagaController(MenuView m, int id) {
		super();
		menuView = m;
		clienteId = id;
		dbConnection = DBConnectionSingleton.getInstance();
		conn = dbConnection.getConnection();
		pd = new PiattoDAO(conn);
		cd = new ClienteDAO(conn);
	}
//questo viene chiamato dopo perche alla prima chiamata questa view non esiste quindi
//non necessita di aggiornare eventuali dati
	public PagaController(PagamentiView p) {
		super();
		pagamentiView = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tot = menuView.getTot();
		System.out.println("Totale da paghare" + tot);
		if (tot == 0)
			nullaDaPagare();
		else
			showPagamentiView(tot);
	}

	private void showPagamentiView(int tot) {
//		System.out.println("dentro showPagamentiView");
		Cliente cliente = cd.selectById(clienteId);
		modificaPiattiDB();
		pagamentiView = new PagamentiView(clienteId, ordine.getTot(), cliente.getCredito());
		pagamentiView.setLocationRelativeTo(menuView);
		menuView.dispose();
		pagamentiView.setVisible(true);
	}
	
	private void nullaDaPagare() {
		NullaDaPagareView view = new NullaDaPagareView();
		view.setLocationRelativeTo(menuView);
		view.setVisible(true);
	}
	
	private void modificaPiattiDB() {
		ordine = Ordine.getIstance();
		for(Piatto p : ordine.getAll())
			pd.cambiaDisponibilita(p, "-");
	}
}
