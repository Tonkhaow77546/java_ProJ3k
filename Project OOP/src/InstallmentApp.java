import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;


public class InstallmentApp extends JFrame implements ActionListener {
    private JTextField originalField;
    private JTextField installmentField;
    private JTextField interestField;
    private JTextField daysLeftField;
    private JTextField installmentDueField;
    private JButton calculateButton;
    private JButton resetButton;
    private JLabel paymentPerInstallmentLabel;
    private JLabel remainingInstallmentsLabel;
    private JLabel nextDaysLabel;
    private JLabel everyDaysLabel;
    private JTextField paidInstallmentsField;

    public InstallmentApp() {
        setTitle("Installment Calculator");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        //inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        

        originalField = new JTextField();
        installmentField = new JTextField();
        interestField = new JTextField();
        daysLeftField = new JTextField();
        installmentDueField = new JTextField();
        paidInstallmentsField = new JTextField("0");

        inputPanel.add(new JLabel("Original Price:"));
        inputPanel.add(originalField);
        inputPanel.add(new JLabel("Number of Installments:"));
        inputPanel.add(installmentField);
        inputPanel.add(new JLabel("Interest Rate (% per installment):"));
        inputPanel.add(interestField);
        inputPanel.add(new JLabel("Days before next installment:"));
        inputPanel.add(daysLeftField);
        inputPanel.add(new JLabel("Installment due every (days):"));
        inputPanel.add(installmentDueField);
        inputPanel.add(new JLabel("Paid Installments:"));
        inputPanel.add(paidInstallmentsField);
        
        TitledBorder inputBorder = BorderFactory.createTitledBorder("Input Details");
        inputBorder.setTitleJustification(TitledBorder.CENTER);
        inputPanel.setBorder(inputBorder);
        inputPanel.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        buttonPanel.add(calculateButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);


        paymentPerInstallmentLabel = new JLabel("");
        remainingInstallmentsLabel = new JLabel("");
        nextDaysLabel = new JLabel("");
        everyDaysLabel = new JLabel("");

        JPanel resultPanel = new JPanel(new GridLayout(5, 1));
        //resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        resultPanel.add(createBigLabel("Details"));
        resultPanel.add(paymentPerInstallmentLabel);
        resultPanel.add(remainingInstallmentsLabel);
        resultPanel.add(nextDaysLabel);
        resultPanel.add(everyDaysLabel);
        
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Payment Details");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        resultPanel.setBorder(titledBorder);
        
        resultPanel.setBackground(Color.WHITE);

        resultPanel.add(paymentPerInstallmentLabel);
        resultPanel.add(remainingInstallmentsLabel);
        resultPanel.add(nextDaysLabel);
        resultPanel.add(everyDaysLabel);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(resultPanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.CENTER);
    }

    private JLabel createBigLabel(String text) {
        JLabel label = new JLabel("<html><h2>" + text + "</h2></html>");
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
    

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == calculateButton) {
        try {
            double original = Double.parseDouble(originalField.getText());
            int installment = Integer.parseInt(installmentField.getText());
            double interest = Double.parseDouble(interestField.getText());
            int daysLeft = Integer.parseInt(daysLeftField.getText());
            int installmentDue = Integer.parseInt(installmentDueField.getText());
            int paidInstallments = Integer.parseInt(paidInstallmentsField.getText());

            if (original <= 0 || installment <= 0 || interest < 0 || paidInstallments < 0) {
                throw new IllegalArgumentException("Please enter valid values (greater than 0).");
            }

            Date futureInstallmentDate = new Date(daysLeft);
            remainingInstallmentsLabel.setText("Next installment due on: " + futureInstallmentDate.toString());
            remainingInstallmentsLabel.setHorizontalAlignment(JLabel.CENTER);

            Date nextInstallmentDate = new Date(daysLeft + installmentDue);
            Date currentDate = new Date();
            Date futureDate = new Date(daysLeft);

            double installmentAmount = (original * (1 + (interest / 100))) / installment;
            double remainingInstallments = (original * (1 + (interest / 100))) - (installmentAmount * paidInstallments);

            if (paidInstallments >= installment) {
                remainingInstallmentsLabel.setText("<html><h1>" + "All installments paid" + "</h1></html>");
                paymentPerInstallmentLabel.setText("");
                nextDaysLabel.setText("");
                everyDaysLabel.setText("");
            } else {
                paymentPerInstallmentLabel.setText("<html><h3>" + "Amount per installment: " + installmentAmount + "</h3></html>");
                paymentPerInstallmentLabel.setHorizontalAlignment(JLabel.CENTER);

                remainingInstallmentsLabel.setText("<html><h3>" + "Remaining installments: " + remainingInstallments + "</h3></html>");
                remainingInstallmentsLabel.setHorizontalAlignment(JLabel.CENTER);
                
                if (daysLeft == 0) {
                //remainingInstallmentsLabel.setText("Pay Now!");
                //paymentPerInstallmentLabel.setText("");
                nextDaysLabel.setText("<html><h2>" + "Pay Now!" + "</h2></html>");
                //everyDaysLabel.setText("");
                nextDaysLabel.setHorizontalAlignment(JLabel.CENTER);
                
                } else{nextDaysLabel.setText("<html><h3>" + "Next Installment Date " + futureDate.toString() + "</h3></html>");
                nextDaysLabel.setHorizontalAlignment(JLabel.CENTER);
                }

                if (installmentDue == 0) {
                //remainingInstallmentsLabel.setText("No more installments");
                //paymentPerInstallmentLabel.setText("");
                //nextDaysLabel.setText("");
                everyDaysLabel.setText("<html><h3>" + "No more installments" + "</h3></html>");
                everyDaysLabel.setHorizontalAlignment(JLabel.CENTER);
                
                } else{everyDaysLabel.setText("<html><h3>" + "Future Installment Date " + nextInstallmentDate.toString() + "</h3></html>");
                everyDaysLabel.setHorizontalAlignment(JLabel.CENTER);
                }
            }
            calculateButton.setText("Update Remaining Payment");
            calculateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    remainingInstallmentsLabel.setText("Remaining Payment: " + remainingInstallments);
                }
            });
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            paymentPerInstallmentLabel.setText("");
            remainingInstallmentsLabel.setText("");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            paymentPerInstallmentLabel.setText("");
            remainingInstallmentsLabel.setText("");
        }
    }
    else if (e.getSource() == resetButton) {
            originalField.setText("");
            installmentField.setText("");
            interestField.setText("");
            daysLeftField.setText("");
            installmentDueField.setText("");
            paidInstallmentsField.setText("0");
            paymentPerInstallmentLabel.setText("");
            remainingInstallmentsLabel.setText("");
            nextDaysLabel.setText("");
            everyDaysLabel.setText("");
        }
}
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InstallmentApp app = new InstallmentApp();
            app.setVisible(true);
        });
    }
}
