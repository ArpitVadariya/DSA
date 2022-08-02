// in this programm we will find target element from infinite number sorted array

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class InfiniteArrayBS {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int ans(int arr[], int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return orderAgnosticBS(arr, target, start, end);
    }

    public static int orderAgnosticBS(int arr[], int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("Enter Size of Array : ");
        int sizeOfArray = sc.nextInt();

        int arr1[] = new int[sizeOfArray];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rd.nextInt(100);
        }

        // int arr[] = { 10, 342, 347, 44, -1, 66, 12, 17, 73, 25, 11 };
        // Arrays.sort(arr);
        // printArray(arr);
        Arrays.sort(arr1);
        printArray(arr1);

        System.out.print("Enter Target Element : ");
        int target = sc.nextInt();

        // System.out.println(ans(arr, target));
        System.out.println(ans(arr1, target));
    }
}
