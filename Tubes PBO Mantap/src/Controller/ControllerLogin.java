/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.AplikasiInventaris;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Riri
 */
public class ControllerLogin implements ActionListener {
    
    private Login view;
    private AplikasiInventaris app;
    Database db = new Database();
    public ControllerLogin() {
        app = new AplikasiInventaris();
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        db.connect();
        Object source = e.getSource();
        if(source.equals(view.getBtnLogin())) {
            ResultSet rs = db.get("select * from daftarorang where username='" + view.getUsername() + "'");
            try {
                if(rs.first()){
                    if(rs.getString("password").equals(view.getPassword())){
                        switch(rs.getInt("job")){
                            case 3 : 
                                ControllerAdmin adm = new ControllerAdmin();
                                break;
                            case 1 :
                                ControllerPetugasUtama pu1 = new ControllerPetugasUtama();
                                break;
                            case 2 : 
                                ControllerPenyediaUtama pu = new ControllerPenyediaUtama();
                                break;
                        }
                        db.disconnect();
                        view.resetall();
                        view.dispose();                 
                    } else{
                        JOptionPane.showMessageDialog(null,"Username atau Password salah !");
                        view.reset();
                    }
                } else{
                    JOptionPane.showMessageDialog(null,"Username atau Password salah !");
                    view.reset();
                }
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }      
            db.disconnect();
        }
    }
    
}
