package src.it.unipv.ingsw.database;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import src.it.unipv.ingsw.DBFiles.DBReader;

public class DBCreatorDAO {
	
	private static Connection conn;
	private DBReader f;

	public DBCreatorDAO(Connection conn) {
		this.conn = conn;
		f = new DBReader();
	}
	
	public boolean CreaDB() throws IOException {
		ArrayList<String> file = new ArrayList<String>();
		
		String query = "";
		file=f.read("creazione_db.sql");
		for(String s : file)
			query += s;

		try(PreparedStatement st1 = conn.prepareStatement(query)) {
			st1.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean PopolaDB() throws IOException {
		ArrayList<String> file = new ArrayList<String>();
		
		String query = "";
		file=f.read("popolazione_db.sql");
		for(String s : file)
			query += s;

		try(PreparedStatement st1 = conn.prepareStatement(query)) {
			st1.execute();
			return true;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
}
