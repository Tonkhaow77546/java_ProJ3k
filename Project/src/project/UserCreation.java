package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserCreation extends JFrame {
    // MySQL database URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USER = "root";
    static final String PASS = "";

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
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    
                    createTable(conn); //if no table
                    String sql = "INSERT INTO Users (username, password, name, admin) VALUES (?, ?, ?, FALSE)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, name);
                    preparedStatement.executeUpdate();
                    conn.close();
                    dispose();
                    new Login();
                } catch (ClassNotFoundException | SQLException ex) {
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

    private void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(50) UNIQUE NOT NULL," +
                "password VARCHAR(50) NOT NULL," +
                "name VARCHAR(50) NOT NULL," +
                "admin BOOLEAN NOT NULL DEFAULT FALSE)";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserCreation();
            }
        });
    }
}