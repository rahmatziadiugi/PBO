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
import Model.Orang;
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
        rs.close();
        rs = db.get("SELECT * FROM `daftarorang`");
        Orang o = null;
        if(rs.last()){
            /*id 0 milik admin,             
            supaya ada yang ngisi di id 1 di kurang 1
            karna jumlah defaultnya 1, yaitu admin
            */
            for(int i = 0; i<rs.getRow()-1;i++){
                Orang.incCount();
            }            
        }
        rs.close();
        db.disconnect();
        
        ControllerLogin clg = new ControllerLogin();        
    }
}
