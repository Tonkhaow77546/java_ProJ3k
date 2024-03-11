//Formula calculated by https://www.set.or.th/th/education-research/education/happymoney/glossary/time-value-of-money?lang=th
package TimeValue.FutureValueHead;

import CustomException.MinusException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FutureValueUI implements ActionListener{
    private JFrame frame;
    private JPanel mainPanel, subPanel1, panelFrame;
    private JPanel subPresentResult, subReward, subTime, subButton, subResult;
    private JLabel JHeadLabel, JPresentLabel, JRewardLabel, JTimeLabel, JResult1, JResult2;
    private JPanel part1, part2, part3;
    private JTextField JPresentText, JRewardResultText, JTimeText;
    private JButton JSummitButton, JResetButton;
    private FutureValue futureValueFN;
    
    public FutureValueUI(){
        futureValueFN = new FutureValue();
        generateUI();
    }
    
    public void generateUI(){
//        frame = new JFrame();
//        frame.setSize(1920, 1080);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelFrame = new JPanel(new BorderLayout());
        panelFrame.setSize(1920, 1080);
//        frame.add(panelFrame, BorderLayout.CENTER);
        
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setSize(1920,1080);
        panelFrame.add(mainPanel, BorderLayout.CENTER);
        JPanel panelResult = new JPanel();
        panelResult.setPreferredSize(new Dimension(1920, 480));
        panelFrame.add(panelResult, BorderLayout.SOUTH);
        
        subPanel1 = new JPanel(new GridLayout(5, 1));
        mainPanel.add(subPanel1, BorderLayout.CENTER);
        
        JHeadLabel= new JLabel("Future Value: FV", SwingConstants.CENTER);
        JHeadLabel.setFont(new Font("Courier", Font.BOLD,22));
        subPanel1.add(JHeadLabel);
        
        part1 = new JPanel(new GridLayout(2,1));
        JPresentLabel = new JLabel("Present Value : ", SwingConstants.LEFT);
        JPresentLabel.setFont(new Font("Courier", Font.BOLD,16));
        part1.add(JPresentLabel);
        JPresentText = new JTextField("0");
        JPresentText.setPreferredSize(new Dimension(300,25));
        subPresentResult = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subPresentResult.add(JPresentText);
        subPresentResult.add(new JLabel("baht"));
        part1.add(subPresentResult);
        subPanel1.add(part1);
        
        part2 = new JPanel(new GridLayout(2,1));
        JRewardLabel = new JLabel("Rate of Return  : ", SwingConstants.LEFT);
        JRewardLabel.setFont(new Font("Courier", Font.BOLD,16));
        part2.add(JRewardLabel);
        JRewardResultText= new JTextField("0");
        JRewardResultText.setPreferredSize(new Dimension(300,25));
        subReward = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subReward.add(JRewardResultText);
        subReward.add(new JLabel("percent"));
        part2.add(subReward);
        subPanel1.add(part2);
        
        part3 = new JPanel(new GridLayout(2,1));
        JTimeLabel = new JLabel("Period  : ", SwingConstants.LEFT);
        JTimeLabel.setFont(new Font("Courier", Font.BOLD,16));
        part3.add(JTimeLabel);
        JTimeText= new JTextField("0");
        JTimeText.setPreferredSize(new Dimension(300,25));
        subTime = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subTime.add(JTimeText);
        subTime.add(new JLabel("year"));
        part3.add(subTime);
        subPanel1.add(part3);
        
        //button
        subButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSummitButton = new JButton("Calculate");
        JResetButton = new JButton("Reset");
        subButton.add(JSummitButton);
        subButton.add(JResetButton);
        subPanel1.add(subButton);
        
        //resultText
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

//        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(JSummitButton)){
            try{
                if( Double.parseDouble(JPresentText.getText()) < 0 || Double.parseDouble(JRewardResultText.getText()) < 0 ||
                    Integer.parseInt(JTimeText.getText()) < 0){
                    throw new MinusException("You cannot enter negative numbers.");
                }
                FutureValSetValue();
                setEditAllTextField(false);
                JResult1.setText("The future amount is " + String.valueOf(futureValueFN.calculate()) + " baht");
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "The information entered cannot be characters.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
            catch (MinusException ex) {
                JOptionPane.showMessageDialog(null, "You cannot enter negative numbers.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource().equals(JResetButton)){
            textFieldAllSet("0");
            setEditAllTextField(true);
            JResult1.setText("");
            JResult2.setText("");
        }
    }
    
    public void FutureValSetValue(){
        futureValueFN.setPresentVal(Double.parseDouble(JPresentText.getText()));
        futureValueFN.setReward(Double.parseDouble(JRewardResultText.getText()));
        futureValueFN.setTime(Integer.parseInt(JTimeText.getText()));             
    }
    
    public void textFieldAllSet(String data){
        JPresentText.setText(data);
        JRewardResultText.setText(data);
        JTimeText.setText(data);    
    }
    
    public void setEditAllTextField(boolean data){
        JPresentText.setEditable(data);
        JRewardResultText.setEditable(data);
        JTimeText.setEditable(data);
    }
    
    public JPanel getFrame(){
        return panelFrame;
    }
    
    
//    public static void main(String[] args) {
//        new FutureValueUI();
//    }
 }

