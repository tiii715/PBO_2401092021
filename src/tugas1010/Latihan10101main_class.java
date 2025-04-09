/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1010;

/**
 *
 * @author user
 */
public class Latihan10101main_class {
    public static void main(String[]args)
    {
        Latihan10101entry_data_buku a = new Latihan10101entry_data_buku("Budi Santoso");
        Latihan10101entry_data_buku b = new Latihan10101entry_data_buku("Siti Aminah");
        
        a.setAlamat("Padang");
        a.setNotelp("081234567890");
        a.setEmail("x.Budists@yahoo.co.id");
        a.tampilkan();
        
        b.setAlamat("Bukittinggi");
        b.setNotelp("085711223344");
        b.setEmail("sitiA@yahoo.co.id");
        b.tampilkan();
    }
}
