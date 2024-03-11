//Formula calculated by https://www.finnomena.com/planet46/beat-inflation-in-retirement/

package retirement;


import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CustomException.AgeException;
import CustomException.MinusException;
import CustomException.RetireAgeException;


public class RetireUI implements ActionListener{
    JFrame frame;
    JPanel mainPanel, subPanel1, panelFrame;
    JPanel subAgeResult, subAgeRetire, subMoneyAfterRetire, subEndOfLife, subInflation, subBegin, subButton, subResult;
    JLabel JHeadLabel, JAgeLabel, JAgeRetireLabel, JMoneyAfterRetireLabel, JEndOfLifeLabel, JInflationLable, JBeginLable, JResult1, JResult2;
    JPanel part1, part2, part3, part4, part5, part6;
    JTextField JAgeResultText, JAgeRetireResultText, JMoneyAfterRetireText, JEndOfLifeText, JInflationText, JBeginText;
    JButton JSummitButton, JResetButton;
   
    Retire retireFn;
    
    public RetireUI(){
        retireFn = new Retire();
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
        panelResult.setPreferredSize(new Dimension(1920, 350));
        panelFrame.add(panelResult, BorderLayout.SOUTH);
        
        subPanel1 = new JPanel(new GridLayout(14, 1));
        mainPanel.add(subPanel1, BorderLayout.CENTER);
        
        JHeadLabel= new JLabel("Retirement Planning", SwingConstants.CENTER);
        JHeadLabel.setFont(new Font("Courier", Font.BOLD,32));
        subPanel1.add(JHeadLabel);
        subPanel1.add(new Panel()); 
        
        part1 = new JPanel(new GridLayout(2,1));
        JAgeLabel = new JLabel("Your age  : ", SwingConstants.LEFT);
        JAgeLabel.setFont(new Font("Courier", Font.BOLD,16));
        part1.add(JAgeLabel);
        
        JAgeResultText = new JTextField("0");
        JAgeResultText.setPreferredSize(new Dimension(300,25));
        subAgeResult = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subAgeResult.add(JAgeResultText);
        subAgeResult.add(new JLabel("year"));
        part1.add(subAgeResult);
        subPanel1.add(part1);
        
        part2 = new JPanel(new GridLayout(2,1));
        JAgeRetireLabel= new JLabel("Retire at age  : ", SwingConstants.LEFT);
        JAgeRetireLabel.setFont(new Font("Courier", Font.BOLD,16));
        part2.add(JAgeRetireLabel);
        
        JAgeRetireResultText= new JTextField("0");
        JAgeRetireResultText.setPreferredSize(new Dimension(300,25));
        subAgeRetire = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subAgeRetire.add(JAgeRetireResultText);
        subAgeRetire.add(new JLabel("year"));
        part2.add(subAgeRetire);
        subPanel1.add(part2);
        
        part3 = new JPanel(new GridLayout(2,1));
        JMoneyAfterRetireLabel = new JLabel("Expenses after retirement  : ", SwingConstants.LEFT);
        JMoneyAfterRetireLabel.setFont(new Font("Courier", Font.BOLD,16));
        part3.add(JMoneyAfterRetireLabel);
        
        JMoneyAfterRetireText= new JTextField("0");
        JMoneyAfterRetireText.setPreferredSize(new Dimension(300,25));
        subMoneyAfterRetire = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subMoneyAfterRetire.add(JMoneyAfterRetireText);
        subMoneyAfterRetire.add(new JLabel("baht per month"));
        part3.add(subMoneyAfterRetire);
        subPanel1.add(part3);
        
        part4 = new JPanel(new GridLayout(2,1));
        JEndOfLifeLabel = new JLabel("Lifespan  : ", SwingConstants.LEFT);
        JEndOfLifeLabel.setFont(new Font("Courier", Font.BOLD,16));
        part4.add(JEndOfLifeLabel);
        
        JEndOfLifeText= new JTextField("0");
        JEndOfLifeText.setPreferredSize(new Dimension(300,25));
        subEndOfLife = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subEndOfLife.add(JEndOfLifeText);
        subEndOfLife.add(new JLabel("year"));
        part4.add(subEndOfLife);
        subPanel1.add(part4);
        
        part5 = new JPanel(new GridLayout(2,1));
        JInflationLable= new JLabel("Inflation rate  : ", SwingConstants.LEFT);
        JInflationLable.setFont(new Font("Courier", Font.BOLD,16));
        part5.add( JInflationLable);
        
        JInflationText= new JTextField("0");
        JInflationText.setPreferredSize(new Dimension(300,25));
        subInflation = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subInflation.add(JInflationText);
        subInflation.add(new JLabel("percent"));
        part5.add(subInflation);
        subPanel1.add(part5);
        
        part6 = new JPanel(new GridLayout(2,1));
        JBeginLable= new JLabel("Starting money  : ", SwingConstants.LEFT);
        JBeginLable.setFont(new Font("Courier", Font.BOLD,16));
        part6.add( JBeginLable);
        
        JBeginText = new JTextField("0");
        JBeginText.setPreferredSize(new Dimension(300,25));
        subBegin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subBegin.add(JBeginText);
        subBegin.add(new JLabel("baht"));
        part6.add(subBegin);
        subPanel1.add(part6);
        
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
                if(Integer.parseInt(JAgeResultText.getText()) > Integer.parseInt(JAgeRetireResultText.getText())){
                    throw new AgeException("The retirement age cannot be less than the current age.");
                }
                if(Integer.parseInt(JEndOfLifeText.getText()) < Integer.parseInt(JAgeRetireResultText.getText())){
                    throw new RetireAgeException("Life expectancy cannot be less than retirement age.");
                }
                if(Integer.parseInt(JEndOfLifeText.getText()) < 0 || Integer.parseInt(JAgeRetireResultText.getText()) < 0
                  || Double.parseDouble(JBeginText.getText()) < 0 || Double.parseDouble(JMoneyAfterRetireText.getText()) < 0
                  || Double.parseDouble(JInflationText.getText()) < 0 || Integer.parseInt(JAgeResultText.getText()) < 0){
                    throw new MinusException("You cannot enter negative numbers.");
                }
                retireSetValue();
                setEditAllTextField(false);
                JResult1.setText("The total amount of money you must have before retirement is "+String.valueOf((int)retireFn.calculateAll())+" baht");
                JResult2.setText("The amount of money that must be saved per month is "+String.valueOf((int)retireFn.calculatePerMonth())+" baht");
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "The information entered cannot be characters.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
            catch (AgeException ex) {
                JOptionPane.showMessageDialog(null, "The retirement age cannot be less than the current age.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
            catch (RetireAgeException ex) {
                JOptionPane.showMessageDialog(null, "Life expectancy cannot be less than retirement age.","ERROR",  JOptionPane.ERROR_MESSAGE);
            } catch (MinusException ex) {
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
    
    public void retireSetValue(){
        retireFn.setAge(Integer.parseInt(JAgeResultText.getText()));
        retireFn.setBegin(Double.parseDouble(JBeginText.getText()));
        retireFn.setDieAge(Integer.parseInt(JEndOfLifeText.getText()));
        retireFn.setExpen(Double.parseDouble(JMoneyAfterRetireText.getText()));
        retireFn.setInflation(Double.parseDouble(JInflationText.getText()));
        retireFn.setRetireAge(Integer.parseInt(JAgeRetireResultText.getText()));
    }
    
    public void textFieldAllSet(String data){
        JAgeResultText.setText(data);
        JBeginText.setText(data);
        JEndOfLifeText.setText(data);
        JMoneyAfterRetireText.setText(data);
        JInflationText.setText(data);
        JAgeRetireResultText.setText(data);
    }
    
    public void setEditAllTextField(boolean data){
        JAgeResultText.setEditable(data);
        JBeginText.setEditable(data);
        JEndOfLifeText.setEditable(data);
        JMoneyAfterRetireText.setEditable(data);
        JInflationText.setEditable(data);
        JAgeRetireResultText.setEditable(data);
        
    }
    
    public JPanel getFrame(){
        return panelFrame;
    }
    
    
    public static void main(String[] args) {
        new RetireUI();
    }
 }