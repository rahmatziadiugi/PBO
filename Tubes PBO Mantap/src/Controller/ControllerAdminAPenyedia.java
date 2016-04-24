/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.AplikasiInventaris;
import Model.Penyedia;
import View.ViewAdminAddPenyedia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Someone-PC
 */
public class ControllerAdminAPenyedia implements ActionListener {
    private ViewAdminAddPenyedia view;
    private AplikasiInventaris app;
    Database db = new Database();
    
    public ControllerAdminAPenyedia() {
        view = new ViewAdminAddPenyedia();
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
                        + view.getTxtPassword() + "', '2')") >= 1)
                {
                    JOptionPane.showMessageDialog(null,"Berhasil menambahkan Penyedia baru!");
                    view.reset();
                    view.dispose();
                } else{
                    JOptionPane.showMessageDialog(null,"Penyedia sudah terdaftar!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Gagal!");
            }
        } else if(source.equals(view.getbtnCancel())){
            ControllerPenyediaUtama pu = new ControllerPenyediaUtama();
            view.dispose();
        }
        db.disconnect();
    }
    
}
