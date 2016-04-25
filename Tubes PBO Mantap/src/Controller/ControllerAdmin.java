/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Someone-PC
 */
public class ControllerAdmin implements ActionListener {
    private ViewAdmin view;
    
    public ControllerAdmin() {
        view = new ViewAdmin();
        view.setVisible(true);
        view.addListener(this);                
        view.setTitle("Aplikasi Inventaris - Admin");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnAGudang())) {
            ControllerAdminAGudang aag = new ControllerAdminAGudang();
            view.dispose();
        } else if (source.equals(view.getBtnAPenyedia())) {
            ControllerAdminAPenyedia aas = new ControllerAdminAPenyedia();
            view.dispose();
        } else if (source.equals(view.getBtnAPetugas())) {
            ControllerAdminAPetugas aap = new ControllerAdminAPetugas();
            view.dispose();
        } else if (source.equals(view.getBtnAPenyedia())) {
            ControllerAdminRGudang arg = new ControllerAdminRGudang();
            view.dispose();
        } else if (source.equals(view.getBtnAPenyedia())) {
            ControllerAdminRPenyedia ars = new ControllerAdminRPenyedia();
            view.dispose();
        } else if (source.equals(view.getBtnAPenyedia())) {
            ControllerAdminRPetugas arp = new ControllerAdminRPetugas();
            view.dispose();
        } else if (source.equals(view.getBtnEGudang())) {
            ControllerAdminEGudang aeg = new ControllerAdminEGudang();
            view.dispose();
        } else if (source.equals(view.getBtnLogout())) {
            ControllerLogin login = new ControllerLogin();
            view.dispose();
        }
    }
}
