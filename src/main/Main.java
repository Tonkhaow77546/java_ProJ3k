/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author LAPTOP_PT
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double total = 375.99;
        System.out.println("please insert your monitor size 38 or 43 only");
        int sizeMonitor = sc.nextInt();
        double priceMonitor = 0;
        if(sizeMonitor==38){
            priceMonitor += 75.99;
            total += 75.99;
        }else if(sizeMonitor==43){
            priceMonitor += 99.99;
            total += 99.99;
        }
        System.out.println("Do you want DVD-ROM? 1 is Yes/0 is No");
        int dvd = sc.nextInt();
        System.out.println("Do you want printer? 1 is Yes/0 is No");
        int printer = sc.nextInt();
        System.out.println("======= Your order =======");
        System.out.println("* computer >>> "+(375.99)+"$");
        System.out.println("* "+sizeMonitor+"'Monitor >>> "+(priceMonitor)+"$");
        if(dvd==1){
            System.out.println("* "+"DVD-Rom >>> "+(65.99)+"$");
            total += 65.99;
        }if(printer==1){
            System.out.println("* "+"Printer >>> "+(125.00)+"$");
            total += 125.00;
        }
        System.out.println("======= Total price >>> "+total+" =======");
    }
    
}
