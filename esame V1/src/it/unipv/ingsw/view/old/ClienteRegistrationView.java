package src.it.unipv.ingsw.view.old;

import javax.swing.*;

import src.it.unipv.ingsw.controller.UtenteController;
import src.it.unipv.ingsw.model.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteRegistrationView {
    private JFrame frame;
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton iscrivitiButton;

    private UtenteController controller;

    public ClienteRegistrationView(UtenteController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 80, 20);
        frame.getContentPane().add(lblNome);

        nomeTextField = new JTextField();
        nomeTextField.setBounds(120, 30, 200, 20);
        frame.getContentPane().add(nomeTextField);
        nomeTextField.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 60, 80, 20);
        frame.getContentPane().add(lblEmail);

        emailTextField = new JTextField();
        emailTextField.setBounds(120, 60, 200, 20);
        frame.getContentPane().add(emailTextField);
        emailTextField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 90, 80, 20);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 90, 200, 20);
        frame.getContentPane().add(passwordField);

        iscrivitiButton = new JButton("Iscriviti come Cliente");
        iscrivitiButton.setBounds(30, 120, 200, 30);
        frame.getContentPane().add(iscrivitiButton);

        iscrivitiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iscriviCliente();
            }
        });
    }

    public void mostra() {
        frame.setVisible(true);
    }

    private void iscriviCliente() {
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // Aggiunta della validazione per nome, email e password
        if (nome.isEmpty() || !isValidEmail(email) || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Inserire nome, email e password validi.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nome, email, password); // Numero Ordini impostato a 0
        controller.setModel(cliente);

        frame.dispose();
    }

    private boolean isValidEmail(String email) {
        // Implementa la tua logica di validazione per l'email qui
        // In questo esempio, verifica solo la presenza di '@'
        return email.contains("@");
    }
}