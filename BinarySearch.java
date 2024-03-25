import java.util.*;
/*
 * Binary Search is an searching algorithm that repeatedly divides the search interval in half 
 * to search a key given a sorted array and returns either the position (if present) or null (if not present)
 * 
 * Apply this algorithm only when:
 *  1. Data structure is sorted
 *  2. Access to any element of the data structure takes constant time
 * 
 * Implementation Types:
 *  1. Iterative
 *  2. Recursive
 * 
 * Link: https://www.geeksforgeeks.org/binary-search/
 */

 public class BinarySearch{
    static int iterativeSearch(int[] arr, int target, int l, int r){
        while(l<=r){
            int mid = (l+r)/2;
            mid = (l+r)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1; //represents 'Key Not Found'
    }
    static int recursiveSearch(int[] arr, int target, int l, int r){
        if(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid]<target){
                return recursiveSearch(arr, target, mid+1, r);
            }
            else{
                return recursiveSearch(arr, target, l, mid-1);
            }
        }
        return -1; //represents 'Key Not Found'
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array to perform binary search: ");
        int size = sc.nextInt(); //getting size of array
        int[] array = new int[size]; //declaring 1D array with the input size

        System.out.println("Enter the target element: ");
        int target = sc.nextInt(); //getting the target

        System.out.println("Enter the (sorted) array elements: ");
        for(int i=0; i<size; i++){
            array[i] = sc.nextInt();
        }

        int result;
        System.out.println("\nResult from Iterative search: ");
        result = iterativeSearch(array, target, 0, size-1);
        if(result!=-1){
            System.out.println("\nKey found at: "+result);
        }
        else{
            System.out.println("\nKey not found!");
        }
        System.out.println("\nResult from Recursive search: ");
        result = recursiveSearch(array, target, 0, size-1);
        if(result!=-1){
            System.out.println("\nKey found at: "+result);
        }
        else{
            System.out.println("\nKey not found!");
        }
    }
}

/*
 * Test Case: 1
 * Size: 4
 * Target: 8
 * Elements: [8,9,10,11]
 * 
 * Output: Key found at: 0
 * --------------------------------
 * Test Case: 2 
 * Size: 4
 * Target: 11
 * Elements: [8,9,10,11]
 * 
 * Output: Key found at: 3
 */