/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posproject1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author johan
 */
public class Pulsa extends Barang {
    public static String noTelp;
    
    public static void loadBarangFromDB()
    {

        Barang pulsa;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "Select * from pulsa";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                pulsa = new Barang();
                pulsa.kode = rs.getString("kode");
                pulsa.nama = rs.getString("nama");
                pulsa.harga = rs.getFloat("harga");
                pulsa.kadaluarsa = null;
                pulsa.operator = rs.getString("operator");
                pulsa.nominal = rs.getFloat("nominal");
                
               
                Barang.daftarBarang.add(pulsa);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}