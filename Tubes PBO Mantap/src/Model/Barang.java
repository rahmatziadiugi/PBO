/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author Riri
 */
public class Barang {
    private static int count=1;
    private String idBarang;
    private String namaBarang;
    private String jenisBarang;
    private int stock;
    
    public Barang(String namaBarang, String jenisBarang, int stock) {
        this.idBarang="INV"+count+namaBarang.substring(0,3);
        this.namaBarang=namaBarang;
        this.jenisBarang=jenisBarang;
        this.stock=stock;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Barang.count = count;
    }
    
    public static void incCount(){
        Barang.count++;
    }

    public String getIdBarang() {
        return this.idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return this.jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void addStock() {
        stock++;
    }
    
    
}
