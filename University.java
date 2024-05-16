/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */
class University {

    LinkedList<College> colleges = new LinkedList<>();

    public void addCollege(College college) {
        colleges.insertLast(college);
    }

    
    public void listColleges() {
        Node<College> print = colleges.head;
        System.out.print("[");
        while (print != null) {
            College c = (College) print.item;
            System.out.print(" " + c.name + ",");
            print = print.next;
        }
        System.out.print("]");
    }

    public void listCoursesByStudent(Student student) {
        
        Node<College> currentCollege = colleges.head;
        System.out.print("[");
        while (currentCollege != null) {
            
            College college = currentCollege.item;
            Node<Department> currentDepartment = college.departments.head;
            
            while (currentDepartment != null) {
                
                Department department = currentDepartment.item;
                Node<Course> currentCourse = department.courses.head;
                
                while (currentCourse != null) {
                    
                    Course course = currentCourse.item;
                    Node<Student> currentStudent = course.enrolledStudents.head;
                    
                    while (currentStudent != null) {
              
                        if (currentStudent.item == student) {
                            System.out.print(" Student " + student.name + " is enrolled in " + course.name+",");
                            break;
                        }
                        currentStudent = currentStudent.next;
                    }
                    

                    currentCourse = currentCourse.next;
                }

                currentDepartment = currentDepartment.next;
            }

            currentCollege = currentCollege.next;
        }
        System.out.print("]");
    }

    
    public void listStudentsByCourse(Course course) {
        Node<Student> currentStudent = course.enrolledStudents.head;
        System.out.print("[");
        while (currentStudent != null) {
            System.out.print(" "+currentStudent.item.name+",");
            currentStudent = currentStudent.next;
        }
        System.out.print("]");
    }

}


//loop 1               2              3         4
 //    |               |             |         |
 //[college1]   -> [college2]->[college3]->[college4]->
 //    |                |             |            |
 //[department1]->[department2]->[department3]->[department4]->
 //    |            |              |                |
 //[courses1]->[courses2]  -> [courses3]  ->   [courses4]->
 //    |           |              |               |
 //[student1]->[student2] ->  [student3] ->  [student4]->
 //