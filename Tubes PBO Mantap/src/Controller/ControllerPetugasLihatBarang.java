/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.Database;
import Model.AplikasiInventaris;
import View.ViewPetugasLihatBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riri
 */
public class ControllerPetugasLihatBarang implements ActionListener {
    private ViewPetugasLihatBarang view;
    private AplikasiInventaris app;
    Database db;
    
    public ControllerPetugasLihatBarang() {
        app = new AplikasiInventaris();
        view = new ViewPetugasLihatBarang();
        view.setTableMenu();
        view.setVisible(true);
        view.addListener(this);
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
