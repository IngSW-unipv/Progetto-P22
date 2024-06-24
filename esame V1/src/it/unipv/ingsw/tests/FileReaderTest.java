package src.it.unipv.ingsw.tests;

import java.io.IOException;

import src.it.unipv.ingsw.DBFiles.DBReader;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DBReader f = new DBReader();
		f.read("creazione_db.sql");
		System.out.println("-------------------------------");
		f.read("popolazione_db.sql");
		f.close();
// ora basterebbe una casse DAOFactory che permette la creazione del db leggendo questi file
	}

}
