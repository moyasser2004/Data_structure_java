/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Mohamed Yasser
 */
class Department {
    
    String name;
    
    LinkedList<Course> courses = new LinkedList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.insertLast(course);
    }

    public void listCourses() {
        Node<Course> print =courses.head;
        System.out.print("[");
        while(print != null){
            Course c= (Course) print.item;
            System.out.print(" "+ c.name+",");
             print= print.next;
        }
        System.out.print("]");
        
    }
    
}