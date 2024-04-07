package src.it.unipv.ingsw.view;

import src.it.unipv.ingsw.controller.UtenteController;
import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.model.Ristorante;
import src.it.unipv.ingsw.view.panel.RistorantePanel;
import src.it.unipv.ingsw.controller.PosizioneController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AppView extends JFrame {
//	ora le cose si fanno serie
	private static final int LARGHEZZA = 400;
	private static final int ALTEZZA = 400;
	
	private JTextField posizione;
	
	private JPanel ristorantiPanel;
	private ArrayList<RistorantePanel> ristoranti;
	
	private JButton cercaRistoranti;
	
	public AppView() {
		super();	
// qusto serve per dare un aspetto alla finestra e controlla se la libreria giusta esiste
    	try {
    	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	};
    	
    	setSize(LARGHEZZA, ALTEZZA);
    	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    	addWindowListener(new DistruttoreFinestra());
    	//	questo comando serve solo per far avviare la view centrata nel monitor
    	setLocationRelativeTo(null);
    	setTitle("The Best APP");
    	setResizable(false);
    	
//	pannello principale
    	JPanel mainPanel = new JPanel(new BorderLayout());

//	pannello per la posizione
    	JPanel posizionePanel = new JPanel();
    	posizionePanel.setBackground(new Color(227, 69, 16));
    	posizionePanel.setPreferredSize(new Dimension(LARGHEZZA, 50));
    	posizionePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

//componenti per posizione
    	JLabel posizioneLabel = new JLabel("Posizione :");
    	posizioneLabel.setForeground(Color.BLACK);
    	posizioneLabel.setFont(new Font("Arial", Font.BOLD, 16));
    	
//immagine lente di ingrandimento
    	ImageIcon icon = new ImageIcon(System.getProperty("user.home") + "\\eclipse-workspace\\Esercizi\\esame V1\\src\\it\\unipv\\ingsw\\immagini\\lente.jpg");
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
    	JScrollPane ristorantiScrollPanel = new JScrollPane(ristorantiPanel);
    	ristorantiScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

//	barra logOut
    	JMenuBar barraLogOut = new JMenuBar();
    	JMenu barraMenu = new JMenu("%User");
    	JMenuItem logOut = new JMenuItem("Log Out");
    	JMenuItem credito = new JMenuItem("Credito");
    	JMenuItem carrello = new JMenuItem("Carrello");
    	
//	aggiunta componenti
    	barraMenu.add(credito);
    	barraMenu.add(carrello);
    	barraMenu.addSeparator();
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);
    	
    	posizionePanel.add(posizioneLabel);
    	posizionePanel.add(posizione);
    	posizionePanel.add(cercaRistoranti);
    	
    	mainPanel.add(posizionePanel, BorderLayout.NORTH);  	
    	mainPanel.add(ristorantiScrollPanel, BorderLayout.CENTER);
    	
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);
    	
    	add(mainPanel);
    	
    	setJMenuBar(barraLogOut);
    	
    	setVisible(false);
	}
	
	public String getPosizione() {
		return posizione.getText();
	}
	
	public int getLarghezza() {
		return LARGHEZZA;
	}
	
	public int getAltezza() {
		return ALTEZZA;
	}
	
	public void addRistoranti(ArrayList<RistorantePanel> a) {
//		setVisible(false);
//mi serve un metodo per rimuovere i RistorantiPanel precedentemente inseriti nel RistprantiPanel
		ristorantiPanel.removeAll();
		
		ristoranti = a;
		for (RistorantePanel rp : ristoranti) {
//	    	r.setPreferredSize(new Dimension(LARGHEZZA, 100));
	    	ristorantiPanel.add(rp);
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
