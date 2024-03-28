/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.*;

/**
 *
 * @author Pattr
 */
public class Register extends DBconnect {
    public Register(){
        super();
    }
    public Object[] Login(String username, String password) throws SQLException {
        super.connect();
        String sql = "SELECT name, admin, id FROM Users WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            boolean isAdmin = rs.getBoolean("admin");
            int id = rs.getInt("id");
            AccountDetail accd = new AccountDetail(isAdmin, name, id);
            Account<AccountDetail> acc = new Account<>();
            acc.setAccount(accd);
            super.setID(id);
            rs.close();
            preparedStatement.close();
            super.disconnect();
            return new Object[]{true, acc.getAccount()};
        } else {
            rs.close();
            preparedStatement.close();
                    super.disconnect();
            return new Object[]{false, null, null, -1};
        }
    }
    
    public void createTable() throws SQLException {
        super.connect();
        String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(50) UNIQUE NOT NULL," +
                "password VARCHAR(50) NOT NULL," +
                "name VARCHAR(50) NOT NULL," +
                "admin BOOLEAN NOT NULL DEFAULT FALSE)";
        Statement stmt = super.getConnection().createStatement();
        String sql_2 = """
                             CREATE TABLE IF NOT EXISTS `recordsfinance` (
                               `id` INT NOT NULL,
                               `date` VARCHAR(45) NOT NULL,
                               `money` DOUBLE NOT NULL,
                               `type` VARCHAR(45) NOT NULL,
                               `detail` VARCHAR(45) NOT NULL);""";
        Statement stmt_2 = super.getConnection().createStatement();
        stmt.executeUpdate(sql);
        stmt_2.executeUpdate(sql_2);
        stmt.close();
        super.disconnect();
}
    
    public void createUser(String username, String password, String name) throws SQLException{
        super.connect();
        String sql = "INSERT INTO Users (username, password, name, admin) VALUES (?, ?, ?, FALSE)";
        PreparedStatement preparedStatement = super.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, name);
        preparedStatement.executeUpdate();
        super.disconnect();
    }
}