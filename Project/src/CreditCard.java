/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
/**
 *
 * @author User
 */
public class CreditCard extends JFrame implements ActionListener{
    private JFrame jf;
    private TextField tFee;
    private TextField tPerPay;
    private TextField tLessPay;
    private TextField tAmount;
    private TextField tFirstDay;
    private TextField tDDay;
    private JPanel palFaA; //this is "L" not one 
    private JPanel palPerPaPL;
    private JPanel palDayaDD;
    private JPanel palButt;
    private JPanel palAddNoti; 
    private JPanel palSum;
    private JButton buttRe;
    private JButton buttCal;
    private JButton buttAddNoti;
    private JLabel lbInaFee;
    private JLabel lbMini;
    private JLabel lbLower;
    private JLabel lbAmount;
    private JLabel lbFrist;
    private JLabel lbDDay;
    private JLabel lbSAmount;
    private JLabel lbsAAmount;
    private JLabel lbsSInter;
    private JLabel lbsAInter;
    private JLabel lbsSNum;
    private JLabel lbsANum;
    private JLabel lbsSLower;
    private JLabel lbALower;
    private JLabel lbSmini;
    private JLabel lbsAmini;
    private JLabel lbsSInaFee;
    private JLabel lbsAInaFee;
    private JLabel lbNoti;
    private JPanel fpa1; // this one fpa1 = free panel
    private JPanel fpa2;
    private JPanel fpa3;
    private JPanel fpa4;
    private JPanel mpal; // mpal = main panel
    private JPanel pal0;
    
    private SumInterest si;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public CreditCard(){
        
        jf = new JFrame("CreditCard");
        jf.setLayout(new GridLayout());
        jf.setSize(1920, 1080);
        
        pal0 = new JPanel();
        pal0.setLayout(new GridLayout(1,3));
        
        fpa1 = new JPanel();
        fpa2 = new JPanel();
        fpa3 = new JPanel();
        fpa4 = new JPanel();
        
        mpal = new JPanel();
        mpal.setLayout(new GridLayout(6,2));
        
        palFaA = new JPanel();
        palFaA.setLayout(new GridLayout(2, 2));
        tFee = new TextField();
        lbInaFee = new JLabel("      Interest and Fee");
        lbInaFee.setFont(new Font("Arial", Font.CENTER_BASELINE, 60));
        tAmount = new TextField();
        lbAmount = new JLabel("   Amount");
        lbAmount.setFont(new Font("Arial", Font.CENTER_BASELINE, 60));
        
        palFaA.add(lbInaFee);
        palFaA.add(lbAmount);
        palFaA.add(tFee);
        palFaA.add(tAmount);
        
        palPerPaPL = new JPanel();
        palPerPaPL.setLayout(new GridLayout(2, 2));
        tPerPay = new TextField();
        lbMini = new JLabel("   Minimum reimbursement(%)");
        lbMini.setFont(new Font("Arial", Font.CENTER_BASELINE, 60));
        tLessPay = new TextField();
        lbLower = new JLabel("   Amount is not lower than");
        lbLower.setFont(new Font("Arial", Font.CENTER_BASELINE, 60));
        
        palPerPaPL.add(lbMini);
        palPerPaPL.add(lbLower);
        palPerPaPL.add(tPerPay);
        palPerPaPL.add(tLessPay);
        
        palDayaDD = new JPanel();
        palDayaDD.setLayout(new GridLayout(2, 2));
        tDDay = new TextField("dd/mm/yyyy");
        lbFrist = new JLabel("   Transaction day");
        lbFrist.setFont(new Font("Arial", Font.CENTER_BASELINE, 60));
        tFirstDay = new TextField("dd/mm/yyyy");
        lbDDay = new JLabel("   Payment due date");
        lbDDay.setFont(new Font("Arial", Font.CENTER_BASELINE, 60));
        
        palDayaDD.add(lbFrist);
        palDayaDD.add(lbDDay);
        palDayaDD.add(tFirstDay);
        palDayaDD.add(tDDay);
        
        
        
        palButt = new JPanel();
        palButt.setLayout(new GridLayout(1, 3));
        buttRe = new JButton("Reset");
        buttCal = new JButton("Calculate");
        
        palButt.add(buttRe);
        palButt.add(fpa1);
        palButt.add(buttCal);
        
        palAddNoti = new JPanel();
        palAddNoti.setLayout(new GridLayout(1, 1));
        lbNoti = new JLabel("Want to add Notification pay date? ");
        buttAddNoti = new JButton("Add");
        
        palAddNoti.add(lbNoti);
        palAddNoti.add(buttAddNoti);
        
        palSum = new JPanel();
        palSum.setLayout(new GridLayout(6, 2));
        lbSAmount = new JLabel();
        lbsAAmount = new JLabel();
        lbsSInter = new JLabel();
        lbsAInter = new JLabel();
        lbsSNum = new JLabel();
        lbsANum = new JLabel();
        lbsSLower = new JLabel();
        lbALower = new JLabel();
        lbSmini = new JLabel();
        lbsAmini = new JLabel();
        lbsSInaFee = new JLabel();
        lbsAInaFee = new JLabel();
        
        palSum.add(lbSAmount);
        palSum.add(lbsAAmount);
        palSum.add(lbsSInter);
        palSum.add(lbsAInter);
        palSum.add(lbsSNum);
        palSum.add(lbsANum);
        palSum.add(lbsSLower);
        palSum.add(lbALower);
        palSum.add(lbSmini);
        palSum.add(lbsAmini);
        palSum.add(lbsSInaFee);
        palSum.add(lbsAInaFee);
        
        
        
        
        buttRe.addActionListener(this);
        buttCal.addActionListener(this);
        buttAddNoti.addActionListener(this);
        
        mpal.add(palFaA);
        mpal.add(palPerPaPL);
        mpal.add(palDayaDD);
        mpal.add(palButt);
        mpal.add(palSum);
        //mpal.add(palAddNoti);
        
        
        //pal0.add(fpa1, BorderLayout.NORTH);
        //pal0.add(fpa2, BorderLayout.SOUTH);
        //pal0.add(fpa3, BorderLayout.EAST);
        //pal0.add(fpa4, BorderLayout.WEST);
        pal0.add(fpa3);
        pal0.add(mpal);
        pal0.add(fpa4);
        
        //jf.add(fpa3);
        jf.add(pal0);
        //jf.add(fpa4);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
        
    @Override    
    public void actionPerformed(ActionEvent e) {
        Object sc = e.getSource();
        if (sc.equals(buttRe)) {
            tFee.setText("");
            tPerPay.setText("");
            tLessPay.setText("");
            tAmount.setText("");
            tFirstDay.setText("");
            tDDay.setText("");
            
            lbSAmount.setText("");
            lbsSInter.setText("");
            lbsSNum.setText("");
            lbsSLower.setText("");
            lbSmini.setText("");
            lbsSInaFee.setText("");

            lbsAAmount.setText("");
            lbsAInter.setText("");
            lbsANum.setText("");
            lbALower.setText("");
            lbsAmini.setText("");
            lbsAInaFee.setText("");
        } else if (sc.equals(buttCal)) {
            try{
                this.si = new SumInterest(365, 2);
                
                if (Integer.valueOf(tAmount.getText()) <= 0 || Integer.valueOf(tFee.getText())<= 0 || Integer.valueOf(tLessPay.getText()) < 0 || Integer.valueOf(tPerPay.getText()) < 0) {
                    throw new IllegalArgumentException("Please enter valid values (greater than 0).");
                }
                
                if (tFirstDay.getText().length() != 10 || tDDay.getText().length() != 10){
                    throw new IllegalArgumentException("Please enter the date like dd/mm/yyyy");
                }
                if (Integer.valueOf(tFirstDay.getText().substring(3, 5)) > 12 || Integer.valueOf(tFirstDay.getText().substring(3, 5)) < 1 || Integer.valueOf(tDDay.getText().substring(3, 5)) > 12 || Integer.valueOf(tDDay.getText().substring(3, 5)) < 1){
                    throw new IllegalArgumentException("Please enter the date like dd/mm/yyyy (if one digit number fill 0)");
                }
                if (Integer.valueOf(tFirstDay.getText().substring(0, 2)) > 31 || Integer.valueOf(tFirstDay.getText().substring(0, 2)) < 1 || Integer.valueOf(tDDay.getText().substring(0, 2)) > 31 || Integer.valueOf(tDDay.getText().substring(0, 2)) < 1){
                    throw new IllegalArgumentException("Please enter the date like dd/mm/yyyy (if one digit number fill 0)");
                }
                si.setDaysBe(LocalDate.parse(tFirstDay.getText(), formatter), LocalDate.parse(tDDay.getText(), formatter));
                
                if(si.getDaysBe() < 0){
                    throw new IllegalArgumentException("Please enter date Transaction day before Payment due date");
                }
                si.CheckLeap(Integer.valueOf((tFirstDay.getText()).substring(6)));
                si.ManyDay();
                si.setAmount(Integer.valueOf(tAmount.getText()));
                si.setPay(Integer.valueOf(tLessPay.getText()), Integer.valueOf(tPerPay.getText()), Double.valueOf(tAmount.getText()));
                si.setFee(Double.valueOf(tFee.getText()));
                
                

                lbSAmount.setText("Amount");
                lbsSInter.setText("All Interest");
                lbsSNum.setText("Number of installments");
                lbsSLower.setText("Amount is not lower than");
                lbSmini.setText("Minimum reimbursement(%)");
                lbsSInaFee.setText("Interest and Fee");

                lbsAAmount.setText(tAmount.getText());
                lbsAInter.setText(String.valueOf(si.getTFee()));
                lbsANum.setText(String.valueOf(si.getTime()));
                lbALower.setText(tLessPay.getText());
                lbsAmini.setText(tPerPay.getText());
                lbsAInaFee.setText(tFee.getText());
                
                mpal.add(palAddNoti);
                
                if (sc.equals(buttRe)) {
                    si.setDayCount(LocalDate.parse(tDDay.getText(), formatter));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
                tFee.setText("");
                tPerPay.setText("");
                tLessPay.setText("");
                tAmount.setText("");
                tFirstDay.setText("");
                tDDay.setText("");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                tFee.setText("");
                tPerPay.setText("");
                tLessPay.setText("");
                tAmount.setText("");
                tFirstDay.setText("");
                tDDay.setText("");
            }
    }
}
    public JPanel getCreditFrame(){
        return pal0;
    }
}


//cr: https://www.ktc.co.th/article/knowledge/credit-card-interest-charge-method