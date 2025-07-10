/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia20032025;
import java.io.*;
/**
 *
 * @author user
 */
public class Aritmatika {
    public static void main(String[] args) throws IOException{
        int n, fibo;
        
        n=Integer.parseInt(args[0]);
        fibo=Integer.parseInt(args[1]);
        
        System.out.println(ganjil(n));
        System.out.println("Angka fibonachi dari array = " + fibonachi(fibo));
    }
    
    public static int ganjil(int n) throws IOException{
        BufferedReader dataIn  = new BufferedReader(new InputStreamReader(System.in));
        int i;
        int[] angka = new int[n];
        
        for(i=0;i<n;i++){
            System.out.print("Enter number for index - " + i + ":");
            angka[i] = Integer.parseInt(dataIn.readLine());
        }
        
        System.out.print("Array : ");
        for (i=0;i<n;i++){
            System.out.print(angka[i] + " ");
        }
        System.out.println();
        
        for (i=0;i<n;i++){
            if (angka[i]%2!=0){
                return angka[i];
            }
        }
        return 0;
    }
    
    public static int fibonachi(int fibo){
        if (fibo <= 1){
            return fibo;
        }
        
        int i;
        int a_fibo=0;
        int b_fibo=1;
        int c_fibo=0;
        
        for (i = 2; i <= fibo; i++){
            c_fibo = a_fibo + b_fibo;
            a_fibo = b_fibo;
            b_fibo = c_fibo;
        }
        return c_fibo;
    }
}
