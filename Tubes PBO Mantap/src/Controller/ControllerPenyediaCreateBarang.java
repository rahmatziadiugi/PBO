/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.Database;
import Model.AplikasiInventaris;
import Model.Barang;
import View.ViewPenyediaCreateBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Riri
 */
public class ControllerPenyediaCreateBarang implements ActionListener {
    private ViewPenyediaCreateBarang view;
    private AplikasiInventaris app;
    Database db = new Database();
    
    public ControllerPenyediaCreateBarang() {
        app = new AplikasiInventaris();
        view = new ViewPenyediaCreateBarang();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnTambah())) {
            db.connect();
            try {
                if(db.manipulate("INSERT INTO `daftarbarangpenyedia` (`idBarang`, `namaBarang`, `jenisBarang`, `stock`, `id_penyedia`) VALUES ('INV"
                    + Barang.getCount() + view.getNamaBarang().substring(0,3) + "', '"
                    + view.getNamaBarang() + "', '"
                    + view.getJenisBarang() + "', '"
                    + view.getStock() + "', '"
                    + app.getId() + "')") >= 1)
                {
                    Barang.incCount();
                    JOptionPane.showMessageDialog(null,"Barang berhasil ditambah!");
                } else{
                    JOptionPane.showMessageDialog(null,"Barang sudah terdaftar!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Gagal!");
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
