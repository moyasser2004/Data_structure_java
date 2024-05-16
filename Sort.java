/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sort;

/**
 *
 * @author Mohamed Yasser
 */
public class Sort {

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

    
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int N = arr.length;

        quickSort(arr, 0, N - 1);
        System.out.println("Sorted array:");
        printArr(arr);
    }
    
}

//************* megre sort
//   // {60, 10, 20, 5, 60, 70};
//                           //    arr      0     3     5
//    public static void merge(int arr[], int l, int m, int r) {
//        
//        int n1 = m - l + 1;//3
//        int n2 = r - m;//5
//
//        int L[] = new int[n1];//3
//        int R[] = new int[n2];//5
//
//        for (int i = 0; i < n1; ++i) {
//            L[i] = arr[l + i];
//        }
//        for (int j = 0; j < n2; ++j) {
//            R[j] = arr[m + 1 + j];
//        }
//
//        int i = 0, j = 0;
//        int k = l;
//        while (i < n1 && j < n2) {
//            if (L[i] <= R[j]) {
//                arr[k] = L[i];
//                i++;
//            } else {
//                arr[k] = R[j];
//                j++;
//            }
//            k++;
//        }
//
//        while (i < n1) {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        while (j < n2) {
//            arr[k] = R[j];
//            j++;
//            k++;
//        }
//    }
//       //   |                  |
//       // {60, 10, 20, 5, 60, 70};
//    
//                               //  arr        4       4 
//                               //  arr        4       5 
//                               //  arr        0       0
//                               //  arr        0       1
//                               //  arr        0       3
//                              //  arr         0       5
//    public static void mergeSort(int arr[], int l, int r) {
//        if (l < r) {
//            int m = (l + r) / 2;//3//1//0//0//4/4
//            
//            //        arr  4   4
//            //        arr  4   4
//            //        arr  0   0
//            //        arr  0   1
//            //        arr  0  3
//            mergeSort(arr, l, m);
//            
//            
//            
//            //        arr   4     5
//            mergeSort(arr, m + 1, r);
//            //    arr  0  3  5
//            merge(arr, l, m, r);
//        }
//    }
//
//    public static void main(String[] args) {
//
//        int x= 0/2;
//        System.out.println(x);
//        
//        int arr[] = {60, 10, 20, 5, 60, 70};
//        int n = arr.length;
//
//        mergeSort(arr, 0, n - 1);
//
//        System.out.println("Sorted array:");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }
////////////////////////////
// ***********insertion 
//     //            0  1   2   3|    4   5
//        int[] arr = {10, 20, 50, 40, 30, 60};
//
//        int key, j;
//            // 1,2,3
//        for (int i = 1; i < arr.length; i++) {
//
//            key = arr[i];// 40
//            
//            j = i - 1;// 2
//            
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            
//            arr[j + 1] = key;//20
//        }
//
//        
//        
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//////////////////////////////////
//**********buble 
//       int[] arr = {10, 20, 30, 50, 40, 60};
//
//        boolean swapped=false;
//        for (int i = 0; i < arr.length - 1; i++) {
//           System.out.println("i" + i);
//            swapped = false;
//            for (int j = 0; j < arr.length - i - 1; j++) {
//               // System.out.println("j" + j);
//                if (arr[j] > arr[j + 1]) {
//
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    swapped = true;
//                }
//            }
//            if (swapped == false) {
//                break;
//            }
//
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
////////////////////////////////////////////////////
//***********selection 
//       int[] arr = {50, 10, 30, 60, 40, 20};
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            
//            int minIndex = i;
//
//            for (int j = i + 1; j < arr.length; j++) {
//                
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;
//                }
//            }
//
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

