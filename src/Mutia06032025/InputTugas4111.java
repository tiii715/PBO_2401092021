/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Mutia06032025;
import java.io.*;
/**
 *
 * @author user
 */

public class InputTugas4111 {
    public static void main(String [] args){
    BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in));
    
    int number= 0;
    char letter= 'a';
    String x="";
    boolean result= true;
    String str= "";
    
    try{ 
        number = Integer.parseInt(dataIn.readLine());
        System.out.println("number= ");
        
        x = dataIn.readLine();
        letter = x.charAt(0);
        System.out.println("letter= ");
        
        str = dataIn.readLine(); 
        System.out.println("str= ");
        } 
        catch( IOException e ){ 
            System.out.println("Error in getting input");
        }
    System.out.println(number);
    System.out.println(letter);
    System.out.println(result);
    System.out.println(str);
 }
}
