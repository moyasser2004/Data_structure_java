///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author Mohamed Yasser
// */

//public class Node{
//    
//    int item;
//    Node next;
//    
//    Node(int item){
//            this.item = item;
//            this.next = null;
//    }
//   
//}

public class Node {
    
    int item;
    Node next;
    Node prev;

    public Node(int num) {
        this.item = num;
        this.next = null;
        this.prev = null;
    }
}