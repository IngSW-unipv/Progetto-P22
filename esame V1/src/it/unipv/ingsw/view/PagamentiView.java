package src.it.unipv.ingsw.view;

import src.it.unipv.ingsw.controller.PagamentoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PagamentiView extends JFrame {
	private static final int LARGHEZZA = 350;
	private static final int ALTEZZA = 300;
	
	private JRadioButton consegnaButton;
	private JRadioButton creditoButton;
	private JRadioButton cartaButton;
	
	private int clienteId;
	
	private JButton paga;
	
	public PagamentiView(int id, int tot, int credito) {
		super();
		clienteId = id;
// qusto serve per dare un aspetto alla finestra e controlla se la libreria giusta esiste
    	try {
    	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	};
    	PagamentoController pc = new PagamentoController(this, clienteId);
    	
    	setSize(LARGHEZZA, ALTEZZA);
    	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    	addWindowListener(new DistruttoreFinestra());
    	//	questo comando serve solo per far avviare la view centrata nel monitor
    	setLocationRelativeTo(null);
    	setTitle("Pagamenti");
    	setResizable(false);
    	
//	pannello principale
    	JPanel mainPanel = new JPanel(new BorderLayout());
    	mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	
    	JPanel titoloPanel = new JPanel(new FlowLayout());
    	
    	JPanel pagaPanel = new JPanel(new FlowLayout());

//  label per il titolo
    	JLabel titolo = new JLabel("METODO DI PAGAMENTO");
    	Font italicBoldFont = new Font(titolo.getFont().getName(), Font.ITALIC | Font.BOLD, 16);
        titolo.setFont(italicBoldFont);
        
//	pannello per i metodi di pagamento
        
        JPanel pannelloPagamento = new JPanel(new GridLayout(3, 1, 0, 0));
        pannelloPagamento.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

//	metodi di pagamento
        consegnaButton = new JRadioButton("Paga alla consegna");
        consegnaButton.setActionCommand("Paga alla consegna");
        consegnaButton.setFont(new Font("Arial", Font.BOLD, 14));
        consegnaButton.addActionListener(pc);
        consegnaButton.setSelected(true);
        
        creditoButton = new JRadioButton("Paga con credito");
        creditoButton.setActionCommand("Paga con credito");
        creditoButton.setFont(new Font("Arial", Font.BOLD, 14));
        creditoButton.addActionListener(pc);
        
        cartaButton = new JRadioButton("Paga con carta");
        cartaButton.setActionCommand("Paga con carta");
        cartaButton.setFont(new Font("Arial", Font.BOLD, 14));
        cartaButton.addActionListener(pc);
 
// label per il credito ed il totale
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1,2));
        
        JLabel creditoLabel = new JLabel("Credito: " + credito);
        creditoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel totLabel = new JLabel("Totale: " + tot);
        totLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        labelPanel.add(creditoLabel);
        labelPanel.add(totLabel);
        
//	viene usato per escludere un bottone dall'altro
        ButtonGroup pagamentiButtonGroup = new ButtonGroup();
        pagamentiButtonGroup.add(consegnaButton);
        pagamentiButtonGroup.add(creditoButton);
        pagamentiButtonGroup.add(cartaButton);
        
//	pulsante per pagare
        paga = new JButton("Paga");
        paga.setFont(new Font("Arial", Font.BOLD, 16));
    	paga.setForeground(Color.WHITE);
    	paga.setBackground(new Color(227, 69, 16));
    	paga.setPreferredSize(new Dimension(100, 30));
    	paga.setActionCommand("paga");
    	paga.addActionListener(pc);
    	
// pulsante per tornare al menu  	
    	JButton indietroButton = new JButton("Torna al Menù");
    	indietroButton.setFont(new Font("Arial", Font.BOLD, 16));
    	indietroButton.setForeground(Color.WHITE);
    	indietroButton.setBackground(new Color(227, 69, 16));
    	indietroButton.setActionCommand("indietro");
    	indietroButton.addActionListener(pc);
        
//	aggiunta dei componenti
    	titoloPanel.add(titolo);
    	pagaPanel.add(indietroButton);
        pagaPanel.add(paga);
    	
        pannelloPagamento.add(consegnaButton);
        pannelloPagamento.add(creditoButton);
        pannelloPagamento.add(labelPanel);
 //     pannelloPagamento.add(cartaButton);
        
        mainPanel.add(titoloPanel, BorderLayout.NORTH);
        mainPanel.add(pannelloPagamento, BorderLayout.CENTER);
        mainPanel.add(pagaPanel, BorderLayout.SOUTH);
          
        add(mainPanel);
        setVisible(false);
	}
	
	public void noCredito() {
		noCreditoView view = new noCreditoView();
		view.setLocationRelativeTo(this);
		view.setVisible(true);	
	}
	
	private class noCreditoView extends JFrame{
		private static final int LARGHEZZA = 220;
		private static final int ALTEZZA = 150;
		public noCreditoView() {
			setSize(LARGHEZZA, ALTEZZA);
			setResizable(false);
		    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		    JPanel panel = new JPanel(new GridLayout(3,1));
		    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		    JLabel label = new JLabel("Credito Insufficiente");
		    JLabel label1 = new JLabel("Puoi pagare alla consegna!");
		    JButton button = new JButton("OK");
		    panel.add(label);
		    panel.add(label1);
		    panel.add(button);
		    add(panel);
		    button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
		    });
		}
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
