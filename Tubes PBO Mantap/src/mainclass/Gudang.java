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
    private String[] JenisBarang;
    private double VolumeMax;
    private double CurrentVolume;
    private int JenisTotal;
    
    public Gudang(String IDGudang,double VolumeMax){
        this.IDGudang = IDGudang;
        this.VolumeMax = VolumeMax;
        this.CurrentVolume = 0;
        this.JenisTotal = 0;
        this.DaftarBarang = new ArrayList<>();
        this.JenisBarang = new String [3];
    }
    
    public void SetID(String ID){
        this.IDGudang = ID;
    }
    
    public String GetID(){
        return this.IDGudang;
    }
    
    public void SetJenis(String Jenis){
        this.JenisBarang[this.JenisTotal] = Jenis;
        this.JenisTotal++;
    }
    
    public void SetJenis(String Jenis, int i){
        try{
            this.JenisBarang[i] = Jenis;
        }catch(Exception e){
            System.out.println("Input tidak sesuai");
        }
    }
    
    public String GetJenis(int i){
        return this.JenisBarang[i];
    }
    
    public void SetVolume(double v){
        this.VolumeMax = v;
    }
    
    public double GetVolume(){
        return this.VolumeMax;
    }
    
    public void AddBarang(Barang b, int n){
        boolean oldone = false;
        int a = -1;
        /*cek stok yang diminta cukup*/
        if(b.GetStock()<n){
            System.out.println("Stok tidak cukup");
        }
        else{
            /*cek gudang*/
            for(int i=0;i<this.JenisTotal;i++){
                if(this.JenisBarang[i] == null ? b.GetJenis() == null : this.JenisBarang[i].equals(b.GetJenis())){
                    /*cek slot di gudang*/
                    if((this.VolumeMax-this.CurrentVolume)>(b.GetVolume()*n)){
                        /*cek udah ada barang*/
                        for(Barang DaftarBarang1 : this.DaftarBarang){
                            if(DaftarBarang1.GetID() == null ? b.GetID() == null : DaftarBarang1.GetID().equals(b.GetID())){
                                oldone = true;
                                DaftarBarang1.AddStock(n);
                                break;
                            }
                        }
                        if(!oldone){
                            this.DaftarBarang.add(new Barang(b.GetID(),b.GetJenis(),b.GetNama(),n,b.GetVolume()));
                        }
                        this.CurrentVolume = this.CurrentVolume + (b.GetVolume()*n);
                        b.RemoveStock(n);
                    }
                    else{
                        System.out.println("Slot di gudang tidak cukup lagi");
                    }
                }
                else{
                    System.out.println("Gudang tidak sesuai");
                }
            }
        }
    }
    
    public void removeBarang(Barang b, int n){
        boolean found = false;
        /*cari barang ada atau gak*/
        for(Barang DaftarBarang1 : this.DaftarBarang){
            if(DaftarBarang1.GetID().equals(b.GetID())){
                found=true;
                this.CurrentVolume = this.CurrentVolume - (n * DaftarBarang1.GetVolume());
                /*cek stok cukup*/
                if(DaftarBarang1.GetStock()>n){
                    DaftarBarang1.RemoveStock(n);
                }
                else if(DaftarBarang1.GetStock()==n){
                    this.DaftarBarang.remove(DaftarBarang1);
                }
                else{
                    System.out.println("Stock tidak cukup");
                    b.RemoveStock(n);
                }
                b.AddStock(n);
                break;
            }
        }
    }
    
    public void ViewAllBarang(){
        System.out.println("ID Gudang\t: "+this.IDGudang);
        System.out.println("Jenis Gudang\t: ");
        for(int i=0;i<this.JenisTotal;i++){
            System.out.println("\t"+(i+1)+". "+this.JenisBarang[i]);
        }
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
