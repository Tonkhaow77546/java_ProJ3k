import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Tax implements ActionListener {
    private static JFrame fr;
    private JTextField tf1, tf2, tf3, tf4, tnf1, tnf2, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17;
    private JButton bn;
    private JLabel l1, l2, l3, l4, l5, nl1, nl2, nl3, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21;
    private JCheckBox ck1, ck2, ck3, ck4, ck5;
    private JComboBox<String> c1;
    private JPanel mainPanel;

    public Tax() {

        //เเก้ไม่โปรเเกรมสร้าง JFRAME ใหม่(ชั่วคราวถ้ารู้วิธีอื่น)
        if (fr != null) {
            // JFrame already exists, do not recreate it.
            return;
        }

        fr = new JFrame();
        fr.setTitle("Tax Calculater");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        Font labelFont = new Font("Angsana New", Font.BOLD, 34);
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);
        tf4 = new JTextField(10);
        tnf1 = new JTextField(10);
        tnf2 = new JTextField(10);
        tf5 = new JTextField(10);
        tf6 = new JTextField(10);
        tf7 = new JTextField(10);
        tf8 = new JTextField(10);
        tf9 = new JTextField(10);
        tf10 = new JTextField(10);
        tf11 = new JTextField(10);
        tf12 = new JTextField(10);
        tf13 = new JTextField(10);
        tf14 = new JTextField(10);
        tf15 = new JTextField(10);
        tf16 = new JTextField(10);
        tf17 = new JTextField(10);

        bn = new JButton("Submit");
        l1 = new JLabel("Salary Baht/month:");
        nl1 = new JLabel("Bonus Baht:");
        nl2 = new JLabel("Other Income / year:");
        l2 = new JLabel("Expenses");
        l3 = new JLabel("Father-Mother Exemption:");
        l4 = new JLabel("Child");
        l5 = new JLabel("Tax to be Paid: ");
        nl3 = new JLabel("Status (Default is single):");
        l6 = new JLabel("Spouse Father-Mother Exemption (In the case of spouse has no income):");
        l7 = new JLabel("Disable/Incompetent person support:");
        ck5 = new JCheckBox("Disabled person:");
        l8 = new JLabel("Social Security Fund contribution (Max 9000 Baht):");
        l9 = new JLabel("Interest Paid for Loan purchase (Baht Deductible):");
        l10 = new JLabel("Life Insurance Premium (Max 100000 Baht):");
        l11 = new JLabel("Health Insurance Premium (Max 25000):");
        l12 = new JLabel("Health insurance premiums for father and mother:");
        l13 = new JLabel("Pension life insurance premiums:");
        l14 = new JLabel("Government Pension Fund (GPF):");
        l15 = new JLabel("National Savings Fund (NSF):");
        l16 = new JLabel("Private Teachers Welfare Fund");
        l17 = new JLabel("Invest in RMF:");
        l18 = new JLabel("Invest in SSF:");
        l19 = new JLabel("Invest in Thai ESG:");
        l20 = new JLabel("Donations for Education, Sports, Social Development, Public Hospitals:");
        l21 = new JLabel("Donations:");

        String status[] = { "Single", "Divorce", "Spouse has income(filing separately)", "Spouse has no income"};
        c1 = new JComboBox<>(status);

        ck1 = new JCheckBox("Father");
        ck2 = new JCheckBox("Mother");
        p2.setLayout(new GridLayout(1, 2));
        p2.add(ck1);
        p2.add(ck2);

        ck3 = new JCheckBox("Father");
        ck4 = new JCheckBox("Mother");
        p3.setLayout(new GridLayout(1, 2));
        p3.add(ck3);
        p3.add(ck4);

        //เเก้ Font
        l1.setFont(labelFont);
        l2.setFont(labelFont);
        l3.setFont(labelFont);
        l4.setFont(labelFont);
        l5.setFont(labelFont);
        nl1.setFont(labelFont);
        nl2.setFont(labelFont);
        c1.setFont(labelFont);
        nl3.setFont(labelFont);
        ck1.setFont(labelFont);
        ck2.setFont(labelFont);
        ck3.setFont(labelFont);
        ck4.setFont(labelFont);
        l6.setFont(labelFont);
        l7.setFont(labelFont);
        l8.setFont(labelFont);
        ck5.setFont(labelFont);
        l9.setFont(labelFont);
        l10.setFont(labelFont);
        l11.setFont(labelFont);
        l12.setFont(labelFont);
        l13.setFont(labelFont);
        l14.setFont(labelFont);
        l15.setFont(labelFont);
        l16.setFont(labelFont);
        l17.setFont(labelFont);
        l18.setFont(labelFont);
        l19.setFont(labelFont);
        l20.setFont(labelFont);
        l21.setFont(labelFont);

        p1.setLayout(new GridLayout(24, 2, 4, 5));
        p1.add(l1);
        p1.add(tf1);
        p1.add(nl1);
        p1.add(tnf1);
        p1.add(nl2);
        p1.add(tnf2);
        p1.add(l2);
        p1.add(tf2);
        p1.add(nl3);
        p1.add(c1);
        p1.add(l4);
        p1.add(tf4);
        p1.add(l3);
        p1.add(p2);
        p1.add(l6);
        p1.add(p3);
        p1.add(l7);
        p1.add(ck5);
        p1.add(l8);
        p1.add(tf3);
        p1.add(l9);
        p1.add(tf5);
        p1.add(l10);
        p1.add(tf6);
        p1.add(l11);
        p1.add(tf7);
        p1.add(l12);
        p1.add(tf8);
        p1.add(l13);
        p1.add(tf9);
        p1.add(l14);
        p1.add(tf10);
        p1.add(l15);
        p1.add(tf11);
        p1.add(l16);
        p1.add(tf12);
        p1.add(l17);
        p1.add(tf13);
        p1.add(l18);
        p1.add(tf14);
        p1.add(l19);
        p1.add(tf15);
        p1.add(l20);
        p1.add(tf16);
        p1.add(l21);
        p1.add(tf17);

        p1.add(bn);
        p1.add(l5);

        mainPanel = new JPanel();
        mainPanel.add(p1);

        bn.addActionListener(this);

        JScrollPane scroll = new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setVisible(true);
        
        mainPanel = new JPanel(new BorderLayout()); // Use BorderLayout to respect the size of the scroll pane.
        mainPanel.add(scroll, BorderLayout.CENTER); 

        fr.add(mainPanel);
        fr.setSize(1920, 1080);
        fr.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CalculateTax taxCalculator = new CalculateTax();
        double bonuns = 0;
        double o_income = 0;
        double expenses = 0;
        double exemption = 0;
        int child = 0;
        double socialSecurityFund = 0;
        double paidHouse = 0;
        double lifePaid = 0;
        double healPaid = 0;
        double healPaidFM = 0;
        double pensionPaid = 0;
        double GPF = 0;
        double NSF = 0;
        double PTWF = 0;
        double RMF = 0;
        double SSF = 0;
        double TESG = 0;
        double publicDonations = 0;
        double donations = 0;

        try {
            //เเปลงเป็น double
            double inCome = Double.parseDouble(tf1.getText());
            System.out.println(inCome);
            if(!tnf1.getText().isEmpty()){
                bonuns = Double.parseDouble(tnf1.getText());
            }
            if(!tnf2.getText().isEmpty()){
                o_income = Double.parseDouble(tnf2.getText());
            }
            if (!tf2.getText().isEmpty()) {
                expenses = Double.parseDouble(tf2.getText());
            }
            if (!tf4.getText().isEmpty()) {
                child = Integer.parseInt(tf4.getText());
            }
            if (!tf3.getText().isEmpty()) {
                socialSecurityFund = Double.parseDouble(tf3.getText());
            }
            if (!tf5.getText().isEmpty()) {
                paidHouse = Double.parseDouble(tf5.getText());
            }
            if (!tf6.getText().isEmpty()) {
                lifePaid = Double.parseDouble(tf6.getText());
            }
            if (!tf7.getText().isEmpty()) {
                healPaid = Double.parseDouble(tf7.getText());
            }
            if (!tf8.getText().isEmpty()) {
                healPaidFM = Double.parseDouble(tf8.getText());
            }
            if (!tf9.getText().isEmpty()) {
                pensionPaid = Double.parseDouble(tf9.getText());
            }
            if (!tf10.getText().isEmpty()) {
                GPF = Double.parseDouble(tf10.getText());
            }
            if (!tf11.getText().isEmpty()) {
                NSF = Double.parseDouble(tf11.getText());
            }
            if (!tf12.getText().isEmpty()) {
                PTWF = Double.parseDouble(tf12.getText());
            }
            if (!tf13.getText().isEmpty()) {
                RMF = Double.parseDouble(tf13.getText());
            }
            if (!tf14.getText().isEmpty()) {
                SSF = Double.parseDouble(tf14.getText());
            }
            if (!tf15.getText().isEmpty()) {
                TESG = Double.parseDouble(tf15.getText());
            }
            if (!tf16.getText().isEmpty()) {
                publicDonations = Double.parseDouble(tf16.getText());
            }
            if (!tf17.getText().isEmpty()) {
                donations = Double.parseDouble(tf17.getText());
            }

            if (child >= 0){
            exemption+= child*30000;
            }

            //พ่อเเละเเม่
            if(ck1.isSelected()){
                exemption+=30000;
            }
            if(ck2.isSelected()){
                exemption+=30000;
            }
            //ผู้พิการ
            if(ck5.isSelected()){
                exemption+=60000;
            }

            //ยกเว้นบิดา-มารดาของคู่สมรส (กรณีคู่สมรสไม่มีรายได้) 30000
            //กรณีคู่สมรสไม่มีรายได้  ลดหย่อนได้ 60,000 บาทต่อปี
            if(c1.getSelectedItem().equals("Spouse has no income")){
                if(ck3.isSelected()){
                    exemption+=30000;
                }
                if(ck4.isSelected()){
                    exemption+=30000;
                }
                exemption += 60000;
            }

            //เงินประกันสังคม
            if(socialSecurityFund <= 9000 && socialSecurityFund > 0){
                exemption+=socialSecurityFund;
            }else if(socialSecurityFund > 9000){
                exemption += 9000;
            }

            if(paidHouse <= 100000 && paidHouse > 0){
                exemption += paidHouse;
            }else if(paidHouse > 100000){
                exemption += 100000;
            }

            if(healPaid <= 25000 && healPaid > 0){
                exemption += healPaid;
            }else if(healPaid > 25000){
                exemption += 25000;
            }

            if(lifePaid + healPaid <= 100000)
                if(lifePaid <= 100000 && lifePaid > 0){
                    exemption += lifePaid;
                }else if(lifePaid > 100000){
                    exemption += 100000;
                }if(healPaid <= 25000 && lifePaid > 0){
                    exemption += lifePaid;
                }else if(lifePaid > 25000){
                    exemption += 25000;
                }
            else{
                exemption += 100000;
            }

            if(healPaidFM <= 15000 && healPaidFM > 0){
                exemption += healPaidFM;
            }else if(healPaidFM > 15000){
                exemption += 15000;
            }


            //ไม่เกิน 15% ของรายได้ทั้งปี ไม่เกิน 200,000 บาท หากไม่ได้ใช้สิทธิประกันชีวิตทั่วไป 
            //สามารถนำมารวมได้สูงสุด 300,000 บาทและรวมกับกองทุนอื่นไม่เกิน 500,000 บาท
            int limit = 0;
            if(lifePaid <= 0){
                limit = 100000;
                //มีเเก้เพิ่ม
            }

            double PLIP = 0;
            if(pensionPaid <= 200000 + limit && pensionPaid > 0 ){
                if(pensionPaid <= (inCome*12) * (15.0/100)){
                    PLIP += pensionPaid;
                }
                else{
                    PLIP += ((inCome*12) * (15.0/100));
                }
            }else if(pensionPaid > 200000 + limit){
                if(PLIP <= (inCome*12) * (15.0/100) && (inCome*12) * (15.0/100) <= 200000){
                    PLIP = (inCome*12) * (15.0/100);
                }else{
                    PLIP += 200000 + limit;
                }
            }

            //เชคขีดจำกัดกองทุน รวมกับกองทุนอื่นไม่เกิน 500,000 บาท
            double GPF_KEEP = 0;
            double NSF_KEEP = 0;
            double RMF_KEEP = 0;
            double SSF_KEEP = 0;
            double PTWF_KEEP = 0;

            if(NSF <= 13200 && NSF > 0){
                NSF_KEEP += NSF;
            }
            else if(NSF > 13200){
                NSF_KEEP += 13200;
            }

            if(PTWF <= ((inCome*12) * (15.0/100)) && PTWF > 0){
                PTWF_KEEP += PTWF;
            }else if(PTWF > ((inCome*12) * (15.0/100))){
                PTWF_KEEP += ((inCome*12) * (15.0/100));
            }

            if(GPF <= ((inCome*12) * (15.0/100)) && GPF > 0){
                GPF_KEEP += GPF;
            }else if(GPF > ((inCome*12) * (15.0/100))){
                GPF_KEEP += ((inCome*12) * (15.0/100));
            }

            //RMF 30% ของรายได้ทั้งปี และรวมกับกองทุนกลุ่มเกษียณ ไม่เกิน 500,000 บาท
            if(RMF <= 200000 && RMF > 0 ){
                if(RMF <= (inCome*12) * (30.0/100)){
                    RMF_KEEP += RMF;
                }
                else{
                    RMF_KEEP += ((inCome*12) * (30.0/100));
                }
            }else if(RMF > 200000){
                if(RMF <= (inCome*12) * (30.0/100) && (inCome*12) * (30.0/100) <= 200000){
                    RMF_KEEP += (inCome*12) * (30.0/100);
                }else{
                    RMF_KEEP += 200000;
                }
            }
            //SSF 30% ของรายได้ทั้งปี ไม่เกิน 200,000 บาทและรวมกับกองทุนกลุ่มเกษียณ ไม่เกิน 500,000 บาท
            if(SSF <= 200000 && SSF > 0 ){
                if(SSF <= (inCome*12) * (30.0/100)){
                    SSF_KEEP += SSF;
                }
                else{
                    SSF = ((inCome*12) * (30.0/100));
                }
            }else if(SSF > 200000){
                if(SSF <= (inCome*12) * (30.0/100) && (inCome*12) * (30.0/100) <= 200000){
                    SSF_KEEP += (inCome*12) * (30.0/100);
                }else{
                    SSF_KEEP += 200000;
                }
            }

            //รวมทุกกองทุน กองทุนสำรองเลี้ยงชีพ, ประกันชีวิตบำนาญ,กองทุนออมแห่งชาติ, กองทุน ครูเอกชนกองทุนบำเหน็จบำนาญข้าราชการ, SSF และ RMF รวมกันต้องไม่เกิน 500,000 บาท
            if(GPF_KEEP+NSF_KEEP+PTWF_KEEP+PLIP+RMF_KEEP +SSF_KEEP <= 500000){
                exemption += (GPF_KEEP+NSF_KEEP+PTWF_KEEP+PLIP + RMF_KEEP +SSF_KEEP);
            }else if(GPF_KEEP+NSF_KEEP+PTWF_KEEP+PLIP+RMF_KEEP+SSF_KEEP > 500000){
                exemption += 500000;

            }

            //ThaiESG 30% ของรายได้ทั้งปี ไม่เกิน 100,000 บาทและไม่รวมกับกองทุนกลุ่มเกษียณ(SSF, RMF)
            if(TESG <= 100000 && TESG > 0 ){
                if(TESG <= (inCome*12) * (30.0/100)){
                    exemption = TESG;
                }
                else{
                    exemption = ((inCome*12) * (30.0/100));
                }
            }else if(TESG > 100000){
                if(TESG <= (inCome*12) * (30.0/100) && (inCome*12) * (30.0/100) <= 100000){
                    exemption = (inCome*12) * (30.0/100);
                }else{
                    expenses += 100000;
                }
            }

            //ลดหย่อน 2 เท่าของเงินที่จ่ายจริง แต่ไม่เกิน 10% ของเงินได้สุทธิ
            if(publicDonations * 2 <= exemption * (10.0/100)){
                exemption += publicDonations * 2;
            }else if(publicDonations * 2 > exemption * (10.0/100)){
                exemption += (exemption * (10.0/100));
            }

            if(donations <= exemption * (10.0/100)){
                exemption += donations;
            }else if(donations > exemption * (10.0/100)){
                exemption += (exemption * (10.0/100));
            }

            
            double taxableIncome = ((inCome*12) +bonuns+o_income) - expenses - (exemption + 60000);
            taxCalculator.no_Tax(inCome, bonuns, c1.getSelectedItem(), taxableIncome);
            double tax = taxableIncome * (taxCalculator.TAX / 100.0);

            DecimalFormat df = new DecimalFormat("#0.00");
            l5.setText("Tax to be Paid(Year): " + df.format(tax));

        } catch (NumberFormatException nfe) {
            throw new ArithmeticException("Please enter valid numbers.");
        }
        
    }
    public JPanel getFrame(){
        return mainPanel;
    }
    public static void main(String[] args) {
        new Tax();
    }
}
