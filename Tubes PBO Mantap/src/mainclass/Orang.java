/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

/**
 *
 * @author Someone-PC
 */
public abstract class Orang {
    private String Name;
    private String Username;
    private String Password;
    private int PIN;
    
    public Orang(String Name){
        this.Name = Name;
    }
    
    public void SetName(String Name){
        this.Name = Name;
    }
    
    public String GetName(){
        return this.Name;
    }
    
    public void SetUsername(String username){
        this.Username = username;
    }
    
    public String GetUsername(){
        return this.Username;
    }
    
    public void SetPassword(String password){
        this.Password = password;
    }
    
    public String GetPassword(){
        return this.Password;
    }
    
    public void SetPIN(int pin){
        this.PIN = pin;
    }
    
    public int GetPIN(){
        return this.PIN;
    }
}