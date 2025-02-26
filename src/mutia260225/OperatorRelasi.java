/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutia260225;

/**
 *
 * @author user
 */
public class OperatorRelasi {
    public static void main(String[] args) {
        int i = 37;
        int j = 42;
        int k = 42;
        k = ++j + i;
        
        System.out.println("Variable Values");
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        
        System.out.println("Greater than..."); 
        System.out.println(" i > j = " + (i > j)); //false 
        System.out.println(" j > i = " + (j > i)); //true 
        System.out.println(" k > j = " + (k > j)); //false
        
        System.out.println("Greater than or equal to..."); 
        System.out.println(" i >= j = " + (i >= j)); //false 
        System.out.println(" j >= i = " + (j >= i)); //true 
        System.out.println(" k >= j = " + (k >= j)); //true
        
        System.out.println("Less than..."); 
        System.out.println(" i < j = " + (i < j)); //true 
        System.out.println(" j < i = " + (j < i)); //false 
        System.out.println(" k < j = " + (k < j)); //false 
        
        System.out.println("Less than or equal to..."); 
        System.out.println(" i <= j = " + (i <= j)); //true 
        System.out.println(" j <= i = " + (j <= i)); //false 
        System.out.println(" k <= j = " + (k <= j)); //true
        
        System.out.println("Equal to..."); 
        System.out.println(" i == j = " + (i == j)); //false 
        System.out.println(" k == j = " + (k == j)); //true
        
        System.out.println(" not equal to..."); 
        System.out.println(" i != j = " + (i != j)); //true
        System.out.println(" k != j = " + (k != j)); //false
    }
}
