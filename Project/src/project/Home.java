/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Pattr
 */
public class Home extends JFrame {
    JLabel name;

    public Home(){
        this(new Account());
    }
    public Home(Account acc) {
        JFrame fr = new JFrame();
        String u_name = acc.GetName();
        name = new JLabel(u_name);
        fr.add(name);
        fr.setSize(300, 200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}