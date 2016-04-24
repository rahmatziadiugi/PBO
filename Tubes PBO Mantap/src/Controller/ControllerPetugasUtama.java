/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewPetugasUtama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Riri
 */
public class ControllerPetugasUtama implements ActionListener {
    private ViewPetugasUtama view;
    
    public ControllerPetugasUtama() {
        view = new ViewPetugasUtama();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnTambahBarang())) {
            ControllerPetugasTambahBarang ptb = new ControllerPetugasTambahBarang();
            view.dispose();
        } else if (source.equals(view.getBtnHapusBarang())) {
            ControllerPetugasRemoveBarang prb = new ControllerPetugasRemoveBarang();
            view.dispose();
        } else if (source.equals(view.getBtnLihatBarang())) {
            ControllerPetugasLihatBarang plb = new ControllerPetugasLihatBarang();
            view.dispose();
        } else if (source.equals(view.getBtnLogout())) {
            ControllerLogin cl = new ControllerLogin();
            view.dispose();
        }
    }
    

}
