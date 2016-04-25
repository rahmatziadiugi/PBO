/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.Database;
import Model.AplikasiInventaris;
import Model.Barang;
import View.ViewPenyediaAddStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Riri
 */
public class ControllerPenyediaAddStock implements ActionListener {
    private ViewPenyediaAddStock view;
    private AplikasiInventaris app;
    Database db = new Database();
    
    public ControllerPenyediaAddStock() {
        app = new AplikasiInventaris();
        view = new ViewPenyediaAddStock();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Aplikasi Inventaris - Supplier");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnTambah())) {
            db.connect();
            ResultSet rs = db.get("SELECT * FROM `daftarbarangpenyedia` WHERE `idBarang` = '"
                    + view.getNamaBarang() + "' AND `id_penyedia` = "
                    + AplikasiInventaris.getId());
            try {                
                if(rs.first()){
                    int sisa = view.getStock() + rs.getInt("stock");
                    if(db.manipulate("UPDATE `daftarbarangpenyedia` SET `stock` = '"
                            + sisa + "' WHERE `daftarbarangpenyedia`.`idBarang` = '"
                            + view.getNamaBarang() + "' AND `daftarbarangpenyedia`.`id_penyedia` = '"
                            + AplikasiInventaris.getId() + "';") >= 1)
                    {
                        JOptionPane.showMessageDialog(null,"Stock Barang berhasi ditambah!");
                    }
                }                                    
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"ID Barang salah!");
            }
            db.disconnect();
            view.reset();
            ControllerPenyediaUtama pu = new ControllerPenyediaUtama();
            view.dispose();
        } else if (source.equals(view.getBtnCancel())) {
            ControllerPenyediaUtama pu = new ControllerPenyediaUtama();
            view.dispose();
        }        
    }
    
}
