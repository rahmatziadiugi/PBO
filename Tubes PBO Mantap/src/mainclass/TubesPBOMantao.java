/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

/**
 *
 * @author Someone-PC
 */
public class TubesPBOMantao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Penyedia p1 = new Penyedia("Riki","66613134");
        Penyedia p2 = new Penyedia("Maru","99998887");

        p1.CreateBarang("Assault Rifle","AK-47",4,5);
        p1.CreateBarang("Assault Rifle","M4A1-S",3,5);
        p1.CreateBarang("Assault Rifle","M6",3,5);
        p2.CreateBarang("Sniper Rifle","AWP",2,6);
        p2.CreateBarang("Sniper Rifle","G3SG1",1,6);
        
        
        p1.ViewAllBarang();
        p2.ViewAllBarang();
        
        System.out.println("===================================================");
        
        Gudang g1 = new Gudang("AR1380",80);
        Gudang g2 = new Gudang("SR1250",50);
        
        g1.SetJenis("Assault Rifle");
        g2.SetJenis("Sniper Rifle");
        
        g1.AddBarang(p1.GetBarang(0),2);
        g1.AddBarang(p1.GetBarang(0),1);
        g1.AddBarang(p1.GetBarang(1),1);
        g1.AddBarang(p1.GetBarang(2),3);
        g2.AddBarang(p2.GetBarang(0),1);
        g2.AddBarang(p2.GetBarang(1),1);
        
        g1.ViewAllBarang();
        g2.ViewAllBarang();
        
        System.out.println("===================================================");
        System.out.println("===================================================");
        
        p1.ViewAllBarang();
        p2.ViewAllBarang();
        
        System.out.println("===================================================");
        
        g1.removeBarang(p1.GetBarang(0),1);
        g2.removeBarang(p1.GetBarang(1),1);
        g1.ViewAllBarang();
        g2.ViewAllBarang();
        
        
        p1.ViewAllBarang();
        p2.ViewAllBarang();
        
    }
}
