package src.it.unipv.ingsw.model;

public class Cliente extends Utente {
    private int numeroOrdini;
    private int id;
    private double conto;
    private String password;

//	questo serve quando chiediamo al DB che i clienti hanno una ID autoassegnato
    public Cliente(int id, String email, String nome, String password) {
        super(email, nome);
        numeroOrdini = 0;
        conto = 0;
        this.id = id;
        this.password = password;
    }
    
//	test per dao siccome mette l ID automaticamente nel DB
    public Cliente(String email, String nome, String password) {
        super(email, nome);
        numeroOrdini = 0;
        conto = 0;
        this.password = password;
    }

    public int getNumeroOrdini() {
        return numeroOrdini;
    }
    
    public int getID() {
        return id;
    }

    public String getPassword() {
        return password;
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