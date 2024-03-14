import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Installment extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel left, right, input, output;
    private JTextField priceField, paymentField, rateField, yearsField, amountField, totalField, installField;
    private JLabel priceLabel, paymentLabel, rateLabel, yearsLabel, amountLabel, totalLabel, installLabel;
    private int priceNum, paymentNum, rateNum, yearsNum, amountNum, totalNum, installNum;
    private JButton clear, calculate;
    public Installment(){
        frame = new JFrame("Installments");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        left = new JPanel();
        right = new JPanel();
        output = new JPanel();
        input = new JPanel();
        priceField = new JTextField();
        priceLabel = new JLabel("Price (Bath)");
        priceLabel.setHorizontalAlignment(0);
        paymentField = new JTextField();
        paymentLabel = new JLabel("Down payment (Bath)");
        paymentLabel.setHorizontalAlignment(0);
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
        
        amountField  = new JTextField(String.valueOf(amountNum));
        amountField.setEditable(false);
        amountLabel = new JLabel("Financing amount (Bath)");
        amountLabel.setHorizontalAlignment(0);
        totalField = new JTextField(String.valueOf(totalNum));
        totalField.setEditable(false);
        totalLabel = new JLabel("Total (Bath)");
        totalLabel.setHorizontalAlignment(0);
        installField = new JTextField(String.valueOf(installNum));
        installLabel = new JLabel("Installment/Month (Bath)");
        installLabel.setHorizontalAlignment(0);
        installField.setEditable(false);
        
        frame.setSize(1920, 1080);
        frame.setLayout(new GridLayout(1, 2));
        frame.add(left);                                            frame.add(right);
        
        left.setLayout(new GridLayout(9,1));
        left.add(priceLabel);                                       left.add(priceField);
        left.add(paymentLabel);                                     left.add(paymentField);
        left.add(rateLabel);                                        left.add(rateField);
        left.add(yearsLabel);                                       left.add(yearsField);
        left.add(clear);                                            left.add(calculate);
        
        right.setLayout(new GridLayout(5, 1));
        right.add(amountLabel);                                     right.add(amountField);
        right.add(totalLabel);                                      right.add(totalField);
        right.add(installLabel);                                    right.add(installField);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Clear"))
        {
            priceField.setText(""); 
            paymentField.setText("");
            rateField.setText("");
            yearsField.setText("");
            amountField.setText("0");
            totalField.setText("0");
            installField.setText("0");
        }
        else if (button.getText().equals("Calculate"))
        try {
            priceNum = Integer.parseInt(priceField.getText());
            paymentNum = Integer.parseInt(paymentField.getText());
            rateNum = Integer.parseInt(rateField.getText());
            yearsNum = Integer.parseInt(yearsField.getText());
                
            if (priceNum <= 0 || paymentNum <= 0 || rateNum < 0 || yearsNum < 0) {
                throw new IllegalArgumentException("Please enter valid values (greater than 0).");
            }
            if (paymentNum >= priceNum) {
                throw new IllegalArgumentException("Down payment shouldn't be more than the price.");
            }

            calculate();
            amountField.setText(String.valueOf((int)amountNum));
            totalField.setText(String.valueOf((int)totalNum));
            installField.setText(String.valueOf((int)installNum));
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            priceField.setText("");
            paymentField.setText("");
            rateField.setText("");
            yearsField.setText("");
            amountField.setText("0");
            totalField.setText("0");
            installField.setText("0");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            priceField.setText("");
            paymentField.setText("");
            rateField.setText("");
            yearsField.setText("");
            amountField.setText("0");
            totalField.setText("0");
            installField.setText("0");
        }
    }
    
    public void calculate(){
        amountNum = priceNum - paymentNum;
        totalNum = ((priceNum - paymentNum) + ((priceNum - paymentNum) * (rateNum / 100) * yearsNum));
        installNum = (((priceNum - paymentNum) + ((priceNum - paymentNum) * (rateNum / 100) * yearsNum)) / (yearsNum * 12));
    }
    
    public static void main(String[] args) {
            new Installment();
        }
    }