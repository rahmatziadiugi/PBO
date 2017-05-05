/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.Database;
import Model.AplikasiInventaris;
import View.ViewAdminRemoveGudang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Someone-PC
 */
public class ControllerAdminRGudang implements ActionListener {
    private ViewAdminRemoveGudang view;
    private AplikasiInventaris app;
    Database db = new Database();
    
    public ControllerAdminRGudang() {
        view = new ViewAdminRemoveGudang();
        view.setVisible(true);
        view.addListener(this);
        view.setTitle("Aplikasi Inventaris - Admin");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        db.connect();
        Object source = ae.getSource();
        if(source.equals(view.getbtnRemove())) {
            try{
                if(db.manipulate("DELETE FROM `daftargudang` WHERE `daftargudang`.`id_gudang` = \""
                        + view.getTxtIDGudang() + "\";") >= 1)
                {
                    JOptionPane.showMessageDialog(null,"Berhasil menghapus gudang!");
                    db.disconnect();
                    ControllerAdmin adm = new ControllerAdmin();
                    view.dispose();                    
                } else{
                    JOptionPane.showMessageDialog(null,"ID Gudang salah!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Gagal!");
            }
            view.reset();
        } else if(source.equals(view.getbtnCancel())){
            db.disconnect();
            view.reset();
            ControllerAdmin adm = new ControllerAdmin();            
            view.dispose();            
        }
    }
}
