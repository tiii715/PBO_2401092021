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
public class Peminjaman {
    private Anggota kodeAnggota;
    private Buku kodeBuku;
    private String tglpinjam;
    private String tglkembali;

    public Peminjaman() {
    }

    public Anggota getAnggota() {
        return kodeAnggota;
    }

    public void setAnggota(Anggota anggota) {
        this.kodeAnggota = anggota;
    }

    public Buku getBuku() {
        return kodeBuku;
    }

    public void setBuku(Buku buku) {
        this.kodeBuku = buku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
}
