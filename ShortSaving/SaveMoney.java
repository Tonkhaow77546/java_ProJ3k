/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShortSaving;

import retirement.Retire;

/**
 *
 * @author LAPTOP_PT
 */
public class SaveMoney extends Retire{
    private int day= 0;
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
    
    @Override
    public double calculateAll(){
        return (getMoneyWant()-getBegin())/getDay();
    }
}
