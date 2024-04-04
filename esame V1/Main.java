import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pagamento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        JLabel paymentLabel = new JLabel("Seleziona il metodo di pagamento:");
        panel.add(paymentLabel);

        JRadioButton cashRadioButton = new JRadioButton("Paga alla consegna");
        JRadioButton creditRadioButton = new JRadioButton("Paga con credito");
        JRadioButton cardRadioButton = new JRadioButton("Paga con carta");

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashRadioButton);
        paymentGroup.add(creditRadioButton);
        paymentGroup.add(cardRadioButton);

        panel.add(cashRadioButton);
        panel.add(creditRadioButton);
        panel.add(cardRadioButton);

        // Componente per visualizzare l'importo del credito
        JLabel creditLabel = new JLabel("Credito disponibile: $100.00");

        // Nascondi il componente inizialmente
        creditLabel.setVisible(false);

        panel.add(creditLabel);

        // Campi di input per i dati della carta
        JLabel cardDetailsLabel = new JLabel("Inserisci i dati della carta:");
        JTextField cardNumberField = new JTextField(16);
        JTextField expiryDateField = new JTextField(5);
        JTextField cvvField = new JTextField(3);

        // Nascondi i campi di input inizialmente
        cardDetailsLabel.setVisible(false);
        cardNumberField.setVisible(false);
        expiryDateField.setVisible(false);
        cvvField.setVisible(false);

        panel.add(cardDetailsLabel);
        panel.add(new JLabel("Numero della carta:"));
        panel.add(cardNumberField);
        panel.add(new JLabel("Data di scadenza (MM/YY):"));
        panel.add(expiryDateField);
        panel.add(new JLabel("CVV:"));
        panel.add(cvvField);

        // Aggiungi un ActionListener per gestire la selezione dell'opzione "Paga con credito"
        creditRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSelected = creditRadioButton.isSelected();
                creditLabel.setVisible(isSelected);
            }
        });

        // Aggiungi un ActionListener per gestire la selezione dell'opzione "Paga con carta"
        cardRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSelected = cardRadioButton.isSelected();
                cardDetailsLabel.setVisible(isSelected);
                cardNumberField.setVisible(isSelected);
                expiryDateField.setVisible(isSelected);
                cvvField.setVisible(isSelected);
            }
        });

        JButton payButton = new JButton("Paga");
        panel.add(payButton);

        frame.setVisible(true);
    }
}






