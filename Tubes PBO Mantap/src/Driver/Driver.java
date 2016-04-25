/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerLogin;
import DB.Database;
import Model.AplikasiInventaris;
import Model.Barang;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Riri
 */
public class Driver {
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        db.connect();
        ResultSet rs = db.get("SELECT * FROM `daftarbarangpenyedia`");
        Barang b = null;
        if(rs.last()){
            for(int i = 0; i<rs.getRow();i++){
                Barang.incCount();
            }            
        }
        db.disconnect();
        
        ControllerLogin clg = new ControllerLogin();
//        AplikasiInventaris inv = new AplikasiInventaris();
//        inv.login();
        
    }
}
