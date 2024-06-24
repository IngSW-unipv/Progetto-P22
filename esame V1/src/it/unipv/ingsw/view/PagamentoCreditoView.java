package src.it.unipv.ingsw.view;

import javax.swing.*;

import src.it.unipv.ingsw.controller.LogoutController;

import java.awt.*;
import java.awt.event.*;

public class PagamentoCreditoView extends JFrame{	
	private static final int LARGHEZZA = 300;
	private static final int ALTEZZA = 150;
	
	private JPanel mainPanel;
	private JButton logoutButton;
	private int type;
	
    public PagamentoCreditoView(int type, int credito) {
    	super();
        this.type = type;

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
    	setTitle("Ordine completato");
    	setResizable(false);
    	
//	pannello principale
    	mainPanel = new JPanel();
    	mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
    	setLayout(new BorderLayout());

//	pulsanti

    	logoutButton = new JButton("Logout");
    	logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
    	logoutButton.setForeground(Color.WHITE);
    	logoutButton.setBackground(new Color(227, 69, 16));
    	logoutButton.addActionListener(new LogoutController(this));
    	
    	
//	etichette
    	JLabel completoLabel = new JLabel("Ordine completato con successo!");
    	completoLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	

//	occhi che anche se si usa il borde layout, l'ordine di inserimento dei pannelli nel main conta
    	mainPanel.add(completoLabel, BorderLayout.NORTH);
    	
    	
//	pannello tasti
    	mainPanel.add(logoutButton,  BorderLayout.NORTH);
    	
    	System.out.println(type);
    	if(type == 2) {
    		JLabel creditoLabel = new JLabel("Credito: " + credito);
    		creditoLabel.setFont(new Font("Arial", Font.BOLD, 14));
    		mainPanel.add(creditoLabel, BorderLayout.SOUTH);
    		mainPanel.revalidate();
    		mainPanel.repaint();
    	}

//	aggiunta main pannel
    	add(mainPanel);
 
    	
    	setVisible(false);
    }

    
    public JPanel getMainPanel() {
    	return mainPanel;
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


