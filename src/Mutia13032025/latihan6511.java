/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia13032025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author user
 */
public class latihan6511 {
    public static void main (String [] args){
    BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in));
    String nilai1= "";
    String nilai2= "";
    String nilai3= "";
    double rata=0;
    
    System.out.println("Nilai ujian 1 = ");
    try{ 
        nilai1 = dataIn.readLine(); 
        } 
        catch( IOException e ){ 
    System.out.println("Error!");
        }
    
    System.out.println("Nilai ujian 2 = ");
    try{ 
        nilai2 = dataIn.readLine(); 
        } 
        catch( IOException e ){ 
    System.out.println("Error!");
        }
    
    System.out.println("Nilai ujian 3 = ");
    try{ 
        nilai3 = dataIn.readLine(); 
        } 
        catch( IOException e ){ 
    System.out.println("Error!");
        }
    
    try{ 
        rata = (Integer.parseInt(nilai1)+Integer.parseInt(nilai2)+Integer.parseInt(nilai3))/3; 
        System.out.println("Rata-rata Nilai Ujian = " + rata);
        if(rata>= 60 ){ 
        System.out.println( ":-)" ); 
        } 
        else{ 
        System.out.println(":-(" ); 
        } 
       } 
        catch( NumberFormatException nfe ){ 
    System.out.println("Error!");
        }
  }
}
