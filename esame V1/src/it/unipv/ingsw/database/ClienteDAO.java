package src.it.unipv.ingsw.database;

import java.sql.*;
import java.util.ArrayList;

import src.it.unipv.ingsw.model.Cliente;
import src.it.unipv.ingsw.model.Piatto;

public class ClienteDAO {

	private static Connection conn;


	public ClienteDAO(Connection conn) {
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
				Cliente c = new Cliente(rs1.getInt(1), rs1.getString(3),rs1.getString(4), rs1.getString(2), rs1.getString(6), rs1.getInt(5));

				result.add(c);
			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}
	
	public Cliente selectByEmail(String email){
		Cliente result = null;

		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM users WHERE email = '" + email + "'";

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
				result = new Cliente(rs1.getInt(1), rs1.getString(3),rs1.getString(4), rs1.getString(2), rs1.getString(6), rs1.getInt(5));

			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}
	
	public Cliente selectById(int id){
		Cliente result = null;

		PreparedStatement st1;
		ResultSet rs1;

		try
		{
			String query="SELECT * FROM users WHERE id = " + id;

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
				result = new Cliente(rs1.getInt(1), rs1.getString(3),rs1.getString(4), rs1.getString(2), rs1.getString(6), rs1.getInt(5));

			}
		}catch (Exception e){e.printStackTrace();}

		return result;
	}

	public boolean insertCliente(Cliente c) {
        String query = "INSERT INTO users (firstname, secondname, email, password) VALUES (?, ?, ?, ?)";

        try (PreparedStatement st1 = conn.prepareStatement(query)) {
            st1.setString(1, c.getNome());
            st1.setString(2, c.getCognome());
            st1.setString(3, c.getEmail());
            st1.setString(4, c.getPassword());

            st1.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean cambiaCredito(Cliente c, int i) {

		PreparedStatement st1;

		boolean esito=true;

		try
		{
//			String query = "update dishes\r\n" + "	set avaibility = 5\r\n" + "    where id = 13;";
			String query = "update users set balance = balance - "+ i +" where id = " + c.getID();
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