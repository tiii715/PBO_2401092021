/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan116;

/**
 *
 * @author user
 */
public class AbstrakClassShape {
    abstract class Shape {
        private String nm;
        Shape(String nama) {
            nm = nama; 
        }
        public String getName() {
            return nm;
        }
        abstract float getArea();
    }

    class Circle extends Shape {
        int r;
        Circle(String nama) {
            super(nama);
            r= 3;
        }
        float getArea() {
            float luas;
            luas = (float)(3.14 * r * r);
            return luas;
        }
    }

    class Square extends Shape {
        private int sisi;
        Square(String nama) {
            super(nama);
            sisi = 3;
        }
        
        float getArea() {
            float luas;
            luas = sisi * sisi;
            return luas;
        }
    }
}
