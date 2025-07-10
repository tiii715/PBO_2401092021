/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PraUTS;

/**
 *
 * @author user
 */

public class Pegawai {
    private String nip;
    private String nama;
    private String golongan;
    private double gapok;
    private double tunjangan;
    private double total;
    
    public void setNip(String nip){
        this.nip = nip;
    }
    public String getNip(){
        return nip;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    
    public void setGolongan(String golongan){
        this.golongan = golongan;
    }
    public String getGolongan(){
        return golongan;
    }
    
    public double getGapok(){
        switch(golongan){
            case "1A": gapok = 1000000;
            break;
            
            case "2A": gapok = 2000000;
            break;
                
            case "3A": gapok = 3000000;
            break;
        }
        return gapok;
    }
    
    public double getTunjangan(){
        tunjangan = 0.05* gapok;
        return tunjangan;
    }
    
    public double getTotal(){
        total = gapok + tunjangan;
        return total;
    }
      
}
