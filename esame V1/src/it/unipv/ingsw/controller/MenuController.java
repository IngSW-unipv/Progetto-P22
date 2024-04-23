package src.it.unipv.ingsw.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuController extends MouseAdapter {
	
	public MenuController() {
		super();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//	comado per test
		System.out.println(e.getSource());
			try {
				if (e.getSource().equals("AppView.cercaRistoranti")) {
					System.out.println("true_MenuController ");
//					cercaRistoranti();
				} else
					System.out.println("ERRORE: valore pulsante non valido");
			} catch (NullPointerException n) {
				System.err.println("ERRORE: evento nullo");
			}
    }
}
