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
public class Penyedia extends Orang {    
    private String username;
    private String password;
    private ArrayList<Barang> daftarBarang;
    
    public Penyedia(int id, String nama, String username, String password) {
        super(id,nama);
        this.username=username;
        this.password=password;
        daftarBarang = new ArrayList<>();
    }
    
    public void createBarang(String namaBarang, String jenisBarang, int stock) {
        Barang b = new Barang(namaBarang, jenisBarang, stock);
        daftarBarang.add(b);
    }
    
    public Barang getBarang(int indeks) {
        return daftarBarang.get(indeks);
    }
        
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @Override
    public String toString() {
        return "ID Penyedia : "+ getId() + ", Nama Penyedia : " + getNama();
    }
    
    public void viewAll() {
        System.out.println("");
        System.out.println("Data Barang Penyedia  : " + this.getNama());
        System.out.println("========================");
        int i=1;
        for (Barang brg:  daftarBarang) {
            System.out.println("===========================");
            System.out.println("Indeks Barang : "+i);
            System.out.println("ID Barang : "+brg.getIdBarang());
            System.out.println("Nama Barang : "+brg.getNamaBarang());
            System.out.println("Jenis Barang : "+brg.getJenisBarang());
            System.out.println("Stock : "+brg.getStock());
            i++;
            System.out.println("===========================");
        }
    }

    public ArrayList<Barang> getDaftarBarang() {
        return daftarBarang;
    }
    
    public int sizeBarang() {
        return daftarBarang.size();
    }
    
    
}
