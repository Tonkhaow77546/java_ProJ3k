package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserCreation extends JFrame {
    // MySQL database URL

    JLabel usernameLabel, passwordLabel, nameLabel;
    JTextField usernameField, passwordField, nameField;
    JButton createUserButton;

    public UserCreation() {
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        nameLabel = new JLabel("Name:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        nameField = new JTextField(20);
        createUserButton = new JButton("Create User");

        createUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String name = nameField.getText();

                try {
                    Register register = new Register();
                    register.createTable(); //if no table
                    register.createUser(username, password, name);
                    dispose();
                    new Login();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(UserCreation.this, "Error creating user: " + ex.getMessage());
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(createUserButton);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserCreation();
            }
        });
    }
}