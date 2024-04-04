package src.it.unipv.ingsw.controller;

import src.it.unipv.ingsw.view.PagamentiView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PagamentoController implements ActionListener {
	
	private PagamentiView p;
	
	public PagamentoController(PagamentiView p) {
		super();
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		comado per test
		System.out.println(e.getActionCommand());
		try {
			if (e.getActionCommand().equals("Paga con carta")) {
				showCartaInput();
			} 
			else if (e.getActionCommand().equals("Paga con credito")) {
				showCredito();
			} else
				System.out.println("ERRORE: valore pulsante non valido: " + e.getActionCommand());
		} catch (NullPointerException n) {
			System.err.println("ERRORE: evento nullo");
		}
	}
	
	private void showCartaInput() {
		JLabel numeroCarta = new JLabel("Numero Carta :");
		JLabel scadenza = new JLabel("Scadenza :");
		JLabel cvv = new JLabel("CVV :");
		
		JTextField numeroCartaField = new JTextField();
		JTextField scadenzaField = new JTextField();
		JTextField cvvField = new JTextField();	
	}
	
	private void showCredito() {
		
	}
}
