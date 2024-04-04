package src.it.unipv.ingsw.model;

public class Ristorante extends Utente {
    private String tipoCucina;

    public Ristorante(String nome, String tipoCucina) {
        super(nome);
        this.tipoCucina = tipoCucina;
    }

    public String getTipoCucina() {
        return tipoCucina;
    }

    @Override
    public String getRuolo() {
        return "Ristorante";
    }
}
