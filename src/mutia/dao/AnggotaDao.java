/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutia.dao;

import mutia.model.Anggota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AnggotaDao {

    public void insert(Anggota anggota) throws Exception{
        String sql = "insert into anggota values(?,?,?,?)";
        try (
                Connection con = new Koneksi().getKoneksi();
                PreparedStatement ps = con.prepareStatement(sql);
                ) {
            ps.setString(1, anggota.getKode());
            ps.setString(2, anggota.getNama());
            ps.setString(3, anggota.getAlamat() );
            ps.setString(4, anggota.getJekel());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }

    public void Update(Anggota anggota) throws Exception{
        Connection con = new Koneksi().getKoneksi();
        String sql = "update anggota set nama=?, alamat=?, jekel=? where kodeanggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(3, anggota.getNama());
        ps.setString(1, anggota.getAlamat());
        ps.setString(4, anggota.getJekel());
        ps.setString(2, anggota.getKode());
        ps.executeUpdate();
    }

    public void Delete(Anggota anggota) throws Exception{
        Connection con = new Koneksi().getKoneksi();
        String sql = "delete from anggota where kodeanggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKode());
        ps.executeUpdate();
    }

    public Anggota getAnggota(String kode) throws Exception{
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from anggota where kodeamggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Anggota anggota = null;
        if(rs.next()){
            anggota = new Anggota();
            anggota.setKode(rs.getString(2));
            anggota.setNama(rs.getString(3));
            anggota.setAlamat(rs.getString(1));
            anggota.setJekel(rs.getString(4));
        }
        return anggota;
    }

    public List<Anggota> getAllAnggota(String kode) throws Exception{
        Connection con = new Koneksi().getKoneksi();
        String sql = "select * from anggota";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        List<Anggota> aglist = new ArrayList<>();
        while(rs.next()){
            Anggota ag = new Anggota();
            ag.setKode(rs.getString(1));
            ag.setNama(rs.getString(2));
            ag.setAlamat(rs.getString(3));
            ag.setJekel(rs.getString(4));
        }
        return aglist;
    }

    public List<Anggota> getAllAnggota() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }
}
