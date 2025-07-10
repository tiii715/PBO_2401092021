package Interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class gatau {
    public static void main(String[] args) {
        InterfaceStudentRecord student1 = new InterfaceStudentRecord();
        InterfaceStudentRecord student2 = new InterfaceStudentRecord();

        System.out.println("Nama siswa 1: " + student1.getName());
        System.out.println("Rata-rata siswa 1: " + student1.getAverage());
        System.out.println("Jumlah siswa: " + Student1.getStudentCount());
        
        InterfaceStudentRecord.HasName namedEntity = (InterfaceStudentRecord.HasName) student2;
        System.out.println("Nama dari entitas bernama: " + namedEntity.getName());

        InterfaceStudentRecord.HasAverage averageEntity = (InterfaceStudentRecord.HasAverage) student1;
        System.out.println("Rata-rata dari entitas yang memiliki rata-rata: " + averageEntity.getAverage());
    }
}
