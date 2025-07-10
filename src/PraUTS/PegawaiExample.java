/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PraUTS;

/**
 *
 * @author user
 */
public class PegawaiExample{
    public static void main(String [] args){
        Pegawai Gaji = new Pegawai();
        
        Gaji.setNip("1010010101");
        Gaji.setNama("Kiciw Slebew");
        Gaji.setGolongan("1A");
        
        System.out.println("Nama Pegawai                        : " + Gaji.getNama());
        System.out.println("NIP Pegawai                         : " + Gaji.getNip());
        System.out.println("Golongan Pegawai                    : " + Gaji.getGolongan());
        System.out.println("Gaji Pokok yang diterima Pegawai    : " + Gaji.getGapok());
        System.out.println("Tunjangan yang diterima Pegawai     : " + Gaji.getTunjangan());
        System.out.println("Total Gaji yang diterima Pegawai    : " + Gaji.getTotal());
    }
}
