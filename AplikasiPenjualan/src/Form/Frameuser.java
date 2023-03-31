/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Form.MenuUtama;
import java.awt.Image;
import static java.lang.String.format;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ARIFFUD
 */
public class Frameuser extends javax.swing.JFrame {
 private Statement stat;
    private ResultSet res;
    private final DefaultTableModel tabModel;
    private PreparedStatement prestat;

    /**
     * Creates new form Frameuser
     */
    public Frameuser() {
        initComponents();
           String row[]={"kode","nama","produsen","mesin","harga","kapasitas","keterangan","foto"};
           
           
           setLocationRelativeTo(null);
         new Fungsi.Koneksi().koneksiDatabase();
         tabModel = new DefaultTableModel(null,row);
         table1.setModel(tabModel);
    
             tampilDataKeTabel("","","");
        
    }

     public void tampilDataKeTabel(String cari,String sort,String rega){
        try{
            String sql="";
            if(!cari.equals("")){
                sql="select * from barang where nama='"
                        + cari + "'";
            }
            else if (sort.equals("yamaha")||sort.equals("honda")||sort.equals("suzuki"))
                    {
                        sql="select * from barang where mesin='"+sort+"'";     
                    }
            else if (rega.equals("mahal"))
            {
                sql="select * from barang order by harga desc";  
            }
             else if (rega.equals("murah"))
             {
                 sql="select * from barang order by harga asc"; 
             }
            
            else{
                sql="select * from barang";
            }
            stat = new Fungsi.Koneksi().koneksiDatabase().createStatement();
            res = stat.executeQuery(sql);
            while(res.next()){
                String kode = res.getString("kode");
                String nama = res.getString("nama");
                String produsen = res.getString("produsen");
                String mesin = res.getString("mesin");
                String harga = res.getString("harga");
                String kapasitas = res.getString("kapasitas");
                String keterangan = res.getString("keterangan");
                String foto = res.getString("foto");
                String data[] = {kode,nama,produsen,mesin,harga,kapasitas,keterangan,foto};
                tabModel.addRow(data);
            }
        }
        catch(Exception e){
            System.out.println("ada error nama field, coba dicek");
        }
    }
   
        public void hapusPadaForm(){
        int row = tabModel.getRowCount();
        for(int a=0; a<row; a++){
            tabModel.removeRow(0); 
        }        
    }
      /*  public void termurah(){
        try{
            
            String sql="select * from barang order by "
                     + "harga asc";
             //res = stat.executeQuery();
            stat = new Fungsi.Koneksi().koneksiDatabase().createStatement();
            res = stat.executeQuery(sql);
            while(res.next()){
                String kode = res.getString("kode");
                String nama = res.getString("nama");
                String produsen = res.getString("produsen");
                String mesin = res.getString("mesin");
                String harga = res.getString("harga");
                String kapasitas = res.getString("kapasitas");
                String keterangan = res.getString("keterangan");
                String foto = res.getString("foto");
                String data[] = {kode,nama,produsen,mesin,harga,kapasitas,keterangan,foto};
                tabModel.addRow(data);
            }
                      
        }
        catch(Exception e){
            System.out.println("ada error nama field, coba dicek");
        }
        }
         public void termahal(){
        try{
            
            String sql="select * from barang order by "
                     + "harga desc";
             //res = stat.executeQuery();
            stat = new Fungsi.Koneksi().koneksiDatabase().createStatement();
            res = stat.executeQuery(sql);
            while(res.next()){
                String kode = res.getString("kode");
                String nama = res.getString("nama");
                String produsen = res.getString("produsen");
                String mesin = res.getString("mesin");
                String harga = res.getString("harga");
                String kapasitas = res.getString("kapasitas");
                String keterangan = res.getString("keterangan");
                String foto = res.getString("foto");
                String data[] = {kode,nama,produsen,mesin,harga,kapasitas,keterangan,foto};
                tabModel.addRow(data);
            }
                      
        }
        catch(Exception e){
            System.out.println("ada error nama field, coba dicek");
        }
        }*/
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Panelgambar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfnama = new javax.swing.JTextField();
        tfprod = new javax.swing.JTextField();
        tfmesin = new javax.swing.JTextField();
        tfharga = new javax.swing.JTextField();
        tfkapasitas = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfket = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfkode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        tfcari = new javax.swing.JTextField();
        jbcari = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Harga = new javax.swing.JMenu();
        jbmahal = new javax.swing.JMenuItem();
        jbmurah = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        Panelgambar.setBackground(new java.awt.Color(204, 255, 0));

        jLabel7.setText("mesin");

        jLabel8.setText("nama motor");

        jLabel9.setText("produsen");

        jLabel10.setText("harga");

        jLabel11.setText("kapasitas mesin");

        jLabel12.setText("keterangan");

        tfket.setColumns(20);
        tfket.setRows(5);
        jScrollPane3.setViewportView(tfket);

        jLabel1.setText("beli");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("kode motor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panelgambar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 69, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfkapasitas, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(tfnama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfharga, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfprod)
                                    .addComponent(tfmesin, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfkode))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Panelgambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfmesin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfharga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfkapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1))
                            .addComponent(jLabel12)))))
        );

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jbcari.setText("cari");
        jbcari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbcariMouseClicked(evt);
            }
        });
        jbcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbcari, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 114, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbcari))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Short by");

        Harga.setText("Harga");

        jbmahal.setText("Termahal");
        jbmahal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbmahalActionPerformed(evt);
            }
        });
        Harga.add(jbmahal);

        jbmurah.setText("Termurah");
        jbmurah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbmurahActionPerformed(evt);
            }
        });
        Harga.add(jbmurah);

        jMenu1.add(Harga);

        jMenu3.setText("Mesin");

        jMenuItem1.setText("Yamaha");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Honda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem2.setText("Suzuki");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
try {  
              int row  = table1.getSelectedRow();
             String kode = tabModel.getValueAt(row, 0).toString();
             String nama = tabModel.getValueAt(row, 1).toString();
             String produsen = tabModel.getValueAt(row, 2).toString();
             String mesin = tabModel.getValueAt(row, 3).toString();
             String harga = tabModel.getValueAt(row, 4).toString();
             String kapasitas = tabModel.getValueAt(row, 5).toString();
             String keterangan = tabModel.getValueAt(row, 6).toString();
             tfkode.setText(kode);
              tfnama.setText(nama);
              tfprod.setText(produsen);
              tfmesin.setText(mesin);
              tfharga.setText(harga);
              tfkapasitas.setText(kapasitas);
              tfket.setText(keterangan);
                

             prestat = new Fungsi.Koneksi().koneksiDatabase().prepareStatement("select foto from barang where kode=?");
             //res = stat.executeQuery();
           prestat.setString(1, kode);
            ResultSet res = prestat.executeQuery();
            res.next();
            
            
                byte[] imagedata = res.getBytes("foto");
                format = new ImageIcon(imagedata);
                Image im = format.getImage();
                Image img2 = im.getScaledInstance(Panelgambar.getWidth(),Panelgambar.getHeight() ,Image.SCALE_DEFAULT);
                ImageIcon img = new ImageIcon(img2);
                Panelgambar.setIcon(img);   
            
         } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }   

        // TODO add your handling code here:
    }//GEN-LAST:event_table1MouseClicked

    private void jbcariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbcariMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jbcariMouseClicked

    private void jbcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcariActionPerformed
    hapusPadaForm();
tampilDataKeTabel(tfcari.getText(),"","");
        // TODO add your handling code here:
    }//GEN-LAST:event_jbcariActionPerformed

    private void jbmahalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbmahalActionPerformed
hapusPadaForm();
        tampilDataKeTabel("","","mahal");
        // TODO add your handlieng code here:
    }//GEN-LAST:event_jbmahalActionPerformed

    private void jbmurahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbmurahActionPerformed
        
hapusPadaForm();
tampilDataKeTabel("","","murah");

        // TODO add your handling code here:
    }//GEN-LAST:event_jbmurahActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        hapusPadaForm();
        tampilDataKeTabel("","suzuki","");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        // TODO add your handling code here:
        hapusPadaForm();
        tampilDataKeTabel("","yamaha","");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        hapusPadaForm();
        tampilDataKeTabel("","honda","");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
       transaksi tr = new transaksi(tfkode,tfnama,tfprod,tfmesin,tfkapasitas,tfharga);
       tr.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked
 ImageIcon format=null;
 String fname = null;
 int s =0;
 byte[] pimage=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frameuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frameuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frameuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frameuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frameuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Harga;
    private javax.swing.JLabel Panelgambar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbcari;
    private javax.swing.JMenuItem jbmahal;
    private javax.swing.JMenuItem jbmurah;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tfcari;
    private javax.swing.JTextField tfharga;
    private javax.swing.JTextField tfkapasitas;
    private javax.swing.JTextArea tfket;
    private javax.swing.JTextField tfkode;
    private javax.swing.JTextField tfmesin;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tfprod;
    // End of variables declaration//GEN-END:variables
}
