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
public class Petugas extends Orang{
    private String NIP;
    
    public Petugas(String name){
        super(name);
    }
    
    public Petugas(String name, String NIP){
        super(name);
        this.NIP = "P"+NIP;
        this.SetUsername(NIP);
    }
    
    public void SetNIP(String NIP){
        this.NIP = NIP;
    }
    
    public String GetNIP(){
        return NIP;
    }
}
