package src.it.unipv.ingsw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import src.it.unipv.ingsw.view.AccessoView;
import src.it.unipv.ingsw.view.AppView;
import src.it.unipv.ingsw.view.MenuView;

public class LogoutController implements ActionListener {
	
	private AccessoView accessoView;
	private JFrame view;

	public LogoutController(JFrame a) {
		super();
		view = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		showAccessoView();		
	}
	
	private void showAccessoView() {
		view.dispose();
		accessoView = new AccessoView();
		accessoView.setVisible(true);}
	}
