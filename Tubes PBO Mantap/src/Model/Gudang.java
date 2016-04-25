/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Riri
 */
public class Gudang {

    private ArrayList<Barang> daftarBarang;
    private String idGudang;
    private static int nVolumeGudang;
    private int volumeMaxGudang;

    public Gudang(String idGudang, int volumeMaxGudang) {
        daftarBarang = new ArrayList<>();
        this.idGudang = idGudang;
        this.volumeMaxGudang = volumeMaxGudang;
    }

    Gudang(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    public void addBarang(Barang b) {
        if ((volumeMaxGudang-nVolumeGudang) >= b.getStock()) {
            daftarBarang.add(b);
            nVolumeGudang+=b.getStock();
        } else {
            System.out.println("Gudang sudah penuh !");
        }
        
    }

    public void removeBarang(int indeks) {
        nVolumeGudang-=daftarBarang.get(indeks).getStock();
        daftarBarang.remove(indeks);
        
    }
    
    public void viewAll() {
        System.out.println("");
        System.out.println("Data Gudang  : " + this.getIdGudang());
        System.out.println("========================");
        int i=1;
        for (Barang brg:  daftarBarang) {
            System.out.println("===========================");
            System.out.println("Indeks Barang : "+i);
            System.out.println("ID Barang : "+brg.getIdBarang());
            System.out.println("Nama Barang: "+brg.getNamaBarang());
            System.out.println("Jenis Barang : "+brg.getJenisBarang());
            System.out.println("Stock Barang: "+brg.getStock());
            System.out.println("===========================");
            i++;
        }
        System.out.println("Sisa Kapasitas = " + (this.getVolumeMaxGudang()- nVolumeGudang));
    }

    public String getIdGudang() {
        return idGudang;
    }

    public void setIdGudang(String idGudang) {
        this.idGudang = idGudang;
    }

    public int getVolumeMaxGudang() {
        return volumeMaxGudang;
    }

    public void setVolumeMaxGudang(int volumeMaxGudang) {
        this.volumeMaxGudang = volumeMaxGudang;
    }

    public ArrayList<Barang> getDaftarBarang() {
        return daftarBarang;
    }
    
    

}
