import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fixed extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel left, right, input, output;
    private JTextField principleField, rateField, yearsField, totalInterestField, monthInterestField, monthInstallField, monthInstallpayField;
    private JLabel principleLabel, rateLabel, yearsLabel, totalInterestLabel, monthInterestLabel, monthInstallLabel, monthInstallpayLabel;
    private int principleNum, rateNum, yearsNum, totalInterestNum, monthInterestNum, monthInstallNum, monthInstallpayNum;
    private JButton clear, calculate, compound;
    public Fixed(){
        frame = new JFrame("Fixed interest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        left = new JPanel();
        right = new JPanel();
        output = new JPanel();
        input = new JPanel();
        principleField = new JTextField();
        principleLabel = new JLabel("Principle (Bath)");
        principleLabel.setHorizontalAlignment(0);
        rateField = new JTextField();
        rateLabel = new JLabel("Interest rate (%)");
        rateLabel.setHorizontalAlignment(0);
        yearsField = new JTextField();
        yearsLabel = new JLabel("Years");
        yearsLabel.setHorizontalAlignment(0);
        calculate = new JButton("Calculate");
        calculate.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        //I want to Create a button but I can't do that bro T-T
        //compound = new JButton("Compound interest ->");
        //compound.addActionListener(this);
        
        totalInterestField  = new JTextField(String.valueOf(totalInterestNum));
        totalInterestField.setEditable(false);
        totalInterestLabel = new JLabel("Total interest (Bath)");
        totalInterestLabel.setHorizontalAlignment(0);
        monthInterestField  = new JTextField(String.valueOf(monthInterestNum));
        monthInterestField.setEditable(false);
        monthInterestLabel = new JLabel("Interest/Month (Bath)");
        monthInterestLabel.setHorizontalAlignment(0);
        monthInstallField  = new JTextField(String.valueOf(monthInstallNum));
        monthInstallField.setEditable(false);
        monthInstallLabel = new JLabel("Installment/Month (Bath)");
        monthInstallLabel.setHorizontalAlignment(0);
        monthInstallpayField = new JTextField(String.valueOf(monthInstallpayNum));
        monthInstallpayField.setEditable(false);
        monthInstallpayLabel = new JLabel("Installment payment/Month (Bath)");
        monthInstallpayLabel.setHorizontalAlignment(0);
        
        frame.setSize(1920, 1080);
        frame.setLayout(new GridLayout(1, 2));
        frame.add(left);                                            frame.add(right);
        
        left.setLayout(new GridLayout(7,1));
        left.add(principleLabel);                                   left.add(principleField);
        left.add(rateLabel);                                        left.add(rateField);
        left.add(yearsLabel);                                       left.add(yearsField);
        left.add(clear);                                            left.add(calculate);
        
        right.setLayout(new GridLayout(7, 1));
        right.add(totalInterestLabel);                              right.add(totalInterestField);
        right.add(monthInterestLabel);                              right.add(monthInterestField);
        right.add(monthInstallLabel);                               right.add(monthInstallField);
        right.add(monthInstallpayLabel);                            right.add(monthInstallpayField);
        //right.add(compound);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Clear"))
        {
            principleField.setText(""); 
            rateField.setText("");
            yearsField.setText("");
            totalInterestField.setText("0");
            monthInterestField.setText("0");
            monthInstallField.setText("0");
            monthInstallpayField.setText("0");
        }
        else if (button.getText().equals("Calculate"))
        try {
            principleNum = Integer.parseInt(principleField.getText());
            rateNum = Integer.parseInt(rateField.getText());
            yearsNum = Integer.parseInt(yearsField.getText());
                
            if (principleNum <= 0 || rateNum < 0 || yearsNum < 0) {
                throw new IllegalArgumentException("Please enter valid values (greater than 0).");
            }

            calculate();
            totalInterestField.setText(String.valueOf((int)totalInterestNum));
            monthInterestField.setText(String.valueOf((int)monthInterestNum));
            monthInstallField.setText(String.valueOf((int)monthInstallNum));
            monthInstallpayField.setText(String.valueOf((int)monthInstallpayNum));
                
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            principleField.setText(""); 
            rateField.setText("");
            yearsField.setText("");
            totalInterestField.setText("0");
            monthInterestField.setText("0");
            monthInstallField.setText("0");
            monthInstallpayField.setText("0");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            principleField.setText(""); 
            rateField.setText("");
            yearsField.setText("");
            totalInterestField.setText("0");
            monthInterestField.setText("0");
            monthInstallField.setText("0");
            monthInstallpayField.setText("0");
        }
    }
    
    public void calculate(){
        totalInterestNum = (principleNum * (rateNum / 100) * yearsNum);
        monthInterestNum = ((principleNum * (rateNum / 100) * yearsNum) / (yearsNum * 12));
        monthInstallNum = (principleNum / (yearsNum * 12));
        monthInstallpayNum = (((principleNum + (principleNum * (rateNum / 100) * yearsNum))) / (yearsNum * 12));
    }
    
    public static void main(String[] args) {
            new Fixed();
        }
    }