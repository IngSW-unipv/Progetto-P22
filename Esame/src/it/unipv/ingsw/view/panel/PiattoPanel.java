package src.it.unipv.ingsw.view.panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import src.it.unipv.ingsw.controller.ContoController;

public class PiattoPanel extends JPanel{
	private static final int LARGHEZZA = 300;
	private static final int ALTEZZA = 50;
	
	private JLabel quantitaLabel;
	private JLabel disponibileLabel;
	private JLabel costoLabel;
	private JButton bottonePiu;
	private JButton bottoneMeno;
	
	private int quantita = 0;
	private int costo;
	private int id;
	
	public PiattoPanel (String nome, int costo, int prepTime, int disponibile, int id) {
		// qusto serve per dare un aspetto alla finestra e controlla se la libreria giusta esiste
		super();
		this.costo = costo;
		this.id = id;
		
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
		piattoPanel.setLayout(new GridLayout(3,1,0,0));
		piattoPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		
		JLabel nomeLabel = new JLabel(nome);
		costoLabel = new JLabel("Prezzo: " + costo + " €");
		JLabel prepTimeLabel = new JLabel("Stima: " + prepTime + " min.");
		
//	pannello per inmettere la quantitia di quel piatto che si vuole
		quantitaLabel = new JLabel(String.valueOf(quantita));
//		ContoController cc = new ContoController(this);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		
		bottonePiu = new JButton("+");
		bottonePiu.setActionCommand("addPiatto");
/*		bottonePiu.addActionListener(cc
			new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			// action listener temporaneo
				int i = quantita;
				if(i >= 0)
					++quantita;
				revalidate();
			}}
			);
*/		
		bottoneMeno = new JButton("-");
		bottoneMeno.setActionCommand("removePiatto");
/*		bottoneMeno.addActionListener(cc
			new ActionListener() {
			// action listener temporaneo
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(quantitaLabel.getText());
				// TODO Auto-generated method stub
				int i = Integer.valueOf(quantitaLabel.getText());
				if(i > 0)
					quantitaLabel.setText(String.valueOf(i - 1));
//				System.out.println(quantitaLabel.getText());
				revalidate();
			}}
			);
*/		
		disponibileLabel = new JLabel("Rimasti :" + disponibile);
		disponibileLabel.setForeground(Color.RED);
		disponibileLabel.setVisible(false);
		
//	aggiunta componenti
		piattoPanel.add(nomeLabel);
		piattoPanel.add(costoLabel);
		piattoPanel.add(prepTimeLabel);
		
		buttonsPanel.add(bottonePiu);
		buttonsPanel.add(quantitaLabel);
		buttonsPanel.add(bottoneMeno);
		
		leftPanel.add(buttonsPanel);
		leftPanel.add(disponibileLabel);
		
		add(piattoPanel);
		add(leftPanel);
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int i) {
		quantita = i;
		quantitaLabel.setText(String.valueOf(quantita));
	}
	
	public int getCosto() {
		return costo;
	}
	
	public void showDisponibile(Boolean b) {
		disponibileLabel.setVisible(b);
	}
	
	public void setDisponibile(int i) {
		disponibileLabel.setText("Rimasti: " + String.valueOf(i));
	}
	
	public int getId() {
		return id;
	}
	
	public JButton getBottonePiu() {
		return bottonePiu;
	}
	
	public JButton getBottoneMeno() {
		return bottoneMeno;
	}
}
