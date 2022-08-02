import java.util.*;

public class LinearS {
    // This Function Prints Array.
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Linear Search use in sorted and unsorted array.");
        Random rd = new Random();
        int size = rd.nextInt(15) + 5;
        System.out.println("array size = " + size);
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(100) + 1;
        }
        printArray(arr);
        System.out.println("Value assigned");
        System.out.println();

        int target = arr[rd.nextInt(size)];
        System.out.println("target --> " + target);

        for(int i=0;i<size;i++){
            if(arr[i] == target){
                System.out.println(target + " found at position " + i);
                break;
            }
        }
    }
}