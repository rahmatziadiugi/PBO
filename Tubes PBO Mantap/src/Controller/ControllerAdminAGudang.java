/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.AplikasiInventaris;
import View.ViewAdminAddGudang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Someone-PC
 */
public class ControllerAdminAGudang implements ActionListener {
    private ViewAdminAddGudang view;
    private AplikasiInventaris app;
    Database db = new Database();

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.connect();
        Object source = ae.getSource();
        if(source.equals(view.getbtnAdd())) {
            try{
                if(db.manipulate("INSERT INTO `daftargudang` (`id_gudang`, `slot`) VALUES ('"
                    + view.gettxtId() + "', '"
                    + view.gettxtSlot() + "')") >= 1)
                {
                    JOptionPane.showMessageDialog(null,"Berhasil menambahkan gudang baru!");
                } else{
                    JOptionPane.showMessageDialog(null,"Gudang sudah terdaftar!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Gagal!");
            }
        }        
    }
    
}
