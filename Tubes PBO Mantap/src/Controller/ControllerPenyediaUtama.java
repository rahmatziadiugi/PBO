/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewPenyediaUtama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Riri
 */
public class ControllerPenyediaUtama implements ActionListener {
    private ViewPenyediaUtama view;
    
    public ControllerPenyediaUtama() {
        view = new ViewPenyediaUtama();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getbtnAddBarang())) {
            ControllerPenyediaCreateBarang pcb = new ControllerPenyediaCreateBarang();
            view.dispose();
        } else if (source.equals(view.getbtnDataBarang())) {
            ControllerPenyediaViewBarang ptt = new ControllerPenyediaViewBarang();
            view.dispose();
        } else if (source.equals(view.getbtnAddStock())) {
            ControllerPenyediaViewBarang ptt = new ControllerPenyediaViewBarang();
            view.dispose();
        } else if (source.equals(view.getBtnLogout())) {
            ControllerLogin login = new ControllerLogin();
            view.dispose();
        }
    }
    
}
