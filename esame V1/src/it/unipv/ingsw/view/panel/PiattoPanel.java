package src.it.unipv.ingsw.view.panel;

import java.awt.*;
import javax.swing.*;

public class PiattoPanel extends JPanel{
	private static final int LARGHEZZA = 300;
	private static final int ALTEZZA = 100;
	
	public PiattoPanel () {
		// qusto serve per dare un aspetto alla finestra e controlla se la libreria giusta esiste
		super();
    	try {
    	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	};
    	
		setPreferredSize(new Dimension(LARGHEZZA, ALTEZZA));
		setLayout(new GridLayout(1,2));
		setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 5));
		setBackground(Color.LIGHT_GRAY);

//	pannello info piatto, come nome, costo, etcc
		JPanel piattoPanel = new JPanel();
		piattoPanel.setLayout(new GridLayout(2,1,0,0));
		piattoPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		
		JLabel nomeLabel = new JLabel("nome");
		JLabel costoLabel = new JLabel("costo");
		
//	pannello per inmettere la quantitia di quel piatto che si vuole
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		
		JButton bottonePiu = new JButton("+");
		JButton bottoneMeno = new JButton("-");
		
		JLabel quantitaLabel = new JLabel("1");
		
//	aggiunta componenti
		piattoPanel.add(nomeLabel);
		piattoPanel.add(costoLabel);
		
		buttonsPanel.add(bottonePiu);
		buttonsPanel.add(quantitaLabel);
		buttonsPanel.add(bottoneMeno);
		
		add(piattoPanel);
		add(buttonsPanel);
	}
}
