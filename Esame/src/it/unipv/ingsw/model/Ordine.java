package src.it.unipv.ingsw.model;

import java.util.ArrayList;

public class Ordine {
// questa classe è puramente un testo o un test quindi al momento non è realizzata per l'esecuzione
// potrebbe espldere il pc se lo si fa
	private static Ordine ordine;
	
	private ArrayList<Piatto> piatti;
	private int tot = 0;
	private int totPrepTime;
	
	public static Ordine getIstance() {
		if(ordine == null)
			return ordine = new Ordine();
		return ordine;
	}
	
	private Ordine() {
		piatti = new ArrayList<Piatto>();
	}
	
	public void addPiatto(Piatto p) {
		piatti.add(p);
// test
		System.out.println("add" + tot);
		tot += p.getCosto();
		totPrepTime += p.getPrepTime();
		p.setDisponibile(p.isDisponibile()-1);
	}
	
	public void removePiatto(Piatto p) {
		piatti.remove(p);
// test
		System.out.println("remove" + tot);
		tot -= p.getCosto();
		totPrepTime -= p.getPrepTime();
		p.setDisponibile(p.isDisponibile()+1);
	}
	
	public Piatto getPiatto(Piatto p) {
		Piatto piatto = null;
		for(Piatto p1 : piatti) {
			if(p1.getId() == p.getId())
				piatto = p1;
		}
		return piatto;
	}
	
	public void removeAll() {
		piatti.removeAll(piatti);
	}
	
	public ArrayList<Piatto> getAll() {
		return piatti;
	}
	
	public int getTot() {
		return tot;
	}
	
	public int getTotPrepTime() {
		return totPrepTime;
	}
}
