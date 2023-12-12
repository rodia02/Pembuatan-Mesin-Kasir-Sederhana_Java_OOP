/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posproject1;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author jo
 */
class Barang {
    String kode;
    String nama;
    float harga;
    Date kadaluarsa;
    String operator;
    float nominal;
    
    static ArrayList<Barang> daftarBarang;
    public static void loadBarangFromDB()
    {
        daftarBarang = new ArrayList<Barang>(); 
        Barang barang;
    }
}

