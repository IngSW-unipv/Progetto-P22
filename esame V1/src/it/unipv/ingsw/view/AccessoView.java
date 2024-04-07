package src.it.unipv.ingsw.view;

// importo le classi controller
import src.it.unipv.ingsw.controller.SwapViewController;
import src.it.unipv.ingsw.controller.UtenteController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccessoView extends JFrame{	
	private static final int LARGHEZZA = 400;
	private static final int ALTEZZA = 250;
	
	private JTextField emailField;
	private JPasswordField passwordField;
	
	private JButton accediButton;
	private JButton registratiButton;
	
    public AccessoView() {
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
    	setTitle("Pagina per accedere");
    	setResizable(false);
    	
//	pannello principale
    	JPanel mainPanel = new JPanel();
    	mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
    	setLayout(new BorderLayout());

//	label per il titolo
    	JLabel titolo = new JLabel("ACCEDI A JUsTMEAT");
    	Font italicBoldFont = new Font(titolo.getFont().getName(), Font.ITALIC | Font.BOLD, 16);
        titolo.setFont(italicBoldFont);

//	pannelli principali
    	JPanel pannelloTasti = new JPanel();
    	pannelloTasti.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    	pannelloTasti.setLayout(new GridLayout(1, 2, 20, 0));
    	
    	JPanel pannelloInput = new JPanel();
    	pannelloInput.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    	pannelloInput.setLayout(new GridLayout(2, 2, 0, 10));
    	
//	pulsanti
    	accediButton = new JButton("Accedi");
    	accediButton.setFont(new Font("Arial", Font.BOLD, 14));
    	accediButton.setForeground(Color.WHITE);
    	accediButton.setBackground(new Color(227, 69, 16));
    	// questi comansi servono per il controller in modo da diversificare i pulsanti delle due view
    	accediButton.setActionCommand("AccessoView.accedi");
    	accediButton.addActionListener(new UtenteController(this));
        
    	registratiButton = new JButton("Registrati");
    	registratiButton.setFont(new Font("Arial", Font.BOLD, 14));
    	registratiButton.setForeground(Color.WHITE);
    	registratiButton.setBackground(new Color(227, 69, 16));
    	// questi comansi servono per il controller in modo da diversificare i pulsanti delle due view
    	registratiButton.setActionCommand("AccessoView.registrati");
    	registratiButton.addActionListener(new SwapViewController(this));
    	
    	
//	etichette
    	JLabel emailLabel = new JLabel("Email :");
    	emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	JLabel passwordLabel = new JLabel("Password :");
    	passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
    	
    	JLabel pswDimenticata = new JLabel("Password dimenticata?");
    	pswDimenticata.setForeground(Color.BLUE);
    	pswDimenticata.setFont(new Font("Arial", Font.ITALIC, 12));
    	//giusto per fare qualcosa
    	pswDimenticata.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame("Password dimenticata");
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                JLabel label = new JLabel("Coming Soon!");
                JButton button = new JButton("OK");
                button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
                });
                panel.add(label, BorderLayout.NORTH);
                panel.add(button, BorderLayout.CENTER);
                frame.add(panel);
                frame.setSize(200, 100);
                frame.setLocationRelativeTo(mainPanel);
                frame.setVisible(true);
            }
    	});
    	
//	area testo
    	emailField = new JTextField(12);
    	passwordField = new JPasswordField(12);

//	occhi che anche se si usa il borde layout, l'ordine di inserimento dei pannelli nel main conta
    	mainPanel.add(titolo, BorderLayout.NORTH);
    	
//	pannello input
    	pannelloInput.add(emailLabel);
    	pannelloInput.add(emailField);
    	
    	pannelloInput.add(passwordLabel);
    	pannelloInput.add(passwordField);
    	mainPanel.add(pannelloInput, BorderLayout.CENTER);

//	test
    	
    	mainPanel.add(pswDimenticata);
    	
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
    		return "AccessoView creata";
    	else
    		return "AccessoView non è abilitata";		
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


