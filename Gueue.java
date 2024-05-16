/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */

//Circle Geueu 

public class Gueue {

    int rear;
    int front;
    int length;
    int arr [];
    int maxSize=10;

    public Gueue() {
       this.front = 0;
       this.arr = new int[maxSize];
       this. rear = maxSize - 1;
       this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == maxSize;
    }

    public void addQueue(int element) {
        if (isFull()) {
            System.out.println("Queue Full Can't Enqueue ...!");
        } else {
            rear = (rear + 1) % maxSize;
            arr[rear] = element;
            length++;
        }
    }

    public void deleteQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue Can't Dequeue ...!");
        } else {
            front = (front + 1) % maxSize;
            length--;
        }
    }

    public int frontQueue() {
        return arr[front];
    }

    public int rearQueue() {
        return arr[rear];
    }

    public void printQueue() {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % maxSize) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[rear]);
        } else {
            System.out.println("Empty Queue");
        }
    }

    public int queueSearch(int element) {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % maxSize) {
                if (arr[i] == element) {
                    return i;
                }
            }
            if(arr[rear]==element){
                return length-1;
            }
        } else {
            System.out.println("Q is empty ! ");
        }
        return -1;
    }

    

    public static void main(String[] args) {
        Gueue q1 = new Gueue();
        q1.addQueue(10);
        q1.addQueue(20);
        q1.addQueue(30);
        q1.addQueue(40);
        q1.addQueue(50);
        System.out.println(q1.queueSearch(50));
        q1.deleteQueue();
        q1.printQueue();
    }

}
