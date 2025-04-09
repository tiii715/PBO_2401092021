package tugas1010;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Latihan10101entry_data_buku {
    private String nama;
    private String alamat;
    private String notelp;
    private String email;
    public Latihan10101entry_data_buku (String temp) //CONSTRUCTOR
    {
        nama = temp;
    }
        
    public String getAlamat()  //ACCESSOR
    {
        return alamat;
    }
    public void setAlamat(String temp) //MUTATOR
    {
        alamat = temp;
    }
        
    public String getNotelp () //ACCESSOR
    {
        return notelp;
    }
    public void setNotelp (String temp) //MUTATOR
    {
        notelp = temp;
    }
        
    public String getEmail() //ACCESSOR
    {
        return email;
    }
    public void setEmail(String temp)  //MUTATOR
    {
        email = temp;
    }
        
    public void tampilkan() //MENCETAK
    {
        System.out.println("Nama : " + nama); //dari constructor
        System.out.println("Alamat : " + getAlamat());
        System.out.println("Nomor telp : " + getNotelp());
        System.out.println("Email : " + getEmail());
    }
}
