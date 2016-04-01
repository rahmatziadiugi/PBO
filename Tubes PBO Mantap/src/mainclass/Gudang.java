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
        System.out.println("cek barang");
        /*cek stok yang diminta cukup*/
        if(b.GetStock()<n){
            System.out.println("Stok tidak cukup");
        }
        else{
            /*cek gudang*/
            for(int i=0;i<this.JenisTotal;i++){
                if(this.JenisBarang[i]==b.GetJenis()){
                    /*cek slot di gudang*/
                    if((this.VolumeMax-this.CurrentVolume)>(b.GetVolume()*n)){
                        /*cek udah ada barang*/
                        for(int j=0;j<this.DaftarBarang.size();i++){
                            if(this.DaftarBarang.get(j).GetID()==b.GetID()){
                                this.DaftarBarang.get(j).AddStock(n);
                                oldone = true;
                                break;
                            }
                        }
                        if(!oldone){
                            Barang brg = new Barang(b.GetID(),b.GetJenis(),b.GetNama(),b.GetStock(),b.GetVolume());
                            this.DaftarBarang.add(brg);
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
        for(int i=0;i<this.DaftarBarang.size()+1;i++){
            if(this.DaftarBarang.get(i).GetID().equals(b.GetID())){
                found=true;
                this.CurrentVolume = this.CurrentVolume - (n * this.DaftarBarang.get(i).GetVolume());
                /*cek stok cukup*/
                if(this.DaftarBarang.get(i).GetStock()>n){
                    this.DaftarBarang.get(i).RemoveStock(n);
                }
                else if(this.DaftarBarang.get(i).GetStock()==n){
                    this.DaftarBarang.remove(i);
                }
                else{
                    System.out.println("Stock tidak cukup");
                }
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
        for(int i=0;i<this.DaftarBarang.size();i++){
            System.out.print(this.DaftarBarang.get(i).GetID()+"\t\t");
            System.out.print(this.DaftarBarang.get(i).GetNama()+"\t\t");
            System.out.print(this.DaftarBarang.get(i).GetJenis()+"\t\t");
            System.out.print(this.DaftarBarang.get(i).GetStock());
            System.out.println();
        }
        System.out.println();
    }
    
}
