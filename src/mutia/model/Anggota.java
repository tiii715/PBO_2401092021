/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutia.model;

/**
 *
 * @author User
 */
public class Anggota {
    private String kode;
    private String nama;
    private String jekel;
    private String alamat;

    public Anggota() {
    }

    public Anggota(String kode, String nama, String jekel, String alamat) {
        this.kode = kode;
        this.nama = nama;
        this.jekel = jekel;
        this.alamat = alamat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
