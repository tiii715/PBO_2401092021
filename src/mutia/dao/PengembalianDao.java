/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutia.dao;

import mutia.model.Anggota;
import mutia.model.Buku;
import mutia.model.Peminjaman;
import mutia.model.Pengembalian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PengembalianDao {

    public void insert(Pengembalian pengembalian) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "insert into pengembalian values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getPeminjaman().getAnggota().getKode());
        ps.setString(2, pengembalian.getPeminjaman().getBuku().getKode());
        ps.setString(3, pengembalian.getPeminjaman().getTglpinjam());
        ps.setString(4, pengembalian.getTgldikembalikan());
        ps.setInt(5, pengembalian.getTerlambat());
        ps.setInt(6, pengembalian.getDenda());
        ps.executeUpdate();
    }
    
    public void update(Pengembalian pengembalian) throws Exception{
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "update pengembalian set tgl_dikembalikan=?, terlambat=?, denda=? where id_pengembalian=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pengembalian.getTgldikembalikan());
        ps.setInt(2, pengembalian.getTerlambat());
        ps.setLong(3, pengembalian.getDenda());
        
        
        ps.executeUpdate();
    }
    
    public void delete(Pengembalian pengembalian) throws Exception {
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "delete from pengembalian where id_pengembalian=?";
        PreparedStatement ps = con.prepareStatement(sql);
        

        ps.executeUpdate();
    }
    
    public Pengembalian getPengembalian(java.lang.String tglpinjam) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from pengembalian "
       + "where kodeanggota = ? and kodebuku = ? and tglpinjam = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tglpinjam);
        ps.setString(2, tglpinjam);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        AnggotaDao anggotaDao = new AnggotaDao();
        BukuDao bukuDao = new BukuDao();
        PeminjamanDao peminjamanDao = new PeminjamanDao();
        if (rs.next()) {
            pengembalian = new Pengembalian();
            Peminjaman peminjaman = peminjamanDao.getPeminjaman(tglpinjam, tglpinjam, tglpinjam);
            pengembalian.setTglPinjam(peminjaman);
            pengembalian.setTgldikembalikan(rs.getString(4));
            pengembalian.setTerlambat(rs.getInt(5));
            pengembalian.setDenda(rs.getInt(6));
        }
        return pengembalian;
    }

    public List<Pengembalian> getAll() throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from pengembalian";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        PeminjamanDao peminjamanDao = new PeminjamanDao();
        List<Pengembalian> pengembalians = new ArrayList<>();
        while (rs.next()) {
            pengembalian = new Pengembalian();
            Peminjaman peminjaman = peminjamanDao.getPeminjaman(rs.getString(1), rs.getString(2), rs.getString(3));
            pengembalian.setTglPinjam(peminjaman);
            pengembalian.setTgldikembalikan(rs.getString(4));
            pengembalian.setTerlambat(rs.getInt(5));
            pengembalian.setDenda(rs.getInt(6));
            pengembalians.add(pengembalian);
        }
        return pengembalians;
    }
    
    public int getKurangTanggal(String tgl1, String tgl2) throws Exception{
        Connection con = new Koneksi().getKoneksi();
        String sql = "select datediff(?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tgl1);
        ps.setString(2, tgl2);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    public Pengembalian getPengembalian(int idPengembalian) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
