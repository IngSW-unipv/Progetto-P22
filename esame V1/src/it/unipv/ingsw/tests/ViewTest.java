package src.it.unipv.ingsw.tests;

import src.it.unipv.ingsw.view.AccessoView;
import src.it.unipv.ingsw.view.RegistrazioneView;
import src.it.unipv.ingsw.view.AppView;
import src.it.unipv.ingsw.view.PagamentiView;

public class ViewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccessoView test1 = new AccessoView();
		RegistrazioneView test2 = new RegistrazioneView();
		AppView test3 = new AppView();
		PagamentiView test4 = new PagamentiView();
		test1.setVisible(true);
		test3.setVisible(true);
		test4.setVisible(true);
	}

}
