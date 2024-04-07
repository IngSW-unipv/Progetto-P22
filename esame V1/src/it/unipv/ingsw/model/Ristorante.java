package src.it.unipv.ingsw.model;

public class Ristorante extends Utente {
    private String tipoCucina;
    private int id;
    private String indirizzo;
    private String citta;

    public Ristorante(int id, String nome, String indirizzo, String citta, String email) {
        super(email, nome);
        this.id = id;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
    
    public Ristorante(String nome, String indirizzo, String citta, String email) {
        super(email, nome);
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
    
    public int getId() {
    	return id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
    
    public String getCitta() {
        return citta;
    }

    @Override
    public String getRuolo() {
        return "Ristorante";
    }
    
    @Override
    public String toString() {
    	return "ID= " + id + "\nNome= " + getNome() + "\nIndirizzo= " + indirizzo + "\nCittà= " + citta + "\nEmail= " + getEmail();
    }
}
