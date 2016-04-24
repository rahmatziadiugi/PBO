/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Reynaldi
 */
public class ViewAdminEditGudang extends javax.swing.JFrame {

    /**
     * Creates new form ViewPenyediaCreateBarang
     */
    public ViewAdminEditGudang() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txNamaBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txStock = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Gudang");

        jLabel3.setText("Slot");

        btnTambah.setText("Tambah");

        btnCancel.setText("Cancel");

        txStock.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(5), null, Integer.valueOf(5)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txStock, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(txNamaBarang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnCancel))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnTambah() {
        return btnTambah;
    }
    
    public void addListener(ActionListener e) {
        btnTambah.addActionListener(e);
        btnCancel.addActionListener(e);
    }
    
    public void setNamaBarang(String s) {
        txNamaBarang.setText(s);
    }
        
    public void setStock(int i) {
        txStock.setValue(i);
    }
    
    public String getNamaBarang() {
        return txNamaBarang.getText();
    }
    

    public int getStock() {
        int x = (int) txStock.getValue();
        return x;
    }
    
    public void reset(){
        txNamaBarang.setText(null);
        txStock.setValue(0);
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txNamaBarang;
    private javax.swing.JSpinner txStock;
    // End of variables declaration//GEN-END:variables
}
