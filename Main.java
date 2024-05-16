/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Mohamed Yasser
 */
public class Main {
    public static void main(String[] args) {

        
        University university = new University();

        College college1 = new College(" Faculty of Computeing and Data Science ");
        
        Department department1 = new Department("Gener  department");
        Department department2 = new Department("Private department ");
        
        Course course1 = new Course("data structure", 12301);
        Course course2 = new Course("data science", 20239);
        Course course3 = new Course("data base", 012112);
        
        Student student1 = new Student("mohamed", 22010234);
        Student student2 = new Student("ahmed", 220102321);
        Student student3 = new Student("mohamb", 22010344);

        
        department1.addCourse(course1);
        department1.addCourse(course2);
        department1.addCourse(course3);
        
        
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course1.enrollStudent(student3);
        
        course2.enrollStudent(student1);
        course2.enrollStudent(student2);
    
        course3.enrollStudent(student1);

        
        
        college1.addDepartment(department1);
        college1.addDepartment(department2);
        
        
        university.addCollege(college1);

        
     
        System.out.print(" colleges:");
        university.listColleges();
        System.out.println("");
        
        System.out.print("\n departments in College 1:");
        college1.listDepartments();
        System.out.println("");

        System.out.print("\n courses in Department 1:");
        department1.listCourses();
        System.out.println("");

        
        System.out.print("\n courses taken by Student 1:");
        university.listCoursesByStudent(student1);
        
        System.out.print("\n courses taken by Student 2:");
        university.listCoursesByStudent(student2);
        System.out.println("");
        
        System.out.print("\n courses taken by Student 3:");
        university.listCoursesByStudent(student3);
 
        System.out.print("\n students enrolled in Course 1: ");
        university.listStudentsByCourse(course1);
        
        System.out.print("\n students enrolled in Course 2: ");
        university.listStudentsByCourse(course2);
        
        System.out.print("\n students enrolled in Course 3: ");
        university.listStudentsByCourse(course3);
        
    }

}
