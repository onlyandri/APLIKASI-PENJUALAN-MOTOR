package Fungsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
    public static Connection konek;
     public Connection koneksiDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver MySQL ditemukan");
            String url = "jdbc:mysql://localhost:3306/penjualan";
            String user = "root";
            String pass = "";
            konek = DriverManager.getConnection(url,user,pass);
            System.out.println("Koneksi database sukses");
        }catch(ClassNotFoundException e){
            System.out.println("Driver MySQL tidak ada");
        }catch(SQLException e){
            System.out.println("Koneksi database gagal");
        }
        return konek;
    }
}
