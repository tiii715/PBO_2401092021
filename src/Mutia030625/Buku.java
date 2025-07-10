/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia030625;

/**
 *
 * @author user
 */
public class Buku {
    private String kodeBuku;
    private String judulBuku;
    private String pengarangBuku;
    private String penerbitBuku;
    private String tahunTerbit;
    
    
    public Buku(String kodeBuku, String judulBuku, 
            String pengarangBuku, String penerbitBuku, String tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.pengarangBuku = pengarangBuku;
        this.penerbitBuku = penerbitBuku;
        this.tahunTerbit = tahunTerbit;
    }
    
    public String getKodeBuku() {
        return kodeBuku;
    }
    
    public String geJudulBuku() {
        return judulBuku;
    }
    
    public String getPengarangBuku() {
        return pengarangBuku;
    }
    
    public String getPenerbitBuku() {
        return penerbitBuku;
    }
    
    public String getTahunTerbit() {
        return tahunTerbit;
    }
   
    @Override
    public String toString() {
        return "Kode Buku : " + kodeBuku + "\n" + 
                "Judul Buku : " + judulBuku + "\n" + 
                "Pengarang Buku : " + pengarangBuku + "\n" + 
                "Penerbit Buku : " + penerbitBuku + "\n" +
                "Tahun Terbit Buku : " + tahunTerbit + "\n";
    }
}
