/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */
class College {

    String name;

    LinkedList<Department> departments = new LinkedList<>();

    public College(String name) {
        this.name = name;
    }

    public void addDepartment(Department department) {
        departments.insertLast(department);
    }

    public void listDepartments() {
        Node<Department> print = departments.head;
        System.out.print("[");
        while (print != null) {
            Department d = (Department) print.item;
            System.out.print("  " + d.name + ",");
            print = print.next;
        }
        System.out.print("]");
    }

}
