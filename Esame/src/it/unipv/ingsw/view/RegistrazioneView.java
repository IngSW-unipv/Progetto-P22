package src.it.unipv.ingsw.view;

import src.it.unipv.ingsw.controller.RegistrazioneController;
//importo le classi controller
import src.it.unipv.ingsw.controller.SwapViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrazioneView extends JFrame {
	private static final int LARGHEZZA = 400;
	private static final int ALTEZZA = 300;
	
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField emailField;
	private JPasswordField passwordField;
	
	private JButton accediButton;
	private JButton registratiButton;
	
	private JLabel erroreEmailLabel;
	private JLabel erroreCampiLabel;
	
	private JPanel mainPanel;
	
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
    	mainPanel = new JPanel();
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
    	pannelloInput.setLayout(new GridLayout(4, 2, 0, 10));
    	
//	pulsanti
    	accediButton = new JButton("Accedi");
    	accediButton.setFont(new Font("Arial", Font.BOLD, 14));
    	accediButton.setForeground(Color.WHITE);
    	accediButton.setBackground(new Color(227, 69, 16));
// questi comansi servono per il controller in modo da diversificare i pulsanti delle due view
    	accediButton.setActionCommand("RegistrazioneView.accedi");
        
    	registratiButton = new JButton("Registrati");
    	registratiButton.setFont(new Font("Arial", Font.BOLD, 14));
    	registratiButton.setForeground(Color.WHITE);
    	registratiButton.setBackground(new Color(227, 69, 16));
// questi comansi servono per il controller in modo da diversificare i pulsanti delle due view
    	registratiButton.setActionCommand("RegistrazioneView.registrati");
    	registratiButton.addActionListener(new RegistrazioneController(this));
    	
    	
//	etichette
    	JLabel nomeLabel = new JLabel("Nome :");
    	nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	JLabel cognomeLabel = new JLabel("Cognome :");
    	cognomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	JLabel emailLabel = new JLabel("Email :");
    	emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	JLabel passwordLabel = new JLabel("Password :");
    	passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	erroreEmailLabel = new JLabel("Email già presente, vuoi accedere?");
		erroreEmailLabel.setFont(new Font("Arial", Font.BOLD, 14));
		erroreCampiLabel = new JLabel("Completa tutti i campi");
		erroreCampiLabel.setFont(new Font("Arial", Font.BOLD, 14));
//	area testo
    	nomeField = new JTextField(12);
    	cognomeField = new JTextField(12);
    	emailField = new JTextField(12);
    	passwordField = new JPasswordField(12);

//	occhi che anche se si usa il borde layout, l'ordine di inserimento dei pannelli nel main conta
    	mainPanel.add(titolo, BorderLayout.NORTH);
    	
//	pannello input
    	pannelloInput.add(nomeLabel);
    	pannelloInput.add(nomeField);
    	pannelloInput.add(cognomeLabel);
    	pannelloInput.add(cognomeField);
    	pannelloInput.add(emailLabel);
    	pannelloInput.add(emailField);
    	pannelloInput.add(passwordLabel);
    	pannelloInput.add(passwordField);
    	mainPanel.add(pannelloInput, BorderLayout.CENTER);
    	
//	pannello tasti
    	pannelloTasti.add(accediButton);
    	pannelloTasti.add(registratiButton);
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
	
	public String getNome() {
        return nomeField.getText();
    }
	
	public String getCognome() {
        return cognomeField.getText();
    }
	
	public String getEmail() {
        return emailField.getText();
    }
	
	public String getPassword() {
        return passwordField.getText();
    }
	
	public JButton getAccediButton() {
		return accediButton;
	}
	
	public void erroreEmail() {
    	mainPanel.remove(erroreCampiLabel);
    	mainPanel.remove(erroreEmailLabel);
		mainPanel.add(erroreEmailLabel, BorderLayout.SOUTH);
		mainPanel.revalidate();
		mainPanel.repaint();
		
	}
	public void erroreCampi() {
    	mainPanel.remove(erroreEmailLabel);
    	mainPanel.remove(erroreCampiLabel);
		mainPanel.add(erroreCampiLabel, BorderLayout.SOUTH);
		mainPanel.revalidate();
		mainPanel.repaint();
		
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
