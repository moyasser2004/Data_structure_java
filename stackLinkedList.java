/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xmlfile;


/**
 *
 * @author Mohamed Yasser
 * @param <T>
 */
public class stackLinkedList<T> {

    Node<T> top;

    public stackLinkedList() {
        this.top = null;
    }

    
    public Boolean isEmpety() {
        return top == null;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T getTop() {
        if (isEmpety()) {
            System.out.println("NO data in stack");
            return null;
        } else {
            return top.item;
        }
    }

    public T pop() {
        if (isEmpety()) {
            System.out.println("NO data in stack");
            return null;
        } else {
            Node<T> temp = top;
            T x = temp.item;
            top = top.next;
            temp.next = null;
            return x;
        }
    }

    public void disPlay() {
        Node<T> temp = top;
        System.out.println("");
        System.out.print("[ ");
        while (temp != null) {
            System.out.print(" " + temp.item + ",");
            temp = temp.next;
        }
        System.out.print(" ]");
    }
    

}
