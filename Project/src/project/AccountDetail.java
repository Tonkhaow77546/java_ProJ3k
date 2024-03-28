/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Pattr
 */
public class AccountDetail extends AccountBase implements  Accessible{
    private boolean admin;
    private String name;
    private int id;
    public AccountDetail(){
        this(false, "", -1);
    }
    public AccountDetail(boolean i_admin, String i_name, int i_id){
        this.admin = i_admin;
        this.name = i_name;
        this.id = i_id;
    }
    @Override
    public boolean GetAdmin(){
        return admin;
    }
    @Override
    public String GetName(){
        return name;
    }
    @Override
    public int GetId(){
        return id;
    }

    @Override
    public void report() {
        System.out.println("--------------------------");
        System.out.println("Admin Status: " + admin);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("--------------------------");
    }
}