/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShortSaving;

import ShortSaving.CustomException.DayException;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SaveMoneyUI implements ActionListener{
    JFrame frame;
    JPanel mainPanel, subPanel1, panelFrame;
    JPanel subAmountResult, subAgeRetire, subBegin, subButton, subResult;
    JLabel JHeadLabel, JAmountLabel, JAgeRetireLabel, JBeginLable, JResult1, JResult2;
    JPanel part1, part2, part3;
    JTextField JAmount, JDayText, JBeginText;
    JButton JSummitButton, JResetButton;
   
    SaveMoney saveMoneyFn;
    
    public SaveMoneyUI(){
        saveMoneyFn = new SaveMoney();
        generateUI();
    }
    
    public void generateUI(){
       frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelFrame = new JPanel(new BorderLayout());
        panelFrame.setSize(1920, 1080);
        frame.add(panelFrame, BorderLayout.CENTER);
        
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setSize(1920,1080);
        panelFrame.add(mainPanel, BorderLayout.CENTER);
        JPanel panelResult = new JPanel();
        panelResult.setPreferredSize(new Dimension(1920, 550));
        panelFrame.add(panelResult, BorderLayout.SOUTH);
        
        subPanel1 = new JPanel(new GridLayout(14, 1));
        mainPanel.add(subPanel1, BorderLayout.CENTER);
        
        JHeadLabel= new JLabel("Short term Savings", SwingConstants.CENTER);
        JHeadLabel.setFont(new Font("Courier", Font.BOLD,32));
        subPanel1.add(JHeadLabel);
        subPanel1.add(new Panel()); 
        
        part1 = new JPanel(new GridLayout(2,1));
        JAmountLabel = new JLabel("Required amount : ", SwingConstants.LEFT);
        JAmountLabel.setFont(new Font("Courier", Font.BOLD,16));
        part1.add(JAmountLabel);
        
        JAmount= new JTextField("0");
        JAmount.setPreferredSize(new Dimension(300,25));
        subAmountResult = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subAmountResult.add(JAmount);
        subAmountResult.add(new JLabel("baht"));
        part1.add(subAmountResult);
        subPanel1.add(part1);
        
        part2 = new JPanel(new GridLayout(2,1));
        JAgeRetireLabel= new JLabel("Savings period  : ", SwingConstants.LEFT);
        JAgeRetireLabel.setFont(new Font("Courier", Font.BOLD,16));
        part2.add(JAgeRetireLabel);
        
        JDayText = new JTextField("0");
        JDayText.setPreferredSize(new Dimension(300,25));
        subAgeRetire = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subAgeRetire.add(JDayText);
        subAgeRetire.add(new JLabel("days"));
        part2.add(subAgeRetire);
        subPanel1.add(part2);
        
        part3 = new JPanel(new GridLayout(2,1));
        JBeginLable= new JLabel("Starting money  : ", SwingConstants.LEFT);
        JBeginLable.setFont(new Font("Courier", Font.BOLD,16));
        part3.add( JBeginLable);
        
        JBeginText = new JTextField("0");
        JBeginText.setPreferredSize(new Dimension(300,25));
        subBegin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subBegin.add(JBeginText);
        subBegin.add(new JLabel("baht"));
        part3.add(subBegin);
        subPanel1.add(part3);
        
        subButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSummitButton = new JButton("Calculate");
        JResetButton = new JButton("Reset");
        subButton.add(JSummitButton);
        subButton.add(JResetButton);
        subPanel1.add(subButton);
        
        subResult = new JPanel(new GridLayout(2,1));
        JResult1 = new  JLabel("");
        JResult1.setFont(new Font("Courier", Font.BOLD,22));
        subResult.add(JResult1);
        JResult2 = new JLabel("");
        JResult2.setFont(new Font("Courier", Font.BOLD,22));
        subResult.add(JResult2);
        panelResult.add(subResult);
        
        JSummitButton.addActionListener(this);
        JResetButton.addActionListener(this);

        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource().equals(JSummitButton)){
            try{
                if(Integer.parseInt(JDayText.getText()) == 0){
                    throw new DayException("The number of days cannot be 0.");
                }
                retireSetValue();
                setEditAllTextField(false);
                JResult1.setText("The amount of money that must be collected per day is "+String.valueOf((int)saveMoneyFn.calculateAll())+" baht");
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "The information entered cannot be characters.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
            catch (DayException ex) {
                JOptionPane.showMessageDialog(null, "The number of days cannot be 0.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        if(e.getSource().equals(JResetButton)){
            textFieldAllSet("0");
            setEditAllTextField(true);
            JResult1.setText("");
            JResult2.setText("");
        }
    }
    
    public void retireSetValue(){
       saveMoneyFn.setMoneyWant(Double.parseDouble(JAmount.getText()));
       saveMoneyFn.setBegin(Double.parseDouble(JBeginText.getText()));
       saveMoneyFn.setDay(Integer.parseInt(JDayText.getText()));
    }
    
    public void textFieldAllSet(String data){
        JAmount.setText(data);
        JBeginText.setText(data);
        JDayText.setText(data);
    }
    
    public void setEditAllTextField(boolean data){
        JAmount.setEditable(data);
        JBeginText.setEditable(data);
        JDayText.setEditable(data);
    }
    
    public JPanel getFrame(){
        return panelFrame;
    }
    
    
    public static void main(String[] args) {
        new SaveMoneyUI();
    }
 }