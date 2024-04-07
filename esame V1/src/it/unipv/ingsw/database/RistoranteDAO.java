package src.it.unipv.ingsw.database;

import java.sql.*;
import java.util.ArrayList;

import src.it.unipv.ingsw.model.Ristorante;

public class RistoranteDAO {

	private static Connection conn;


	public RistoranteDAO(Connection conn) {
		this.conn = conn;
	}



	public ArrayList<Ristorante> selectAll ()
	{
		ArrayList<Ristorante> result = new ArrayList<>();

		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * FROM restaurants";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Ristorante r = new Ristorante(rs1.getInt(1), rs1.getString(2),rs1.getString(3), rs1.getString(4), rs1.getString(6));

				result.add(r);
			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}

	public ArrayList<Ristorante> selectByCitta(String citta)
	{
		ArrayList<Ristorante> result = new ArrayList<>();

		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM restaurants WHERE city = '" + citta + "'";

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
				Ristorante r1 = new Ristorante(rs1.getInt(1), rs1.getString(2),rs1.getString(3), rs1.getString(4), rs1.getString(6));

				result.add(r1);
			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}

//	PS: si potrebbe creare un metodo simile per cercare per indirizzo

	public boolean insertRistorante(Ristorante r) {

		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="insert into restaurants (name,address,city,email,password)" +
					"values ('" + r.getNome() + "','" + r.getIndirizzo() + "','" + r.getCitta() +"','" + r.getEmail() + "','qwerty')";
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