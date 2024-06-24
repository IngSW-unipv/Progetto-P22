package src.it.unipv.ingsw.controller;

import src.it.unipv.ingsw.database.ClienteDAO;
import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.model.Cliente;
import src.it.unipv.ingsw.model.Ordine;
import src.it.unipv.ingsw.view.MenuView;
import src.it.unipv.ingsw.view.PagamentiView;
import src.it.unipv.ingsw.view.PagamentoCreditoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;



public class PagamentoController implements ActionListener {
	
	private static DBConnectionSingleton dbConnection;
    private static Connection conn;
    private ClienteDAO cd;
    
    private Ordine ordine;
    private int clienteId;
    
	private static PagamentiView pagamentiView;
	private static MenuView menuView;
	private static PagamentoCreditoView pagamentoCreditoView;
	private static int type = 0;
	
	public PagamentoController(PagamentiView p, int id) {
		super();
		clienteId = id;
		pagamentiView = p;
	}
	
	public PagamentoController(MenuView m) {
		super();
		menuView = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dbConnection = DBConnectionSingleton.getInstance();
		conn = dbConnection.getConnection();
		cd = new ClienteDAO(conn);
//		comado per test
		System.out.println(e.getActionCommand());
		try {
			switch(e.getActionCommand()) {
				case "Paga con carta":
				type = 3;
				break;
			case "Paga con credito":
				type = 2;
//		    	System.out.println(type);
				break;
			case "Paga alla consegna":
				type = 1;
				break;
			case "indietro":
				showMenuView();
				break;
			case "paga":
				pagamento();
				break;
			 default:
				System.out.println("ERRORE: valore pulsante non valido: " + e.getActionCommand());
			}
		} catch (NullPointerException n) {
			System.err.println("ERRORE: PagamentoController evento nullo");
			n.printStackTrace();
		}
	}
	
	private void showCartaInput() {
//		JLabel numeroCarta = new JLabel("Numero Carta :");
//		JLabel scadenza = new JLabel("Scadenza :");
//		JLabel cvv = new JLabel("CVV :");
		
//		JTextField numeroCartaField = new JTextField();
//		JTextField scadenzaField = new JTextField();
//		JTextField cvvField = new JTextField();	
	}
	
	private void pagamento() {
		boolean noCredito = false;
		if (type == 2) {
			ordine = Ordine.getIstance();
			Cliente c = cd.selectById(clienteId);
			if(c.getCredito() >= ordine.getTot())
				cd.cambiaCredito(cd.selectById(clienteId), ordine.getTot());
			else {
				pagamentiView.noCredito();
				noCredito = true;
			}
		}
		if(!(noCredito)) {
			pagamentoCreditoView = new PagamentoCreditoView(type, cd.selectById(clienteId).getCredito());
			pagamentoCreditoView.setVisible(true);
			pagamentiView.dispose();
		}
	}
	
	private void showMenuView() {
		menuView.setVisible(true);	
		pagamentiView.dispose();
	}
}
