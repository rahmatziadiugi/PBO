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

public class Penyedia extends Orang{
    private ArrayList<Barang> DaftarBarang;
    private String ID;
    
    public Penyedia(String Name, String ID){
        super(Name);
        this.DaftarBarang = new ArrayList<>();
        this.ID = ID;
    }
    
    public String GetID(){
        return this.ID;
    }

    public void CreateBarang(String Jenis, String NamaBarang, int Stock, double Volume){
        Barang b = new Barang(Jenis,NamaBarang,Stock,Volume);
        this.DaftarBarang.add(b);
        String id = this.ID.substring(0,3)+ Jenis.substring(0,1) + NamaBarang.substring(0,2);
        this.DaftarBarang.get(this.DaftarBarang.indexOf(b)).SetID(id);
    }
    
    public int GetIndexBarang(Barang b){
        boolean found = false;
        for(int i=0;i<this.DaftarBarang.size();i++){
            if(this.DaftarBarang.get(i).GetID().equals(b.GetID())){
                return i;
            }
        }
        return -1;
    }
    
    public Barang GetBarang(int i){
        try{
            return this.DaftarBarang.get(i);
        }catch(Exception e){
            System.out.println("Indeks salah");
            return null;
        }
    }
    
    public void RemoveBarang(int indeks){
        try{
            this.DaftarBarang.remove(indeks);
        }catch(Exception x){
            System.out.println("Remove barang gagal");
        }
    }
    
    public void RemoveBarang(Barang b){
        for(Barang DaftarBarang1 : this.DaftarBarang){
            if(DaftarBarang1.GetID().equals(b.GetID())){
                this.DaftarBarang.remove(DaftarBarang1);
                break;
            }
        }
    }
    
    public void RemoveAll(){
        try{
            this.DaftarBarang.clear();
        }catch(NullPointerException e){
            System.out.println("Daftar sudah kosong");
        }catch(Exception e){
            System.out.println("Remove semua barang gagal");
        }
    }
    
    public void ViewAllBarang(){
        System.out.println("Nama\t: "+this.GetName());
        System.out.println("ID\t: "+this.ID);
        System.out.println("ID Barang\tBarang\t\tJenis\t\t\tStok");
        for (Barang DaftarBarang1 : this.DaftarBarang) {
            System.out.print(DaftarBarang1.GetID() + "\t\t");
            System.out.print(DaftarBarang1.GetNama() + "\t\t");
            System.out.print(DaftarBarang1.GetJenis() + "\t\t");
            System.out.print(DaftarBarang1.GetStock());
            System.out.println();
        }
        System.out.println();
    }
    
    public void AddStockBarang(Barang b, int n){
        for(Barang DaftarBarang1 : this.DaftarBarang){
            if(DaftarBarang1.GetID().equals(b.GetID())){
                DaftarBarang1.AddStock(n);
                break;
            }
        }
    }
    
    public void RemoveStockBarang(Barang b, int n){
        for(Barang DaftarBarang1 : this.DaftarBarang){
            if(DaftarBarang1.GetID().equals(b.GetID())){
                DaftarBarang1.RemoveStock(n);
                break;
            }
        }
    }
 
}
