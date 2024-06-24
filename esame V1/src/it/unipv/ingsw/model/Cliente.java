package src.it.unipv.ingsw.model;

public class Cliente extends Utente {
    private int id;
    private int credito;
    private String cognome;
    private String password;

//	questo serve quando chiediamo al DB che i clienti hanno una ID autoassegnato
    public Cliente(int id, String nome, String cognome, String email, String password, int credito) {
        super(email, nome);
        this.credito = credito;
        this.id = id;
        this.cognome = cognome;
        this.password = password;
    }
    
//	test per dao siccome mette l ID automaticamente nel DB
    public Cliente(String nome, String cognome, String email, String password) {
        super(email, nome);
// superfluo tanto lo fa il db
        credito = 0;
        this.cognome = cognome;
        this.password = password;
    }
    
    public int getID() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public int getCredito() {
        return credito;
    }

    @Override
    public String getRuolo() {
        return "Cliente";
    }
    
    @Override
    public String toString() {
    	return "ID= " + id + "\nEmail= " + getEmail() + "\nNome= " + getNome();
    }
}