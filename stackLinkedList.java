///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author Mohamed Yasser
// * @param <T>
// */
////

public class stackLinkedList<T> {

    Node top;

    stackLinkedList() {
        this.top = null;
    }

    public Boolean isEmpety() {
        return top == null;
    }

    public void push(int item) {
        Node newNode= new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public int getTop() {
        if (isEmpety()) {
            System.out.println("NO data in stack");
            return 0;
        } else {
            return top.item;
        }
    }

    public void pop() {
        if (isEmpety()) {
            System.out.println("NO data in stack");
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
        }
    }

    public void disPlay() {
        Node temp = top;
        System.out.print("[ ");
        while (temp != null) {
            System.out.print(" " + temp.item + " ");
            temp = temp.next;
        }
        System.out.print(" ]");
    }

}
