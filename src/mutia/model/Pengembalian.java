/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutia.model;

/**
 *
 * @author LABSIDOSEN
 */
public class Pengembalian {
    private Peminjaman tglpinjam;
    private String tglDikembalikan;
    private int terlambat;
    private int denda;

    public Pengembalian() {
    }

    public Peminjaman getPeminjaman() {
        return tglpinjam;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.tglpinjam = peminjaman;
    }

    public String getTgldikembalikan() {
        return tglDikembalikan;
    }

    public void setTgldikembalikan(String tgldikembalikan) {
        this.tglDikembalikan = tgldikembalikan;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }

    public int getDenda() {
        denda = 100 * terlambat;
        return denda ;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }
    
    
}
