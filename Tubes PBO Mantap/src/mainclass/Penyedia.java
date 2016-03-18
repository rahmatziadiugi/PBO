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
public class Penyedia extends Orang{
    Barang[] daftarBarang;
    
    public Penyedia(String name){
        super(name);
    }
    
    public void createBarang(){
        daftarBarang = new Barang[99];
    }
}
