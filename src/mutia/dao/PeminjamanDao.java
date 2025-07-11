/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutia.dao;

import mutia.model.Anggota;
import mutia.model.Buku;
import mutia.model.Peminjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PeminjamanDao {

    public void insert(Peminjaman peminjaman) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "insert into peminjaman values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKode());
        ps.setString(2, peminjaman.getBuku().getKode());
        ps.setString(3, peminjaman.getTglpinjam());
        ps.setString(4, peminjaman.getTglkembali());
        ps.executeUpdate();
    }
    
    public void Update(Peminjaman peminjaman) throws Exception{
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "update peminjaman set tgl_kembali=? where kode_anggota=? and kode_buku=? and tgl_pinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, peminjaman.getTglkembali());
        ps.setString(2, peminjaman.getAnggota().getKode());
        ps.setString(3, peminjaman.getBuku().getKode());
        ps.setString(4, peminjaman.getTglpinjam());
        
        ps.executeUpdate();
    }

    public void Delete(Peminjaman peminjaman) throws Exception {
        java.sql.Connection con = new Koneksi().getKoneksi();
        String sql = "delete from peminjaman where kode_anggota=?  and kode_buku=? and tgl_pinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKode());
        ps.setString(2, peminjaman.getBuku().getKode());
        ps.setString(3, peminjaman.getTglpinjam());

        ps.executeUpdate();
    }

    
    public Peminjaman getPeminjaman(String kodeanggota, 
            String kodebuku, String tglpinjam) throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from peminjaman "
       + "where kodeanggota = ? and kodebuku = ? and tglpinjam = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Peminjaman peminjaman = null;
        AnggotaDao anggotaDao = new AnggotaDao();
        BukuDao bukuDao = new BukuDao();
        if (rs.next()) {
            peminjaman = new Peminjaman();
            Anggota anggota = anggotaDao.getAnggota(rs.getString(1));
            peminjaman.setAnggota(anggota);
            Buku buku = bukuDao.getBuku(rs.getString(2));
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(rs.getString(3));
            peminjaman.setTglkembali(rs.getString(4));
        }
        return peminjaman;
    }

    public List<Peminjaman> getAllPeminjaman() throws Exception {
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from peminjaman";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Peminjaman peminjaman = null;
        AnggotaDao anggotaDao = new AnggotaDao();
        BukuDao bukuDao = new BukuDao();
        List<Peminjaman> peminjamans = new ArrayList<>();
        while (rs.next()) {
            peminjaman = new Peminjaman();
            peminjaman.setAnggota(anggotaDao.getAnggota(rs.getString(1)));
            peminjaman.setBuku(bukuDao.getBuku(rs.getString(2)));
            peminjaman.setTglpinjam(rs.getString(3));
            peminjaman.setTglkembali(rs.getString(4));
            peminjamans.add(peminjaman);
        }
        return peminjamans;
    }

}
