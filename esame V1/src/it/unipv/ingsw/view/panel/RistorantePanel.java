package src.it.unipv.ingsw.view.panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class RistorantePanel extends JPanel {
	private static final int LARGHEZZA = 400;
	private static final int ALTEZZA = 100;
	
	public RistorantePanel(String nome, String indirizzo, String citta) {
		// qusto serve per dare un aspetto alla finestra e controlla se la libreria giusta esiste
		super();
    	try {
    	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	};
    	
		setPreferredSize(new Dimension(LARGHEZZA, ALTEZZA));
		setLayout(new GridLayout(1,2,10,0));
		setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 5));
		setBackground(Color.LIGHT_GRAY);
		addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
                System.out.println("true" + nome);
            }
    	});
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(3,1));
		labelPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		
		JLabel nomeLabel = new JLabel("Nome: " + nome);
		nomeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel indirizzoLabel = new JLabel("Via: " + indirizzo);
		indirizzoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		JLabel cittaLabel = new JLabel("Città: " + citta);
		cittaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		//immagine lente di ingrandimento
    	ImageIcon icon = new ImageIcon(System.getProperty("user.home") + "\\eclipse-workspace\\Esercizi\\esame V1\\src\\it\\unipv\\ingsw\\immagini\\"+ nome +".jpg");
    	Image iconOriginale = icon.getImage();
    	Image resizedImage = iconOriginale.getScaledInstance(180, 90, Image.SCALE_SMOOTH);
    	ImageIcon boh = new ImageIcon(resizedImage);
    	
		JLabel iconaLabel = new JLabel(boh);
		iconaLabel.setPreferredSize(new Dimension(50,50));
		
		labelPanel.add(nomeLabel);
		labelPanel.add(indirizzoLabel);
		labelPanel.add(cittaLabel);
		
		
		add(iconaLabel);
		add(labelPanel);
	}
}
