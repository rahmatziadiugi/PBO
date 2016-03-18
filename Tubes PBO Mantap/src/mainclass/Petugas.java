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
    private long NIP;
    
    public Petugas(String name){
        super(name);
    }
    
    public Petugas(String name, long NIP){
        super(name);
        this.NIP = NIP;
    }
    
    public void setNIP(long NIP){
        this.NIP = NIP;
    }
    
    public long getNIP(){
        return NIP;
    }
}
