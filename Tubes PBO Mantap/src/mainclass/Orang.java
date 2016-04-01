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
    
    public Orang(String Name){
        this.Name = Name;
    }
    
    public void SetName(String Name){
        this.Name = Name;
    }
    
    public String GetName(){
        return this.Name;
    }
}