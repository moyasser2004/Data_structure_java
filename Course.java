/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Mohamed Yasser
 */
//enrolled مسجل

class Course {
    
    String name;
    int courseId;
    
    LinkedList<Student> enrolledStudents = new LinkedList<>();

    public Course(String name, int courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.insertLast(student);
    }

    public void listEnrolledStudents() {
        enrolledStudents.print();
    }
    
}