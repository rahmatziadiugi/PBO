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
public class Gudang {
    private Barang[] DaftarBarang;
    private String IDGudang;
    private String[] JenisBarang;
    private double VolumeMax;
    private double CurrentVolume;
    private int JenisTotal;
    private int JumlahBarang;
    
    public Gudang(){
        this.VolumeMax = 0;
        this.CurrentVolume = 0;
        this.JenisTotal = 0;
        this.JumlahBarang = 0;
        this.DaftarBarang = new Barang[99];
        this.JenisBarang = new String [5];
    }
    
    public void setID(String ID){
        this.IDGudang = ID;
    }
    
    public String getID(){
        return this.IDGudang;
    }
    
    public void addBarang(Barang b, int n){
        boolean found = false;
        /*pengecekan barang sesuai dengen jenis gudang atau tidak*/
        for(int i=0;i<this.JenisTotal;i++){
            if(this.JenisBarang[i]==b.getJenis()){
                /*pengecekan, masih ada slot gak digudang
                kalau gak ada slot lagi, tidak dimasukkan ke gudang
                */
                if((b.getVolume()*n)>(VolumeMax-CurrentVolume)){
                    System.out.println("Maaf, kapasitas barang melebihi sisa gudang");
                }
                else{
                    b.removeStock(n);
                    /*pengecekan, barang udah ada di gudang atau blum,
                    kalau udah cuma tambah stock,
                    kalau blum nambah daftar barang
                    */
                    for(int j=0;j<this.JumlahBarang;j++){
                        if(this.DaftarBarang[j].getID()==b.getID()){
                            found=true;
                            this.DaftarBarang[j].addStock(n);
                            break;
                        }
                    }
                    if(!found){
                        this.DaftarBarang[this.JumlahBarang] = b;
                        this.DaftarBarang[this.JumlahBarang].addStock(n);
                        this.JumlahBarang++;
                        found=true;
                    }
                    /* end cari barang*/
                }
                break;
                /*end cek slot gudang*/
            }
        }
        /*end check jenis*/
        if(!found){
            System.out.println("Maaf, barang tidak sesuai dengen jenis gudang");
        }
    }
    
    public void removeBarang(Barang b, int n){
        boolean found = false;
        /*cari barang ada atau gak*/
        for(int i=0;i<this.JumlahBarang;i++){
            if(this.DaftarBarang[i].getID()==b.getID()){
                found=true;
                this.DaftarBarang[i].removeStock(n);
                break;
            }
        }
        /*end cari barang*/
        if(!found){
            System.out.println("Barang tidak ditemukan");
        }
    }
    
}
