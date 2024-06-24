package src.it.unipv.ingsw.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class NullaDaPagareView extends JFrame {
	private static final int LARGHEZZA = 220;
	private static final int ALTEZZA = 100;
	public NullaDaPagareView() {
		setSize(LARGHEZZA, ALTEZZA);
		setResizable(false);
	    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    JPanel panel = new JPanel(new GridLayout(2,1));
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    JLabel label = new JLabel("Non hai messo niente nell'ordine");
	    JButton button = new JButton("OK");
	    panel.add(label);
	    panel.add(button);
	    add(panel);
	    button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
	    });
	}
}

