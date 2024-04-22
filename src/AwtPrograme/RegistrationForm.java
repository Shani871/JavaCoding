package AwtPrograme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm {
    private JFrame frame;
    private JLabel nameLabel, emailLabel, passwordLabel;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegistrationForm() {
        frame = new JFrame("Registration Form");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 80, 20);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 20);
        frame.add(nameField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 60, 80, 20);
        frame.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 60, 200, 20);
        frame.add(emailField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 90, 80, 20);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 90, 200, 20);
        frame.add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 120, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                // Perform registration logic here, e.g., save to database
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
        });
        frame.add(registerButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm();
            }
        });
    }
}
