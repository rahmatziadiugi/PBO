/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import java.util.ArrayList;

/**
 *
 * @author Someone-PC
 */
public class Gudang {
    private ArrayList<Barang> DaftarBarang;
    private String IDGudang;
    private String JenisBarang;
    private double VolumeMax;
    private double CurrentVolume;
    
    public Gudang(String IDGudang,double VolumeMax){
        this.IDGudang = IDGudang;
        this.VolumeMax = VolumeMax;
        this.CurrentVolume = 0;
        this.DaftarBarang = new ArrayList<>();
    }
    
    public void SetID(String ID){
        this.IDGudang = ID;
    }
    
    public String GetID(){
        return this.IDGudang;
    }
    
    public void SetJenis(String Jenis){
        this.JenisBarang = Jenis;
    }
    
    public String GetJenis(){
        return this.JenisBarang;
    }
    
    public void SetVolume(double v){
        this.VolumeMax = v;
    }
    
    public double GetVolume(){
        return this.VolumeMax;
    }
    
    public void AddBarang(Barang b, int n){
        /*memasukkan barang ke gudang*/
        boolean found = false;
        /*pengecekan barang udha ada atau belum
        kalau sudah ada hanya penambahan stok*/
        for(Barang DaftarBarang1 : this.DaftarBarang){
            if(DaftarBarang1.GetID()==b.GetID()){
                DaftarBarang1.SetStock(DaftarBarang1.GetStock()-n);
                found = true;
                break;
            }
        }
        /*kalau belum ada, membuat clone dari objek barang
        namun dengan jumlah stok yang bisa berbeda jumlahnya*/
        if(!found){
            this.DaftarBarang.add(new Barang(b.GetID(),b.GetJenis(),b.GetNama(),n,b.GetVolume()));
        }
    }
    
    public void removeBarang(Barang b, int n){
        /*mengurangi stok barang yang ada di gudang*/
        for(Barang DaftarBarang1 : this.DaftarBarang){
            if(DaftarBarang1.GetID()==b.GetID()){
                DaftarBarang1.SetStock(DaftarBarang1.GetStock()-n);
                break;
            }
        }
    }
    
    public void ViewAllBarang(){
        System.out.println("ID Gudang\t: "+this.IDGudang);
        System.out.print("Jenis Gudang\t: "+this.JenisBarang);
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
    
}
