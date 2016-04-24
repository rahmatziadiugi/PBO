/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.util.Scanner;

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
    Penyedia supplier = new Penyedia(001, "Duncan", "asd", "123");
    Petugas petugas = new Petugas(002, "Parker", "qwe", "123");
    Gudang gudang = new Gudang("Gudang-01", 30);

    public Petugas getPetugas() {
        return petugas;
    }

    public Penyedia getPenyedia() {
        return supplier;
    }

    public Gudang getGudang() {
        return gudang;
    }

    public void login() {
        int x = 0;
        while (x != 1) {
            System.out.println("");
            System.out.println("Masukkan username : ");
            String username = huruf.nextLine();
            System.out.println("Masukkan password : ");
            String password = huruf.nextLine();
            if (username.equals(supplier.getUsername()) && password.equals(supplier.getPassword())) {
                menu2();
                x=1;
            } else if (username.equals(petugas.getUsername()) && password.equals(petugas.getPassword())) {
                menu1();
                x=1;
            }
            System.out.println("Username atau Password Salah !");
        }

    }

    public void menu1() {
        int x = 0;
        while (x != 1) {
            System.out.println("");
            System.out.println("Anda Login Sebagai Petugas");
            System.out.println("MENU :");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Remove Barang");
            System.out.println("3. Lihat Barang");
            System.out.println("4. Keluar");
            System.out.println("Pilihan : ");
            int pil = angka.nextInt();
            switch (pil) {
                case 1:
                    System.out.println("");
                    System.out.println("Masukkan nama barang : ");
                    String namaBarang = huruf.nextLine();
                    System.out.println("Masukkan jenis barang : ");
                    String jenisBarang = huruf.nextLine();
                    System.out.println("Masukkan jumlah stock : ");
                    int stock = angka.nextInt();
                    Barang b = new Barang(namaBarang, jenisBarang, stock);
                    gudang.addBarang(b);                    
                    break;
                case 2:
                    System.out.println("");
                    gudang.viewAll();
                    System.out.println("[Masukkan angka 0 untuk kembali ke menu sebelumnya]");
                    System.out.println("Masukkan indeks barang yang ingin dihapus : ");
                    int pil2 = angka.nextInt();
                    if (pil2 == 0) {
                        break;
                    } else {
                        gudang.removeBarang(pil2 - 1);
                    }

                    break;
                case 3:
                    gudang.viewAll();
                    break;
                case 4:
                    x = 1;
                    login();
            }
        }
    }

    public void menu2() {
        int y = 0;
        while (y != 1) {
            System.out.println("");
            System.out.println("Anda Login Sebagai Penyedia");
            System.out.println("MENU :");
            System.out.println("1. Create Barang");
            System.out.println("2. Tambahkan barang ke inventaris");
            System.out.println("3. Logout");
            System.out.println("Pilihan : ");
            int pil1 = angka.nextInt();
            switch (pil1) {
                case 1:
                    System.out.println("");
                    System.out.println("Masukkan nama barang : ");
                    String namBar = huruf.nextLine();
                    System.out.println("Masukkan jenis barang : ");
                    String jenBar = huruf.nextLine();
                    System.out.println("Masukkan jumlah stock : ");
                    int stck = angka.nextInt();
                    supplier.createBarang(namBar, jenBar, stck);
                    break;
                case 2:
                    System.out.println("");
                    supplier.viewAll();
                    System.out.println("[Masukkan angka 0 untuk kembali ke menu sebelumnya]");
                    System.out.println("Masukkan indeks barang yang ingin ditambahkan ke gudang : ");
                    int idx = angka.nextInt();
                    if (idx == 0) {
                        break;
                    } else {
                        gudang.addBarang(supplier.getBarang(idx - 1));
                    }

                    break;
                case 3:
                    y = 1;
                    login();
                    break;
            }
        }

    }
    
    public void menu3() {
        int y = 0;
        while (y != 1) {
            System.out.println("");
            System.out.println("Anda Login Sebagai Penyedia");
            System.out.println("MENU :");
            System.out.println("1. Create Barang");
            System.out.println("2. Tambahkan barang ke inventaris");
            System.out.println("3. Logout");
            System.out.println("Pilihan : ");
            int pil1 = angka.nextInt();
            switch (pil1) {
                case 1:
                    System.out.println("");
                    System.out.println("Masukkan nama barang : ");
                    String namBar = huruf.nextLine();
                    System.out.println("Masukkan jenis barang : ");
                    String jenBar = huruf.nextLine();
                    System.out.println("Masukkan jumlah stock : ");
                    int stck = angka.nextInt();
                    supplier.createBarang(namBar, jenBar, stck);
                    break;
                case 2:
                    System.out.println("");
                    supplier.viewAll();
                    System.out.println("[Masukkan angka 0 untuk kembali ke menu sebelumnya]");
                    System.out.println("Masukkan indeks barang yang ingin ditambahkan ke gudang : ");
                    int idx = angka.nextInt();
                    if (idx == 0) {
                        break;
                    } else {
                        gudang.addBarang(supplier.getBarang(idx - 1));
                    }

                    break;
                case 3:
                    y = 1;
                    login();
                    break;
            }
        }

    }

}
