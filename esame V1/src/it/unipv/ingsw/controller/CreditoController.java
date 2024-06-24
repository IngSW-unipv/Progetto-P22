package src.it.unipv.ingsw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import src.it.unipv.ingsw.database.ClienteDAO;
import src.it.unipv.ingsw.database.DBConnectionSingleton;
import src.it.unipv.ingsw.model.Cliente;

public class CreditoController implements ActionListener {
	
	private int clienteId;
	
	private static DBConnectionSingleton dbConnection;
    private static Connection conn;
    private static ClienteDAO clienteDAO;
	
	public CreditoController(int id){
		super();
		dbConnection = DBConnectionSingleton.getInstance();
		conn = dbConnection.getConnection();
		clienteDAO = new ClienteDAO(conn);
		clienteId = id;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		showCredito(clienteId);
	}
	
	private void showCredito(int id) {
		Cliente cliente = clienteDAO.selectById(id);
		System.out.println(cliente.getCredito());
	}
	

}
