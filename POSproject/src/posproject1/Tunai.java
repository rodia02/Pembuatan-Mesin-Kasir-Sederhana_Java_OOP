/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posproject1;

/**
 *
 * @author johan
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tunai implements Pembayaran {
    private float dibayar;
    private float kembalian;
    private float totalHarga;
    private String waktuPembayaran;
    private int IDPembayaran; public float uangDiterima;
    public final String jenisPembayaran = "Tunai";
    
    public Tunai(float kembalian, float uangDiterima){
        this.kembalian = kembalian;
        this.uangDiterima = uangDiterima;
    }
    

    public float getDibayar() {
        return dibayar;
    }

    public void setDibayar(float dibayar) {
        this.dibayar = dibayar;
    }

    public float getKembalian() {
        return kembalian;
    }

    public void setKembalian(float kembalian) {
        this.kembalian = kembalian;
    }

    @Override
    public float getTotalHarga() {
        return totalHarga;
    }

    @Override
    public void setTotalHarga(float totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Override
    public String getWaktuPembayaran() {
        return waktuPembayaran;
    }

    @Override
    public void setWaktuPembayaran(String waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
    }

    @Override
    public int getIDPembayaran() {
        return IDPembayaran;
    }

    @Override
    public void setIDPembayaran(int IDPembayaran) {
        this.IDPembayaran = IDPembayaran;
    }
    public void simpanDatabase() throws SQLException{
         try{
            Connection con= DBConnector.connection;
            PreparedStatement stmt=con.prepareStatement("INSERT INTO transaksi (id_pembayaran, total_harga, waktu_pembayaran,jenis_pembayaran) VALUES(?, ?, ?, ?)"); 
           
            stmt.setInt(1,IDPembayaran);
            stmt.setFloat(2, totalHarga);
            stmt.setString(3, waktuPembayaran);
            stmt.setString(4, jenisPembayaran);
            stmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.print(e);
        }
    }
}
