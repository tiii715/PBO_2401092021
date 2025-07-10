/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan116;

/**
 *
 * @author user
 */
public class StudentRecord {
    public String name;
        private String address;
        private int age;
        private double mathGrade;
        private double englishGrade;
        private double scienceGrade;
        private double average;
        private static int studentCount;

    public String getName(){
        return name;
    }

    public void setName( String temp ){
        name = temp;
    }

    public double getAverage(){
        double result = 0;
        result = ( mathGrade+englishGrade+scienceGrade )/3;
        return result;
    }
    
    public static int getStudentCount(){
        return studentCount;
    }
}
