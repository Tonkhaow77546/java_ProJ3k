
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.swing.table.*;

public class Main_screen implements ActionListener, KeyListener {
    protected JFrame frame01;
    protected JPanel panelmain, panelTop, panelLow, panelCenter, panelView, panelTopView, panelTable, panel;
    private JTextField textMoney, textFor;
    private JLabel labelTop, labelDate, labelMoney, labelFor;
    private JButton bt_income, bt_expend, bt_view;
    private JDateChooser date, dateView;
    private JTable table;
    private JScrollPane scrollPane;
    //private DBconnect1 database;
    private String x, typee;
    private int count_point, last_row;
    private double total_income, total_expend;
    private DefaultTableModel model;
    private RecFinance recf;

    public Main_screen(Account acc) {
        count_point = 0;
        recf = new RecFinance();
        recf.setID(acc.GetID());
        //this.database = new DBconnect1(acc);
        panelmain = new JPanel();
        panelTop = new JPanel();
        panelLow = new JPanel();
        panelCenter = new JPanel();
        panelView = new JPanel();
        panelTopView = new JPanel();
        panel = new JPanel();
        panelTable = new JPanel();
        panelView.setLayout(new BorderLayout());
        date = new JDateChooser();
        dateView = new JDateChooser();
        table = new JTable();
        scrollPane = new JScrollPane();
        frame01 = new JFrame();
        textMoney = new JTextField(30);
        textMoney.addKeyListener(this);
        textFor = new JTextField(30);
        bt_view = new JButton("View");
        bt_view.addActionListener(this);

        panelTop.setLayout(new BorderLayout());
        panelLow.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(6, 1));
        labelTop = new JLabel("say hi!");
        labelDate = new JLabel("Choose Date");
        labelMoney = new JLabel("Money");
        labelFor = new JLabel("For / Where");
        panelTop.add(labelTop, BorderLayout.CENTER);
        bt_income = new JButton("Income");
        bt_income.addActionListener(this);
        bt_expend = new JButton("Expend");
        bt_expend.addActionListener(this);

        panelCenter.add(labelDate);
        panelCenter.add(date);
        panelCenter.add(labelMoney);
        panelCenter.add(textMoney);
        panelCenter.add(labelFor);
        panelCenter.add(textFor);

        panelLow.add(bt_income);
        panelLow.add(bt_expend);

        panelmain.setLayout(new BorderLayout());
        panelmain.add(panelTop, BorderLayout.NORTH);
        panelmain.add(panelCenter, BorderLayout.CENTER);
        panelmain.add(panelLow, BorderLayout.SOUTH);
        
        panelTable.setLayout(new BorderLayout());
        panelTable.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(table);
        
        panelTopView.add(dateView);
        panelTopView.add(bt_view);
        panelView.add(panelTopView, BorderLayout.NORTH);
        model = (DefaultTableModel)table.getModel();
        model.addColumn("No");
        model.addColumn("Money");
        model.addColumn("type");
        model.addColumn("detail");
        panelView.add(panelTable, BorderLayout.CENTER);
        
        panel.setLayout(new GridLayout(1, 2));
        panel.add(panelmain);
        panel.add(panelView);

        frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame01.add(panel);
        frame01.pack();
        frame01.setVisible(true);
    }

    public void addView(int loop, String date, DefaultTableModel model){
        total_income = 0;
        total_expend = 0;
        for(int i=1;i <= loop; i++) {
            System.out.println(i);
            String datatext = recf.search(i, date);
            String listdata[] = datatext.split(" ");
            model.addRow(new Object[0]);
            model.setValueAt(i, i-1, 0);
            model.setValueAt(listdata[0], i-1, 1);
            model.setValueAt(listdata[1], i-1, 2);
            model.setValueAt(listdata[2], i-1, 3);
            this.last_row = i;
            System.out.println("/" +listdata[1].toString()+"/");
            String hhh = "/" +listdata[1].toString()+"/";
            if ("/Income/".equals(hhh)){
                this.total_income += Double.parseDouble(listdata[0]);
            }
            else{
                this.total_expend += Double.parseDouble(listdata[0]);
            }
        }
        model.addRow(new Object[0]);
        model.setValueAt("Income = ", last_row, 0);
        model.setValueAt(total_income+"", last_row, 1);
        model.setValueAt("Expends = ", last_row, 2);
        model.setValueAt(total_expend+"", last_row, 3);
    }
    public String getUesDate(String x){
        String list_ofx[] = x.split(" ");
        String datee = list_ofx[2] + "/" +  list_ofx[1] +"/"+ list_ofx[5];
        DateTimeFormatter dtf_1 = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        DateTimeFormatter dtf_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String use_date = LocalDate.parse(datee, dtf_1).format(dtf_2);
        return use_date;
    }
    public void removeTable(DefaultTableModel model){
        while (true) {
                if (model.getRowCount() <= 0){
                    break;
                }
                model.removeRow(0);
            }
    }
    public void setTextfield(){
        this.textMoney.setText(textMoney.getText().substring(0, textMoney.getText().length()-1));
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        
        try{
            System.out.println(event.getSource());
            if (event.getSource() == bt_view){
                x = dateView.getDate().toString();    
            }
            else{
                x = date.getDate().toString();    
            }
            String use_date = this.getUesDate(x);
            if (event.getSource() == bt_view){
                this.removeTable(model);
                this.addView(recf.getCount(use_date), use_date, this.model);
            }
            else{
                if (event.getSource() == bt_income || event.getSource() == bt_expend) {
                    typee = "";
                    if (event.getSource() == bt_income){
                        typee = "Income";
                    }
                    else {
                        typee = "Expends";
                    }
                    if (textFor.getText().length() > 0){
                        recf.insertRow(use_date, Double.parseDouble(textMoney.getText()), typee, textFor.getText());
                    }
                    else{
                        recf.insertRow( use_date, Double.parseDouble(textMoney.getText()), typee, "None");
                    }
                } 
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please fill the information completely.", "", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            textFor.setText("");
            textMoney.setText("");
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) { 
        char ch = e.getKeyChar();
        if (ch == '.'){
            count_point += 1;
            if (count_point >= 2){
                this.setTextfield();
            }
            
        }
        else if (Character.isDigit(ch) == false){
            this.setTextfield();
        }
    }
    public static void main(String[] args){
        new Main_screen(new Account(true, "kk", 1));
    }
}
    
