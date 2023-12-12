/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author johan
 */
public class KartuDebit implements Pembayaran {
    private String BankNama;
    private String NoCard;
    private float totalHarga;
    private String waktuPembayaran;
    private int IDPembayaran;
    public final String jenisPembayaran = "Kartu Debit";
    
    public KartuDebit(String BankNama, String NoCard) {
        this.BankNama = BankNama;
        this.NoCard = NoCard;
    }
 
    // Implementasikan getter dan setter
    
    public void DetailPembayaran(){
        System.out.println("Total pembayaran "+totalHarga+" menggunakan kartu debit bank "+BankNama);
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
