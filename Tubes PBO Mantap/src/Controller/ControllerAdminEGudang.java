/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.AplikasiInventaris;
import View.ViewAdminAddGudang;
import View.ViewAdminEditGudang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Someone-PC
 */
public class ControllerAdminEGudang implements ActionListener {
    private ViewAdminEditGudang view;
    private AplikasiInventaris app;
    Database db = new Database();
    
    public ControllerAdminEGudang() {
        view = new ViewAdminEditGudang();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        db.connect();
        Object source = ae.getSource();
        if(source.equals(view.getBtnEdit())) {
            try{
                if(db.manipulate("UPDATE `daftargudang` SET `slot` = '"
                        + view.getStock() + "' WHERE `daftargudang`.`id_gudang` = '"
                        + view.getIDGudang() +"'") >= 1)
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
