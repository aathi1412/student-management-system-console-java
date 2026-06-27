package src.com.studentmanagementsystem.model;

import java.util.*;

public class Department {
    private String deptName;
    private List<Student> students;
    private List<Faculty> faculties;

    public Department(String deptName) {
        this.deptName = deptName;
        students = new ArrayList<>();
        faculties = new ArrayList<>();
    }

    public void addStudent(Student s) { students.add(s); }
    public Student findStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) return s;
        }
        return null;
    }
    public boolean removeStudent(int rollNo) {
        return students.removeIf(s -> s.getRollNo() == rollNo);
    }
    public void displayStudents() {
        if (students.isEmpty()) System.out.println("No students available.");
        else for (Student s : students) s.display();
    }

    public void addFaculty(Faculty f) { faculties.add(f); }
    public Faculty findFaculty(String name) {
        for (Faculty f : faculties) {
            if (f.getName().equalsIgnoreCase(name)) return f;
        }
        return null;
    }
    public boolean removeFaculty(String name) {
        return faculties.removeIf(f -> f.getName().equalsIgnoreCase(name));
    }
    public void displayFaculties() {
        if (faculties.isEmpty()) System.out.println("No faculties available.");
        else for (Faculty f : faculties) f.display();
    }
}