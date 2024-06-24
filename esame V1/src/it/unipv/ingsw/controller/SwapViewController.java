package src.it.unipv.ingsw.controller;

import src.it.unipv.ingsw.view.AccessoView;
import src.it.unipv.ingsw.view.RegistrazioneView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapViewController implements ActionListener{
//	se non le si mettesse satiche, alla chiamata dell'altro costruttore mi andrebbe ad eliminare r
	private static AccessoView accessoView;
	private static RegistrazioneView registrazioneView;
	
	public SwapViewController(AccessoView a) {
		super();
		accessoView = a;
	}
	
/*	public SwapViewController(RegistrazioneView r) {
		super();
		SwapViewController.r = r;
	}
*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//	comado per test
//		System.out.println(e.getActionCommand());
		try {
			if (e.getActionCommand().equals("AccessoView.registrati")) {
				showRegsitrazioneView();
			} 
			else if (e.getActionCommand().equals("RegistrazioneView.accedi")) {
				showAccessoView();
			} else
				System.out.println("ERRORE: valore pulsante non valido: " + e.getActionCommand());
		} catch (NullPointerException n) {
			System.err.println("ERRORE: evento nullo");
		}
	}
	
	private void showRegsitrazioneView() {
		registrazioneView = new RegistrazioneView();
		registrazioneView.getAccediButton().addActionListener(this);
		try {
			registrazioneView.setLocationRelativeTo(accessoView);
			accessoView.dispose();
			registrazioneView.setVisible(true);
		} catch (NullPointerException n) {
		System.err.println("ERRORE: Una delle View è nulla");
		}
	}
	
	private void showAccessoView() {
// a questo punto appView e registrazioneView esistono entrambe (in teoria)
		try {
			accessoView.setLocationRelativeTo(registrazioneView);
			registrazioneView.dispose();
			accessoView.setVisible(true);
		} catch (NullPointerException n) {
		System.err.println("ERRORE: Una delle View è nulla");
		}
	}

}
