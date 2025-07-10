/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan116;

import Latihan116.StudentRecord;

/**
 *
 * @author user
 */
public class StudentRecordExample {
    public static void main( String[] args ){
        StudentRecord afrilRecord = new StudentRecord();
        afrilRecord.setName("Afril");
        System.out.println(afrilRecord.getName() );
        System.out.println("Count= "+StudentRecord.getStudentCount());
    }

    class CobaOverride extends StudentRecord {
        @Override
        public String getName(){
            System.out.println("afril juga student loooh....");
            return name;
        }
    }
}
