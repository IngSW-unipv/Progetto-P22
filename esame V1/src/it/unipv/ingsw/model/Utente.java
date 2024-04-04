package src.it.unipv.ingsw.model;

public abstract class Utente {
    protected String nome;

    public Utente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String getRuolo();
}
