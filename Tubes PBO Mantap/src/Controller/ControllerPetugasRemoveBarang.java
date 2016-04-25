/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.Database;
import Model.AplikasiInventaris;
import View.ViewPetugasRemoveBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Riri
 */
public class ControllerPetugasRemoveBarang implements ActionListener {
    private ViewPetugasRemoveBarang view;
    private AplikasiInventaris app;
    Database db = new Database();
    String id;
    String nama;
    String jenis;
    int id_penyedia;
    int stock;
    String id_gudang;
    int slot;
    
    public ControllerPetugasRemoveBarang() {
        app = new AplikasiInventaris();
        view = new ViewPetugasRemoveBarang();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean a = false; //cek gagal di barang
        boolean b = false; //cek gagal di gudang
        db.connect();
        Object source = e.getSource();
        if(source.equals(view.getBtnHapus())) {
            ResultSet rs = db.get("SELECT * FROM `daftarbarangpenyedia` WHERE `idBarang` = '" + view.getIDBarang() + "'");
            try {                
                if(rs.first()){
                    id = rs.getString("idbarang");
                    nama = rs.getString("namabarang");
                    jenis = rs.getString("jenisbarang");
                    id_penyedia = rs.getInt("id_penyedia");
                    stock = rs.getInt("stock");
                    a = !a;
                } else{
                    JOptionPane.showMessageDialog(null,"ID barang salah!");
                }
                rs.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Gagal di Barang!");
            }
            rs = db.get("SELECT * FROM `daftargudang` WHERE `id_gudang` = '" + view.getGudang() + "'");
            try {            
                if(rs.first()){
                    id_gudang = rs.getString("id_gudang");
                    slot = rs.getInt("slot");
                    b = !b;
                }else{
                    JOptionPane.showMessageDialog(null,"ID gudang salah!");
                }
                rs.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Gagal di Gudang!");
            }
            
            if(id!= null && id_gudang!=null){
                if((stock >= view.getJumlah()) && (slot>=view.getJumlah())){
                    if(a==b){
                        int sisa = (stock+view.getJumlah());
                        db.manipulate("UPDATE daftarbarangpenyedia SET stock = " 
                                + sisa + " WHERE daftarbarangpenyedia.idBarang = '"
                                + id + "';");
                        sisa = (slot+view.getJumlah());
                        db.manipulate("UPDATE daftargudang SET slot = " 
                                + sisa + " WHERE daftargudang.id_gudang = '"
                                + id_gudang + "';");
                        rs = db.get("SELECT * FROM `daftarbaranggudang` WHERE `id` = '"
                                + view.getIDBarang() + "' AND `id_gudang` = '" + view.getGudang() + "'");
                        try {
                            if(rs.first()){
                                stock = rs.getInt("stock");                                
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ControllerPetugasRemoveBarang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        sisa = stock-view.getJumlah();                        
                        db.manipulate("UPDATE `daftarbaranggudang` SET `stock` = '"
                                + sisa + "' WHERE `daftarbaranggudang`.`id` = '"
                                + view.getIDBarang() + "' AND `daftarbaranggudang`.`id_gudang` = '"
                                + view.getGudang() + "';");
                        if(sisa==0){
                            db.manipulate("DELETE FROM `daftarbaranggudang` WHERE `daftarbaranggudang`.`id` = '"
                                + view.getIDBarang() +"' AND `daftarbaranggudang`.`id_gudang` = '"
                                + view.getGudang() + "';");
                        }
                        db.disconnect();
                        JOptionPane.showMessageDialog(null,"Barang berhasil dikeluarkan!");
                        view.reset();  
                    } else{
                        view.reset();   
                    }                   
                } else{
                    JOptionPane.showMessageDialog(null,"Stock tidak cukup!");
                    view.resetJum();
                }
            } else{
                view.reset();
            }
        } else if (source.equals(view.getBtnCancel())) {
            db.disconnect();
            view.reset();
            ControllerPetugasUtama pu = new ControllerPetugasUtama();
            view.dispose();
        }
    }
    
}
