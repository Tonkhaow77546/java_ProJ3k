/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Pattr
 */
public class Account<T extends AccountBase & Accessible> {
    private T account;
    public void setAccount(T account){
        this.account = account;
    }
    public T getAccount(){
        account.report();
        return account;
    }
}
