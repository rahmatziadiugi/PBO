/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Riri
 */
public class Petugas extends Orang {
    private String username;
    private String password;
    
    public Petugas(int id, String nama, String username, String password) {
        super(id, nama);
        this.username=username;
        this.password=password;
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
        return "ID Petugas : "+ getId() + ", Nama Petugas : " + getNama();
    }
}
