package src.it.unipv.ingsw.view;

//importo le classi controller
import src.it.unipv.ingsw.controller.SwapViewController;
import src.it.unipv.ingsw.controller.UtenteController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrazioneView extends JFrame {
	private static final int LARGHEZZA = 400;
	private static final int ALTEZZA = 280;
	
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField passwordField;
	
	private JButton accediButton;
	private JButton registratiButton;
	
	public RegistrazioneView() {
		super();
		
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
    	setTitle("Pagina per registrarsi");
    	setResizable(false);
    	
//    	pannello principale
    	JPanel mainPanel = new JPanel();
    	mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    	setLayout(new BorderLayout());
    	
//	label per il titolo
    	JLabel titolo = new JLabel("REGISTARTI");
    	Font italicBoldFont = new Font(titolo.getFont().getName(), Font.ITALIC | Font.BOLD, 16);
        titolo.setFont(italicBoldFont);

//	pannelli principali
    	JPanel pannelloTasti = new JPanel();
    	pannelloTasti.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    	pannelloTasti.setLayout(new GridLayout(1, 2, 20, 0));
    	
    	JPanel pannelloInput = new JPanel();
    	pannelloInput.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    	pannelloInput.setLayout(new GridLayout(3, 2, 0, 10));
    	
//	pulsanti
    	accediButton = new JButton("Accedi");
    	accediButton.setFont(new Font("Arial", Font.BOLD, 14));
    	accediButton.setForeground(Color.WHITE);
    	accediButton.setBackground(new Color(227, 69, 16));
// questi comansi servono per il controller in modo da diversificare i pulsanti delle due view
    	accediButton.setActionCommand("RegistrazioneView.accedi");
    	accediButton.addActionListener(new SwapViewController(this));
        
    	registratiButton = new JButton("Registrati");
    	registratiButton.setFont(new Font("Arial", Font.BOLD, 14));
    	registratiButton.setForeground(Color.WHITE);
    	registratiButton.setBackground(new Color(227, 69, 16));
// questi comansi servono per il controller in modo da diversificare i pulsanti delle due view
    	registratiButton.setActionCommand("RegistrazioneView.registrati");
    	registratiButton.addActionListener(new UtenteController(this));
    	
    	
//	etichette
    	JLabel nomeLabel = new JLabel("Nome :");
    	nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	JLabel emailLabel = new JLabel("Email :");
    	emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	JLabel passwordLabel = new JLabel("Password :");
    	passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
//	area testo
    	nomeField = new JTextField(12);
    	emailField = new JTextField(12);
    	passwordField = new JTextField(12);

//	occhi che anche se si usa il borde layout, l'ordine di inserimento dei pannelli nel main conta
    	mainPanel.add(titolo, BorderLayout.NORTH);
    	
//	pannello input
    	pannelloInput.add(nomeLabel);
    	pannelloInput.add(nomeField);
    	pannelloInput.add(emailLabel);
    	pannelloInput.add(emailField);
    	pannelloInput.add(passwordLabel);
    	pannelloInput.add(passwordField);
    	mainPanel.add(pannelloInput, BorderLayout.CENTER);
    	
//	pannello tasti
    	pannelloTasti.add(registratiButton);
    	pannelloTasti.add(accediButton);
    	mainPanel.add(pannelloTasti, BorderLayout.SOUTH);

//	aggiunta main pannel
    	add(mainPanel);
    	
    	setVisible(false);
	}
	
//	just in case
	@Override
    public String toString() {
    	if (this.isEnabled())
    		return "RegistrazioneView creata";
    	else
    		return "RegistrazioneView non è abilitata";		
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
