package src.it.unipv.ingsw.controller;

import java.awt.event.*;


import src.it.unipv.ingsw.view.AccessoView;
import src.it.unipv.ingsw.view.RegistrazioneView;

public class RegistrazioneController implements ActionListener  {
//	se non le si mettesse satiche, alla chiamata dell'altro costruttore mi andrebbe ad eliminare r
	private static AccessoView a;
	private static RegistrazioneView r;
	
	public RegistrazioneController(AccessoView a) {
		super();
		RegistrazioneController.a = a;
	}
	
	public RegistrazioneController(RegistrazioneView r) {
		super();
		RegistrazioneController.r = r;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//	comado per test
//		System.out.println(e.getActionCommand());
		try {
			if (e.getActionCommand().equals("AccessoView.registrati")) {
//				showRegsitrazioneView();
			} 
			else if (e.getActionCommand().equals("RegistrazioneView.accedi")) {
//				showAccessoView();
			} else
				System.out.println("ERRORE: valore pulsante non valido: " + e.getActionCommand());
		} catch (NullPointerException n) {
			System.err.println("ERRORE: evento nullo");
		}
	}
}
