/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.time.*; 
import java.time.format.DateTimeFormatter;
/**
 *
 * @author User
 */
public class SumInterest {
    private boolean LeapYear = false;
    private boolean arrt = false;
    private int Days;
    private int DaysBefore;
    private int time = 1;
    private double fee = 0;
    private double Tfee = 0;
    private double pay;
    public int count = 0;
    private double amount;
    private LocalDate endDay;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public SumInterest(int days, int daysbefore){
        this.Days = days;
        this.DaysBefore = daysbefore;
    }
    
    public void setDays(int day){
        this.Days = day;
    }
    
    public int getDays(){
        return this.Days;
    }
    
    public void setDaysBe(LocalDate startdate,  LocalDate enddate){
        Period difference  = Period.between(startdate,  enddate);
        DaysBefore = difference.getDays() + (difference.getMonths() * 30);
    }
    
    public int getDaysBe(){
        return this.DaysBefore;
    }
    
    public void CheckLeap(int yyy){
        if ((yyy % 4 == 0 ) && ( yyy % 100 != 0)){
            LeapYear = true;
        }else if(yyy % 400 == 0){
            LeapYear = true;
        }
    }
    
    public void ManyDay(){
        if (LeapYear){
            setDays(366);
        }else{
            setDays(365);
        }
    }
    
    public void setFee(double interest){
        if (time == 1){
            fee =(((this.getAmount() * (interest / 100)) * (this.getDaysBe() - 1)) / this.getDays());
            Tfee += fee;
            //this.setAmount(this.getAmount() + fee);
            this.setAmount(this.getAmount() - this.getPay());
        }
        //time += ((int)amount / (int)pay) ;
        //for (int i = 0; i > time ; i ++){
        for (int i = 0; i < 99999999 ; i ++){
        //while (true){
            if (this.getAmount() <= 0){
                break;
            }
            fee = 0;
            //System.out.println(this.getAmount());
            fee =(((this.getAmount() * (interest / 100)) * (30)) / this.getDays());
            //System.out.println(fee);
            Tfee += fee;
            //this.setAmount(this.getAmount() + fee);
            this.setAmount(this.getAmount() - this.getPay());
            this.setTime(this.getTime() + 1);
        }
        fee = Tfee;
        for (int i = 0; i < 99999999 ; i ++){
            if (fee <= 0){
                break;
            }
            fee -= this.getPay();
            this.setTime(this.getTime() + 1);
        }
        
        Tfee = Math.floor( Tfee * 100 ) / 100;
    }
    
    public void setPay(int pless,int perless, double amount){
        if((amount * (perless / 100)) > pless){
            pay = amount * (perless / 100);
        } else{
            pay = pless;
        }
    }
    
    public double getPay(){
        return this.pay;
    }
    
    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return this.time;
    }
    
    public double getTFee(){
        return this.Tfee;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
    public void setDayCount(LocalDate enddate){
        this.endDay = enddate;
    }
    
    public LocalDate getDayCount(){
        return this.endDay;
    }
    
    public String Noti(){
        LocalDateTime startdate = LocalDateTime.now();
        String formattedDateTime = startdate.format(formatter);
        Period difference  = Period.between(LocalDate.parse(formattedDateTime, formatter),  this.getDayCount());
        return "There are " + difference.getMonths() + " months" + difference.getDays() + "days left before paying the credit card.";
    }
}
