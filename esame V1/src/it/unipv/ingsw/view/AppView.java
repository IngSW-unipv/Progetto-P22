package src.it.unipv.ingsw.view;

import src.it.unipv.ingsw.view.panel.RistorantePanel;
import src.it.unipv.ingsw.controller.CreditoController;
import src.it.unipv.ingsw.controller.LogoutController;
import src.it.unipv.ingsw.controller.MenuController;
import src.it.unipv.ingsw.controller.PosizioneController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AppView extends JFrame {
//	ora le cose si fanno serie
	private static final int LARGHEZZA = 400;
	private static final int ALTEZZA = 400;
	
	private static AppView appView = null;
	
	private JTextField posizione;
	
	private JPanel ristorantiPanel;
	private ArrayList<RistorantePanel> ristoranti;
	
	private JButton cercaRistoranti;
	public JPanel mainPanel;
	public JScrollPane ristorantiScrollPanel;
	public JLabel erroreLabel;
	
	private int clienteId;
	
	public AppView(int clienteId) {
		super();	
		this.clienteId = clienteId;
// qusto serve per dare un aspetto alla finestra e controlla se la libreria giusta esiste
   	try {
    	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	};
  	
// questo è un comando momentaneo o di fortuna, probabilmente sarebbe meglio creare AppView come singleton e poi gestire le cose da li
    	
    	setSize(LARGHEZZA, ALTEZZA);
    	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    	addWindowListener(new DistruttoreFinestra());
    	//	questo comando serve solo per far avviare la view centrata nel monitor
    	setLocationRelativeTo(null);
    	setTitle("The Best APP");
    	setResizable(false);
    	
//	pannello principale
    	mainPanel = new JPanel(new BorderLayout());

//	pannello per la posizione
    	JPanel posizionePanel = new JPanel();
    	posizionePanel.setBackground(new Color(227, 69, 16));
    	posizionePanel.setPreferredSize(new Dimension(LARGHEZZA, 50));
    	posizionePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
    	
// label in caso non si trovano ristoranti o la posizione è errata   	
    	erroreLabel = new JLabel("Posizione non valida");
    	erroreLabel.setForeground(Color.BLACK);
    	erroreLabel.setFont(new Font("Arial", Font.BOLD, 20));

//componenti per posizione
    	JLabel posizioneLabel = new JLabel("Posizione :");
    	posizioneLabel.setForeground(Color.BLACK);
    	posizioneLabel.setFont(new Font("Arial", Font.BOLD, 16));
    	
//immagine lente di ingrandimento
    	ImageIcon icon = new ImageIcon(System.getProperty("user.home") + "\\eclipse-workspace\\esame V1\\src\\it\\unipv\\ingsw\\immagini\\lente.jpg");
    	Image iconOriginale = icon.getImage();
    	Image resizedImage = iconOriginale.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    	ImageIcon lente = new ImageIcon(resizedImage);
    	
    	posizione = new JTextField(15);
    	
    	cercaRistoranti = new JButton(lente);
    	cercaRistoranti.setBackground(Color.WHITE);
    	cercaRistoranti.setActionCommand("AppView.cercaRistoranti");
    	cercaRistoranti.addActionListener(new PosizioneController(this));
    	
//	pannello per i ristoranti
    	ristorantiPanel = new JPanel();
    	ristorantiPanel.setLayout(new BoxLayout(ristorantiPanel, BoxLayout.Y_AXIS));
    	
//barra laterale per il pannello ristoranti	
    	ristorantiScrollPanel = new JScrollPane(ristorantiPanel);
    	ristorantiScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

//	barra logOut
    	JMenuBar barraLogOut = new JMenuBar();
    	JMenu barraMenu = new JMenu("Opzioni");
// controller con clienteId
    	JMenuItem logOut = new JMenuItem("Log Out");
    	logOut.addActionListener(new LogoutController(this));
    	JMenuItem credito = new JMenuItem("Credito");
    	credito.addActionListener(new CreditoController(clienteId));
    	
//	aggiunta componenti
    	barraMenu.add(credito);
    	barraMenu.addSeparator();
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);
    	
    	posizionePanel.add(posizioneLabel);
    	posizionePanel.add(posizione);
    	posizionePanel.add(cercaRistoranti);
    	
    	mainPanel.add(posizionePanel, BorderLayout.NORTH);  	
//    	mainPanel.add(ristorantiScrollPanel, BorderLayout.CENTER);
    	
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);
    	
    	add(mainPanel);
    	
    	setJMenuBar(barraLogOut);
// permette di premere invio invece che il pulsante per cercare    	
    	posizionePanel.getRootPane().setDefaultButton(cercaRistoranti);
// test clienteId
    	System.out.println("Cliente ID = " + clienteId);
    	
    	setVisible(false);
	}
	
/*	public static AppView getIstance(int clienteId) {
// test
		System.out.println(appView == null ? true : false);
		if(appView == null)
			appView = new AppView(clienteId);
		return appView;
	}
	
	public static AppView getIstance() {
		// test
		System.out.println(appView == null ? true : false);
		if(appView != null)
			return appView;
		return null;
	}
*/	
	public String getPosizione() {
		return posizione.getText();
	}
	
	public int getLarghezza() {
		return LARGHEZZA;
	}
	
	public int getAltezza() {
		return ALTEZZA;
	}
	
	public int getClienteId() {
		return clienteId;
	}
	
	public void addRistoranti(ArrayList<RistorantePanel> a) {
//		setVisible(false);
//mi serve un metodo per rimuovere i RistorantiPanel precedentemente inseriti nel RistprantiPanel
		ristorantiPanel.removeAll();
		mainPanel.add(ristorantiScrollPanel);
		mainPanel.remove(erroreLabel);
		
		ristoranti = a;
		for (RistorantePanel rp : ristoranti) {
//	    	r.setPreferredSize(new Dimension(LARGHEZZA, 100));
			rp.getRistoranteButton().addActionListener(new MenuController(this));
	    	ristorantiPanel.add(rp);
	    }
//	    setVisible(true);
//non so bene la differenza tra setVisible and revalidate (la so a grandi linee) ma entrambi "refreshano"/aggiornano la View
	    revalidate();
	    repaint();
	}
	
	public void noRistoranti() {	
		ristorantiPanel.removeAll();
		
		erroreLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		ristorantiPanel.add(erroreLabel);
		mainPanel.remove(ristorantiScrollPanel);
		mainPanel.add(erroreLabel, BorderLayout.CENTER);
		mainPanel.revalidate();
        mainPanel.repaint();
        System.out.println("nessun ristorante trovato");
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
