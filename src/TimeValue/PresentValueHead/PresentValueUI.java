//Formula calculated by https://www.set.or.th/th/education-research/education/happymoney/glossary/time-value-of-money?lang=th
package TimeValue.PresentValueHead;

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


public class PresentValueUI implements ActionListener{
    JFrame frame;
    JPanel mainPanel, subPanel1, panelFrame;
    JPanel subFutureResult, subReward, subTime, subButton, subResult;
    JLabel JFutureLabel, JRewardLabel, JTimeLabel, JResult1, JResult2;
    JPanel part1, part2, part3;
    JTextField JFutureText, JRewardResultText, JTimeText;
    JButton JSummitButton, JResetButton;
   
    PresentValue presentValueFN;
    
    public PresentValueUI(){
        presentValueFN = new PresentValue();
        generateUI();
    }
    
    public void generateUI(){
//        frame = new JFrame();
//        frame.setSize(1920, 1080);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
        panelFrame = new JPanel(new BorderLayout());
        panelFrame.setSize(1920, 1080);
//        frame.add(panelFrame, BorderLayout.CENTER);
        
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setSize(1920,1080);
        panelFrame.add(mainPanel, BorderLayout.CENTER);
        JPanel panelResult = new JPanel();
        panelResult.setPreferredSize(new Dimension(1920, 500));
        panelFrame.add(panelResult, BorderLayout.SOUTH);
        
        subPanel1 = new JPanel(new GridLayout(4, 1));
        mainPanel.add(subPanel1, BorderLayout.CENTER);
        
        //row1
        part1 = new JPanel(new GridLayout(2,1));
        JFutureLabel = new JLabel("Future Value : ", SwingConstants.LEFT);
        JFutureLabel.setFont(new Font("Courier", Font.BOLD,16));
        part1.add(JFutureLabel);
        
        JFutureText = new JTextField("0");
        JFutureText.setPreferredSize(new Dimension(300,25));
        subFutureResult = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subFutureResult.add(JFutureText);
        subFutureResult.add(new JLabel("baht"));
        part1.add(subFutureResult);
        subPanel1.add(part1);
        
        //row2
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
        
        //row3
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
                if( Double.parseDouble(JFutureText.getText()) < 0 || Double.parseDouble(JRewardResultText.getText()) < 0 ||
                    Integer.parseInt(JTimeText.getText()) < 0){
                    throw new MinusException("You cannot enter negative numbers.");
                }
                FutureValSetValue();
                setEditAllTextField(false);
                JResult1.setText("The present amount is " + String.valueOf(presentValueFN.calculate()) + " baht");
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
        presentValueFN.setFutureVal(Double.parseDouble(JFutureText.getText()));
        presentValueFN.setReward(Double.parseDouble(JRewardResultText.getText()));
        presentValueFN.setTime(Integer.parseInt(JTimeText.getText()));
                  
    }
    
    public void textFieldAllSet(String data){
        JFutureText.setText(data);
        JRewardResultText.setText(data);
        JTimeText.setText(data);
        
    }
    
    public void setEditAllTextField(boolean data){
        JFutureText.setEditable(data);
        JRewardResultText.setEditable(data);
        JTimeText.setEditable(data);

        
    }
    
    public JPanel getFrame(){
        return panelFrame;
    }
    
    
    public static void main(String[] args) {
        new PresentValueUI();
    }
}
