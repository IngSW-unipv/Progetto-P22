package src.it.unipv.ingsw.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import src.it.unipv.ingsw.controller.ContoController;
import src.it.unipv.ingsw.controller.CreditoController;
import src.it.unipv.ingsw.controller.LogoutController;
import src.it.unipv.ingsw.controller.MenuController;
import src.it.unipv.ingsw.controller.PagaController;
import src.it.unipv.ingsw.controller.PagamentoController;
import src.it.unipv.ingsw.view.panel.PiattoPanel;
import src.it.unipv.ingsw.view.panel.RistorantePanel;

public class MenuView extends JFrame{
	private static final int LARGHEZZA = 300;
	private static final int ALTEZZA = 400;
	
	private String nome;
	private int tot;
	private int clienteId;
	
	private JLabel contoTot;
	private JLabel titoloLabel;
	private JPanel piattiPanel;
	
	private static MenuView menuView = null;
	private ArrayList<PiattoPanel> piatti;
	
//	per questa classe bisogna fare molte cose basate sul DB
/*	public static MenuView getIstance(String nome, int id) {
		if(menuView == null) {
			menuView = new MenuView(nome,id);
		} else
			menuView.setNome(nome);
		return menuView;
	}
	
	public static MenuView getIstance() {
		if(!(menuView == null))
			return menuView;
		else
			return null;
	}
*/	
	public MenuView(String nome, int id) {
		super();
		clienteId = id;
		this.nome = nome;
		
		PagamentoController pc = new PagamentoController(this);
		// qusto serve per dare un aspetto alla finestra e controlla se la libreria giusta esiste
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		};
// credo che questro sia un modo grezzo per realizzare cio, magari si può creare questra classe come singleton e nel controller fare getIstance		
		
		setSize(LARGHEZZA, ALTEZZA);
    	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    	addWindowListener(new DistruttoreFinestra());
//questo comando serve solo per far avviare la view centrata nel monitor
//la si potrebbe centrare sulle altre view che lasciano il posto a questa
    	setLocationRelativeTo(null);
    	setTitle(nome +" Menù");
    	setResizable(false);
    	
//  pannello principale
    	JPanel mainPanel = new JPanel(new BorderLayout());
 
//	titolo
    	JPanel titoloPanel = new JPanel();
    	titoloPanel.setBackground(new Color(227, 69, 16));
    	titoloPanel.setPreferredSize(new Dimension(LARGHEZZA, 40));
    	titoloPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));
    	
    	titoloLabel = new JLabel(nome +" Menù");
    	titoloLabel.setForeground(Color.BLACK);
    	Font italicBoldFont = new Font(titoloLabel.getFont().getName(), Font.ITALIC | Font.BOLD, 20);
        titoloLabel.setFont(italicBoldFont);

//	pannello per i piatti
    	piattiPanel = new JPanel();
//    	piattiPanel.setBackground(Color.BLUE);
    	piattiPanel.setLayout(new BoxLayout(piattiPanel, BoxLayout.Y_AXIS));
    	
    	JScrollPane piattiScrollPanel = new JScrollPane(piattiPanel);
    	piattiScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

//	pulsante per acquistare etc.
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setBackground(new Color(227, 69, 16));
    	buttonPanel.setPreferredSize(new Dimension(LARGHEZZA, 40));
    	buttonPanel.setLayout(new GridLayout(1,3,0,20));
    	
    	JButton pagaButton = new JButton("Paga");
    	pagaButton.addActionListener(new PagaController(this, clienteId));
    	pagaButton.setFont(new Font("Arial", Font.BOLD, 16));
//    	pagaButton.setPreferredSize(new Dimension(100, 30));
    	
    	JButton indietroButton = new JButton("Indietro");
    	indietroButton.setFont(new Font("Arial", Font.BOLD, 16));
//    	indietroButton.setPreferredSize(new Dimension(100, 30));
    	indietroButton.setActionCommand("MenuView.indietro");
    	indietroButton.addActionListener(new MenuController(this));
    	
// label conto totale
    	contoTot = new JLabel("TOT: " + tot);
    	contoTot.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
//    	contoTot.setPreferredSize(new Dimension(100, 30));

//	barra logOut
    	JMenuBar barraLogOut = new JMenuBar();
    	JMenu barraMenu = new JMenu("Opzioni");
    	JMenuItem logOut = new JMenuItem("Log Out");
    	logOut.addActionListener(new LogoutController(this));
    	JMenuItem credito = new JMenuItem("Credito");
    	credito.addActionListener(new CreditoController(clienteId));
    	
//	aggiunta componenti
//	barra menu
    	barraMenu.add(credito);
    	barraMenu.addSeparator();
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);
    	
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);

//	titolo
    	titoloPanel.add(titoloLabel);
 
// pulsante
    	buttonPanel.add(indietroButton);
    	buttonPanel.add(pagaButton);
    	buttonPanel.add(contoTot);
    	
// main panel
    	mainPanel.add(titoloPanel, BorderLayout.NORTH);
    	mainPanel.add(piattiScrollPanel, BorderLayout.CENTER);
    	mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    	
    	add(mainPanel);
    	
    	setJMenuBar(barraLogOut);
    	
    	setVisible(false);
	}
	
	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
		contoTot.setText("TOT: " + String.valueOf(tot) + " €");
	}

	public int getLarghezza() {
		return LARGHEZZA;
	}
	
	public int getAltezza() {
		return ALTEZZA;
	}
	
	public void setNome(String s) {
		nome = s;
		setTitle(nome +" Menú!");
		titoloLabel.setText(nome +" Menú!");
	}
	
	public void addPiatti(ArrayList<PiattoPanel> p) {
//		setVisible(false);
//mi serve un metodo per rimuovere i RistorantiPanel precedentemente inseriti nel RistprantiPanel
		piattiPanel.removeAll();
		
		piatti = p;
		for (PiattoPanel pp : piatti) {
//	    	r.setPreferredSize(new Dimension(LARGHEZZA, 100));
			ContoController cc = new ContoController(pp, this);
			pp.getBottoneMeno().addActionListener(cc);
			pp.getBottonePiu().addActionListener(cc);
	    	piattiPanel.add(pp);
	    }
//	    setVisible(true);
//non so bene la differenza tra setVisible and revalidate (la so a grandi linee) ma entrambi "refreshano"/aggiornano la View
	    revalidate();
	}
	
//	utilizzata per la chiusura della finestra
    private class DistruttoreFinestra extends WindowAdapter {
//	occhio a mettere la w minuscola o altrimenti crea un nuovo metodo
    	@Override
    	public void windowClosing(WindowEvent e) {
//    		System.out.print("debug");
//    		DBConnectionSingleton dbConnection = DBConnectionSingleton.getInstance();
//   		dbConnection.closeConnection();
    		dispose();
    		System.exit(0);
    	}
    }
}
