package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USER = "root";
    static final String PASS = "";

    JLabel usernameLabel, passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, createbutton;

    public Login() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        createbutton = new JButton("Create Account");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    Object[] UserInfo = isValidUser(conn, username, password);
                    boolean UserValid = (boolean) UserInfo[0];
                    String name = (String) UserInfo[1];
                    boolean isAdmin = (boolean) UserInfo[2];
                    
                    if (UserValid) {
                        JOptionPane.showMessageDialog(Login.this, "Login successful!");
                        dispose();
                        Account acc = new Account(isAdmin, name);
                        new Home(acc);
                    } else {
                        JOptionPane.showMessageDialog(Login.this, "Invalid username or password.");
                    }

                    conn.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Login.this, "Error: " + ex.getMessage());
                }
            }
        });
        
        createbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserCreation();
            }
        });

        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(createbutton);

        add(panel);

        setVisible(true);
    }

    private Object[] isValidUser(Connection conn, String username, String password) throws SQLException {
        String sql = "SELECT name, admin FROM Users WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            boolean isAdmin = rs.getBoolean("admin");
            rs.close();
            preparedStatement.close();
            return new Object[]{true, name, isAdmin};
        } else {
            rs.close();
            preparedStatement.close();
            return new Object[]{false, null, null};
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
