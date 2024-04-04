package src.it.unipv.ingsw.view.old;

import src.it.unipv.ingsw.model.Utente;

public class UtenteView {
    public void stampaDettagliUtente(Utente utente) {
        System.out.println("Nome: " + utente.getNome());
        System.out.println("Ruolo: " + utente.getRuolo());
    }
}
