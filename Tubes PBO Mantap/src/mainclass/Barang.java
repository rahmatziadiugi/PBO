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
import java.util.*;

public class Barang {
    private String IDBarang;
    private String Jenis;
    private String NamaBarang;
    private int Stock;
    private double Volume;
    
    public Barang(){
        this.Stock = 0;
    }
    
    public Barang(String Jenis, String NamaBarang, int Stock, double Volume){
        this.Jenis = Jenis;
        this.NamaBarang = NamaBarang;
        this.Stock = Stock;
        this.Volume = Volume;
    }
    
    public Barang(String IDBarang, String Jenis, String NamaBarang, int Stock, double Volume){
        this.IDBarang = IDBarang;
        this.Jenis = Jenis;
        this.NamaBarang = NamaBarang;
        this.Stock = Stock;
        this.Volume = Volume;
    }
    
    public void SetID(String IDBarang){
        this.IDBarang = IDBarang;
    }
    
    public void SetJenis(String Jenis){
        this.Jenis = Jenis;
    }
    
    public void SetNama(String Nama){
        this.NamaBarang = Nama;
    }
        
    public void SetVolume(double Volume){
        this.Volume = Volume;
    }
    
    public String GetID(){
        return this.IDBarang;
    }
    
    public String GetJenis(){
        return this.Jenis;
    }
    
    public String GetNama(){
        return this.NamaBarang;
    }
        
    public int GetStock(){
        return this.Stock;
    }
    
    public double GetVolume(){
        return this.Volume;
    }
    
    public void AddStock(int n){
        this.Stock = this.Stock + n;
    }
    
    public void RemoveStock(int n){
        this.Stock = this.Stock - n;
    }
}
