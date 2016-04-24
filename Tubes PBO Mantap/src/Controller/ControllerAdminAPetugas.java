/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.AplikasiInventaris;
import View.ViewAdminAddPetugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Someone-PC
 */
public class ControllerAdminAPetugas implements ActionListener {
    private ViewAdminAddPetugas view;
    private AplikasiInventaris app;
    Database db = new Database();
    
    public ControllerAdminAPetugas() {
        view = new ViewAdminAddPetugas();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.connect();
        Object source = ae.getSource();
        if(source.equals(view.getbtnAdd())) {
            try{
                if(db.manipulate("INSERT INTO `daftarorang` (`id`, `nama`, `username`, `password`, `job`) VALUES (NULL, '"
                        + view.getTxtNama()+ "', '"
                        + view.getTxtUsername() + "', '"
                        + view.getTxtPassword() + "', '1')") >= 1)
                {
                    JOptionPane.showMessageDialog(null,"Berhasil menambahkan Petugas baru!");
                } else{
                    JOptionPane.showMessageDialog(null,"Petugas sudah terdaftar!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Gagal!");
            }
            view.reset();
        } else if(source.equals(view.getbtnCancel())){
            db.disconnect();
            ControllerAdmin adm = new ControllerAdmin();
            view.reset();
            view.dispose();
        }
    }
    
}
