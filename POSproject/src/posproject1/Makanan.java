/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posproject1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Masyitoh
 */
public class Makanan extends Barang{
    
    
    public static void loadBarangFromDB()
    {
        Barang makanan;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "Select * from makanan";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                makanan = new Barang();
                makanan.kode = rs.getString("kode");
                makanan.nama = rs.getString("nama");
                makanan.harga = rs.getFloat("harga");
                makanan.kadaluarsa = rs.getDate("kadaluarsa");
                makanan.operator = null;
                makanan.nominal = 0;
               
                Barang.daftarBarang.add(makanan);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}

