/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.AplikasiInventaris;
import View.ViewAdminRemovePetugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Someone-PC
 */
public class ControllerAdminRPetugas implements ActionListener {
    private ViewAdminRemovePetugas view;
    private AplikasiInventaris app;
    Database db = new Database();
    
    public ControllerAdminRPetugas() {
        view = new ViewAdminRemovePetugas();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        db.connect();
        Object source = ae.getSource();
        if(source.equals(view.getbtnRemove())) {
            try{
                if(db.manipulate("DELETE FROM `daftarorang` WHERE `daftarorang`.`id` = "
                        + view.getTxtNIPPetugas() +" and `job` = 1") >= 1)
                {
                    JOptionPane.showMessageDialog(null,"Berhasil menghapus Petugas!");
                    db.disconnect();
                    ControllerAdmin adm = new ControllerAdmin();
                    view.dispose();                    
                } else{
                    JOptionPane.showMessageDialog(null,"ID Petugas Salah!");
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
