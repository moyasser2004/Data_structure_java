/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */
public class Node<T> {

    T item;
    Node next;

   public  Node(T item) {
        this.item = item;
        this.next = null;
    }
}
