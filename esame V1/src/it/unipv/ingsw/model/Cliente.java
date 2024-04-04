package src.it.unipv.ingsw.model;

public class Cliente extends Utente {
    private int numeroOrdini;
    private int id;
    private String email;
    private String password;

    public Cliente(int id, String email, String nome, String password) {
        super(nome);
        numeroOrdini = 0;
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
//	test per dao siccome mette l ID automaticamente nel DB
    public Cliente(String email, String nome, String password) {
        super(nome);
        numeroOrdini = 0;
        this.email = email;
        this.password = password;
    }

    public int getNumeroOrdini() {
        return numeroOrdini;
    }
    
    public int getID() {
        return id;
    }
    
    public String getEmail() {
        return email;
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
    	return "ID= " + id + "\nEmail= " + email + "\nNome= " + nome;
    }
}