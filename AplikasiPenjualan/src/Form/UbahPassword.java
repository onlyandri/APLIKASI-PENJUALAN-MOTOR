

package Form;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class UbahPassword extends javax.swing.JFrame {

   
    public UbahPassword() {
        initComponents();
         setLocationRelativeTo(null);
         new Fungsi.Koneksi().koneksiDatabase();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pfPasswordLama = new javax.swing.JPasswordField();
        pfPasswordBaru = new javax.swing.JPasswordField();
        jbSimpanPass = new javax.swing.JButton();

        jLabel1.setText("Ubah Password");

        jLabel2.setText("Password Lama");

        jLabel3.setText("Password Baru");

        pfPasswordBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPasswordBaruActionPerformed(evt);
            }
        });

        jbSimpanPass.setText("Simpan");
        jbSimpanPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSimpanPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pfPasswordBaru)
                            .addComponent(pfPasswordLama, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbSimpanPass)
                            .addComponent(jLabel1))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfPasswordLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pfPasswordBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jbSimpanPass)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSimpanPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSimpanPassActionPerformed
        
        try{
            Statement stat = new Fungsi.Koneksi().konek.createStatement();
            ResultSet res = stat.executeQuery("select * from " 
                    + "user where password=md5('"
                    + pfPasswordLama.getText() + "') and "
                    + "status='Aktif'");
            
            if(res.next()){
                String username = res.getString("username");
                stat.executeUpdate("update user set password=md5('"
                        + pfPasswordBaru.getText() + "') "
                        + "where username='" + username + "'");
                JOptionPane.showMessageDialog(rootPane, "Password berhasil diubah");
            }
            else{
                 JOptionPane.showMessageDialog(rootPane, "Password lama salah");
            }
             pfPasswordLama.setText(null);
             pfPasswordBaru.setText(null);
             pfPasswordLama.requestFocus();
        }
        catch(Exception e){
            System.out.println(""+e);
        }
    }//GEN-LAST:event_jbSimpanPassActionPerformed

    private void pfPasswordBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPasswordBaruActionPerformed
        
        jbSimpanPass.doClick();
    }//GEN-LAST:event_pfPasswordBaruActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UbahPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbSimpanPass;
    private javax.swing.JPasswordField pfPasswordBaru;
    private javax.swing.JPasswordField pfPasswordLama;
    // End of variables declaration//GEN-END:variables
}
