package src.it.unipv.ingsw.model;

public abstract class Utente {
    private String nome;
    private String email;

    public Utente(String email, String nome) {
    	this.email = email;
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public abstract String getRuolo();
}
