package src.it.unipv.ingsw.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.it.unipv.ingsw.view.panel.PiattoPanel;

public class MenuView extends JFrame{
	private static final int LARGHEZZA = 300;
	private static final int ALTEZZA = 400;
	
	private JPanel piattiPanel;
	
//	per questa classe bisogna fare molte cose basate sul DB
	public MenuView(String nome) {
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
//questo comando serve solo per far avviare la view centrata nel monitor
//la si potrebbe centrare sulle altre view che lasciano il posto a questa
    	setLocationRelativeTo(null);
    	setTitle("The "+nome+" Menú!");
    	setResizable(false);
    	
//  pannello principale
    	JPanel mainPanel = new JPanel(new BorderLayout());
 
//	titolo
    	JPanel titoloPanel = new JPanel();
    	titoloPanel.setBackground(new Color(227, 69, 16));
    	titoloPanel.setPreferredSize(new Dimension(LARGHEZZA, 40));
    	titoloPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));
    	
    	JLabel titoloLabel = new JLabel("The "+nome+" Menú!");
    	titoloLabel.setForeground(Color.BLACK);
    	Font italicBoldFont = new Font(titoloLabel.getFont().getName(), Font.ITALIC | Font.BOLD, 20);
        titoloLabel.setFont(italicBoldFont);

//	pannello per i piatti
    	piattiPanel = new JPanel();
//    	piattiPanel.setBackground(Color.BLUE);
    	piattiPanel.setLayout(new BoxLayout(piattiPanel, BoxLayout.Y_AXIS));
    	
    	JScrollPane piattiScrollPanel = new JScrollPane(piattiPanel);
    	piattiScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	
    	addPiatti();

//	pulsante per acquistare
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setBackground(new Color(227, 69, 16));
    	buttonPanel.setPreferredSize(new Dimension(LARGHEZZA, 40));
    	
    	JButton pagaButton = new JButton("Paga");
    	pagaButton.setFont(new Font("Arial", Font.BOLD, 16));
    	pagaButton.setPreferredSize(new Dimension(100, 30));

//	barra logOut
    	JMenuBar barraLogOut = new JMenuBar();
    	JMenu barraMenu = new JMenu("%User");
    	JMenuItem logOut = new JMenuItem("Log Out");
    	JMenuItem credito = new JMenuItem("Credito");
    	JMenuItem carrello = new JMenuItem("Carrello");
    	
//	aggiunta componenti
//	barra menu
    	barraMenu.add(credito);
    	barraMenu.add(carrello);
    	barraMenu.addSeparator();
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);
    	
    	barraMenu.add(logOut);
    	barraLogOut.add(barraMenu);

//	titolo
    	titoloPanel.add(titoloLabel);
 
// pulsante
    	buttonPanel.add(pagaButton);
    	
// main panel
    	mainPanel.add(titoloPanel, BorderLayout.NORTH);
    	mainPanel.add(piattiScrollPanel, BorderLayout.CENTER);
    	mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    	
    	add(mainPanel);
    	
    	setJMenuBar(barraLogOut);
    	
    	setVisible(false);
	}
	
	public int getLarghezza() {
		return LARGHEZZA;
	}
	
	public int getAltezza() {
		return ALTEZZA;
	}
	
	public void addPiatti() {
		for(int i = 1; i<=10; i++) {
			PiattoPanel l = new PiattoPanel();
			piattiPanel.add(l);
		}
//		revalidate();
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
