/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiInventaris;
import View.ViewPetugasRemoveBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Riri
 */
public class ControllerPetugasRemoveBarang implements ActionListener {
    private ViewPetugasRemoveBarang view;
    private AplikasiInventaris app;
    
    public ControllerPetugasRemoveBarang() {
        app = new AplikasiInventaris();
        view = new ViewPetugasRemoveBarang();
        view.setVisible(true);
        view.addListener(this);
        view.inputData(app.getGudang().getDaftarBarang());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnHapus())) {
            app.getGudang().removeBarang(view.getNomorBarang());
            JOptionPane.showMessageDialog(null, "Barang berhasil dihapus !");
        } else if (source.equals(view.getBtnCancel())) {
            ControllerPetugasUtama pu = new ControllerPetugasUtama();
            view.dispose();
        }
    }
    
}
