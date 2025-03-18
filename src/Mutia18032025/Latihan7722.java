/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia18032025;

import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class Latihan7722 {
    public static void main (String [] args){
        final int jumData = 10;
        int [] arrData = new int [jumData];
        
        for(int i=0; i<jumData; i++){
        arrData[i] = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nilai " + (i+1)));
        }
    
        int terbesar=arrData[0];
        for(int i=0; i<jumData; i++){
            if (arrData[i]>terbesar){
            terbesar = arrData[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Nilai terbesar adalah " + terbesar);
    }
}
