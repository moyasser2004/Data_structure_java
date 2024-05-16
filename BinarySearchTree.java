/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mohamed Yasser
 */
public class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    //insert Binary Search Tree  
    void insert(int num) {
        root = insertRec(root, num);
    }

    Node insertRec(Node root, int num) {
        if (root == null) {
            root = new Node(num);
            return root;
        }

        if (num < root.key) {
            root.left = insertRec(root.left, num);
        } else if (num > root.key) {
            root.right = insertRec(root.right, num);
        }

        return root;
    }

    
    //delete Binary Search Tree       
    void delete(int num) {
        root = deleteRec(root, num);
    }

    Node deleteRec(Node root, int num) {
        if (root == null) {
            return root;
        }
        if (num < root.key) {
            root.left = deleteRec(root.left, num);///
        } else if (num > root.key) {
            root.right = deleteRec(root.right, num);//
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    
    //min Binary Search Tree 
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    
    //search Binary Search Tree 
    boolean search(int num) {
        return searchRec(root, num);
    }
    boolean searchRec(Node root, int num) {
        if (root == null) {
            return false;
        } else if (root.key == num) {
            return true;
        }
        if (num < root.key) {
            return searchRec(root.left, num);
        } else {
            return searchRec(root.right, num);
        }
    }

    
    //height Binary Search Tree
    int height() {
        return findHeight(root);
    }
    int findHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = findHeight(root.left);

        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    
    int findMin() {
        return findMinValue(root);
    }
    int findMinValue(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    
    int findMax() {
        return findMaxValue(root);
    }
    int findMaxValue(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }
    

}
