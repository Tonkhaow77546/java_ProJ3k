package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {

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
                String password = passwordField.getText();

                try {
                    Register register = new Register();
                    register.createTable();
                    Object[] UserInfo = register.Login(username, password);
                    if (UserInfo[0].equals(true)){
                        JOptionPane.showMessageDialog(Login.this, "Login successful!");
                        dispose();
                        Account acc = new Account((boolean) UserInfo[2], (String) UserInfo[1], (int) UserInfo[3]);
                        new Home(acc);
                    } else {
                        JOptionPane.showMessageDialog(Login.this, "Invalid username or password.");
                    }

                } catch (SQLException ex) {
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

//    private Object[] isValidUser(Connection conn, String username, String password) throws SQLException {
//        String sql = "SELECT name, admin, id FROM Users WHERE username = ? AND password = ?";
//        PreparedStatement preparedStatement = conn.prepareStatement(sql);
//        preparedStatement.setString(1, username);
//        preparedStatement.setString(2, password);
//        ResultSet rs = preparedStatement.executeQuery();
//        if (rs.next()) {
//            String name = rs.getString("name");
//            boolean isAdmin = rs.getBoolean("admin");
//            int id = rs.getInt("id");
//            rs.close();
//            preparedStatement.close();
//            return new Object[]{true, name, isAdmin, id};
//        } else {
//            rs.close();
//            preparedStatement.close();
//            return new Object[]{false, null, null};
//        }
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
