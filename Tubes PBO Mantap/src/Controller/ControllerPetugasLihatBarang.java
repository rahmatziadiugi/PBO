/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiInventaris;
import View.ViewPetugasLihatBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Riri
 */
public class ControllerPetugasLihatBarang implements ActionListener {
    private ViewPetugasLihatBarang view;
    private AplikasiInventaris app;
    
    public ControllerPetugasLihatBarang() {
        app = new AplikasiInventaris();
        view = new ViewPetugasLihatBarang();
        view.setVisible(true);
        view.addListener(this);
        System.out.println(app.getGudang().getDaftarBarang().isEmpty());
        view.viewAll(app.getGudang().getDaftarBarang());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnKembali())) {
            ControllerPetugasUtama pu = new ControllerPetugasUtama();
            view.dispose();
        }
    }
    
}
