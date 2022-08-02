import java.util.Arrays;
import java.util.Random;

public class BinaryS {
    // This will rint Array.
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int BS(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

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
        System.out.println("Binary Search always use in sorted array.");
        Random rd = new Random();
        int size = rd.nextInt(15) + 5;
        System.out.println("array size = " + size);
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(100) + 1;
        }
        int target = arr[rd.nextInt(size)];
        System.out.println("target --> " + target);
        Arrays.sort(arr);
        printArray(arr);

        int ans = BS(arr, target);
        System.out.println(target + " found at position " + ans);

    }
}
