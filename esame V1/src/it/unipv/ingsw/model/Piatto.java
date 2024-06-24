package src.it.unipv.ingsw.model;

public class Piatto{
	private int id;
	private String nome;
	private int disponibile;
	private int prepTime;
	private int costo;
	private int ristoranteId;
	
	public Piatto(int id, String nome, int disponibile, int prepTime, int costo, int ristoranteId) {
		this.id = id;
		initPiatto(nome, disponibile, prepTime, costo, ristoranteId);
	}
	
	public Piatto(String nome, int disponibile, int prepTime, int costo, int ristoranteId) {
		initPiatto(nome, disponibile, prepTime, costo, ristoranteId);
	}
	
	private void initPiatto(String nome, int disponibile, int prepTime, int costo, int ristoranteId) {
		this.nome = nome;
		this.disponibile = disponibile;
		this.prepTime = prepTime;
		this.costo = costo;
		this.ristoranteId = ristoranteId;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int isDisponibile() {
		return disponibile;
	}
	
	public void setDisponibile(int i) {
		disponibile = i;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public int getCosto() {
		return costo;
	}
	
	public int getRistoranteId() {
		return ristoranteId;
	}
	
	@Override
	public String toString() {
		return "ID= " + id + "\nNome= " + nome + "\nDisponibile= " + disponibile + "\nCosto= " + costo + "\nRistoranteID= " + ristoranteId;
	}
}
