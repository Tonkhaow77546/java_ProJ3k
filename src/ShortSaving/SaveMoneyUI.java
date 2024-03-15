
package ShortSaving;

import CustomException.DayException;
import CustomException.MinusException;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class SaveMoneyUI implements ActionListener {

    private JFrame frame;
    private JPanel mainPanel, subPanel1, panelFrame;
    private JPanel subAmountResult, subchooser1, subchooser2, subBegin, subButton, subResult;
    private JLabel JHeadLabel, JAmountLabel, JChoser1Label, JChoser2Label, JBeginLable, JResult1, JResult2;
    private JPanel part1, part2, part3, part4;
    private JTextField JAmount, JBeginText;
    private JButton JSummitButton, JResetButton;
    private JDateChooser chooser1, chooser2;
    private SaveMoney saveMoneyFn;

    public SaveMoneyUI() {
        saveMoneyFn = new SaveMoney();
        generateUI();
    }

    public void generateUI() {
        frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelFrame = new JPanel(new BorderLayout());
        panelFrame.setSize(1920, 1080);
        frame.add(panelFrame, BorderLayout.CENTER);

        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setSize(1920, 1080);
        panelFrame.add(mainPanel, BorderLayout.CENTER);
        JPanel panelResult = new JPanel();
        panelResult.setPreferredSize(new Dimension(1920, 550));
        panelFrame.add(panelResult, BorderLayout.SOUTH);

        subPanel1 = new JPanel(new GridLayout(14, 1));
        mainPanel.add(subPanel1, BorderLayout.CENTER);

        JHeadLabel = new JLabel("Short term Savings", SwingConstants.CENTER);
        JHeadLabel.setFont(new Font("Courier", Font.BOLD, 32));
        subPanel1.add(JHeadLabel);
        subPanel1.add(new Panel());

        part1 = new JPanel(new GridLayout(2, 1));
        JAmountLabel = new JLabel("Required amount : ", SwingConstants.LEFT);
        JAmountLabel.setFont(new Font("Courier", Font.BOLD, 16));
        part1.add(JAmountLabel);
        JAmount = new JTextField("0");
        JAmount.setPreferredSize(new Dimension(300, 25));
        subAmountResult = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subAmountResult.add(JAmount);
        subAmountResult.add(new JLabel("baht"));
        part1.add(subAmountResult);
        subPanel1.add(part1);

        part2 = new JPanel(new GridLayout(2, 1));
        JChoser1Label = new JLabel("Start  : ", SwingConstants.LEFT);
        JChoser1Label.setFont(new Font("Courier", Font.BOLD, 16));
        part2.add(JChoser1Label);
        chooser1 = new JDateChooser();
        chooser1.setPreferredSize(new Dimension(300, 25));
        subchooser1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subchooser1.add(chooser1);
        subchooser1.add(new JLabel("days"));
        part2.add(subchooser1);
        subPanel1.add(part2);

        part3 = new JPanel(new GridLayout(2, 1));
        JChoser2Label = new JLabel("Stop  : ", SwingConstants.LEFT);
        JChoser2Label.setFont(new Font("Courier", Font.BOLD, 16));
        part3.add(JChoser2Label);
        chooser2 = new JDateChooser();
        chooser2.setPreferredSize(new Dimension(300, 25));
        subchooser2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subchooser2.add(chooser2);
        subchooser2.add(new JLabel("days"));
        part3.add(subchooser2);
        subPanel1.add(part3);

        part4 = new JPanel(new GridLayout(2, 1));
        JBeginLable = new JLabel("Starting money  : ", SwingConstants.LEFT);
        JBeginLable.setFont(new Font("Courier", Font.BOLD, 16));
        part4.add(JBeginLable);
        JBeginText = new JTextField("0");
        JBeginText.setPreferredSize(new Dimension(300, 25));
        subBegin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subBegin.add(JBeginText);
        subBegin.add(new JLabel("baht"));
        part4.add(subBegin);
        subPanel1.add(part4);

        subButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSummitButton = new JButton("Calculate");
        JResetButton = new JButton("Reset");
        subButton.add(JSummitButton);
        subButton.add(JResetButton);
        subPanel1.add(subButton);

        subResult = new JPanel(new GridLayout(2, 1));
        JResult1 = new JLabel("");
        JResult1.setFont(new Font("Courier", Font.BOLD, 22));
        subResult.add(JResult1);
        JResult2 = new JLabel("");
        JResult2.setFont(new Font("Courier", Font.BOLD, 22));
        subResult.add(JResult2);
        panelResult.add(subResult);

        JSummitButton.addActionListener(this);
        JResetButton.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(JSummitButton)) {
            try {
                double i = Double.parseDouble(JAmount.getText());
                double j = Double.parseDouble(JBeginText.getText());
                if (chooser1.getDate().getTime() > chooser2.getDate().getTime()) {
                    throw new DayException("The end date cannot be less than the start date.");
                }
                if(Double.parseDouble(JAmount.getText()) < 0 || Double.parseDouble(JBeginText.getText()) < 0){
                    throw new MinusException("You cannot enter negative numbers.");
                }
                SaveMoneySetValue();
                setEditAllTextField(false);
                JResult1.setText("The amount of money that must be collected per day is " + String.valueOf(Calculate(chooser1.getCalendar(), chooser2.getCalendar())) + " baht");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "The information entered cannot be characters.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (DayException ex) {
                JOptionPane.showMessageDialog(null, "The end date cannot be less than the start date..", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (MinusException ex) {
                JOptionPane.showMessageDialog(null, "You cannot enter negative numbers.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getSource().equals(JResetButton)) {
            textFieldAllSet("0");
            setEditAllTextField(true);
            JResult1.setText("");
            JResult2.setText("");
        }
    }

    public void SaveMoneySetValue() {
        saveMoneyFn.setMoneyWant(Double.parseDouble(JAmount.getText()));
        saveMoneyFn.setBegin(Double.parseDouble(JBeginText.getText()));
    }

    public void textFieldAllSet(String data) {
        JAmount.setText(data);
        JBeginText.setText(data);
        chooser1.setToolTipText("");
        chooser2.setToolTipText("");
    }

    public void setEditAllTextField(boolean data) {
        JAmount.setEditable(data);
        JBeginText.setEditable(data);
        chooser1.setEnabled(data);
        chooser2.setEnabled(data);
    }
    
    public long Calculate(Calendar startDate, Calendar endDate) {
        //credit https://fwebsolution.blogspot.com/2012/04/java-carlendar.html?m=1
        Calendar date = (Calendar) startDate.clone();
        long daysBetween = 0;
        while (date.before(endDate)) {
          date.add(Calendar.DAY_OF_MONTH, 1);
          daysBetween++;
        }
        return (long) ((Double.parseDouble(JAmount.getText())-Double.parseDouble(JBeginText.getText()))/daysBetween);
   }
    
    public JPanel getFrame() {
        return panelFrame;
    }

    public static void main(String[] args) {
        new SaveMoneyUI();
    }
}
