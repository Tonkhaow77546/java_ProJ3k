/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShortSaving;


/**
 *
 * @author LAPTOP_PT
 */
public class SaveMoney{
    private int day= 0;
    private double begin = 0;
    private double moneyWant = 0;    
   
    public SaveMoney(){
        this(0, 0, 0);
    }
    
    public SaveMoney(int day, double moneyWant, double begin){
        setDay(day);
        setMoneyWant(moneyWant);
        setBegin(begin);
    }
    
        public void setDay(int day){
        this.day= day;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setMoneyWant(double moneyWant){
        this.moneyWant = moneyWant;
    }
    
    public double getMoneyWant(){
        return moneyWant;
    }
    
    public void setBegin(double begin){
        this.begin = begin;
    }
    
    public double getBegin(){
        return begin;
    }
    
}
