/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia13032025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author user
 */
public class latihan6522 {
    public static void main(String [] args){
    BufferedReader dataIn=new BufferedReader(new InputStreamReader(System.in));
    
    String angka="";
    String huruf="";
    System.out.println("Input angka = ");
    
        try{
            angka=dataIn.readLine();
        }catch(IOException e){
            System.out.println("ERROR!");
        }
        
        switch(Integer.parseInt(angka)){
            case 1:
                System.out.println("SATU");
                break;
            case 2:
                System.out.println("DUA");
                break;
            case 3:
                System.out.println("TIGA");
                break;
            case 4:
                System.out.println("EMPAT");
                break;
            case 5:
                System.out.println("LIMA");
                break;
            case 6:
                System.out.println("ENAM");
                break;
            case 7:
                System.out.println("TUJUH");
                break;
            case 8:
                System.out.println("DELAPAN");
                break;
            case 9:
                System.out.println("SEMBILAN");
                break;
            case 10:
                System.out.println("SEPULUH");
                break;
            default:
            System.out.println("Invalid number");     
        }
    }
}
