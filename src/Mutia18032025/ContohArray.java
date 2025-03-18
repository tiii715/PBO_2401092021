/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia18032025;

/**
 *
 * @author user
 */
public class ContohArray {
    public static void main  (String [] args){
        boolean results[] = {true,false,true,false};
        double[] grades = {100, 90, 80, 75};
        String days[] = {"Senin", "Selasa", "Rabu", "Kamis", "Juma'at", "Sabtu", "Minggu"};
        System.out.println("results ke->0 adalah " + results[0]);
        
        for(int i = 0; i < days.length; i++){
            System.out.println("indeks ke-"+i+": " + days[i]);
        }
    } 
}
