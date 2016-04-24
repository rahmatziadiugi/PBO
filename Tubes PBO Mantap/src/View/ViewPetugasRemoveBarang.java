/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Barang;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reynaldi
 */
public class ViewPetugasRemoveBarang extends javax.swing.JFrame {

    /**
     * Creates new form ViewPetugasRemoveBarang
     */
    public ViewPetugasRemoveBarang() {
        initComponents();
        setHeader();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        txNomorBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnCancel = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelBarang);

        jLabel1.setText("Masukkan nomor barang");

        btnHapus.setText("Hapus");

        btnCancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNomorBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNomorBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus)
                    .addComponent(btnCancel))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JToggleButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnHapus() {
        return btnHapus;
    }

    public void addListener(ActionListener e) {
        btnCancel.addActionListener(e);
        btnHapus.addActionListener(e);
    }

    public void setNomorBarang(String s) {
        txNomorBarang.setText(s);
    }
    
    public int getNomorBarang() {
        int x = Integer.parseInt(txNomorBarang.getText());
        return x;
    }
    
        public void setHeader() {
        String[] header = {"No","Id Barang","Nama Barang","Jenis Barang","Stock"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        tabelBarang.setModel(model);
    }
    
    public void inputData(ArrayList<Barang> listBarang) {
        DefaultTableModel model = (DefaultTableModel)tabelBarang.getModel();
        if (listBarang != null) {
            for (int i = 0; i < listBarang.size(); i++) {
                model.addRow(new String[] {(i+1)+"",listBarang.get(i).getIdBarang()
                ,listBarang.get(i).getNamaBarang(),listBarang.get(i).getJenisBarang()
                ,listBarang.get(i).getStock()+""});
            }
        }
        else {
            model.addRow(new String[] {"","","","",""});
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancel;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTextField txNomorBarang;
    // End of variables declaration//GEN-END:variables
}
