package src.it.unipv.ingsw.view;

import src.it.unipv.ingsw.view.RistorantePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AppView extends JFrame {
//	ora le cose si fanno serie
	private static final int LARGHEZZA = 400;
	private static final int ALTEZZA = 400;
	
	private JTextField posizione;
	
	private JButton cercaRistoranti;
	
	private ArrayList<RistorantePanel> ristoranti;
	
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
    	ImageIcon icon = new ImageIcon(System.getProperty("user.home") + "\\Desktop\\lente.jpg");
    	Image iconOriginale = icon.getImage();
    	Image resizedImage = iconOriginale.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    	ImageIcon lente = new ImageIcon(resizedImage);
    	
    	posizione = new JTextField(15);
    	
    	cercaRistoranti = new JButton(lente);
    	cercaRistoranti.setBackground(Color.WHITE);
    	
//	pannello per i ristoranti
    	JPanel ristorantiPanel = new JPanel();
    	ristorantiPanel.setLayout(new BoxLayout(ristorantiPanel, BoxLayout.Y_AXIS));
    	
    	//qua bisogna sostituire con un metodo per aggiungere tutti i ristoranti necessari
    	ristoranti = new ArrayList<RistorantePanel> ();
    	ristoranti.add(new RistorantePanel(Color.CYAN));
    	ristoranti.add(new RistorantePanel(Color.BLACK));
    	ristoranti.add(new RistorantePanel(Color.BLUE));
    	ristoranti.add(new RistorantePanel(Color.MAGENTA));
    	ristoranti.add(new RistorantePanel(Color.GREEN));
    	ristoranti.add(new RistorantePanel(Color.GRAY));  	
    	for (RistorantePanel r : ristoranti) {
    		r.setPreferredSize(new Dimension(LARGHEZZA, 100));
    		ristorantiPanel.add(r);
         }
    	
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
	
//	utilizzata per la chiusura della finestra
    private class DistruttoreFinestra extends WindowAdapter {
//	occhio a mettere la w minuscola o altrimenti crea un nuovo metodo
    	@Override
    	public void windowClosing(WindowEvent e) {
//    		System.out.print("debug");
    		dispose();
    		System.exit(0);
    	}
    }
}
