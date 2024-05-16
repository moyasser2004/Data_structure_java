/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */
public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(0);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(55);

        System.out.println("\nSearch for key 40: " + tree.search(40));
        System.out.println("Search for key 90: " + tree.search(90));

        System.out.println("Height of the tree: " + tree.height());

        System.out.println("Minimum value in the tree: " + tree.findMin());
        System.out.println("Maximum value in the tree: " + tree.findMax());

        System.out.println("\nDelete key 20:");
        tree.delete(20);

        System.out.println("Search for key 20: " + tree.search(20));

    }

}
