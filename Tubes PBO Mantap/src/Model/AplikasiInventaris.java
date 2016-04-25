/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riri
 */
public class AplikasiInventaris {

    /**
     * @param args the command line arguments
     */
    Scanner angka = new Scanner(System.in);
    Scanner huruf = new Scanner(System.in);
    Database db = new Database();
    private static int id;
    public ArrayList<Barang> ListBrg = new ArrayList<>();
    public ArrayList<Gudang> ListGudang = new ArrayList<>();
    
    public void getArray(){
        ListBrg.clear();
        ListGudang.clear();
        db.connect();
        ResultSet rs = db.get("SELECT * FROM `daftarbaranggudang`");
        try {
            rs.beforeFirst();
            while(rs.next()){
                ListBrg.add(new Barang(rs.getString("namaBarang"), rs.getString("jenisBarang"), rs.getInt("stock")));           
                ListBrg.get(rs.getRow()-1).setIdBarang(rs.getString("id"));
                ListGudang.add(new Gudang(rs.getString("id_gudang"),0));
            }                
        } catch (SQLException ex) {
            Logger.getLogger(AplikasiInventaris.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.disconnect();
    }
    
    public void getArray(String idGudang){
        ListBrg.clear();
        ListGudang.clear();
        db.connect();
        ResultSet rs = db.get("SELECT * FROM `daftarbaranggudang` WHERE `id_gudang` = '"
                + idGudang + "';");
        try {
            rs.beforeFirst();
            while(rs.next()){
                ListBrg.add(new Barang(rs.getString("namaBarang"), rs.getString("jenisBarang"), rs.getInt("stock")));           
                ListBrg.get(rs.getRow()-1).setIdBarang(rs.getString("id"));
                ListGudang.add(new Gudang(rs.getString("id_gudang"),0));
            }                
        } catch (SQLException ex) {
            Logger.getLogger(AplikasiInventaris.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.disconnect();
    }
    
    public void getArrayPenyedia(){
        ListBrg.clear();
        ListGudang.clear();
        db.connect();
        ResultSet rs = db.get("SELECT * FROM `daftarbarangpenyedia` WHERE `id_penyedia` = '"
                + id + "';");
        try {
            rs.beforeFirst();
            while(rs.next()){
                ListBrg.add(new Barang(rs.getString("namaBarang"), rs.getString("jenisBarang"), rs.getInt("stock")));           
                ListBrg.get(rs.getRow()-1).setIdBarang(rs.getString("idBarang"));
            }                
        } catch (SQLException ex) {
            Logger.getLogger(AplikasiInventaris.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.disconnect();
    }
    
    public void getArrayPenyedia(String idBarang){
        ListBrg.clear();
        ListGudang.clear();
        db.connect();
        ResultSet rs = db.get("SELECT * FROM `daftarbarangpenyedia` WHERE `id_penyedia` = '"
                + id + "' AND `idBarang` = '"
                + idBarang + "';");
        try {
            rs.beforeFirst();
            while(rs.next()){
                ListBrg.add(new Barang(rs.getString("namaBarang"), rs.getString("jenisBarang"), rs.getInt("stock")));           
                ListBrg.get(rs.getRow()-1).setIdBarang(rs.getString("idBarang"));
            }                
        } catch (SQLException ex) {
            Logger.getLogger(AplikasiInventaris.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.disconnect();
    }
    
    public static void setId(int i){
        id = i;
    }
    
    public static int getId(){
        return id;
    }
    
    public Barang getBarang(int i){
        return ListBrg.get(i);
    }
    
    public Gudang getGudang(int i){
        return ListGudang.get(i);
    }   
}