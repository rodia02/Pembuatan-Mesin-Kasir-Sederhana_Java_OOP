/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posproject1;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author johan
 */
class Transaksi {
    public int totalTransaksi;
    public int bayarTransaksi;
    public int kembalianTransaksi;
    public String waktuTransaksi;
    public String deskripsiBarang = "";
    public Date timeTransaksi;
    static ArrayList<Transaksi> daftarTransaksi;
    

    
    public String informasiBarang(String nama, int jumlah) {
        String deskripsi = "";
        deskripsi = nama + "     x " + Integer.toString(jumlah) + "\n\n";

        return deskripsi;
    }
    
    public static void informasiTransaksi(){
        daftarTransaksi = new ArrayList<Transaksi>(); 
        Transaksi transaksi;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT * FROM transaksi";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                transaksi =  new Transaksi(); 
                transaksi.timeTransaksi =  rs.getDate("time");
                transaksi.deskripsiBarang = rs.getString("daftarbelanja");
                transaksi.totalTransaksi = rs.getInt("total");
                transaksi.bayarTransaksi = rs.getInt("jumlah");
                transaksi.kembalianTransaksi = rs.getInt("kembalian");

                
                daftarTransaksi.add(transaksi);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
