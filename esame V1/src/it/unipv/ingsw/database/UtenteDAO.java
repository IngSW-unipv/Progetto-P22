package src.it.unipv.ingsw.database;

import java.sql.*;
import java.util.ArrayList;

import src.it.unipv.ingsw.database.DBConnection;
import src.it.unipv.ingsw.model.Cliente;

public class UtenteDAO {

	private static Connection conn;


	public UtenteDAO(Connection conn) {
		this.conn = conn;
	}



	public ArrayList<Cliente> selectAll ()
	{
		ArrayList<Cliente> result = new ArrayList<>();

		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from users";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Cliente c = new Cliente(rs1.getInt(1), rs1.getString(2),rs1.getString(3), rs1.getString(6));

				result.add(c);
			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}

	public ArrayList<Cliente> selectByCitta(Cliente c)
	{
		ArrayList<Cliente> result = new ArrayList<>();

		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM FORNITORI WHERE NOME = \"Mario\"";

			//"SELECT * FROM FORNITORE WHERE CITTA='"+fornInput.getCitta()+"'"

			//'OR 1=1

			//"SELECT * FROM FORNITORE WHERE CITTA='

			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getNome());

			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Cliente c1 = new Cliente(rs1.getInt(1), rs1.getString(2),rs1.getString(3), rs1.getString(6));

				result.add(c1);
			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}

	public boolean insertCliente(Cliente c) {

		PreparedStatement st1;

		boolean esito=true;

		try
		{
			String query="insert into users (firstname,secondname,email,password)" +
					"values ('" + c.getNome() + "','b','" + c.getEmail() +"','" + c.getPassword() +"')";
			System.out.println(query);
			st1 = conn.prepareStatement(query);
//	questa parte di codice non sembra funzionare
//			st1.setString(0, c.getNome());
//			st1.setString(2, "Rossi");
//			st1.setString(3, c.getEmail());
//			st1.setString(4, "qwerty");

			st1.executeUpdate(query);

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		return esito;

	}

}