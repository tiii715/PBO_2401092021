/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Mutia04032025;
/**
 *
 * @author user
 */

public class OperatorAnd {
    public static void main( String[] args ){ 
        
    int i= 0; 
    int j= 10; 
    boolean test= false; 
 
 //demonstrasi && 
    test = (i > 10) && (j++ > 9); 
    System.out.println(i); 
    System.out.println(j); 
    System.out.println(test); 
    
 //demonstrasi & 
    test = (i > 10) & (j++ > 9); 
    System.out.println(i); 
    System.out.println(j);
    System.out.println(test); 
    }
}
