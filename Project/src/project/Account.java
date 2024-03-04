/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Pattr
 */
public class Account{
    private boolean admin;
    private String name;
    public Account(){
        this(false, "");
    }
    public Account(boolean i_admin, String i_name){
        this.admin = i_admin;
        this.name = i_name;
    }
    public boolean GetAdmin(){
        return admin;
    }
    public String GetName(){
        return name;
    }
}