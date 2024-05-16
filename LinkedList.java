/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */
public class LinkedList {

    Node head;
    int length;

    public LinkedList() {
        this.head = null;
        length = 0;
    }

    //  {10}-{10}-null 
    void insertFirst(int num) {
        Node newNode = new Node(num);
        newNode.next = head;
        head = newNode;
        length++;
    }

    //      |     
    // {5}-{10}-{20}
    void insertLast(int num) {
        if (length != 0) {
            Node newNode = new Node(num);
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
    void insertIn(int index, int num) {
        if (index == 0) {
            insertFirst(num);
        } else if (index == length - 1) {
            insertLast(num);
        } else if (index > length) {
            System.out.println("Cant add to List");
        } else {

            Node newNode = new Node(num);
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

    
    void delete(int num) {
        if (num == head.item) {
            deleteFirst();
        }else {
            
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
            Node temp = head;

            while (temp != null) {
                listIndex++;
                if (index == listIndex) {
                    delete(temp.item);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("not in the arr");
        }
    }

    
    void reverse() {
        Node pref = null;
        Node middle = head;
        Node surf = middle.next;

        while (surf != null) {
            surf = middle.next;
            middle.next = pref;

            pref = middle;
            middle = surf;
        }
        head = pref;
    }

    
    void print() {
        Node Print = head;
        System.out.print("[");
        while (Print != null) {
            System.out.print("  " + Print.item + " ");
            Print = Print.next;
        }
        System.out.print("]");
    }

}

//
//
//
////   void deleteLast(){
////        Node pref = head;
////        
////        while(pref.next.next !=null){
////            pref=pref.next;
////        }
////        
////       pref.next=null;
////    }
