/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort;

import java.util.Arrays;

/**
 *
 * @author Mohamed Yasser
 */
public class sort_compare {
    
}

//    static void bubbleSort(int arr[]) {
//        boolean swapped;
//        for (int i = 0; i < arr.length - 1; i++) {
//           // System.out.println("i" + i);
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
//    }
//
//    static void printArray(int arr[]) {
//        
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String [] args) {
//        
//        int arr[] = {10, 20, 30, 40, 50, 60};
//        bubbleSort(arr);
//        
//        System.out.println("Sorted array: ");
//        printArray(arr);
//        
//    }

//Time Complexity: O(N^2)
//Auxiliary Space: O(1)
//Total number of comparison (Worst case) = N(N-1)/2
//Total number of swaps (Worst case) = N(N-1)/2
//Best Case: The best case occurs when the array is already sorted. So the number of comparisons required is N-1 and the number of swaps required = 0. Hence the best case complexity is O(N).
//Worst Case: The worst-case condition for bubble sort occurs when elements of the array are arranged in decreasing order.
//In the worst case, the total number of iterations or passes required to sort a given array is (N-1). where ‘N’ is the number of elements present in the array.
//The sum of maximum difference in position across all elements will be




///////////////////////////////////////////////////////////////////////////////////////////////////// 



//    static int partition(int[] arr, int low, int high) {
//
//        int pivot = arr[high];
//
//        int i = (low - 1);
//
//        for (int j = low; j <= high - 1; j++) {
//
//            if (arr[j] < pivot) {
//                i++;
//
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//
//            }
//        }
//        int temp = arr[i + 1];
//        arr[i + 1] = arr[high];
//        arr[high] = temp;
//        return (i + 1);
//    }
//
//    static void quickSort(int[] arr, int low, int high) {
//        if (low < high) {
//            int pi = partition(arr, low, high);
//            quickSort(arr, low, pi - 1);
//            quickSort(arr, pi + 1, high);
//        }
//    }
//
//    public static void printArr(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int[] arr = {10, 7, 8, 9, 1, 5};
//        int N = arr.length;
//
//        quickSort(arr, 0, N - 1);
//        System.out.println("Sorted array:");
//        printArr(arr);
//    }

// a sorting algorithm based on the Divide and Conquer algorithm that
// Best Case: Ω (N log (N))

// The best-case scenario for quicksort occur when the pivot chosen at the each step divides the array into roughly equal halves.
// In this case, the algorithm will make balanced partitions, leading to efficient Sorting.
// Average Case: θ ( N log (N))

// Quicksort’s average-case performance is usually very good in practice, making it one of the fastest sorting Algorithm.
// Worst Case: O(N^2)
// The worst-case Scenario for Quicksort occur when the pivot at each step consistently results in highly unbalanced partitions.
//When the array is already sorted and the pivot is always chosen as the smallest or largest element.
//To mitigate the worst-case Scenario, various techniques are used such as choosing a good pivot (e.g., median of three)
//and using Randomized algorithm (Randomized Quicksort ) to shuffle the element before sorting.
// Auxiliary Space: O(1), if we don’t consider the recursive stack space. If we consider the recursive stack space then, 
//in the worst case quicksort could make O(N).

//It has a worst-case time complexity of O(N^2), which occurs when the pivot is chosen poorly.
//It is not a good choice for small data sets.
//It is not a stable sort, meaning that if two elements have the same key,
//their relative order will not be preserved in the sorted output in case of quick sort,
//because here we are swapping elements according to the pivot’s position (without considering their original positions).


// T(N) = N * T(1) + N * log2N. Therefore, the time complexity is O(N * logN).
// T(N) =  N^2/2 + N/2


/////////////////////////////////////////////////////////////////////////////

//
//    public static void countingSort(int[] arr) {
//        int max = findMax(arr);
//
//        int[] count = new int[max + 1];
//
//      
//        for (int num : arr) {
//            count[num]++;
//        }
//
//        int index = 0;
//        for (int i = 0; i <= max; i++) {
//            while (count[i] > 0) {
//                arr[index++] = i;
//                count[i]--;
//            }
//        }
//    }
//
//    public static int findMax(int[] arr) {
//        int max = arr[0];
//        for (int num : arr) {
//            if (num > max) {
//                max = num;
//            }
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//        
//        int[] arr = {60, 10, 20, 5, 60, 70};
//
//        System.out.println("Original Array: " + Arrays.toString(arr));
//
//        countingSort(arr);
//
//        System.out.println("Sorted Array: " + Arrays.toString(arr));
//    }