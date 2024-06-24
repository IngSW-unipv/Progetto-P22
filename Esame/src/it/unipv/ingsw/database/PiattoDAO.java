package src.it.unipv.ingsw.database;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import src.it.unipv.ingsw.model.Piatto;
import src.it.unipv.ingsw.model.Ristorante;

public class PiattoDAO {
	private static Connection conn;

	public PiattoDAO(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Piatto> selectAll ()
	{
		ArrayList<Piatto> result = new ArrayList<>();

		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from dishes";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Piatto p = new Piatto(rs1.getInt(1), rs1.getString(2),rs1.getInt(3), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6));

				result.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}

	public ArrayList<Piatto> selectByRestaurantsId(int restaurantId)
	{
		ArrayList<Piatto> result = new ArrayList<>();

		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query= "SELECT * FROM dishes WHERE restaurant = " + restaurantId;

			st1 = conn.prepareStatement(query);
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Piatto p = new Piatto(rs1.getInt(1), rs1.getString(2),rs1.getInt(3), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6));

				result.add(p);
			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}
	
	public Piatto selectById(int id) {
		Piatto result = null;
		
		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM dishes WHERE id = " + id;

			//"SELECT * FROM FORNITORE WHERE CITTA='"+fornInput.getCitta()+"'"

			//'OR 1=1

			//"SELECT * FROM FORNITORE WHERE CITTA='

//	PS: la sinatssi con VALUES e ? con setString sottocommentato non funziona con la versione del server SQL installato quindi 
//	ho midificato il codice come sopra per città
			st1 = conn.prepareStatement(query);
//		    st1.setString(1, citta);

			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				result = new Piatto(rs1.getInt(1), rs1.getString(2),rs1.getInt(3), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6));
			}
		}catch (Exception e){e.printStackTrace();}
		
		if(!(result == null))
			return result;
		else {
			System.err.println("ERRORE: controllare PiattoDAO.selectByID; result is null");
			return result;
		}
	}

	public boolean insertPiatto(Piatto p) {

		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="insert into dishes (name,avaibility,prep_time,price,restaurant)" +
					"values ('" + p.getNome() + "','" + p.isDisponibile() + "','" + p.getPrepTime() +"','" + p.getCosto() +"','" + p.getRistoranteId() +"')";
//			System.out.println(query);
			
			st1 = conn.prepareStatement(query);
			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}
		return esito;
	}
	
	public boolean cambiaDisponibilita(Piatto p, String s) {

		PreparedStatement st1;

		boolean esito=true;

		try
		{
//			String query = "update dishes\r\n" + "	set avaibility = 5\r\n" + "    where id = 13;";
			String query = "update dishes set avaibility = avaibility "+ s + " 1 where id = " + p.getId();
//			System.out.println(query);
			
			st1 = conn.prepareStatement(query);
			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}
		return esito;
	}
}
