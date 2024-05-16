/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */
public class DoubleLinkedList {

    int length;
    Node head;
    Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void insertFirst(int num) {
        Node newNode = new Node(num);

        if (length == 0) {
            head = tail = newNode;
            newNode.next = newNode.prev = null;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    void insertLast(int num) {
        if (length == 0) {
            insertFirst(num);
        } else {
            Node newNode = new Node(num);
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    void inser(int index, int num) {
        if (index == 0) {
            insertFirst(num);
        } else if (length - 1 == index) {
            insertLast(num);
        } else if (index > length) {
            System.out.println("Cant add to List ");
        } else {
            Node newNode = new Node(num);
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            length++;
        }
    }

    void deleteFirst() {

        switch (length) {
            case 0 ->
                System.out.println("No data in list");
            case 1 -> {
                head = tail = null;
                length--;
            }
            default -> {
                head = head.next;
                head.prev = null;
                length--;
            }
        }
    }

    void deleteLast() {

        switch (length) {
            case 0 ->
                System.out.println("No data in list");
            case 1 -> {
                head = tail = null;
                length--;
            }
            default -> {
                tail = tail.prev;
                tail.next = null;
                length--;
            }
        }
    }

    void delete(int num) {
        if (num == head.item) {
            deleteFirst();
        } else if (num == tail.item) {
            deleteLast();
        } else {
            Node temp = head;
            while (temp.item != num) {
                if (temp.next == null) {
                    System.out.println("Not Found in list");
                    return;
                } else {
                    temp = temp.next;
                }
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.next = temp.prev = null;
        }
    }

    public void pop(int index) {
        if (index == 0) {
            deleteFirst();
        } else if (index == length - 1) {
            deleteLast();
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            delete(temp.item);
        }
    }

    public void print() {
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(" " + temp.item + " ");
            temp = temp.next;
        }
        System.out.print("]");
    }

}
