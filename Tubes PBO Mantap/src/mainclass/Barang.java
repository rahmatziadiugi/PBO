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
public class Barang {
    private String IDBarang;
    private String Jenis;
    private String NamaBarang;
    private int Stok;
    private double Volume;
    
    public Barang(){
        this.Stok = 0;
    }
    
    public void setID(String ID){
        this.IDBarang = ID;
    }
    
    public void setJenis(String jenis){
        this.Jenis = jenis;
    }
    
    public void setNama(String nama){
        this.NamaBarang = nama;
    }
        
    public void setVolume(double v){
        this.Volume = v;
    }
    
    public String getID(){
        return this.IDBarang;
    }
    
    public String getJenis(){
        return this.Jenis;
    }
    
    public String getNama(){
        return this.NamaBarang;
    }
    
    
    public int getStock(){
        return this.Stok;
    }
    
    public double getVolume(){
        return this.Volume;
    }
    
    public void addStock(int n){
        this.Stok = this.Stok + n;
    }
    
    public void removeStock(int n){
        //pengencekan supaya stok tidak minus
        if((this.Stok-n)<0){
            n=Stok;
            this.Stok = 0;
        }
}
