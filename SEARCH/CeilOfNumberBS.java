// Interview Q.
// Ceil of Target number in Array --> smallest Element in array greater or = target

import java.util.Arrays;
import java.util.Random;

public class CeilOfNumberBS {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int Ceil(int arr[], int target) {
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // System.out.println("start = " + start);
            // System.out.println("mid = " + mid);
            // System.out.println("end = " + end);
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println("Binary Search always use in sorted array.");
        Random rd = new Random();
        int size = rd.nextInt(15) + 5;
        System.out.println("array size = " + size);
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(100) + 1;
        }
        Arrays.sort(arr);
        printArray(arr);
        int target = rd.nextInt(100);
        System.out.println("target --> " + target);
        int ans = Ceil(arr, target);
        if (ans < 0) {
            System.out.println("answer found at position = " + ans);
        } else {
            System.out.println("ans = " + arr[ans]);
        }
    }
}