/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia11032025;

/**
 *
 * @author user
 */
public class ContohIf {
    public static void main( String[] args ) 
    { 
    double grade = 92.0; 
    if( grade >= 90 ){ 
        System.out.println( "Excellent!" ); 
        } 
    else if( (grade < 90) && (grade >= 80)){ 
        System.out.println("Good job!" ); 
        } 
    else if( (grade < 80) && (grade >= 60)){ 
        System.out.println("Study harder!" ); 
        } 
    else{ 
        System.out.println("Sorry, you failed."); 
        } 
    }
  
}
