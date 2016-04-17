package mainclass;

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
    private int login;
    Scanner input = new Scanner (System.in);
        
    public void login(){
        boolean login = false;
        System.out.print("Username\t: ");
        String id = input.next();
        System.out.print("Password\t: ");
        String pw = input.next();
        /*username untuk petugas,penyedia, dan admin berbeda
        untuk petugas dengan penyedia, username-nya diambil dari ID atau NIP
        username untuk petugas dan penyedia punya inisial khusus*/
        switch (id.substring(0,4)){
            case "S":
                for(Penyedia s : this.DaftarPenyedia){
                    if(s.GetUsername()==id && s.GetPassword()==pw){
                        this.s = s;
                        this.login = 2;
                        login = true;
                    }
                }
                break;
            case "P":
                for(Petugas p : this.DaftarPetugas){
                    if(p.GetUsername()==id && p.GetPassword()==pw){
                        this.p = p;
                        this.login = 1;
                        login = true;
                    }
                }
                break;
            case "admin":
                if(pw=="admin"){
                    this.login = 0;
                    login = true;
                }
            default:
                System.out.println("Username atau Password salah!");
        }            
    }
    
    public void lupaPassword(){
        
    }

    public void AddPetugas(){
        this.DaftarPetugas.add(new Petugas(input.next()));
    }
    
    public void RemovePetugas(Petugas p){
        this.DaftarPetugas.remove(p);
    }
    
    public void addPenyedia(Penyedia s){
        this.DaftarPenyedia.add(new Penyedia(input.next(),input.next()));
    }
    
    public void RemovePenyedia(Penyedia s){
        this.DaftarPenyedia.remove(s);
    }
    
    public void RemovePenyedia(String ID){
        /*menghapus penyedia berdasarkan ID*/
        for(Penyedia Daftar : this.DaftarPenyedia){
            if(Daftar.GetID()==(ID)){
                this.DaftarPenyedia.remove(Daftar);
            }
        }
    }
    
    public void AddBarang(){        
        /*tersedia untuk penyedia*/
        String Jenis = input.next();
        String NamaBarang = input.next();
        int Stock = input.nextInt();
        int Volume = input.nextInt();
        this.s.CreateBarang(Jenis,NamaBarang,Stock,Volume);
    }
    
    public void RemoveBarang(Barang b){
        this.s.RemoveBarang(b);
    }
        
    public void TambahStock(Barang b, int n){
        /*Penyedia menambahkan stok barang dia*/
        this.s.AddStockBarang(b,n);
    }
    
    public void AmbilStock(Barang b, int n){
        /*mengurankan stok barang yang ada di gudang*/
        this.s.RemoveStockBarang(b, n);
    }
    
    public void AmbilBarang(Barang b, int n){
        /*memindahkan barang dari gudang ke penyedia*/
        for(Gudang DaftarG : this.DaftarGudang){
            DaftarG.removeBarang(b, n);
        }        
    }
    
    public void taruhBarang(Barang b, int n){
        /*menindahkan barang ke gudang
        di cek gudang mana yang sesuai untuk barangnya
        jika sama, baru barangnya masuk ke situ*/        
        for(Gudang DaftarG : this.DaftarGudang){
            if(DaftarG.GetJenis()==b.GetJenis()){
                this.s.RemoveStockBarang(b, n);
                DaftarG.AddBarang(b, n);
                break;
            }
        }
    }
    
    public void DataBarang() {
        /*view all Barang from each Gudang*/
        for (Gudang DaftarGudang1 : this.DaftarGudang){
            DaftarGudang1.ViewAllBarang();
        }
    }
    public void TambahGudang(Gudang g){
        this.DaftarGudang.add(g);
    }
    
    public void RemoveGudang(Gudang g){
        this.DaftarGudang.remove(g);
    }
    
    public void EditGudang(String ID){
        /*mengedit data data gudang*/
        for (Gudang DaftarGudang1 : this.DaftarGudang){
            if(DaftarGudang1.GetID()==ID){
                DaftarGudang1.SetJenis(input.next());
                DaftarGudang1.SetVolume(input.nextInt());
            }  
        }
    }
}
