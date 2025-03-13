/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia13032025;

import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class latihan6512 {
    public static void main (String [] args){
    String nilai1= "";
    String nilai2= "";
    String nilai3= "";
    double rata=0;
    
    nilai1 = JOptionPane.showInputDialog("enter nilai 1"); 
    nilai2 = JOptionPane.showInputDialog("enter nilai 2"); 
    nilai3 = JOptionPane.showInputDialog("enter nilai 3"); 
    try{ 
        rata = (Integer.parseInt(nilai1)+Integer.parseInt(nilai2)+Integer.parseInt(nilai3))/3; 
        String msg = "Rata-rata Nilai Ujian" + rata;
        if(rata>= 60 ){ 
        JOptionPane.showMessageDialog(null, msg + ":-)"); 
        } 
        else{ 
        JOptionPane.showMessageDialog(null, msg + ":-(");
        } 
    } 
    catch(NumberFormatException nfe){ 
    String msg = "INPUT ERROR!"; 
    JOptionPane.showMessageDialog(null, msg);
     }     
  }
}
