/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Pattr
 */
public class Home extends JFrame {
    JLabel name;
    JLabel admin;
    JLabel id;

    public Home(){
        this(new AccountDetail());
    }
    public Home(AccountDetail acc) {
        JFrame fr = new JFrame();
        String u_name = acc.GetName();
        name = new JLabel(u_name);
        admin = new JLabel(String.valueOf(acc.GetAdmin()));
        id = new JLabel(String.valueOf(acc.GetId()));
        fr.setLayout(new FlowLayout());
        fr.add(name);
        fr.add(admin);
        fr.add(id);
        fr.setSize(300, 200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}