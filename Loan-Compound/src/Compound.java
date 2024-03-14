import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Compound extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel left, right, input, output;
    private JTextField principleField, rateField, paidField, daysField, periodField;
    private JLabel principleLabel, rateLabel, paidLabel, daysLabel, yearsLabel, periodLabel;
    private int principleNum, rateNum, paidNum, daysNum, yearsNum, periodNum;
    private JButton clear, calculate, fixed;
    private JComboBox daysCombo, yearsCombo;
    String[] days = {"28", "29", "30", "31"};
    String[] years = {"365", "366"};
    public Compound(){
        frame = new JFrame("Compound interest");
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
        paidField = new JTextField();
        paidLabel = new JLabel("The principal has been paid (Bath)");
        paidLabel.setHorizontalAlignment(0);
        daysField = new JTextField();
        daysLabel = new JLabel("Number of days in the month");
        daysLabel.setHorizontalAlignment(0);
        yearsLabel = new JLabel("Number of days in the year");
        yearsLabel.setHorizontalAlignment(0);
        calculate = new JButton("Calculate");
        calculate.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        //I want to Create a button but I can't do that bro T-T
        //fixed = new JButton("<- Fixed interest");
        //fixed.addActionListener(this);
        daysCombo = new JComboBox(days);
        daysCombo.setSelectedItem("30");
        daysCombo.addActionListener(this);
        yearsCombo = new JComboBox(years);
        yearsCombo.setSelectedItem("365");
        yearsCombo.addActionListener(this);
        
        periodField  = new JTextField(String.valueOf(periodNum));
        periodField.setEditable(false);
        periodLabel = new JLabel("Interest in this period (Bath)");
        periodLabel.setHorizontalAlignment(0);
        
        frame.setSize(1920, 1080);
        frame.setLayout(new GridLayout(1, 2));
        frame.add(left);                                            frame.add(right);
        
        left.setLayout(new GridLayout(7,1));
        left.add(principleLabel);                                   left.add(principleField);
        left.add(paidLabel);                                        left.add(paidField);
        left.add(rateLabel);                                        left.add(rateField);
        left.add(daysLabel);                                        left.add(daysCombo);
        left.add(yearsLabel);                                       left.add(yearsCombo);
        left.add(clear);                                            left.add(calculate);
        
        right.setLayout(new GridLayout(2, 1));
        right.add(periodLabel);                                     right.add(periodField);
        //right.add(fixed);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Clear"))
        {
            principleField.setText(""); 
            rateField.setText("");
            paidField.setText("");
            periodField.setText("0");
            daysCombo.setSelectedItem("30");
            yearsCombo.setSelectedItem("365");
        }
        else if (button.getText().equals("Calculate"))
        try {
            principleNum = Integer.parseInt(principleField.getText());
            rateNum = Integer.parseInt(rateField.getText());
            paidNum = Integer.parseInt(paidField.getText());
            comboSelected();
                
            if (principleNum <= 0 || rateNum < 0 || paidNum < 0) {
                throw new IllegalArgumentException("Please enter valid values (greater than 0).");
            }
            
            if (daysCombo.getSelectedItem().equals("28") & yearsCombo.getSelectedItem().equals("366")) {
                throw new IllegalArgumentException("The data is not related.");
            }
            
            if (daysCombo.getSelectedItem().equals("29") & yearsCombo.getSelectedItem().equals("365")) {
                throw new IllegalArgumentException("The data is not related.");
            }
            
            calculate();
            periodField.setText(String.valueOf((int)periodNum));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            principleField.setText(""); 
            rateField.setText("");
            paidField.setText("");
            periodField.setText("0.0");
            daysCombo.setSelectedItem("30");
            yearsCombo.setSelectedItem("365");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            principleField.setText(""); 
            rateField.setText("");
            paidField.setText("");
            periodField.setText("0.0");
            daysCombo.setSelectedItem("30");
            yearsCombo.setSelectedItem("365");
        }
    }
    
    public void calculate(){
        periodNum = (((((principleNum - paidNum) * (rateNum / 100) * daysNum)) / yearsNum));
    }
    
    public void comboSelected(){
        if (daysCombo.getSelectedItem().equals("28")){
            daysNum = 28;
        }
        if (daysCombo.getSelectedItem().equals("29")){
            daysNum = 29;
        }
        if (daysCombo.getSelectedItem().equals("30")){
            daysNum = 30;
        }
        if (daysCombo.getSelectedItem().equals("31")){
            daysNum = 31;
        }
        
        if (yearsCombo.getSelectedItem().equals("365")){
            yearsNum = 365;
        }
        if (yearsCombo.getSelectedItem().equals("366")){
            yearsNum = 366;
        }
}
    
    public static void main(String[] args) {
            new Compound();
        }
    }