package mainclass;

import java.util.ArrayList;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author janu
 */
public class Menu {
    
    private ArrayList<Petugas> DaftarPetugas = new ArrayList<>();
    private ArrayList<Penyedia> DaftarPenyedia = new ArrayList<>();
    private ArrayList<Gudang> DaftarGudang = new ArrayList<>();
    private Petugas p;
    private Penyedia s;
    private Gudang g;
    private Barang b;
    private int JenisTotal;
    private login l;
        
    public class login { //inner class
        scanner show = new System.in();
        System.out.println("ID       : ");    
        Id = show.next();
        System.out.println("Password : ");
        Id = show.next();
        
    }
    public void login(){
        this.login.add(l);
        
    }
    
    public void lupaPassword(){
        //belum dibikin classnya
    }

    public void AddPetugas(Petugas p){
        this.DaftarPetugas.add(p);
    }
    
    public void RemovePetugas(Petugas p){
        this.DaftarPetugas.remove(p);
    }
    
    public void addPenyedia(Penyedia s){
        this.DaftarPenyedia.add(s);
    }
    
    public void RemovePenyedia(Penyedia s){
        this.DaftarPenyedia.remove(s);
    }
    
    public void AddBarang(String Jenis, String NamaBarang, int Stock, int Volume){
        this.s.CreateBarang(Jenis,NamaBarang,Stock,Volume);
    }
    
    public void RemoveBarang(Barang b){
        this.s.RemoveBarang(b);
    }
    
    public void TambahStock(Barang b, int n){
        this.s.AddStockBarang(b, n);
    }
    
    public void ambilStock(Barang b, int n){
        this.s.RemoveStockBarang(b, n);
    }
    
    public void ambilBarang(Barang b, int n){
        this.g.removeBarang(b, n);
        this.s.AddStockBarang(b, n);
    }
    
    public void taruhBarang(Barang b, int n){
        this.s.RemoveStockBarang(b, n);
        this.g.AddBarang(b, n);
    }
    
    public void dataBarang() {
        for (Gudang DaftarGudang1 : this.DaftarGudang){
            DaftarGudang1.ViewAllBarang();
        }
    }
    public void tambahGudang(Gudang g){
        this.DaftarGudang.add(g);
    }
    
    public void RemoveGudang(Gudang g){
        this.DaftarGudang.remove(g);
    }
    
    public void editGudang(Gudang g){
            this.DaftarGudang.remove(g);
            this.DaftarGudang.add(g);
        }
    }
}
