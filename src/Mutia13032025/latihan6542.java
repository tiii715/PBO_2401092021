/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia13032025;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class latihan6542 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan angka: ");
        int angka = scanner.nextInt();
        System.out.print("Masukkan nilai pangkat: ");
        int pangkat = scanner.nextInt();

        int hasil = 1;
        for(int i = 1; i <= pangkat; i++){
            hasil *= angka;
        }
        System.out.println(angka + " pangkat " + pangkat + " adalah: " + hasil);
    }
}
