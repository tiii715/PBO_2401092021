/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Mutia06032025;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */

public class Latihan512 {
    public static void main( String[] args ){ 
    String word1= "";
    String word2= "";
    String word3= ""; 
    word1 = JOptionPane.showInputDialog("enter word 1");
    word2 = JOptionPane.showInputDialog("enter word 2"); 
    word3 = JOptionPane.showInputDialog("enter word 3"); 
 
    String msg = "Hello " +" "+word1 +" "+word2 +" "+word3 +"!"; 
 
    JOptionPane.showMessageDialog(null, msg); 
 }
}
