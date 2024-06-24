package src.it.unipv.ingsw.controller;

import java.awt.event.*;
import java.sql.Connection;

import src.it.unipv.ingsw.model.Cliente;
import src.it.unipv.ingsw.view.AppView;
import src.it.unipv.ingsw.view.RegistrazioneView;

import src.it.unipv.ingsw.database.ClienteDAO;
import src.it.unipv.ingsw.database.DBConnectionSingleton;

public class RegistrazioneController implements ActionListener  {
//	se non le si mettesse satiche, alla chiamata dell'altro costruttore mi andrebbe ad eliminare r
	private static RegistrazioneView registrazioneView;
	private static AppView appView;
	
	public RegistrazioneController(RegistrazioneView r) {
		super();
		registrazioneView = r;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//	comado per test
		System.out.println(e.getActionCommand());
		try {
			if (e.getActionCommand().equalsIgnoreCase("RegistrazioneView.registrati")) {
				registra();
			} else
				System.out.println("ERRORE: valore pulsante non valido: " + e.getActionCommand());
		} catch (NullPointerException n) {
			System.err.println("ERRORE: evento nullo");
		}
	}
	
	private void registra() {
        try {
            String nome = registrazioneView.getNome();
            String cognome = registrazioneView.getCognome();
            String email = registrazioneView.getEmail();
            String password = registrazioneView.getPassword();

            // Controllare se tutti i campi sono compilati
            if (nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || password.isEmpty()) {
                System.err.println("Errore: Tutti i campi devono essere compilati.");
                return;
            }

            // Creare un nuovo cliente
            Cliente cliente = new Cliente(nome, cognome, email, password);

            // Controllare se il cliente esiste già
            Connection conn = DBConnectionSingleton.getInstance().getConnection();
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            if (clienteDAO.selectByEmail(email) != null) {
                System.err.println("Errore: Cliente già registrato con questa email.");
                return;
            }

            // Inserire il cliente nel database
            boolean success = clienteDAO.insertCliente(cliente);

            if (success) {
                System.out.println("Registrazione completata con successo");
                int id = clienteDAO.selectByEmail(email).getID();
                showAppView(id);
            } else {
                System.err.println("Errore durante la registrazione");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Errore durante la registrazione");
        }
    }
    
    private void showAppView(int id) {
        // Mostrare l'app vera e propria
    	System.out.println("Accesso consentito");
		registrazioneView.dispose();
		appView = new AppView(id);
		appView.setLocationRelativeTo(registrazioneView);
		appView.setVisible(true);
    }
}
