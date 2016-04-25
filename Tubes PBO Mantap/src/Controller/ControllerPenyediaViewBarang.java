/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiInventaris;
import View.ViewPenyediaViewBarang;
import View.ViewPetugasLihatBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Riri
 */
public class ControllerPenyediaViewBarang implements ActionListener {
    private ViewPenyediaViewBarang view;
    private AplikasiInventaris app;
    
    public ControllerPenyediaViewBarang() {
        app = new AplikasiInventaris();
        view = new ViewPenyediaViewBarang();
        view.setVisible(true);
        view.addListener(this);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())) {
            ControllerPenyediaUtama pu = new ControllerPenyediaUtama();
            view.dispose();
        }
        
    }
    
}
