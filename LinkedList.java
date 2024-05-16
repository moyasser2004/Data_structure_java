/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 * @param <T>
 */
public class LinkedList<T> {

    Node head;
    int length;

    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return head == null || length == 0;
    }

    //  {10}-{10}-null 
    void insertFirst(T num) {
        Node<T> newNode = new Node(num);
        newNode.next = head;
        head = newNode;
        length++;
    }

    //      |     
    // {5}-{10}-{20}
    @SuppressWarnings("UnusedAssignment")
    void insertLast(T num) {
        if (length != 0) {
            Node<T> newNode = new Node(num);
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            temp = newNode;
            length++;
        } else {
            insertFirst(num);
        }
    }

    //        | 
    //  {10}-{20} - {40}
    //          {30}  
    void insertIn(int index, T num) {
        if (index == 0) {
            insertFirst(num);
        } else if (index == length - 1) {
            insertLast(num);
        } else if (index > length) {
            System.out.println("Exception on List length");
        } else {
            Node<T> newNode = new Node(num);
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }

    }

    //      |  
    // {0}-{1}-{2}
    void deleteFirst() {
        switch (length) {
            case 0 -> {
                return;
            }
            case 1 ->
                head = null;
            default ->
                head = head.next;
        }
        length--;
    }

    //         p   s
    //         |   | 
    //{1}-{2}-{3}-{4}
    void deleteLast() {
        switch (length) {
            case 0 -> {
                return;
            }
            case 1 -> {
                deleteFirst();
            }
            default -> {
                Node pref = head;
                Node surf = head.next;
                while (surf.next != null) {
                    pref = pref.next;
                    surf = surf.next;
                }
                pref.next = null;    
                length--;
            }
        }
    }

    void delete(T num) {
        if (num == head.item) {
            deleteFirst();
        } else {
            Node pref = head;
            Node surf = head.next;
            while (surf.item != num) {
                if (surf.next == null) {
                    return;
                } else {
                    pref = pref.next;
                    surf = surf.next;
                }
            }
            if (surf.next == null) {
                deleteLast();
            } else {
                surf = surf.next;
                pref.next = null;
                pref.next = surf;
            }

            length--;
        }
    }

    void pop(int index) {
        if (length - 1 != index) {
            int listIndex = -1;
            Node<T> temp = head;

            while (temp != null) {
                listIndex++;

                if (index == listIndex) {
                    delete(temp.item);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Not found in the List");
        }
    }

    void print() {
        Node<T> newPrint = head;
        System.out.print("[");
        while (newPrint != null) {
            System.out.print("  " + newPrint.item + " ");
            newPrint = newPrint.next;
        }
        System.out.print("]");
    }

}
