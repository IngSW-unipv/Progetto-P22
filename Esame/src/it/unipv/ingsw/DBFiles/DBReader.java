package src.it.unipv.ingsw.DBFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DBReader {
	private FileReader f;
	private BufferedReader b;
	private ArrayList<String> lettura;
	
	public DBReader(){ 	
    	lettura = new ArrayList<String>();
	}
	
	public ArrayList<String> read(String file) throws IOException {
		f=new FileReader(System.getProperty("user.home") + 
				"\\eclipse-workspace\\esame V1\\src\\it\\unipv\\ingsw\\DBFiles\\" + file);
    	b=new BufferedReader(f);
		String s;
		while(true) {
			s=b.readLine();
			if(s==null)
				break;
			lettura.add(s);
			System.out.println(s);
		}
		return lettura;
	}
	public void close() throws IOException {
		b.close();
		f.close();
	}
}
