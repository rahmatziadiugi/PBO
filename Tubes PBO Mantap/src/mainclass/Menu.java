import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

/**
 *
 * @author janu
 */
public class Menu {

private ArrayList<petugas> daftarPetugas=new ArrayList<>();
private ArrayList<penyedia> daftarPenyedia=new ArrayList<>();
private ArrayList<gudang> daftarGudang=new ArrayList<>();
private petugas p;
private penyedia s;
private barang b;
private stock t;


        
    public void login(){
               
    }
    
    public void lupaPassword(){
        
    }

    public void addPetugas(petugas p){
        daftarPetugas.add(p);
    }
    
    public void removePetugas(petugas p){
        daftarPetugas.remove(p);
    }
    
    public void addPenyedia(penyedia s){
        daftarPenyedia.add(s);
    }
    
    public void removePenyedia(penyedia s){
        daftarPenyedia.add(s);
    }
    
    public void addBarang(barang b){
        s.createBarang();
    }
    
    public void removeBarang(){
        s.removeBarang();
    }
    
    public void tambahStock(){
        t.addStock();
    }
    
    public void ambilStock(){
        t.removeStock();
    }
    
    public void ambilBarang(){
        
    }
    
    public void taruhBarang(){
        
    }
    
    public void dataBarang() {
        for (gudang daftarGudang1:this.daftarGudang){
            daftarGudang1.viewAllBarang;           
       
        }
    }
    
    public void tambahGudang(gudang g){
        daftarGudang.addGudang(g);
    }
    
    public void removeGudang(gudang g){
        daftarGudang.removeGudang(g);
    }
    
    public void editGudang(gudang g){
        daftarGudang.editGudang(g);
    }
}
