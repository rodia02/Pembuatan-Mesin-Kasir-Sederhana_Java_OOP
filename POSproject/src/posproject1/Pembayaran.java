/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posproject1;

import java.time.LocalDateTime;
import java.util.UUID;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static posproject1.DBConnector.initDBConnection;



public interface Pembayaran {
    float getTotalHarga();
    void setTotalHarga(float totalHarga);
    
    String getWaktuPembayaran();
    void setWaktuPembayaran(String waktuPembayaran);
    
    int getIDPembayaran();
    void setIDPembayaran(int IDPembayaram);
}

abstract class QRCode implements Pembayaran {
    private String konten;
    private LocalDateTime requestDate;
    private String invoiceID;
    private float totalHarga;
    private String waktuPembayaran;
    private int IDPembayaran;
    public final String jenisPembayaran = "Qris";

    public QRCode(String konten, String invoiceID, float totalHarga) {
        this.konten = konten;
        this.invoiceID = invoiceID;
        this.totalHarga = totalHarga;
        this.requestDate = LocalDateTime.now();
        this.IDPembayaran = generateIDPembayaran();
        this.waktuPembayaran = null;
    }

    // Implementasikan getter dan setter

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

    // Generate ID pembayaran secara acak menggunakan UUID
    private int generateIDPembayaran() {
        return UUID.randomUUID().hashCode();
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
