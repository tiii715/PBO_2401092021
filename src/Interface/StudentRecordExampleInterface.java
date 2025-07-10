/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

/**
 *
 * @author user
 */
public class StudentRecordExampleInterface {
    interface Nameable {
    String getName();
    void setName(String name);
}

class StudentRecord implements Nameable {
    private String name;
    private int studentCount = 0;

    public StudentRecord() {
        studentCount++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount() {
        return studentCount;
    }
}

class CobaOverride implements Nameable {
    private String name;

    public CobaOverride(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        System.out.println("afril juga student loooh....");
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public void main(String[] args) {
        StudentRecord afrilRecord = new StudentRecord();
        afrilRecord.setName("Afril");
        System.out.println(afrilRecord.getName());
        System.out.println("Count= " + afrilRecord.getStudentCount());

        CobaOverride anotherAfril = new CobaOverride("Afril");
        System.out.println(anotherAfril.getName());
    }
}
}
