package src.it.unipv.ingsw.controller;

import src.it.unipv.ingsw.model.Utente;
import src.it.unipv.ingsw.view.AccessoView;
import src.it.unipv.ingsw.view.RegistrazioneView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtenteController implements ActionListener {
    private Utente model;
    
    private static AccessoView accessoView;
    private static RegistrazioneView registrazioneView;

    public UtenteController(AccessoView a) {
    	super();
    	UtenteController.accessoView = a;
    }
    
    public UtenteController(RegistrazioneView r) {
    	super();
    	UtenteController.registrazioneView = r;
    }
    
    public void setModel(Utente model) {
        this.model = model;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
//		comado per test
//			System.out.println(e.getActionCommand());
		try {
			if (e.getActionCommand().equals("AccessoView.accedi")) {
				accedi();
			} 
			else if (e.getActionCommand().equals("RegistrazioneView.registrati")) {
				registra();
			} else
				System.out.println("ERRORE: valore pulsante non valido");
		} catch (NullPointerException n) {
			System.err.println("ERRORE: evento nullo");
		}
	}
	
	private void accedi() {
//	qua serve un operazione che permetta di controllare se l'utente esiste e do accedere
		showAppView();
	}
	
	private void registra() {
//	qua serve un operazione che controlla se l'utente esiste e in caso lo regitra salvandolo probailmente nel DB
		showAppView();
	}
	
	private void showAppView() {
//	questa serve per mostrare l'app vera e propria
	}
}
