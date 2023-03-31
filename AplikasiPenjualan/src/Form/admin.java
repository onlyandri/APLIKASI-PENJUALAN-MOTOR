/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import Fungsi.Koneksi;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import static java.lang.String.format;
import java.rmi.RemoteException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author acer
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
     private Statement stat;
    private ResultSet res;
    private final DefaultTableModel tabModel;
    private PreparedStatement prestat;
    
    
    
    public admin() 
    {
      initComponents();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
          String row[]={"kode","nama","produsen","mesin","harga","kapasitas","keterangan","foto"};
         tabModel = new DefaultTableModel(null,row);
         jTable1.setModel(tabModel);
        
         tampilDataKeTabel("","","");
         jTable1.getTableHeader().setFont((new Font("Segoe UI", Font.BOLD, 12)));
         jTable1.getTableHeader().setOpaque(false);
       //  jTable1.getTableHeader().setBackground(new Color(32, 136, 203));
        // jTable1.getTableHeader().setForeground(new Color(2,255,255));
         jTable1.setRowHeight(35);
         kodeotomatis();
         
         pnMenu.setVisible(false);
         panelAkun.setVisible(false);
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
       public void kodeotomatis()
{
    try
    {
        String sql = "select * from barang order by "
                + "kode desc";
        stat = new Fungsi.Koneksi().konek.createStatement();
        res = stat.executeQuery (sql);
        //mengecek apakah ada baris selanjutnya atau tidak
        if(res.next())
        {
        String kode = res.getString("kode").substring(1);
        String angka = "" +(Integer.parseInt(kode)+1);
        String nol = "";
        if(angka.length()==1){
            nol = "00";
        }
        else if (angka.length()==2){
            nol = "0";
        }
        tfkode.setText("B"+nol+angka);
    }else{
            tfkode.setText("B001");
        }
    }
    catch (Exception e)
            {
                System.out.println(""+e);
            }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        panelEdit = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelSimpan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelHapus = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelUbah = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelLaporan = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panelBatal = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelKeluar = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelAkun = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tfcari = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tffoto = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfkode = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tfprod = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfmesin = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfharga = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfket = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        tfnama = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        panelGambar = new javax.swing.JLabel();
        tfkapasitas = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        pnHonda = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        pnYamaha = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        pnSuzuki = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        pnMurah = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        pnMahal = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bgMouseMoved(evt);
            }
        });
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bgMouseClicked(evt);
            }
        });

        sideBar.setBackground(new java.awt.Color(54, 33, 89));
        sideBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sideBarMouseMoved(evt);
            }
        });
        sideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sideBarMouseClicked(evt);
            }
        });

        panelEdit.setBackground(new java.awt.Color(85, 65, 118));
        panelEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelEditMousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit Barang");

        javax.swing.GroupLayout panelEditLayout = new javax.swing.GroupLayout(panelEdit);
        panelEdit.setLayout(panelEditLayout);
        panelEditLayout.setHorizontalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEditLayout.setVerticalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(1, 1, 1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap())
        );

        panelSimpan.setBackground(new java.awt.Color(64, 43, 100));
        panelSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelSimpanMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bookmark.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Simpan Barang");

        javax.swing.GroupLayout panelSimpanLayout = new javax.swing.GroupLayout(panelSimpan);
        panelSimpan.setLayout(panelSimpanLayout);
        panelSimpanLayout.setHorizontalGroup(
            panelSimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSimpanLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSimpanLayout.setVerticalGroup(
            panelSimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSimpanLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSimpanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelHapus.setBackground(new java.awt.Color(64, 43, 100));
        panelHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHapusMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hapus Barang");

        javax.swing.GroupLayout panelHapusLayout = new javax.swing.GroupLayout(panelHapus);
        panelHapus.setLayout(panelHapusLayout);
        panelHapusLayout.setHorizontalGroup(
            panelHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHapusLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHapusLayout.setVerticalGroup(
            panelHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHapusLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1))
        );

        panelUbah.setBackground(new java.awt.Color(64, 43, 100));
        panelUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelUbahMousePressed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ubah Barang");

        javax.swing.GroupLayout panelUbahLayout = new javax.swing.GroupLayout(panelUbah);
        panelUbah.setLayout(panelUbahLayout);
        panelUbahLayout.setHorizontalGroup(
            panelUbahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbahLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelUbahLayout.setVerticalGroup(
            panelUbahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbahLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelUbahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(1, 1, 1))
        );

        panelLaporan.setBackground(new java.awt.Color(64, 43, 100));
        panelLaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelLaporanMousePressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/token-card-code.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("laporan");

        javax.swing.GroupLayout panelLaporanLayout = new javax.swing.GroupLayout(panelLaporan);
        panelLaporan.setLayout(panelLaporanLayout);
        panelLaporanLayout.setHorizontalGroup(
            panelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLaporanLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLaporanLayout.setVerticalGroup(
            panelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLaporanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11))
            .addGroup(panelLaporanLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lock.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("andri");

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("welcome");

        panelBatal.setBackground(new java.awt.Color(64, 43, 100));
        panelBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBatalMousePressed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/restart.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Batal");

        javax.swing.GroupLayout panelBatalLayout = new javax.swing.GroupLayout(panelBatal);
        panelBatal.setLayout(panelBatalLayout);
        panelBatalLayout.setHorizontalGroup(
            panelBatalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBatalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBatalLayout.setVerticalGroup(
            panelBatalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBatalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBatalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        panelKeluar.setBackground(new java.awt.Color(64, 43, 100));
        panelKeluar.setToolTipText("");
        panelKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelKeluarMouseClicked(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ek.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("sabar tunggu");

        javax.swing.GroupLayout panelKeluarLayout = new javax.swing.GroupLayout(panelKeluar);
        panelKeluar.setLayout(panelKeluarLayout);
        panelKeluarLayout.setHorizontalGroup(
            panelKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeluarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelKeluarLayout.setVerticalGroup(
            panelKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeluarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKeluarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addGroup(panelKeluarLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelAkun.setBackground(new java.awt.Color(0, 51, 204));

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel5MouseMoved(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1 - user.png"))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("your account");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel8MouseMoved(evt);
            }
        });
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/siswa-small.png"))); // NOI18N

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("change account");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 102, 255));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel9MouseMoved(evt);
            }
        });
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/login-red.png"))); // NOI18N

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Log out");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAkunLayout = new javax.swing.GroupLayout(panelAkun);
        panelAkun.setLayout(panelAkunLayout);
        panelAkunLayout.setHorizontalGroup(
            panelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelAkunLayout.setVerticalGroup(
            panelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAkunLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(54, 33, 89));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
        });

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/11-42-01-contacts-filled.png"))); // NOI18N

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("account");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48))
        );

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelUbah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBatal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAkun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarLayout.createSequentialGroup()
                    .addContainerGap(205, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)))
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(66, 66, 66)))
                .addComponent(panelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(panelAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jLabel18)
                    .addContainerGap(967, Short.MAX_VALUE)))
        );

        jScrollPane1.setBorder(null);

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 51));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        jPanel1.setBackground(new java.awt.Color(122, 72, 221));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Halaman Admin");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nav-menu1.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        tfcari.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfcari.setForeground(new java.awt.Color(102, 102, 102));
        tfcari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 3));
        tfcari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfcariMouseEntered(evt);
            }
        });
        tfcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcariActionPerformed(evt);
            }
        });

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-search-filled-50.png"))); // NOI18N
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 51, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("X");
        jLabel28.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel28MouseMoved(evt);
            }
        });
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("nama motor");

        tffoto.setEditable(false);
        tffoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tffoto.setForeground(new java.awt.Color(51, 51, 51));
        tffoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102), 2));
        tffoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffotoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("kapasitas");

        tfkode.setEditable(false);
        tfkode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfkode.setForeground(new java.awt.Color(51, 51, 51));
        tfkode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfkode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));
        tfkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfkodeActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("produsen");

        tfprod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfprod.setForeground(new java.awt.Color(51, 51, 51));
        tfprod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfprod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        tfprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfprodActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("mesin");

        tfmesin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfmesin.setForeground(new java.awt.Color(51, 51, 51));
        tfmesin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfmesin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102), 2));
        tfmesin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmesinActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("harga");

        tfharga.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfharga.setForeground(new java.awt.Color(51, 51, 51));
        tfharga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfharga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102), 2));
        tfharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfhargaActionPerformed(evt);
            }
        });
        tfharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfhargaKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("keterangan");

        tfket.setColumns(20);
        tfket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfket.setForeground(new java.awt.Color(51, 51, 51));
        tfket.setRows(5);
        tfket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153), 2));
        jScrollPane2.setViewportView(tfket);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("kode barang");

        tfnama.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfnama.setForeground(new java.awt.Color(51, 51, 51));
        tfnama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfnama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153), 2));
        tfnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnamaActionPerformed(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/opened-folder.png"))); // NOI18N
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        panelGambar.setForeground(new java.awt.Color(204, 204, 204));
        panelGambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelGambar.setText("image here");

        tfkapasitas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfkapasitas.setForeground(new java.awt.Color(51, 51, 51));
        tfkapasitas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfkapasitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));
        tfkapasitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfkapasitasActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("foto");

        pnMenu.setBackground(new java.awt.Color(54, 33, 89));

        pnHonda.setBackground(new java.awt.Color(64, 43, 100));
        pnHonda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnHonda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnHondaMousePressed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Honda");

        javax.swing.GroupLayout pnHondaLayout = new javax.swing.GroupLayout(pnHonda);
        pnHonda.setLayout(pnHondaLayout);
        pnHondaLayout.setHorizontalGroup(
            pnHondaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHondaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHondaLayout.setVerticalGroup(
            pnHondaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHondaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnYamaha.setBackground(new java.awt.Color(64, 43, 100));
        pnYamaha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnYamaha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnYamahaMousePressed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("yamaha");

        javax.swing.GroupLayout pnYamahaLayout = new javax.swing.GroupLayout(pnYamaha);
        pnYamaha.setLayout(pnYamahaLayout);
        pnYamahaLayout.setHorizontalGroup(
            pnYamahaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnYamahaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        pnYamahaLayout.setVerticalGroup(
            pnYamahaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnYamahaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnSuzuki.setBackground(new java.awt.Color(64, 43, 100));
        pnSuzuki.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnSuzuki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnSuzukiMousePressed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 204, 204));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("suzuki");

        javax.swing.GroupLayout pnSuzukiLayout = new javax.swing.GroupLayout(pnSuzuki);
        pnSuzuki.setLayout(pnSuzukiLayout);
        pnSuzukiLayout.setHorizontalGroup(
            pnSuzukiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSuzukiLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnSuzukiLayout.setVerticalGroup(
            pnSuzukiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSuzukiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnMurah.setBackground(new java.awt.Color(64, 43, 100));
        pnMurah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnMurah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMurahMousePressed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("termurah");

        javax.swing.GroupLayout pnMurahLayout = new javax.swing.GroupLayout(pnMurah);
        pnMurah.setLayout(pnMurahLayout);
        pnMurahLayout.setHorizontalGroup(
            pnMurahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMurahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        pnMurahLayout.setVerticalGroup(
            pnMurahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMurahLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnMahal.setBackground(new java.awt.Color(64, 43, 100));
        pnMahal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnMahal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMahalMousePressed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 204, 204));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("termahal");

        javax.swing.GroupLayout pnMahalLayout = new javax.swing.GroupLayout(pnMahal);
        pnMahal.setLayout(pnMahalLayout);
        pnMahalLayout.setHorizontalGroup(
            pnMahalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMahalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        pnMahalLayout.setVerticalGroup(
            pnMahalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMahalLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel39)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("mesin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 204));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("harga");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addGap(80, 80, 80))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHonda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnYamaha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnSuzuki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnMurah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnMahal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnHonda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnYamaha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnSuzuki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnMurah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnMahal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1316, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(tfprod, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(260, 260, 260)
                                .addComponent(tffoto, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel27))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(75, 75, 75)
                                        .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel23)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfharga, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel25))
                                        .addGap(82, 82, 82)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfmesin, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfkapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGap(139, 139, 139)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addGroup(bgLayout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfkode, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tffoto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfprod, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfmesin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfharga, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfkapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(panelGambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfkode, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelKeluarMouseClicked
        // TODO add your handling code her
        setColor(panelKeluar);
        resetColor(panelSimpan);
        resetColor(panelHapus);
        resetColor(panelUbah);
        resetColor(panelLaporan);
        resetColor(panelBatal);
        resetColor(panelEdit);
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_panelKeluarMouseClicked

    private void panelEditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEditMousePressed
        // TODO add your handling code here:
        setColor(panelEdit);
        resetColor(panelSimpan);
        resetColor(panelHapus);
        resetColor(panelUbah);
        resetColor(panelLaporan);
        resetColor(panelBatal);
        resetColor(panelKeluar);
        kodeotomatis();
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
       
    }//GEN-LAST:event_panelEditMousePressed

    private void panelSimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSimpanMousePressed
        // TODO add your handling code here:
          setColor(panelSimpan);
        resetColor(panelEdit);
        resetColor(panelHapus);
        resetColor(panelUbah);
        resetColor(panelLaporan);
        resetColor(panelBatal);
        resetColor(panelKeluar);
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
        
              try{
                
                if(!(tfnama.getText().equals("") || tfprod.getText().equals("") || tfmesin.getText().equals("") || tfharga.equals("")))
                {
                   String sql = "insert into barang(kode,nama,produsen,mesin,harga,kapasitas,keterangan,foto) values "
                    + "(?,?,?,?,?,?,?,?)";
            prestat = new Fungsi.Koneksi().koneksiDatabase().prepareStatement(sql);
            prestat.setString(1, tfkode.getText());
            prestat.setString(2,tfnama.getText());
            prestat.setString(3,tfprod.getText());
            prestat.setString(4,tfmesin.getText());
            prestat.setString(5,tfharga.getText());
            prestat.setString(6,tfkapasitas.getText());
            prestat.setString(7,tfket.getText());
            prestat.setBytes(8,photo);
            prestat.executeUpdate();
            JOptionPane.showMessageDialog(null, 
            "Data berhasil disimpan","Informasi",
            JOptionPane.INFORMATION_MESSAGE);
           tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
           hapusPadaForm();
            tampilDataKeTabel("","","");
                }else
                {
                      JOptionPane.showMessageDialog(null, 
                    "kolom harus diisi semua","Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
                    
                 }
        
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, 
                    "kolom tidak boloh kosong atau terdapat kesamaan kode barang","Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        }
             byte[] photo =null;
           String filename=null;
          kodeotomatis();
    }//GEN-LAST:event_panelSimpanMousePressed

    private void panelHapusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHapusMousePressed
        // TODO add your handling code here
        setColor(panelHapus);
        resetColor(panelEdit);
        resetColor(panelSimpan);
        resetColor(panelUbah);
        resetColor(panelLaporan);
        resetColor(panelBatal);
        resetColor(panelKeluar);
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
        
             int row  = jTable1.getSelectedRow();
         String kode = tabModel.getValueAt(row, 0).toString();
        try {
               stat.executeUpdate("delete from barang where kode='"+kode+"'");
                JOptionPane.showMessageDialog(null, 
                    "Data berhasil dihapus","Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
           tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           hapusPadaForm();
           tfkode.setText("");
           tampilDataKeTabel("","","");
          kodeotomatis();
    }//GEN-LAST:event_panelHapusMousePressed

    private void panelUbahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUbahMousePressed
        // TODO add your handling code here:
        setColor(panelUbah);
        resetColor(panelEdit);
        resetColor(panelHapus);
        resetColor(panelSimpan);
        resetColor(panelLaporan);
        resetColor(panelBatal);
        resetColor(panelKeluar);
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
        
         int row  = jTable1.getSelectedRow();
          String kode = tabModel.getValueAt(row, 0).toString();
          
        try {  
          //  File gambar = new File(filename);
            //FileInputStream fis = new FileInputStream(gambar);
            //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            //StringBuffer text = new StringBuffer();
       /*     
        String gambar = new File(filename);
        FileInputStream fis = new FileInputStream(gambar);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        
        for(int readNum; (readNum=fis.read(buf))!=-1; )
        {
            bos.write(buf,0,readNum);
        }
        photo = bos.toByteArray();*/
        
        
   
                String sql = "update barang set nama=?,produsen=?,mesin=?,harga=?,kapasitas=?,keterangan=?,foto=? where kode='"+kode+"'";
                prestat = new Fungsi.Koneksi().koneksiDatabase().prepareStatement(sql);
                prestat.setString(1,tfnama.getText());
                prestat.setString(2,tfprod.getText());
                prestat.setString(3,tfmesin.getText());
                prestat.setString(4,tfharga.getText());
                prestat.setString(5,tfkapasitas.getText());
                prestat.setString(6,tfket.getText());
                prestat.setBytes(7,photo);
                prestat.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        "Data berhasil ubah","Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
            
             }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,
                        "kesalahan","Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        
           tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
           hapusPadaForm();
            tampilDataKeTabel("","","");
             byte[] photo =null;
           String filename=null;
       
        kodeotomatis();
    }//GEN-LAST:event_panelUbahMousePressed

    private void panelLaporanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLaporanMousePressed
        // TODO add your handling code here:
        setColor(panelLaporan);
        resetColor(panelEdit);
        resetColor(panelHapus);
        resetColor(panelUbah);
        resetColor(panelSimpan);
        resetColor(panelBatal);
        resetColor(panelKeluar);
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_panelLaporanMousePressed

    private void panelBatalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBatalMousePressed
        // TODO add your handling code here:
        setColor(panelBatal);
        resetColor(panelEdit);
        resetColor(panelHapus);
        resetColor(panelUbah);
        resetColor(panelLaporan);
        resetColor(panelSimpan);
        resetColor(panelKeluar);
        
        
             tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
             hapusPadaForm();
            tampilDataKeTabel("","","");
            kodeotomatis();
            pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_panelBatalMousePressed

    private void tffotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tffotoActionPerformed

    private void tfkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfkodeActionPerformed
        // TODO add your handling code here:
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfkodeActionPerformed

    private void tfprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfprodActionPerformed
        // TODO add your handling code here:
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfprodActionPerformed

    private void tfmesinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmesinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmesinActionPerformed

    private void tfhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfhargaActionPerformed
        // TODO add your handling code here:
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfhargaActionPerformed

    private void tfnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnamaActionPerformed
        // TODO add your handling code here:
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfnamaActionPerformed

    private void tfkapasitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfkapasitasActionPerformed
        // TODO add your handling code here:
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfkapasitasActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
              try {  
              int row  = jTable1.getSelectedRow();
             String kode = tabModel.getValueAt(row, 0).toString();
             String nama = tabModel.getValueAt(row, 1).toString();
             String produsen = tabModel.getValueAt(row, 2).toString();
             String mesin = tabModel.getValueAt(row, 3).toString();
             String harga = tabModel.getValueAt(row, 4).toString();
             String kapasitas = tabModel.getValueAt(row, 5).toString();
             String keterangan = tabModel.getValueAt(row, 6).toString();
             String filename = tabModel.getValueAt(row, 7).toString();
              tfnama.setText(nama);
              tfprod.setText(produsen);
              tfmesin.setText(mesin);
              tfharga.setText(harga);
              tfkapasitas.setText(kapasitas);
              tfket.setText(keterangan);
              tffoto.setText(filename);
              tfkode.setText(kode);
           prestat = new Fungsi.Koneksi().koneksiDatabase().prepareStatement("select foto from barang where kode=?");
             //res = stat.executeQuery();
            prestat.setString(1, kode);
            ResultSet res = prestat.executeQuery();
            res.next();
            
            
                byte[] imagedata = res.getBytes("foto");
                format = new ImageIcon(imagedata);
                Image im = format.getImage();
                Image img2 = im.getScaledInstance(panelGambar.getWidth(),panelGambar.getHeight() ,Image.SCALE_DEFAULT);
                ImageIcon img = new ImageIcon(img2);
                panelGambar.setIcon(img);   
            
         } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        } 
              panelAkun.setVisible(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF , and PNG image", "jpg","png","gif");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();    
        filename = file.getAbsolutePath();
        tffoto.setText(filename);
        try{
        Image image = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(200,300,200));
        
        panelGambar.setIcon(imageIcon);
        panelGambar.setText("");
        
        File gambar = new File(filename);
        FileInputStream fis = new FileInputStream(gambar);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        
        for(int readNum; (readNum=fis.read(buf))!=-1; )
        {
            bos.write(buf,0,readNum);
        }
        photo = bos.toByteArray();
        
        
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel27MouseClicked

    private void tfhargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfhargaKeyTyped
        // TODO add your handling code here:
         char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter)))
        {
            evt.consume();
        }
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfhargaKeyTyped

    private void pnHondaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHondaMousePressed
         clr(pnHonda);
        rclr(pnYamaha);
        rclr(pnSuzuki);
        rclr(pnMahal);
        rclr(pnMurah);
            tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
        hapusPadaForm();
        tampilDataKeTabel("","honda","");
    }//GEN-LAST:event_pnHondaMousePressed

    private void pnYamahaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnYamahaMousePressed
        // TODO add your handling code here:
          clr(pnYamaha);
        rclr(pnHonda);
        rclr(pnSuzuki);
        rclr(pnMahal);
        rclr(pnMurah);
        
             tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
        hapusPadaForm();
        tampilDataKeTabel("","yamaha","");
    }//GEN-LAST:event_pnYamahaMousePressed

    private void pnSuzukiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnSuzukiMousePressed
        // TODO add your handling code here:
          clr(pnSuzuki);
        rclr(pnYamaha);
        rclr(pnHonda);
        rclr(pnMahal);
        rclr(pnMurah);
        
           tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
        hapusPadaForm();
        tampilDataKeTabel("","suzuki","");
    }//GEN-LAST:event_pnSuzukiMousePressed

    private void pnMurahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMurahMousePressed
        // TODO add your handling code here:
          clr(pnMurah);
        rclr(pnYamaha);
        rclr(pnSuzuki);
        rclr(pnMahal);
        rclr(pnHonda);
        
         tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
        hapusPadaForm();
        tampilDataKeTabel("","","murah");
    }//GEN-LAST:event_pnMurahMousePressed

    private void pnMahalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMahalMousePressed
        // TODO add your handling code here:
          clr(pnMahal);
        rclr(pnYamaha);
        rclr(pnSuzuki);
        rclr(pnHonda);
        rclr(pnMurah);
       
        
         tfnama.setText("");
           tfharga.setText("");
           tffoto.setText("");
           tfkapasitas.setText("");
           tfket.setText("");
           tfmesin.setText("");
           tfprod.setText("");
           panelGambar.setIcon(null);
           tfkode.setText("");
        hapusPadaForm();
        tampilDataKeTabel("","","mahal");
    }//GEN-LAST:event_pnMahalMousePressed

    private void tfcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcariActionPerformed
        // TODO add your handling code here:
        
          hapusPadaForm();
        tampilDataKeTabel(tfcari.getText(),"","");
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfcariActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
        pnMenu.setVisible(true);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_jLabel30MouseClicked

    private void bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseClicked
        // TODO add your handling code here:
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_bgMouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
          hapusPadaForm();
        tampilDataKeTabel(tfcari.getText(),"","");
    }//GEN-LAST:event_jLabel40MouseClicked

    private void tfcariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfcariMouseEntered
        // TODO add your handling code here:
          hapusPadaForm();
        tampilDataKeTabel(tfcari.getText(),"","");
        pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_tfcariMouseEntered

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        // TODO add your handling code here:
      
       panelAkun.setVisible(true);
       pnMenu.setVisible(false);
        
    }//GEN-LAST:event_jPanel10MousePressed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        userBaru us = new userBaru();
        us.setVisible(true);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseMoved
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(85,65,118));
        jPanel8.setBackground(new Color(0,102,255));
         jPanel9.setBackground(new Color(0,102,255));
    }//GEN-LAST:event_jPanel5MouseMoved

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        ubah ub = new ubah();
        ub.setVisible(true);
         jPanel5.setBackground(new Color(0,102,255));
         
         
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseMoved
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(0,102,255));
        jPanel8.setBackground(new Color(85,65,118));
        jPanel9.setBackground(new Color(0,102,255));
        
        
    }//GEN-LAST:event_jPanel8MouseMoved

    private void jPanel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseMoved
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(0,102,255));
         jPanel8.setBackground(new Color(0,102,255));
         jPanel9.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_jPanel9MouseMoved

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
             Statement stat;
        try {
            stat = new Fungsi.Koneksi().konek.createStatement();
                 ResultSet res = stat.executeQuery("select * from user where status ='aktif'");
                
                if(res.next())
                {
                    String username = res.getString("username");
                    stat.executeUpdate("update user set status=NULL where username='"+username+ "'");
                setVisible(false);
                 }
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
        depan fr = new depan();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void sideBarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBarMouseMoved
        // TODO add your handling code here:
         jPanel5.setBackground(new Color(0,102,255));
         jPanel8.setBackground(new Color(0,102,255));
         jPanel9.setBackground(new Color(0,102,255));
    }//GEN-LAST:event_sideBarMouseMoved

    private void bgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseMoved
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(0,102,255));
         jPanel8.setBackground(new Color(0,102,255));
         jPanel9.setBackground(new Color(0,102,255));
    }//GEN-LAST:event_bgMouseMoved

    private void sideBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideBarMouseClicked
        // TODO add your handling code here:
         pnMenu.setVisible(false);
        panelAkun.setVisible(false);
    }//GEN-LAST:event_sideBarMouseClicked

    private void jLabel28MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseMoved
        // TODO add your handling code here:
        jPanel4.setBackground(new Color(255,0,51));
    }//GEN-LAST:event_jLabel28MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        jPanel4.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
               Statement stat;
        try {
            stat = new Fungsi.Koneksi().konek.createStatement();
                 ResultSet res = stat.executeQuery("select * from user where status ='aktif'");
                
                if(res.next())
                {
                    String username = res.getString("username");
                    stat.executeUpdate("update user set status=NULL where username='"+username+ "'");
                setVisible(false);
                 }
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
        depan fr = new depan();
        fr.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel28MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
          for(double i = 0.0;i<=1.0;i=i+0.1)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(90);
            }catch(Exception e)
            {
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

    
   void setColor(JPanel panel)
   {
       panel.setBackground(new Color(85,65,118));
       
   }
   void resetColor(JPanel panel)
   {
         panel.setBackground(new Color(64,43,100));
        
   }
   
   void clr(JPanel pn)
   {
      pn.setBackground(new Color(153,153,153)); 
   }
   void rclr(JPanel pn)
   {
       pn.setBackground(new Color(64,43,100)); 
   }
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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }
 ImageIcon format=null;
 String fname = null;
 int s =0;
 byte[] pimage=null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelAkun;
    private javax.swing.JPanel panelBatal;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JLabel panelGambar;
    private javax.swing.JPanel panelHapus;
    private javax.swing.JPanel panelKeluar;
    private javax.swing.JPanel panelLaporan;
    private javax.swing.JPanel panelSimpan;
    private javax.swing.JPanel panelUbah;
    private javax.swing.JPanel pnHonda;
    private javax.swing.JPanel pnMahal;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnMurah;
    private javax.swing.JPanel pnSuzuki;
    private javax.swing.JPanel pnYamaha;
    private javax.swing.JPanel sideBar;
    private javax.swing.JTextField tfcari;
    private javax.swing.JTextField tffoto;
    private javax.swing.JTextField tfharga;
    private javax.swing.JTextField tfkapasitas;
    private javax.swing.JTextArea tfket;
    private javax.swing.JTextField tfkode;
    private javax.swing.JTextField tfmesin;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tfprod;
    // End of variables declaration//GEN-END:variables
byte [] photo=null;
String filename=null;
}
